package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.VideoCategory
import com.example.data.model.VideoItem

@Entity(tableName = "saved_videos")
data class SavedVideoEntity(
    @PrimaryKey
    val videoId: String,
    val channelId: String,
    val channelHandle: String,
    val channelTitle: String,
    val title: String,
    val description: String,
    val duration: String,
    val publishDate: String,
    val views: String,
    val category: String,
    val isShort: Boolean,
    val isFavorite: Boolean,
    val isWatchLater: Boolean,
    val userNotes: String = "",
    val savedTimestamp: Long = System.currentTimeMillis()
) {
    fun toVideoItem(): VideoItem {
        val cat = try {
            VideoCategory.valueOf(category)
        } catch (_: Exception) {
            VideoCategory.ALL
        }
        return VideoItem(
            id = videoId,
            channelId = channelId,
            channelHandle = channelHandle,
            channelTitle = channelTitle,
            title = title,
            description = description,
            duration = duration,
            publishDate = publishDate,
            views = views,
            category = cat,
            isShort = isShort,
            isCustomUserAdded = true
        )
    }

    companion object {
        fun fromVideoItem(
            item: VideoItem,
            isFavorite: Boolean = false,
            isWatchLater: Boolean = false,
            userNotes: String = ""
        ): SavedVideoEntity {
            return SavedVideoEntity(
                videoId = item.id,
                channelId = item.channelId,
                channelHandle = item.channelHandle,
                channelTitle = item.channelTitle,
                title = item.title,
                description = item.description,
                duration = item.duration,
                publishDate = item.publishDate,
                views = item.views,
                category = item.category.name,
                isShort = item.isShort,
                isFavorite = isFavorite,
                isWatchLater = isWatchLater,
                userNotes = userNotes
            )
        }
    }
}
