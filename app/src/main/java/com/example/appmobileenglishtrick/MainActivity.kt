package com.example.appmobileenglishtrick

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appmobileenglishtrick.audio.EnglishTtsManager
import com.example.appmobileenglishtrick.data.model.DifficultyLevel
import com.example.appmobileenglishtrick.data.model.QuestionReview
import com.example.appmobileenglishtrick.data.model.SkillType
import com.example.appmobileenglishtrick.data.model.TestCategory
import com.example.appmobileenglishtrick.data.model.TestResult
import com.example.appmobileenglishtrick.ui.screens.HomeScreen
import com.example.appmobileenglishtrick.ui.screens.LevelSelectScreen
import com.example.appmobileenglishtrick.ui.screens.QuizScreen
import com.example.appmobileenglishtrick.ui.screens.ResultScreen
import com.example.appmobileenglishtrick.ui.theme.AppMobileEnglishTrickTheme

sealed interface AppScreen {
    data object Home : AppScreen
    data class LevelSelect(val category: TestCategory) : AppScreen
    data class Test(val category: TestCategory, val level: DifficultyLevel) : AppScreen
    data class Result(val result: TestResult) : AppScreen
}

class MainActivity : ComponentActivity() {

    private var ttsManager: EnglishTtsManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ttsManager = EnglishTtsManager(this)

        setContent {
            AppMobileEnglishTrickTheme {
                MainApp(ttsManager = ttsManager)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ttsManager?.shutdown()
    }
}

@Composable
fun SafeBackHandler(enabled: Boolean = true, onBack: () -> Unit) {
    if (LocalOnBackPressedDispatcherOwner.current != null) {
        BackHandler(enabled = enabled, onBack = onBack)
    }
}

@Composable
fun MainApp(
    ttsManager: EnglishTtsManager? = null,
    initialScreen: AppScreen = AppScreen.Home
) {
    var currentScreen by remember { mutableStateOf<AppScreen>(initialScreen) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        when (val screen = currentScreen) {
            is AppScreen.Home -> {
                HomeScreen(
                    onSelectCategory = { category ->
                        currentScreen = AppScreen.LevelSelect(category)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }

            is AppScreen.LevelSelect -> {
                SafeBackHandler {
                    currentScreen = AppScreen.Home
                }
                LevelSelectScreen(
                    category = screen.category,
                    onSelectLevel = { level ->
                        currentScreen = AppScreen.Test(screen.category, level)
                    },
                    onBackClick = {
                        currentScreen = AppScreen.Home
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }

            is AppScreen.Test -> {
                SafeBackHandler {
                    ttsManager?.stop()
                    currentScreen = AppScreen.LevelSelect(screen.category)
                }

                val onTestFinished: (TestResult) -> Unit = { result ->
                    currentScreen = AppScreen.Result(result)
                }

                QuizScreen(
                    category = screen.category,
                    level = screen.level,
                    ttsManager = ttsManager,
                    onTestFinished = onTestFinished,
                    onBackClick = {
                        ttsManager?.stop()
                        currentScreen = AppScreen.LevelSelect(screen.category)
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }

            is AppScreen.Result -> {
                SafeBackHandler {
                    currentScreen = AppScreen.Home
                }
                ResultScreen(
                    result = screen.result,
                    onRetakeTest = {
                        currentScreen = AppScreen.Test(screen.result.category, screen.result.level)
                    },
                    onBackHome = {
                        currentScreen = AppScreen.Home
                    },
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

// ---------------------------------------------------------------------------
// Previews
// ---------------------------------------------------------------------------

@Preview(showBackground = true, name = "Main App - Interactive Flow")
@Composable
private fun MainAppInteractivePreview() {
    AppMobileEnglishTrickTheme {
        MainApp(
            ttsManager = null,
            initialScreen = AppScreen.Home
        )
    }
}

@Preview(showBackground = true, name = "Main App - Level Select Screen")
@Composable
private fun MainAppLevelSelectPreview() {
    AppMobileEnglishTrickTheme {
        MainApp(
            ttsManager = null,
            initialScreen = AppScreen.LevelSelect(TestCategory.KIDS)
        )
    }
}

@Preview(showBackground = true, name = "Main App - Result Screen")
@Composable
private fun MainAppResultPreview() {
    AppMobileEnglishTrickTheme {
        MainApp(
            ttsManager = null,
            initialScreen = AppScreen.Result(
                TestResult(
                    category = TestCategory.KIDS,
                    level = DifficultyLevel.LEVEL_1,
                    reviews = listOf(
                        QuestionReview(
                            questionNumber = 1,
                            skill = SkillType.READING,
                            prompt = "Which word is a synonym for 'rapid'?",
                            userAnswer = "Fast",
                            correctAnswer = "Fast",
                            isCorrect = true,
                            scorePercent = 100,
                            explanation = "'Rapid' means happening in a short time or at great speed."
                        )
                    )
                )
            )
        )
    }
}