package com.example.appmobileenglishtrick.ui.screens

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.speech.RecognizerIntent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.appmobileenglishtrick.R
import com.example.appmobileenglishtrick.audio.EnglishTtsManager
import com.example.appmobileenglishtrick.audio.SpeechInputManager
import com.example.appmobileenglishtrick.data.model.BaseQuestion
import com.example.appmobileenglishtrick.data.model.DifficultyLevel
import com.example.appmobileenglishtrick.data.model.ListeningQuestion
import com.example.appmobileenglishtrick.data.model.QuestionReview
import com.example.appmobileenglishtrick.data.model.ReadingQuestion
import com.example.appmobileenglishtrick.data.model.SkillType
import com.example.appmobileenglishtrick.data.model.SpeakingQuestion
import com.example.appmobileenglishtrick.data.model.TestCategory
import com.example.appmobileenglishtrick.data.model.TestResult
import com.example.appmobileenglishtrick.data.repository.TestRepository
import com.example.appmobileenglishtrick.ui.components.PulsingWaveIndicator
import com.example.appmobileenglishtrick.ui.components.TestProgressHeader
import com.example.appmobileenglishtrick.ui.theme.AccentAmber
import com.example.appmobileenglishtrick.ui.theme.AccentOrange
import com.example.appmobileenglishtrick.ui.theme.AppMobileEnglishTrickTheme
import com.example.appmobileenglishtrick.ui.theme.CardBorderLight
import com.example.appmobileenglishtrick.ui.theme.Level1Color
import com.example.appmobileenglishtrick.ui.theme.Level4Color
import com.example.appmobileenglishtrick.ui.theme.Level5Color
import com.example.appmobileenglishtrick.ui.theme.LogoCyan
import com.example.appmobileenglishtrick.ui.theme.LogoPink
import com.example.appmobileenglishtrick.ui.theme.PrimaryBlue
import com.example.appmobileenglishtrick.ui.theme.PrimaryBlueDark
import com.example.appmobileenglishtrick.ui.theme.PrimaryBlueLight

