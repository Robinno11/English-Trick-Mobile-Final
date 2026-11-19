package com.example.appmobileenglishtrick.data.model

data class QuestionReview(
    val questionNumber: Int,
    val skill: SkillType,
    val prompt: String,
    val userAnswer: String,
    val correctAnswer: String,
    val isCorrect: Boolean,
    /** 0 - 100. Multiple choice: 100 or 0. Speaking: pronunciation accuracy. */
    val scorePercent: Int,
    val explanation: String
)

data class TestResult(
    val category: TestCategory,
    val level: DifficultyLevel,
    val reviews: List<QuestionReview>,
    val timeSpentSeconds: Int = 0
) {
    val totalQuestions: Int
        get() = reviews.size

    val correctCount: Int
        get() = reviews.count { it.isCorrect }

    /** Overall score 0 - 100 (average of every question score). */
    val score: Int
        get() = if (reviews.isEmpty()) 0 else reviews.map { it.scorePercent }.average().toInt()

    /** Score 0 - 100 per measured skill (Listening, Reading, Speaking). */
    val skillScores: Map<SkillType, Int>
        get() = SkillType.entries
            .mapNotNull { skill ->
                val skillReviews = reviews.filter { it.skill == skill }
                if (skillReviews.isEmpty()) null
                else skill to skillReviews.map { it.scorePercent }.average().toInt()
            }
            .toMap()

    val grade: String
        get() = gradeFor(score)

    val feedbackMessage: String
        get() = when {
            score >= 85 -> "Outstanding! You proved: English Trick No Speak No Trick!"
            score >= 70 -> "Great performance! Keep sharpening your skills with English Trick!"
            score >= 55 -> "Good effort! Remember: No Speak No Trick, practice consistently!"
            else -> "Don't give up! Practice makes perfect with English Trick!"
        }

    companion object {
        fun gradeFor(score: Int): String = when {
            score >= 85 -> "A (Excellent)"
            score >= 70 -> "B (Good Job)"
            score >= 55 -> "C (Needs Practice)"
            else -> "D (Keep Trying)"
        }

        /** Short skill-ability label used in the result breakdown. */
        fun abilityLabel(score: Int): String = when {
            score >= 85 -> "Sangat Baik"
            score >= 70 -> "Baik"
            score >= 55 -> "Cukup"
            else -> "Perlu Latihan"
        }
    }
}
