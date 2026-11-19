package com.example.appmobileenglishtrick.data.model

sealed interface BaseQuestion {
    val id: String
    val category: TestCategory
    val level: DifficultyLevel
    val skill: SkillType
}

data class ReadingQuestion(
    override val id: String,
    override val category: TestCategory,
    override val level: DifficultyLevel,
    val passageTitle: String,
    val passageText: String,
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
) : BaseQuestion {
    override val skill: SkillType = SkillType.READING
}

data class ListeningQuestion(
    override val id: String,
    override val category: TestCategory,
    override val level: DifficultyLevel,
    val audioTitle: String,
    val audioSpeaker: String,
    val audioScript: String,
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
) : BaseQuestion {
    override val skill: SkillType = SkillType.LISTENING
}

data class SpeakingQuestion(
    override val id: String,
    override val category: TestCategory,
    override val level: DifficultyLevel,
    val title: String,
    val context: String,
    val targetSentence: String,
    val tip: String,
    val phoneticGuide: String = ""
) : BaseQuestion {
    override val skill: SkillType = SkillType.SPEAKING
}