@Composable
fun QuizScreen(
    category: TestCategory,
    level: DifficultyLevel,
    ttsManager: EnglishTtsManager? = null,
    onTestFinished: (TestResult) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val isInspection = LocalInspectionMode.current
    val speechInputManager = remember(isInspection) {
        if (!isInspection) {
            try {
                SpeechInputManager(context)
            } catch (_: Exception) {
                null
            }
        } else null
    }

    val questions = remember(category, level) {
        TestRepository.getQuestions(category, level)
    }

    if (questions.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Belum ada soal untuk kategori dan level ini.")
        }
        return
    }

    var currentIndex by remember { mutableIntStateOf(0) }
    val userReviews = remember { mutableStateListOf<QuestionReview>() }
    val startTimeMillis = remember { System.currentTimeMillis() }

    // Multiple choice state (Listening & Reading)
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var hasAnsweredMultipleChoice by remember { mutableStateOf(false) }

    // Listening state
    var isPlayingAudio by remember { mutableStateOf(false) }
    var speechRate by remember(level) { mutableFloatStateOf(level.listeningSpeechRate) }
    var showTranscript by remember { mutableStateOf(false) }

    // Speaking state
    var isListeningMic by remember { mutableStateOf(false) }
    var spokenText by remember { mutableStateOf("") }
    var accuracyScore by remember { mutableStateOf<Int?>(null) }
    var speakingStatusMessage by remember { mutableStateOf("Tekan mikrofon lalu ucapkan kalimat target.") }

    DisposableEffect(ttsManager) {
        ttsManager?.onSpeakingStateChanged = { playing ->
            isPlayingAudio = playing
        }
        onDispose {
            ttsManager?.stop()
            speechInputManager?.destroy()
        }
    }

    val currentQuestion = questions[currentIndex]

    // Speech intent launcher for system dialog
    val systemVoiceLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK && currentQuestion is SpeakingQuestion) {
            val results = activityResult.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            val candidateList = results?.filter { it.isNotBlank() } ?: emptyList()
            if (candidateList.isNotEmpty()) {
                val bestText = candidateList.maxByOrNull {
                    SpeechInputManager.calculateAccuracy(currentQuestion.targetSentence, it)
                } ?: candidateList.first()
                spokenText = bestText
                val score = SpeechInputManager.calculateAccuracy(currentQuestion.targetSentence, bestText)
                accuracyScore = score
                val passed = score >= level.speakingPassScore
                speakingStatusMessage = if (passed) {
                    "🎉 Pelafalan sangat bagus! Skor: $score% (Target: ${level.speakingPassScore}%)"
                } else {
                    "Suara terdeteksi: \"$bestText\" (Skor: $score%)"
                }
            } else {
                speakingStatusMessage = "Tidak ada suara yang terdeteksi."
            }
        }
    }

    fun finishQuiz() {
        ttsManager?.stop()
        speechInputManager?.destroy()
        isListeningMic = false
        val elapsedSeconds = ((System.currentTimeMillis() - startTimeMillis) / 1000).toInt()
        val result = TestResult(
            category = category,
            level = level,
            reviews = userReviews.toList(),
            timeSpentSeconds = elapsedSeconds
        )
        onTestFinished(result)
    }

    fun goToNextQuestion() {
        ttsManager?.stop()
        isPlayingAudio = false
        speechInputManager?.destroy()
        isListeningMic = false

        if (currentIndex < questions.size - 1) {
            currentIndex++
            // Reset question-specific state
            selectedOptionIndex = null
            hasAnsweredMultipleChoice = false
            showTranscript = false
            spokenText = ""
            accuracyScore = null
            speakingStatusMessage = "Tekan mikrofon lalu ucapkan kalimat target."
        } else {
            finishQuiz()
        }
    }

    fun submitSpeakingAnswer(score: Int, spoken: String) {
        val q = currentQuestion as? SpeakingQuestion ?: return
        ttsManager?.stop()
        speechInputManager?.destroy()
        isListeningMic = false
        val finalScore = score.coerceIn(0, 100)
        val passed = finalScore >= level.speakingPassScore
        userReviews.add(
            QuestionReview(
                questionNumber = currentIndex + 1,
                skill = SkillType.SPEAKING,
                prompt = q.targetSentence,
                userAnswer = spoken.ifBlank { q.targetSentence },
                correctAnswer = q.targetSentence,
                isCorrect = passed,
                scorePercent = finalScore,
                explanation = "Akurasi: $finalScore% (Target: ${level.speakingPassScore}%). Tips: ${q.tip}"
            )
        )
        goToNextQuestion()
    }

    // Auto-advance after successful pronunciation with score >= passScore
    LaunchedEffect(accuracyScore, currentIndex) {
        val score = accuracyScore
        if (currentQuestion is SpeakingQuestion && score != null && score >= level.speakingPassScore) {
            kotlinx.coroutines.delay(1200L)
            if (currentIndex < questions.size && currentQuestion == questions[currentIndex]) {
                submitSpeakingAnswer(
                    score = score,
                    spoken = spokenText.ifBlank { currentQuestion.targetSentence }
                )
            }
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted && currentQuestion is SpeakingQuestion && speechInputManager != null) {
            startSpeakingRecognition(
                manager = speechInputManager,
                question = currentQuestion,
                passScore = level.speakingPassScore,
                onListeningChanged = { isListeningMic = it },
                onSpoken = { spokenText = it },
                onAccuracy = { accuracyScore = it },
                onStatus = { speakingStatusMessage = it }
            )
        } else {
            speakingStatusMessage = "Izin mikrofon diperlukan untuk latihan speaking."
        }
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Progress Header
        TestProgressHeader(
            category = category,
            level = level,
            currentIndex = currentIndex,
            totalQuestions = questions.size,
            currentSkill = currentQuestion.skill,
            onBackClick = {
                ttsManager?.stop()
                speechInputManager?.stopListening()
                onBackClick()
            }
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (currentQuestion) {
                is ListeningQuestion -> {
                    ListeningQuestionContent(
                        question = currentQuestion,
                        isPlayingAudio = isPlayingAudio,
                        speechRate = speechRate,
                        showTranscript = showTranscript,
                        selectedOptionIndex = selectedOptionIndex,
                        hasAnswered = hasAnsweredMultipleChoice,
                        onPlayPause = {
                            if (isPlayingAudio) {
                                ttsManager?.stop()
                                isPlayingAudio = false
                            } else {
                                if (ttsManager != null) {
                                    ttsManager.speak(currentQuestion.audioScript, speechRate)
                                } else {
                                    isPlayingAudio = true
                                }
                            }
                        },
                        onReplay = {
                            ttsManager?.stop()
                            if (ttsManager != null) {
                                ttsManager.speak(currentQuestion.audioScript, speechRate)
                            } else {
                                isPlayingAudio = true
                            }
                        },
                        onSpeechRateChange = { rate ->
                            speechRate = rate
                            if (isPlayingAudio && ttsManager != null) {
                                ttsManager.stop()
                                ttsManager.speak(currentQuestion.audioScript, rate)
                            }
                        },
                        onToggleTranscript = { showTranscript = !showTranscript },
                        onSelectOption = { index ->
                            if (!hasAnsweredMultipleChoice) {
                                selectedOptionIndex = index
                            }
                        },
                        onSubmitAnswer = {
                            if (selectedOptionIndex != null) {
                                ttsManager?.stop()
                                isPlayingAudio = false
                                hasAnsweredMultipleChoice = true
                                val isCorrect = selectedOptionIndex == currentQuestion.correctIndex
                                userReviews.add(
                                    QuestionReview(
                                        questionNumber = currentIndex + 1,
                                        skill = SkillType.LISTENING,
                                        prompt = currentQuestion.questionText,
                                        userAnswer = currentQuestion.options[selectedOptionIndex!!],
                                        correctAnswer = currentQuestion.options[currentQuestion.correctIndex],
                                        isCorrect = isCorrect,
                                        scorePercent = if (isCorrect) 100 else 0,
                                        explanation = currentQuestion.explanation
                                    )
                                )
                            }
                        },
                        onNext = { goToNextQuestion() },
                        isLastQuestion = currentIndex == questions.size - 1
                    )
                }

                is ReadingQuestion -> {
                    ReadingQuestionContent(
                        question = currentQuestion,
                        selectedOptionIndex = selectedOptionIndex,
                        hasAnswered = hasAnsweredMultipleChoice,
                        onSelectOption = { index ->
                            if (!hasAnsweredMultipleChoice) {
                                selectedOptionIndex = index
                            }
                        },
                        onSubmitAnswer = {
                            if (selectedOptionIndex != null) {
                                hasAnsweredMultipleChoice = true
                                val isCorrect = selectedOptionIndex == currentQuestion.correctIndex
                                userReviews.add(
                                    QuestionReview(
                                        questionNumber = currentIndex + 1,
                                        skill = SkillType.READING,
                                        prompt = currentQuestion.questionText,
                                        userAnswer = currentQuestion.options[selectedOptionIndex!!],
                                        correctAnswer = currentQuestion.options[currentQuestion.correctIndex],
                                        isCorrect = isCorrect,
                                        scorePercent = if (isCorrect) 100 else 0,
                                        explanation = currentQuestion.explanation
                                    )
                                )
                            }
                        },
                        onNext = { goToNextQuestion() },
                        isLastQuestion = currentIndex == questions.size - 1
                    )
                }

                is SpeakingQuestion -> {
                    SpeakingQuestionContent(
                        question = currentQuestion,
                        passScore = level.speakingPassScore,
                        isListeningMic = isListeningMic,
                        spokenText = spokenText,
                        accuracyScore = accuracyScore,
                        statusMessage = speakingStatusMessage,
                        onPlayModelAudio = {
                            ttsManager?.speak(currentQuestion.targetSentence, level.listeningSpeechRate)
                        },
                        onMicClick = {
                            if (isListeningMic) {
                                // User finishes speaking: stop listening and analyze without destroying recognizer
                                speechInputManager?.stopListening()
                                isListeningMic = false
                                speakingStatusMessage = "Sedang menganalisis pelafalan suara Anda..."
                            } else {
                                if (speechInputManager != null) {
                                    val hasPermission = ContextCompat.checkSelfPermission(
                                        context,
                                        Manifest.permission.RECORD_AUDIO
                                    ) == PackageManager.PERMISSION_GRANTED

                                    if (hasPermission) {
                                        startSpeakingRecognition(
                                            manager = speechInputManager,
                                            question = currentQuestion,
                                            passScore = level.speakingPassScore,
                                            onListeningChanged = { isListeningMic = it },
                                            onSpoken = { spokenText = it },
                                            onAccuracy = { accuracyScore = it },
                                            onStatus = { speakingStatusMessage = it }
                                        )
                                    } else {
                                        permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                                    }
                                } else {
                                    isListeningMic = true
                                    speakingStatusMessage = "Mendengarkan suara Anda..."
                                }
                            }
                        },
                        onOpenSystemVoiceDialog = {
                            speechInputManager?.stopListening()
                            isListeningMic = false
                            if (!isInspection) {
                                val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                                    putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                                    putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US")
                                    putExtra(RecognizerIntent.EXTRA_PROMPT, "Ucapkan: ${currentQuestion.targetSentence}")
                                }
                                try {
                                    systemVoiceLauncher.launch(intent)
                                } catch (_: Exception) {
                                    speakingStatusMessage = "Dialog suara sistem tidak didukung di perangkat ini."
                                }
                            } else {
                                spokenText = currentQuestion.targetSentence
                                accuracyScore = 90
                                speakingStatusMessage = "Suara terdeteksi! Akurasi: 90% (Simulasi)"
                            }
                        },
                        onQuickPassAndNext = {
                            submitSpeakingAnswer(
                                score = maxOf(level.speakingPassScore, 85),
                                spoken = spokenText.ifBlank { currentQuestion.targetSentence }
                            )
                        },
                        onSubmitAndNext = {
                            val finalScore = accuracyScore ?: if (spokenText.isNotBlank()) {
                                SpeechInputManager.calculateAccuracy(currentQuestion.targetSentence, spokenText)
                            } else {
                                maxOf(level.speakingPassScore, 85)
                            }
                            submitSpeakingAnswer(
                                score = finalScore,
                                spoken = spokenText.ifBlank { currentQuestion.targetSentence }
                            )
                        },
                        isLastQuestion = currentIndex == questions.size - 1
                    )
                }
            }
        }
    }
}

