package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.model.VideoCategory
import com.example.data.repository.ChannelRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("KvakBubly Hub", appName)
  }

  @Test
  fun `test YouTube ID extraction`() {
    val id1 = ChannelRepository.extractYouTubeId("https://www.youtube.com/watch?v=7xL_8W3J35A")
    assertEquals("7xL_8W3J35A", id1)

    val id2 = ChannelRepository.extractYouTubeId("https://youtu.be/kJQP7kiw5Fk")
    assertEquals("kJQP7kiw5Fk", id2)

    val id3 = ChannelRepository.extractYouTubeId("https://www.youtube.com/shorts/EngW7tLk6R8")
    assertEquals("EngW7tLk6R8", id3)

    val id4 = ChannelRepository.extractYouTubeId("9bZkp7q19f0")
    assertEquals("9bZkp7q19f0", id4)
  }

  @Test
  fun `test bottom navigation destinations`() {
    val screens = com.example.ui.navigation.NavRoutes.bottomNavScreens
    assertEquals(5, screens.size)
    assertEquals("home", screens[0].route)
    assertEquals("Home", screens[0].title)
    assertEquals("web_portal", screens[1].route)
    assertEquals("Web Portal", screens[1].title)
    assertEquals("krishna_stories", screens[2].route)
    assertEquals("Krishna Stories", screens[2].title)
    assertEquals("channels", screens[3].route)
    assertEquals("Channels", screens[3].title)
    assertEquals("favorites", screens[4].route)
    assertEquals("Favorites", screens[4].title)
  }

  @Test
  fun `test channel and social network profiles`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val database = com.example.data.local.AppDatabase.getDatabase(context)
    val repository = ChannelRepository(database)

    // Check 6 YouTube channels exist
    val channelHandles = repository.channels.map { it.handle }
    assertEquals(6, repository.channels.size)
    org.junit.Assert.assertTrue(channelHandles.contains("@kvakbubly"))
    org.junit.Assert.assertTrue(channelHandles.contains("@bublyai"))
    org.junit.Assert.assertTrue(channelHandles.contains("@kvakfudokapcai"))
    org.junit.Assert.assertTrue(channelHandles.contains("@kvakkiddiesai"))
    org.junit.Assert.assertTrue(channelHandles.contains("@kvakeliteai"))
    org.junit.Assert.assertTrue(channelHandles.contains("@arunkrishna65"))

    // Check 2 Facebook pages exist
    val fbHandles = repository.facebookPages.map { it.handle }
    assertEquals(2, repository.facebookPages.size)
    org.junit.Assert.assertTrue(fbHandles.contains("@kvakbubble"))
    org.junit.Assert.assertTrue(fbHandles.contains("@kvakkiddiesaifb"))
  }

  @Test
  fun `test pull to refresh updates ui state`() {
    val application = ApplicationProvider.getApplicationContext<android.app.Application>()
    val viewModel = com.example.ui.viewmodel.ChannelViewModel(application)

    assertEquals(false, viewModel.uiState.value.isRefreshing)
    viewModel.refreshContent()
    // Triggering refresh immediately flags isRefreshing to true before delay
    org.junit.Assert.assertTrue(viewModel.uiState.value.isRefreshing)
  }

  @Test
  fun `test sister app and krishna stories category`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val database = com.example.data.local.AppDatabase.getDatabase(context)
    val repository = ChannelRepository(database)

    assertEquals("KVAK23 – Krishna Stories", repository.sisterApp.title)
    assertEquals("io.kodular.kvakpkd66.kvak23", repository.sisterApp.packageName)
    assertEquals("Registered", repository.sisterApp.status)

    val krishnaVideos = repository.getInitialVideos().filter { it.category == VideoCategory.KRISHNA_STORIES }
    org.junit.Assert.assertTrue(krishnaVideos.isNotEmpty())
  }

  @Test
  fun `test krishna stories repository chapters and quizzes`() {
    val stories = com.example.data.repository.KrishnaStoriesRepository.stories
    assertEquals(8, stories.size)

    val makhanChor = com.example.data.repository.KrishnaStoriesRepository.getStoryById("ks_makhan_chor")
    org.junit.Assert.assertNotNull(makhanChor)
    assertEquals("Makhan Chor: The Great Butter Mystery", makhanChor?.title)
    assertEquals(3, makhanChor?.quiz?.size)

    val govardhan = com.example.data.repository.KrishnaStoriesRepository.getStoryById("ks_govardhan_hill")
    org.junit.Assert.assertNotNull(govardhan)
    assertEquals(5, govardhan?.chapter)

    // Verify 5 bottom navigation tabs including Web Portal and Krishna Stories
    assertEquals(5, com.example.ui.navigation.NavRoutes.bottomNavScreens.size)
    org.junit.Assert.assertTrue(
      com.example.ui.navigation.NavRoutes.bottomNavScreens.any { it.route == com.example.ui.navigation.NavRoutes.KRISHNA_STORIES }
    )
  }
}
