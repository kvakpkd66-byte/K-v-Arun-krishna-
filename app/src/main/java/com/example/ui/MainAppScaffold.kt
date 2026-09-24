package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.components.AddVideoDialog
import com.example.ui.components.PromoStudioDialog
import com.example.ui.navigation.BottomNavScreen
import com.example.ui.navigation.NavRoutes
import com.example.ui.screens.ChannelsScreen
import com.example.ui.screens.CreatorScreen
import com.example.ui.screens.FeedScreen
import com.example.ui.screens.KrishnaStoriesScreen
import com.example.ui.screens.LibraryScreen
import com.example.ui.screens.PlayerScreen
import com.example.ui.screens.WebPortalScreen
import com.example.ui.viewmodel.ChannelViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScaffold(
    viewModel: ChannelViewModel,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val filteredVideos by viewModel.filteredVideos.collectAsStateWithLifecycle()
    val favoriteVideos by viewModel.favoriteVideos.collectAsStateWithLifecycle()
    val watchLaterVideos by viewModel.watchLaterVideos.collectAsStateWithLifecycle()
    val allSavedVideos by viewModel.allSavedVideos.collectAsStateWithLifecycle()
    val channelAlerts by viewModel.channelAlerts.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.snackbarMessage) {
        uiState.snackbarMessage?.let { msg ->
            snackbarHostState.showSnackbar(msg)
            viewModel.dismissSnackbar()
        }
    }

    // Determine visibility of TopBar and BottomBar
    val isPlayerRoute = currentRoute?.startsWith("player") == true
    val isCreatorRoute = currentRoute == NavRoutes.CREATOR
    val isMainTabRoute = currentRoute in listOf(
        NavRoutes.HOME,
        NavRoutes.WEB_PORTAL,
        NavRoutes.KRISHNA_STORIES,
        NavRoutes.CHANNELS,
        NavRoutes.FAVORITES
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            // Hide the main scaffold top bar on the player route since PlayerScreen has its own custom toolbar
            if (!isPlayerRoute) {
                TopAppBar(
                    title = {
                        Text(
                            text = when (currentRoute) {
                                NavRoutes.HOME -> if (uiState.selectedChannelId != null) {
                                    viewModel.channels.find { it.id == uiState.selectedChannelId }?.title ?: "Feed"
                                } else "Kvak & Bubly Hub"
                                NavRoutes.WEB_PORTAL -> "Web Portal • kvakbubly.com"
                                NavRoutes.KRISHNA_STORIES -> "KVAK23 Krishna Stories"
                                NavRoutes.CHANNELS -> "YouTube Channels"
                                NavRoutes.FAVORITES -> "Favorites & Saved"
                                NavRoutes.CREATOR -> "Creator Profile"
                                else -> "KvakBubly Hub"
                            },
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        if (isCreatorRoute) {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    },
                    actions = {
                        // Quick Add Video button for Home & Favorites
                        if (currentRoute == NavRoutes.HOME || currentRoute == NavRoutes.FAVORITES) {
                            IconButton(
                                onClick = { viewModel.setAddVideoDialog(true) },
                                modifier = Modifier.testTag("appbar_add_video_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "Add Video"
                                )
                            }
                        }

                        // Promo Studio / Publish & QR Kit button
                        IconButton(
                            onClick = { viewModel.setPromoDialog(true) },
                            modifier = Modifier.testTag("appbar_promo_button")
                        ) {
                            Icon(
                                imageVector = Icons.Filled.QrCode,
                                contentDescription = "Promo & QR Codes"
                            )
                        }

                        // Creator Connect Profile button
                        if (!isCreatorRoute) {
                            IconButton(
                                onClick = { navController.navigate(NavRoutes.CREATOR) },
                                modifier = Modifier.testTag("appbar_creator_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.AccountCircle,
                                    contentDescription = "Creator Profile"
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        },
        bottomBar = {
            // Bottom navigation bar displaying Home, Channels, Favorites
            AnimatedVisibility(
                visible = isMainTabRoute,
                enter = slideInVertically(initialOffsetY = { it }),
                exit = slideOutVertically(targetOffsetY = { it })
            ) {
                NavigationBar(
                    modifier = Modifier
                        .windowInsetsPadding(WindowInsets.navigationBars)
                        .testTag("bottom_navigation_bar"),
                    containerColor = MaterialTheme.colorScheme.surface
                ) {
                    NavRoutes.bottomNavScreens.forEach { screen ->
                        val isSelected = currentRoute == screen.route
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                if (currentRoute != screen.route) {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = screen.icon,
                                    contentDescription = screen.title
                                )
                            },
                            label = { Text(screen.title) },
                            modifier = Modifier.testTag(screen.testTag),
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.White,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        )
                    }
                }
            }
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(if (isPlayerRoute) androidx.compose.foundation.layout.PaddingValues(0.dp) else innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = NavRoutes.HOME,
                modifier = Modifier.fillMaxSize()
            ) {
                // 1. Home Destination (FeedScreen)
                composable(NavRoutes.HOME) {
                    FeedScreen(
                        videos = filteredVideos,
                        channels = viewModel.channels,
                        selectedChannelId = uiState.selectedChannelId,
                        selectedCategory = uiState.selectedCategory,
                        searchQuery = uiState.searchQuery,
                        savedVideos = allSavedVideos,
                        onSelectChannel = { channelId -> viewModel.selectChannelFilter(channelId) },
                        onSelectCategory = { category -> viewModel.selectCategoryFilter(category) },
                        onSearchChange = { q -> viewModel.updateSearchQuery(q) },
                        onClearSearch = { viewModel.clearSearch() },
                        onPlayVideo = { video ->
                            viewModel.setActiveVideo(video)
                            navController.navigate(NavRoutes.player(video.id))
                        },
                        onToggleFavorite = { video -> viewModel.toggleFavorite(video) },
                        onToggleWatchLater = { video -> viewModel.toggleWatchLater(video) },
                        isRefreshing = uiState.isRefreshing,
                        onRefresh = { viewModel.refreshContent() }
                    )
                }

                // 2. Web Portal Destination (Live WordPress Site & Offline Mirror)
                composable(NavRoutes.WEB_PORTAL) {
                    WebPortalScreen()
                }

                // 3. Krishna Stories Destination (KVAK23 Native Rebuilt Edition)
                composable(NavRoutes.KRISHNA_STORIES) {
                    KrishnaStoriesScreen(
                        stories = viewModel.krishnaStories,
                        sisterApp = viewModel.sisterApp,
                        isRefreshing = uiState.isRefreshing,
                        onRefresh = { viewModel.refreshContent() },
                        onPlayRelatedVideo = { videoId ->
                            val video = allSavedVideos.find { it.videoId == videoId }?.toVideoItem()
                                ?: filteredVideos.find { it.id == videoId }
                                ?: com.example.data.model.VideoItem(
                                    id = videoId,
                                    channelId = "ch_kiddies",
                                    channelHandle = "@kvakkiddiesai",
                                    channelTitle = "Kvak Kiddies AI",
                                    title = "Krishna Stories Animated Episode",
                                    description = "Animated story episode by @kvakkiddiesai",
                                    duration = "8:30",
                                    publishDate = "Recent",
                                    views = "1.2K views",
                                    category = com.example.data.model.VideoCategory.KRISHNA_STORIES
                                )
                            viewModel.setActiveVideo(video)
                            navController.navigate(NavRoutes.player(videoId))
                        }
                    )
                }

                // 3. Channels Destination (ChannelsScreen)
                composable(NavRoutes.CHANNELS) {
                    ChannelsScreen(
                        channels = viewModel.channels,
                        facebookPages = viewModel.facebookPages,
                        channelAlerts = channelAlerts,
                        isRefreshing = uiState.isRefreshing,
                        onRefresh = { viewModel.refreshContent() },
                        onChannelSelect = { channelId ->
                            viewModel.selectChannelFilter(channelId)
                            // Navigate to Home tab to show videos for this channel
                            navController.navigate(NavRoutes.HOME) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        onToggleAlert = { channelId, currentEnabled ->
                            viewModel.toggleChannelAlert(channelId, currentEnabled)
                        }
                    )
                }

                // 3. Favorites Destination (LibraryScreen)
                composable(NavRoutes.FAVORITES) {
                    LibraryScreen(
                        favoriteVideos = favoriteVideos,
                        watchLaterVideos = watchLaterVideos,
                        allSavedVideos = allSavedVideos,
                        onPlayVideo = { video ->
                            viewModel.setActiveVideo(video)
                            navController.navigate(NavRoutes.player(video.id))
                        },
                        onToggleFavorite = { video -> viewModel.toggleFavorite(video) },
                        onToggleWatchLater = { video -> viewModel.toggleWatchLater(video) },
                        onOpenAddVideoDialog = { viewModel.setAddVideoDialog(true) }
                    )
                }

                // 4. Video Player Destination (PlayerScreen)
                composable(
                    route = NavRoutes.PLAYER,
                    arguments = listOf(
                        navArgument("videoId") { type = NavType.StringType }
                    )
                ) { backStackEntry ->
                    val videoId = backStackEntry.arguments?.getString("videoId") ?: ""
                    val currentVideo = filteredVideos.find { it.id == videoId }
                        ?: allSavedVideos.find { it.videoId == videoId }?.toVideoItem()
                        ?: uiState.activeVideo

                    if (currentVideo != null) {
                        val savedEntity = allSavedVideos.find { it.videoId == currentVideo.id }
                        PlayerScreen(
                            video = currentVideo,
                            channels = viewModel.channels,
                            allVideos = filteredVideos,
                            savedEntity = savedEntity,
                            onBack = { navController.popBackStack() },
                            onSelectRelatedVideo = { newVideo ->
                                viewModel.setActiveVideo(newVideo)
                                navController.navigate(NavRoutes.player(newVideo.id)) {
                                    popUpTo(NavRoutes.player(currentVideo.id)) {
                                        inclusive = true
                                    }
                                }
                            },
                            onToggleFavorite = { v -> viewModel.toggleFavorite(v) },
                            onToggleWatchLater = { v -> viewModel.toggleWatchLater(v) },
                            onSaveNote = { id, v, note -> viewModel.saveNote(id, v, note) }
                        )
                    } else {
                        LaunchedEffect(Unit) {
                            navController.popBackStack()
                        }
                    }
                }

                // 5. Creator Profile Destination (CreatorScreen)
                composable(NavRoutes.CREATOR) {
                    CreatorScreen(
                        profile = viewModel.creatorProfile,
                        channels = viewModel.channels,
                        facebookPages = viewModel.facebookPages,
                        sisterApp = viewModel.sisterApp,
                        onOpenPromoStudio = { viewModel.setPromoDialog(true) }
                    )
                }
            }
        }

        // Add Video Dialog
        if (uiState.isAddVideoDialogOpen) {
            AddVideoDialog(
                channels = viewModel.channels,
                onDismiss = { viewModel.setAddVideoDialog(false) },
                onAddVideo = { urlOrId, channelId, title, category ->
                    viewModel.addCustomVideo(urlOrId, channelId, title, category)
                }
            )
        }

        // Publish & Promo Studio Dialog
        if (uiState.isPromoDialogOpen) {
            PromoStudioDialog(
                channels = viewModel.channels,
                facebookPages = viewModel.facebookPages,
                sisterApp = viewModel.sisterApp,
                onDismiss = { viewModel.setPromoDialog(false) }
            )
        }
    }
}
