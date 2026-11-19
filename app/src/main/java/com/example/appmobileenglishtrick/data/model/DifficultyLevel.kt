package com.example.appmobileenglishtrick.data.model

/**
 * Five progressive levels. The higher the level, the harder the material:
 * - Listening audio is played faster by default ([listeningSpeechRate]).
 * - Speaking answers need a higher pronunciation accuracy to pass ([speakingPassScore]).
 * - Reading passages and vocabulary become longer and more complex (see question content).
 */
enum class DifficultyLevel(
    val number: Int,
    val title: String,
    val tag: String,
    val description: String,
    val estimatedMinutes: Int,
    val listeningSpeechRate: Float,
    val speakingPassScore: Int
) {
    LEVEL_1(
        number = 1,
        title = "Level 1",
        tag = "Starter",
        description = "Kosakata dasar, kalimat sangat pendek, dan audio yang diputar pelan.",
        estimatedMinutes = 5,
        listeningSpeechRate = 0.75f,
        speakingPassScore = 50
    ),
    LEVEL_2(
        number = 2,
        title = "Level 2",
        tag = "Elementary",
        description = "Kalimat sederhana sehari-hari, teks pendek, dan percakapan singkat.",
        estimatedMinutes = 6,
        listeningSpeechRate = 0.85f,
        speakingPassScore = 55
    ),
    LEVEL_3(
        number = 3,
        title = "Level 3",
        tag = "Pre-Intermediate",
        description = "Cerita dan dialog lebih panjang, kalimat majemuk, dan kecepatan audio normal.",
        estimatedMinutes = 8,
        listeningSpeechRate = 0.95f,
        speakingPassScore = 60
    ),
    LEVEL_4(
        number = 4,
        title = "Level 4",
        tag = "Intermediate",
        description = "Teks informatif, opini, ungkapan umum, dan pertanyaan inferensi.",
        estimatedMinutes = 10,
        listeningSpeechRate = 1.0f,
        speakingPassScore = 70
    ),
    LEVEL_5(
        number = 5,
        title = "Level 5",
        tag = "Advanced",
        description = "Bacaan kompleks, idiom, audio cepat, dan kalimat panjang yang menantang.",
        estimatedMinutes = 12,
        listeningSpeechRate = 1.1f,
        speakingPassScore = 75
    );

    val next: DifficultyLevel?
        get() = entries.getOrNull(ordinal + 1)
}