private fun startSpeakingRecognition(
    manager: SpeechInputManager,
    question: SpeakingQuestion,
    passScore: Int,
    onListeningChanged: (Boolean) -> Unit,
    onSpoken: (String) -> Unit,
    onAccuracy: (Int) -> Unit,
    onStatus: (String) -> Unit
) {
    onListeningChanged(true)
    onStatus("Mendengarkan... Ucapkan kalimat target sekarang! (Ketuk mic lagi untuk selesai).")

    manager.startListening(
        targetSentence = question.targetSentence,
        onResult = { text ->
            onListeningChanged(false)
            onSpoken(text)
            val score = SpeechInputManager.calculateAccuracy(question.targetSentence, text)
            onAccuracy(score)
            val passed = score >= passScore
            onStatus(
                if (passed) "🎉 Pelafalan sangat bagus! Skor: $score% (Target: $passScore%)"
                else "Suara terdeteksi: \"$text\" • Skor: $score% (Target: $passScore%)"
            )
        },
        onError = { error ->
            onListeningChanged(false)
            onStatus("Pengenalan suara: $error. Ketuk mic lagi atau klik 'Konfirmasi Suara & Lanjut'.")
        },
        onListeningStateChanged = onListeningChanged
    )
}

// ---------------------------------------------------------------------------
// Section: Listening Question Content
// ---------------------------------------------------------------------------

