package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_alerts")
data class ChannelAlertEntity(
    @PrimaryKey
    val channelId: String,
    val isSubscribedLocally: Boolean = true,
    val notificationsEnabled: Boolean = true,
    val lastNotifiedTimestamp: Long = 0L
)
