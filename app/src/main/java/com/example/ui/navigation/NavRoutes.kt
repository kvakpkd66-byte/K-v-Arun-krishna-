package com.example.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Subscriptions
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val testTag: String
) {
    data object Home : BottomNavScreen(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home,
        testTag = "bottom_nav_home"
    )

    data object WebPortal : BottomNavScreen(
        route = "web_portal",
        title = "Web Portal",
        icon = Icons.Filled.Language,
        testTag = "bottom_nav_web_portal"
    )

    data object KrishnaStories : BottomNavScreen(
        route = "krishna_stories",
        title = "Krishna Stories",
        icon = Icons.Filled.AutoStories,
        testTag = "bottom_nav_krishna_stories"
    )

    data object Channels : BottomNavScreen(
        route = "channels",
        title = "Channels",
        icon = Icons.Filled.Subscriptions,
        testTag = "bottom_nav_channels"
    )

    data object Favorites : BottomNavScreen(
        route = "favorites",
        title = "Favorites",
        icon = Icons.Filled.Favorite,
        testTag = "bottom_nav_favorites"
    )
}

object NavRoutes {
    const val HOME = "home"
    const val WEB_PORTAL = "web_portal"
    const val KRISHNA_STORIES = "krishna_stories"
    const val CHANNELS = "channels"
    const val FAVORITES = "favorites"
    const val PLAYER = "player/{videoId}"
    const val CREATOR = "creator"

    fun player(videoId: String): String = "player/$videoId"

    val bottomNavScreens = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.WebPortal,
        BottomNavScreen.KrishnaStories,
        BottomNavScreen.Channels,
        BottomNavScreen.Favorites
    )
}