@Composable
private fun ListeningQuestionContent(
    question: ListeningQuestion,
    isPlayingAudio: Boolean,
    speechRate: Float,
    showTranscript: Boolean,
    selectedOptionIndex: Int?,
    hasAnswered: Boolean,
    onPlayPause: () -> Unit,
    onReplay: () -> Unit,
    onSpeechRateChange: (Float) -> Unit,
    onToggleTranscript: () -> Unit,
    onSelectOption: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onNext: () -> Unit,
    isLastQuestion: Boolean
) {
    // Audio Player Card
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, PrimaryBlue.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = question.audioTitle,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = PrimaryBlueDark
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Speaker: ${question.audioSpeaker}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(14.dp))

            PulsingWaveIndicator(isPlaying = isPlayingAudio, modifier = Modifier.height(26.dp))

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Surface(
                    color = if (isPlayingAudio) AccentOrange else PrimaryBlue,
                    shape = CircleShape,
                    modifier = Modifier
                        .size(56.dp)
                        .clickable { onPlayPause() }
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = if (isPlayingAudio) "⏸" else "▶",
                            fontSize = 22.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Surface(
                    color = PrimaryBlue.copy(alpha = 0.1f),
                    shape = CircleShape,
                    modifier = Modifier
                        .size(46.dp)
                        .clickable { onReplay() }
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "↺", fontSize = 20.sp, color = PrimaryBlue)
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Speech Rate Controls
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Kecepatan:", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                Spacer(modifier = Modifier.width(8.dp))
                listOf(0.75f, 0.85f, 1.0f, 1.25f).forEach { rate ->
                    val isSelected = kotlin.math.abs(speechRate - rate) < 0.05f
                    Surface(
                        color = if (isSelected) PrimaryBlue else PrimaryBlue.copy(alpha = 0.08f),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .padding(horizontal = 3.dp)
                            .clickable { onSpeechRateChange(rate) }
                    ) {
                        Text(
                            text = "${rate}x",
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) Color.White else PrimaryBlue,
                            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Transcript Toggle
            Text(
                text = if (showTranscript) "Sembunyikan Teks ▲" else "Lihat Teks Audio ▼",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = PrimaryBlueLight,
                modifier = Modifier.clickable { onToggleTranscript() }
            )

            if (showTranscript) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(10.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderLight),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = question.audioScript,
                        fontSize = 13.sp,
                        lineHeight = 18.sp,
                        fontStyle = FontStyle.Italic,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }

    // Question Text Card
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderLight)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Pertanyaan:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = AccentOrange
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = question.questionText,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }

    // Multiple Choice Options
    OptionsList(
        options = question.options,
        correctIndex = question.correctIndex,
        selectedOptionIndex = selectedOptionIndex,
        hasAnswered = hasAnswered,
        onSelectOption = onSelectOption
    )

    // Answer Explanation (shown after submitting)
    if (hasAnswered) {
        ExplanationCard(explanation = question.explanation)
    }

    // Bottom Action Buttons
    if (!hasAnswered) {
        Button(
            onClick = onSubmitAnswer,
            enabled = selectedOptionIndex != null,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
        ) {
            Text(text = "Kirim Jawaban ✓", fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }
    } else {
        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
        ) {
            Text(
                text = if (isLastQuestion) "Lihat Hasil Tes 🏆" else "Lanjut Soal Berikutnya ➔",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}

// ---------------------------------------------------------------------------
// Section: Reading Question Content
// ---------------------------------------------------------------------------

@Composable
private fun ReadingQuestionContent(
    question: ReadingQuestion,
    selectedOptionIndex: Int?,
    hasAnswered: Boolean,
    onSelectOption: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onNext: () -> Unit,
    isLastQuestion: Boolean
) {
    // Passage Card
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderLight)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    color = PrimaryBlue.copy(alpha = 0.1f),
                    shape = CircleShape,
                    modifier = Modifier.size(32.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = "📖", fontSize = 16.sp)
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = question.passageTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = PrimaryBlueDark
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Surface(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(10.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderLight)
            ) {
                Text(
                    text = question.passageText,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(14.dp)
                )
            }
        }
    }

    // Question Text Card
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderLight)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Pertanyaan Pemahaman:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = AccentOrange
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = question.questionText,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }

    // Options
    OptionsList(
        options = question.options,
        correctIndex = question.correctIndex,
        selectedOptionIndex = selectedOptionIndex,
        hasAnswered = hasAnswered,
        onSelectOption = onSelectOption
    )

    // Explanation
    if (hasAnswered) {
        ExplanationCard(explanation = question.explanation)
    }

    // Bottom Action
    if (!hasAnswered) {
        Button(
            onClick = onSubmitAnswer,
            enabled = selectedOptionIndex != null,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
        ) {
            Text(text = "Kirim Jawaban ✓", fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }
    } else {
        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
        ) {
            Text(
                text = if (isLastQuestion) "Lihat Hasil Tes 🏆" else "Lanjut Soal Berikutnya ➔",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}

// ---------------------------------------------------------------------------
// Section: Speaking Question Content
// ---------------------------------------------------------------------------

@Composable
private fun SpeakingQuestionContent(
    question: SpeakingQuestion,
    passScore: Int,
    isListeningMic: Boolean,
    spokenText: String,
    accuracyScore: Int?,
    statusMessage: String,
    onPlayModelAudio: () -> Unit,
    onMicClick: () -> Unit,
    onOpenSystemVoiceDialog: () -> Unit,
    onQuickPassAndNext: () -> Unit,
    onSubmitAndNext: () -> Unit,
    isLastQuestion: Boolean
) {
    val infiniteTransition = rememberInfiniteTransition(label = "micPulse")
    val micScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isListeningMic) 1.25f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "micScale"
    )

    // Context Card
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = LogoCyan.copy(alpha = 0.08f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, LogoCyan.copy(alpha = 0.35f))
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_english_trick),
                contentDescription = "Logo English Trick",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "NO SPEAK NO TRICK • SPEAKING",
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp,
                    color = LogoPink
                )
                Text(
                    text = question.context,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            }
        }
    }

    // Target Sentence Card
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, PrimaryBlue.copy(alpha = 0.25f))
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = question.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                color = PrimaryBlue
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "“${question.targetSentence}”",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                textAlign = TextAlign.Center,
                lineHeight = 26.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            if (question.phoneticGuide.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Surface(
                    color = AccentAmber.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = question.phoneticGuide,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = AccentOrange,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Audio Sample Button
            OutlinedButton(
                onClick = onPlayModelAudio,
                shape = RoundedCornerShape(10.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, PrimaryBlueLight)
            ) {
                Text(text = "🔊 Dengarkan Contoh Pelafalan", fontSize = 12.sp, color = PrimaryBlue)
            }
        }
    }

    // Microphone & Speech Area
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderLight)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Big Mic Button
            Surface(
                color = if (isListeningMic) Level5Color else PrimaryBlue,
                shape = CircleShape,
                modifier = Modifier
                    .size(68.dp)
                    .scale(micScale)
                    .clickable { onMicClick() }
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = if (isListeningMic) "⏹" else "🎙️",
                        fontSize = 28.sp,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = if (isListeningMic) "Sedang merekam suara..." else "Ketuk mikrofon untuk mulai bicara",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = if (isListeningMic) Level5Color else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Backup: Google Voice Dialog
            Text(
                text = "Atau gunakan Dialog Suara Google ➔",
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = PrimaryBlueLight,
                modifier = Modifier.clickable { onOpenSystemVoiceDialog() }
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Status message
            Surface(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth(),
                border = androidx.compose.foundation.BorderStroke(1.dp, CardBorderLight)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = statusMessage,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                    if (spokenText.isNotBlank()) {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Terdeteksi: \"$spokenText\"",
                            fontSize = 13.sp,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.SemiBold,
                            color = PrimaryBlueDark
                        )
                    }
                }
            }

            // Quick Continue Button when speaking hasn't completed or had recognition error
            if (accuracyScore == null) {
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedButton(
                    onClick = onQuickPassAndNext,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, PrimaryBlueLight)
                ) {
                    Text(
                        text = "✓ Konfirmasi Suara & Lanjut Soal ➔",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = PrimaryBlue
                    )
                }
            }

            // Accuracy Score Display
            if (accuracyScore != null) {
                Spacer(modifier = Modifier.height(12.dp))
                val passed = accuracyScore >= passScore
                val scoreColor = if (passed) Level1Color else Level5Color
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Skor Akurasi: $accuracyScore%",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = scoreColor
                    )
                    Surface(
                        color = scoreColor.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = if (passed) "✓ LULUS (Min $passScore%)" else "✕ Target: $passScore%",
                            color = scoreColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }
                }

                if (passed) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Otomatis lanjut ke soal berikutnya... atau ketuk tombol di bawah:",
                        fontSize = 11.sp,
                        color = Level1Color,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }

    // Pronunciation Tip Card
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = PrimaryBlue.copy(alpha = 0.05f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, PrimaryBlue.copy(alpha = 0.2f))
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "💡", fontSize = 20.sp)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Tips Pelafalan English Trick",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = PrimaryBlue
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = question.tip,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            }
        }
    }

    // Submit & Next Button
    Button(
        onClick = onSubmitAndNext,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (accuracyScore != null && accuracyScore >= passScore) Level1Color else PrimaryBlue
        )
    ) {
        Text(
            text = if (isLastQuestion) "Selesaikan Tes 🏆" else "Lanjut ke Soal Berikutnya ➔",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
    }
}

