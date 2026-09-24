package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDao {
    @Query("SELECT * FROM saved_videos ORDER BY savedTimestamp DESC")
    fun getAllSavedVideos(): Flow<List<SavedVideoEntity>>

    @Query("SELECT * FROM saved_videos WHERE isFavorite = 1 ORDER BY savedTimestamp DESC")
    fun getFavoriteVideos(): Flow<List<SavedVideoEntity>>

    @Query("SELECT * FROM saved_videos WHERE isWatchLater = 1 ORDER BY savedTimestamp DESC")
    fun getWatchLaterVideos(): Flow<List<SavedVideoEntity>>

    @Query("SELECT * FROM saved_videos WHERE videoId = :id LIMIT 1")
    suspend fun getSavedVideoById(id: String): SavedVideoEntity?

    @Query("SELECT * FROM saved_videos WHERE videoId = :id LIMIT 1")
    fun observeSavedVideoById(id: String): Flow<SavedVideoEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(video: SavedVideoEntity)

    @Update
    suspend fun update(video: SavedVideoEntity)

    @Query("DELETE FROM saved_videos WHERE videoId = :id")
    suspend fun deleteById(id: String)

    @Query("SELECT * FROM channel_alerts")
    fun getAllChannelAlerts(): Flow<List<ChannelAlertEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setChannelAlert(alert: ChannelAlertEntity)

    @Query("SELECT * FROM channel_alerts WHERE channelId = :channelId LIMIT 1")
    suspend fun getChannelAlert(channelId: String): ChannelAlertEntity?
}
