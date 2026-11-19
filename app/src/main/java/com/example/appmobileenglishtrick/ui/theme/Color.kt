package com.example.appmobileenglishtrick.ui.theme

import androidx.compose.ui.graphics.Color
import com.example.appmobileenglishtrick.data.model.DifficultyLevel

// Primary English Trick Brand Colors
val PrimaryBlue = Color(0xFF1E3A8A)
val PrimaryBlueLight = Color(0xFF3B82F6)
val PrimaryBlueDark = Color(0xFF172554)

val AccentOrange = Color(0xFFF97316)
val AccentAmber = Color(0xFFF59E0B)
val LogoCyan = Color(0xFF00A8CC)
val LogoPink = Color(0xFFFF1493)

val LevelEasy = Color(0xFF10B981)
val LevelEasyBg = Color(0xFFECFDF5)

val LevelMedium = Color(0xFFF59E0B)
val LevelMediumBg = Color(0xFFFFFBEB)

val LevelHard = Color(0xFFEF4444)
val LevelHardBg = Color(0xFFFEF2F2)

// Level 1 - 5 Colors (progressively "hotter" as difficulty rises)
val Level1Color = Color(0xFF10B981)
val Level1Bg = Color(0xFFECFDF5)
val Level2Color = Color(0xFF0EA5E9)
val Level2Bg = Color(0xFFF0F9FF)
val Level3Color = Color(0xFF6366F1)
val Level3Bg = Color(0xFFEEF2FF)
val Level4Color = Color(0xFFF59E0B)
val Level4Bg = Color(0xFFFFFBEB)
val Level5Color = Color(0xFFEF4444)
val Level5Bg = Color(0xFFFEF2F2)

fun DifficultyLevel.color(): Color = when (this) {
    DifficultyLevel.LEVEL_1 -> Level1Color
    DifficultyLevel.LEVEL_2 -> Level2Color
    DifficultyLevel.LEVEL_3 -> Level3Color
    DifficultyLevel.LEVEL_4 -> Level4Color
    DifficultyLevel.LEVEL_5 -> Level5Color
}

fun DifficultyLevel.bgColor(): Color = when (this) {
    DifficultyLevel.LEVEL_1 -> Level1Bg
    DifficultyLevel.LEVEL_2 -> Level2Bg
    DifficultyLevel.LEVEL_3 -> Level3Bg
    DifficultyLevel.LEVEL_4 -> Level4Bg
    DifficultyLevel.LEVEL_5 -> Level5Bg
}

// Neutral Colors
val SurfaceLight = Color(0xFFFFFFFF)
val BackgroundLight = Color(0xFFF8FAFC)
val CardBorderLight = Color(0xFFE2E8F0)
val TextPrimaryLight = Color(0xFF0F172A)
val TextSecondaryLight = Color(0xFF64748B)

// Dark Theme Variants
val SurfaceDark = Color(0xFF1E293B)
val BackgroundDark = Color(0xFF0F172A)
val TextPrimaryDark = Color(0xFFF8FAFC)
val TextSecondaryDark = Color(0xFF94A3B8)