// ---------------------------------------------------------------------------
// Common Helper Components
// ---------------------------------------------------------------------------

@Composable
private fun OptionsList(
    options: List<String>,
    correctIndex: Int,
    selectedOptionIndex: Int?,
    hasAnswered: Boolean,
    onSelectOption: (Int) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        options.forEachIndexed { index, optionText ->
            val isSelected = selectedOptionIndex == index
            val isCorrect = index == correctIndex

            val backgroundColor = when {
                !hasAnswered && isSelected -> PrimaryBlue.copy(alpha = 0.1f)
                hasAnswered && isCorrect -> Level1Color.copy(alpha = 0.15f)
                hasAnswered && isSelected && !isCorrect -> Level5Color.copy(alpha = 0.15f)
                else -> MaterialTheme.colorScheme.surface
            }

            val borderColor = when {
                !hasAnswered && isSelected -> PrimaryBlue
                hasAnswered && isCorrect -> Level1Color
                hasAnswered && isSelected && !isCorrect -> Level5Color
                else -> CardBorderLight
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = !hasAnswered) { onSelectOption(index) },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = backgroundColor),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, borderColor)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val optionLabel = ('A' + index).toString()
                    Surface(
                        color = when {
                            !hasAnswered && isSelected -> PrimaryBlue
                            hasAnswered && isCorrect -> Level1Color
                            hasAnswered && isSelected && !isCorrect -> Level5Color
                            else -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
                        },
                        shape = CircleShape,
                        modifier = Modifier.size(30.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = optionLabel,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = if (isSelected || (hasAnswered && isCorrect)) Color.White else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = optionText,
                        fontSize = 14.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )

                    if (hasAnswered) {
                        if (isCorrect) {
                            Text(text = "✓", color = Level1Color, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        } else if (isSelected) {
                            Text(text = "✕", color = Level5Color, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ExplanationCard(explanation: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = PrimaryBlue.copy(alpha = 0.06f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, PrimaryBlue.copy(alpha = 0.25f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "💡", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Penjelasan:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = PrimaryBlue
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = explanation,
                fontSize = 13.sp,
                lineHeight = 18.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.85f)
            )
        }
    }
}

// ---------------------------------------------------------------------------
// Preview
// ---------------------------------------------------------------------------

@Preview(showBackground = true, name = "Quiz Screen - Kids Level 1")
@Composable
private fun QuizScreenKidsPreview() {
    AppMobileEnglishTrickTheme {
        QuizScreen(
            category = TestCategory.KIDS,
            level = DifficultyLevel.LEVEL_1,
            ttsManager = null,
            onTestFinished = {},
            onBackClick = {}
        )
    }
}
