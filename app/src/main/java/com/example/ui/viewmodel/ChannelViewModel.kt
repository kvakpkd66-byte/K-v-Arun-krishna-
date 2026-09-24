package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.SavedVideoEntity
import com.example.data.model.ChannelInfo
import com.example.data.model.CreatorProfile
import com.example.data.model.FacebookPageInfo
import com.example.data.model.KrishnaStory
import com.example.data.model.VideoCategory
import com.example.data.model.VideoItem
import com.example.data.repository.ChannelRepository
import com.example.data.repository.KrishnaStoriesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ChannelUiState(
    val selectedChannelId: String? = null, // null means "All Channels"
    val selectedCategory: VideoCategory = VideoCategory.ALL,
    val searchQuery: String = "",
    val activeVideo: VideoItem? = null,
    val isAddVideoDialogOpen: Boolean = false,
    val isFeedbackDialogOpen: Boolean = false,
    val isPromoDialogOpen: Boolean = false,
    val isRefreshing: Boolean = false,
    val userFeedbackMessage: String = "",
    val snackbarMessage: String? = null
)

class ChannelViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ChannelRepository(AppDatabase.getDatabase(application))

    val channels: List<ChannelInfo> = repository.channels
    val facebookPages: List<FacebookPageInfo> = repository.facebookPages
    val creatorProfile: CreatorProfile = repository.creatorProfile
    val sisterApp = repository.sisterApp
    val krishnaStories: List<KrishnaStory> = KrishnaStoriesRepository.stories

    private val _uiState = MutableStateFlow(ChannelUiState())
    val uiState: StateFlow<ChannelUiState> = _uiState.asStateFlow()

    private val _baseVideos = MutableStateFlow(repository.getInitialVideos())

    // Room DB streams
    val favoriteVideos: StateFlow<List<SavedVideoEntity>> = repository.favoriteVideosFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val watchLaterVideos: StateFlow<List<SavedVideoEntity>> = repository.watchLaterVideosFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val allSavedVideos: StateFlow<List<SavedVideoEntity>> = repository.allSavedVideosFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val channelAlerts = repository.channelAlertsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Combined filtered video list
    val filteredVideos: StateFlow<List<VideoItem>> = combine(
        _baseVideos,
        allSavedVideos,
        _uiState
    ) { baseList, savedList, state ->
        // Merge base curated videos with user-added custom videos
        val customVideos = savedList.filter { it.isShort || it.category.isNotEmpty() }.map { it.toVideoItem() }
        val allUnique = (baseList + customVideos).distinctBy { it.id }

        allUnique.filter { video ->
            // Filter by channel
            val matchesChannel = state.selectedChannelId == null || video.channelId == state.selectedChannelId

            // Filter by category
            val matchesCategory = when (state.selectedCategory) {
                VideoCategory.ALL -> true
                VideoCategory.SHORTS -> video.isShort
                else -> video.category == state.selectedCategory
            }

            // Filter by search query
            val matchesQuery = if (state.searchQuery.isBlank()) {
                true
            } else {
                val q = state.searchQuery.trim().lowercase()
                video.title.lowercase().contains(q) ||
                        video.channelTitle.lowercase().contains(q) ||
                        video.channelHandle.lowercase().contains(q) ||
                        video.description.lowercase().contains(q) ||
                        video.tags.any { it.lowercase().contains(q) }
            }

            matchesChannel && matchesCategory && matchesQuery
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), repository.getInitialVideos())

    fun selectChannelFilter(channelId: String?) {
        _uiState.value = _uiState.value.copy(selectedChannelId = channelId)
    }

    fun selectCategoryFilter(category: VideoCategory) {
        _uiState.value = _uiState.value.copy(selectedCategory = category)
    }

    fun updateSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun clearSearch() {
        _uiState.value = _uiState.value.copy(searchQuery = "")
    }

    fun setActiveVideo(video: VideoItem) {
        _uiState.value = _uiState.value.copy(activeVideo = video)
    }

    fun setAddVideoDialog(open: Boolean) {
        _uiState.value = _uiState.value.copy(isAddVideoDialogOpen = open)
    }

    fun setFeedbackDialog(open: Boolean) {
        _uiState.value = _uiState.value.copy(isFeedbackDialogOpen = open)
    }

    fun setPromoDialog(open: Boolean) {
        _uiState.value = _uiState.value.copy(isPromoDialogOpen = open)
    }

    fun refreshContent() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isRefreshing = true)
            kotlinx.coroutines.delay(750)
            _baseVideos.value = repository.getInitialVideos()
            _uiState.value = _uiState.value.copy(isRefreshing = false)
            showSnackbar("Content refreshed!")
        }
    }

    fun toggleFavorite(video: VideoItem) {
        viewModelScope.launch {
            repository.toggleFavorite(video)
            showSnackbar("Updated Favorites")
        }
    }

    fun toggleWatchLater(video: VideoItem) {
        viewModelScope.launch {
            repository.toggleWatchLater(video)
            showSnackbar("Updated Watch Later")
        }
    }

    fun saveNote(videoId: String, video: VideoItem, note: String) {
        viewModelScope.launch {
            repository.saveUserNote(videoId, video, note)
            showSnackbar("Note saved!")
        }
    }

    fun addCustomVideo(rawInput: String, channelId: String, title: String, category: VideoCategory) {
        viewModelScope.launch {
            val added = repository.addCustomVideo(rawInput, channelId, title, category)
            if (added != null) {
                showSnackbar("Added video \"${added.title}\" to hub!")
                setAddVideoDialog(false)
            } else {
                showSnackbar("Invalid YouTube URL or Video ID. Please check and retry.")
            }
        }
    }

    fun toggleChannelAlert(channelId: String, currentEnabled: Boolean) {
        viewModelScope.launch {
            repository.toggleChannelAlert(channelId, !currentEnabled)
            showSnackbar(if (!currentEnabled) "Alerts enabled for channel" else "Alerts muted")
        }
    }

    fun showSnackbar(message: String) {
        _uiState.value = _uiState.value.copy(snackbarMessage = message)
    }

    fun dismissSnackbar() {
        _uiState.value = _uiState.value.copy(snackbarMessage = null)
    }
}
