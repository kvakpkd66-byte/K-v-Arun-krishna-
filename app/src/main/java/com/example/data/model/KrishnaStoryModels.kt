package com.example.data.model

data class KrishnaQuizQuestion(
    val question: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String
)

data class KrishnaStory(
    val id: String,
    val chapter: Int,
    val title: String,
    val subtitle: String,
    val moralLesson: String,
    val quote: String,
    val emoji: String,
    val accentColorHex: Long,
    val readingTimeMinutes: Int,
    val summary: String,
    val fullStoryParagraphs: List<String>,
    val audioTrackName: String,
    val relatedYouTubeVideoId: String,
    val tags: List<String>,
    val quiz: List<KrishnaQuizQuestion>
)

data class KrishnaQuizResult(
    val storyId: String,
    val score: Int,
    val totalQuestions: Int,
    val passed: Boolean
)
