package com.example.appmobileenglishtrick.data.repository

import com.example.appmobileenglishtrick.data.model.BaseQuestion
import com.example.appmobileenglishtrick.data.model.DifficultyLevel
import com.example.appmobileenglishtrick.data.model.SkillType
import com.example.appmobileenglishtrick.data.model.TestCategory
import com.example.appmobileenglishtrick.data.repository.content.kidsQuestions
import com.example.appmobileenglishtrick.data.repository.content.speakingBoosterQuestions
import com.example.appmobileenglishtrick.data.repository.content.teensQuestions

object TestRepository {

    private val allQuestions: List<BaseQuestion> by lazy {
        kidsQuestions + teensQuestions + speakingBoosterQuestions
    }

    /**
     * Returns the questions of one level, ordered by skill
     * (Listening → Reading → Speaking) so the quiz flows section by section.
     */
    fun getQuestions(category: TestCategory, level: DifficultyLevel): List<BaseQuestion> {
        return allQuestions
            .filter { it.category == category && it.level == level }
            .sortedBy { it.skill.ordinal }
    }

    fun getTotalQuestionCount(category: TestCategory, level: DifficultyLevel): Int {
        return getQuestions(category, level).size
    }

    /** Skills measured in a level, in quiz order. */
    fun getSkills(category: TestCategory, level: DifficultyLevel): List<SkillType> {
        return getQuestions(category, level).map { it.skill }.distinct()
    }
}
