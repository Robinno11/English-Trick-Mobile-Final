package com.example.appmobileenglishtrick.data.model

/**
 * The language skills measured inside every level.
 * Declaration order is also the order in which questions appear in a level.
 */
enum class SkillType(
    val title: String,
    val iconEmoji: String
) {
    LISTENING(title = "Listening", iconEmoji = "🎧"),
    READING(title = "Reading", iconEmoji = "📖"),
    SPEAKING(title = "Speaking", iconEmoji = "🎙️")
}
