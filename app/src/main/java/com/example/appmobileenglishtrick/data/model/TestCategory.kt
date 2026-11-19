package com.example.appmobileenglishtrick.data.model

/**
 * Program categories shown on the home screen.
 * Every category contains 5 levels; every level mixes Listening, Speaking and Reading questions.
 */
enum class TestCategory(
    val id: String,
    val title: String,
    val subtitle: String,
    val iconEmoji: String,
    val description: String
) {
    KIDS(
        id = "kids",
        title = "English for Kids",
        subtitle = "Fun basics for young learners",
        iconEmoji = "🧸",
        description = "Belajar bahasa Inggris yang seru untuk anak: kosakata dasar, kalimat sederhana, dan cerita pendek. Setiap level mengukur kemampuan Listening, Speaking, dan Reading."
    ),
    TEENS(
        id = "teens",
        title = "English for Teens",
        subtitle = "School, hobbies & daily life",
        iconEmoji = "🎒",
        description = "Bahasa Inggris untuk remaja: topik sekolah, hobi, teman, dan kehidupan sehari-hari. Setiap level mengukur kemampuan Listening, Speaking, dan Reading."
    ),
    SPEAKING_BOOSTER(
        id = "speaking_booster",
        title = "Speaking Booster",
        subtitle = "Fluency & confident conversation",
        iconEmoji = "🚀",
        description = "Latihan intensif untuk berbicara lancar dan percaya diri dalam percakapan nyata, dengan dukungan Listening dan Reading. English Trick No Speak No Trick!"
    )
}
