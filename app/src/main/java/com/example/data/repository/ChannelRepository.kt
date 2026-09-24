package com.example.data.repository

import com.example.data.local.AppDatabase
import com.example.data.local.ChannelAlertEntity
import com.example.data.local.SavedVideoEntity
import com.example.data.model.ChannelInfo
import com.example.data.model.CreatorProfile
import com.example.data.model.FacebookPageInfo
import com.example.data.model.SisterAppInfo
import com.example.data.model.VideoCategory
import com.example.data.model.VideoItem
import kotlinx.coroutines.flow.Flow

class ChannelRepository(private val database: AppDatabase) {

    private val videoDao = database.videoDao()

    val creatorProfile = CreatorProfile()
    val sisterApp = SisterAppInfo()

    val channels: List<ChannelInfo> = listOf(
        ChannelInfo(
            id = "kvakbubly",
            handle = "@kvakbubly",
            title = "Kvak Bubly",
            tagline = "Official Hub • Creative AI & Visual Narratives",
            description = "Welcome to Kvak Bubly! The creative heart of our network showcasing innovative digital storytelling, animated adventures, behind-the-scenes vlogs, and community updates.",
            badge = "Official Hub",
            accentColorHex = 0xFFFF3366,
            subscriberCount = "18.5K",
            videoCount = 42,
            youtubeUrl = "https://www.youtube.com/@kvakbubly",
            avatarEmoji = "🫧",
            primaryTags = listOf("Creativity", "Storytelling", "Animation", "Vlog")
        ),
        ChannelInfo(
            id = "bublyai",
            handle = "@bublyai",
            title = "Bubly AI",
            tagline = "AI Tech • Future Tools & Smart Workflows",
            description = "Your ultimate destination for artificial intelligence breakthroughs, prompt crafting, neural generative art, automation guides, and emerging AI technologies.",
            badge = "AI & Tech",
            accentColorHex = 0xFF00E5FF,
            subscriberCount = "24.8K",
            videoCount = 68,
            youtubeUrl = "https://www.youtube.com/@bublyai",
            avatarEmoji = "⚡",
            primaryTags = listOf("AI Tools", "Generative AI", "Prompts", "Tech Guide")
        ),
        ChannelInfo(
            id = "kvakfudokapcai",
            handle = "@kvakfudokapcai",
            title = "Kvak Fudokapc AI",
            tagline = "Gaming • PC Builds • AI Hardware & Tests",
            description = "High-performance PC rigs, AI hardware benchmarks, AI-enhanced gameplay, hardware overclocking, and tech experiments built for gamers and creators.",
            badge = "Gaming & PC",
            accentColorHex = 0xFF00E676,
            subscriberCount = "14.2K",
            videoCount = 37,
            youtubeUrl = "https://www.youtube.com/@kvakfudokapcai",
            avatarEmoji = "🎮",
            primaryTags = listOf("PC Build", "Gaming AI", "Benchmarks", "Hardware")
        ),
        ChannelInfo(
            id = "kvakkiddiesai",
            handle = "@kvakkiddiesai",
            title = "Kvak Kiddies AI",
            tagline = "Kids & Family • Wholesome AI Animations",
            description = "Safe, colorful, and heartwarming entertainment for children and families. Bedtime stories, nursery songs, educational ABCs, and charming animated animal friends.",
            badge = "Kids & Family",
            accentColorHex = 0xFFFFB300,
            subscriberCount = "31.6K",
            videoCount = 89,
            youtubeUrl = "https://www.youtube.com/@kvakkiddiesai",
            avatarEmoji = "🧸",
            primaryTags = listOf("Bedtime Stories", "Nursery Rhymes", "Learning", "Animation")
        ),
        ChannelInfo(
            id = "kvakeliteai",
            handle = "@kvakeliteai",
            title = "Kvak Elite AI",
            tagline = "Elite AI Systems • Masterclasses & Advanced Frameworks",
            description = "Dedicated to deep-dive AI architectures, autonomous agents, neural workflow automation, and elite research for engineers, developers, and power creators.",
            badge = "Elite AI",
            accentColorHex = 0xFF7C4DFF,
            subscriberCount = "9.4K",
            videoCount = 28,
            youtubeUrl = "https://www.youtube.com/@kvakeliteai",
            avatarEmoji = "👑",
            primaryTags = listOf("Agentic AI", "Neural Networks", "Workflows", "Elite")
        ),
        ChannelInfo(
            id = "arunkrishna65",
            handle = "@arunkrishna65",
            title = "Arun Krishna",
            tagline = "Personal Channel • Creator Insights & Behind The Scenes",
            description = "The official personal channel of Arun Krishna. Creative philosophy, tech vlogs, studio updates, community conversations, and creator journey insights.",
            badge = "Creator",
            accentColorHex = 0xFFFF9100,
            subscriberCount = "12.1K",
            videoCount = 34,
            youtubeUrl = "https://www.youtube.com/@arunkrishna65",
            avatarEmoji = "🌟",
            primaryTags = listOf("Creator Vlogs", "BTS", "Insights", "Personal")
        )
    )

    val facebookPages: List<FacebookPageInfo> = listOf(
        FacebookPageInfo(
            id = "kvakbubble",
            handle = "@kvakbubble",
            title = "Kvak Bubble",
            tagline = "Official Facebook Community • Daily Reels & Highlights",
            description = "Follow Kvak Bubble on Facebook for quick community discussions, short video reels, behind-the-scenes stories, and interactive creator polls.",
            pageUrl = "https://www.facebook.com/kvakbubble",
            avatarEmoji = "🫧",
            badge = "Facebook Page",
            followersCount = "15K+ Followers"
        ),
        FacebookPageInfo(
            id = "kvakkiddiesaifb",
            handle = "@kvakkiddiesaifb",
            title = "Kvak Kiddies AI",
            tagline = "Family Facebook Page • Kids Stories & Parenting Fun",
            description = "The official family hub on Facebook: heartwarming kids animation clips, bedtime storytelling snippets, and creative activity sheets for children.",
            pageUrl = "https://www.facebook.com/kvakkiddiesaifb",
            avatarEmoji = "🧸",
            badge = "Family Page",
            followersCount = "22K+ Followers"
        )
    )

    // Curated catalog representing the 6 channels with YouTube IDs
    private val curatedVideos: List<VideoItem> = listOf(
        // @kvakbubly
        VideoItem(
            id = "L_LUpnjgPso",
            channelId = "kvakbubly",
            channelHandle = "@kvakbubly",
            channelTitle = "Kvak Bubly",
            title = "The Magic of Creative AI: Inside the Kvak Bubly Studio",
            description = "Take a full behind-the-scenes tour of how we produce animated stories and combine music, visual styling, and AI narratives.",
            duration = "12:45",
            publishDate = "2 days ago",
            views = "8.4K views",
            category = VideoCategory.ANIMATION,
            isShort = false,
            tags = listOf("Studio Tour", "AI Art", "Animation")
        ),
        VideoItem(
            id = "kJQP7kiw5Fk",
            channelId = "kvakbubly",
            channelHandle = "@kvakbubly",
            channelTitle = "Kvak Bubly",
            title = "Bubbles in the Metaverse - Visual Fantasy Short",
            description = "An experimental visual immersion featuring floating digital spheres and melodic audio landscapes.",
            duration = "0:58",
            publishDate = "4 days ago",
            views = "14.1K views",
            category = VideoCategory.SHORTS,
            isShort = true,
            tags = listOf("Shorts", "Bubbles", "Visuals")
        ),
        VideoItem(
            id = "fJ9rUzIMcZQ",
            channelId = "kvakbubly",
            channelHandle = "@kvakbubly",
            channelTitle = "Kvak Bubly",
            title = "Community Milestone & Roadmap: What's Next for Kvak Bubly",
            description = "Thanking all subscribers across our channels and sharing exciting plans for upcoming video series and interactive features.",
            duration = "8:20",
            publishDate = "1 week ago",
            views = "5.6K views",
            category = VideoCategory.COMMUNITY,
            isShort = false,
            tags = listOf("Community", "Q&A", "Update")
        ),

        // @bublyai
        VideoItem(
            id = "aircAruvnKk",
            channelId = "bublyai",
            channelHandle = "@bublyai",
            channelTitle = "Bubly AI",
            title = "Mastering Generative AI Tools in 2026: Complete Guide",
            description = "Comprehensive walkthrough covering latest generation models, structured prompts, image synthesis, and automated workflows.",
            duration = "18:32",
            publishDate = "Yesterday",
            views = "19.3K views",
            category = VideoCategory.AI_TECH,
            isShort = false,
            tags = listOf("Generative AI", "Prompts", "Masterclass")
        ),
        VideoItem(
            id = "EngW7tLk6R8",
            channelId = "bublyai",
            channelHandle = "@bublyai",
            channelTitle = "Bubly AI",
            title = "3 Insane AI Prompts That Feel Like Cheating #shorts",
            description = "Level up your creative prompts in under 60 seconds with these 3 formula tricks.",
            duration = "0:45",
            publishDate = "3 days ago",
            views = "32.8K views",
            category = VideoCategory.SHORTS,
            isShort = true,
            tags = listOf("Shorts", "AI Prompts", "Tips")
        ),
        VideoItem(
            id = "bHQqvYy5KYo",
            channelId = "bublyai",
            channelHandle = "@bublyai",
            channelTitle = "Bubly AI",
            title = "Build Your Own Local AI Assistant Step-by-Step",
            description = "Run your private language model locally on consumer hardware without sending private data to cloud providers.",
            duration = "15:10",
            publishDate = "5 days ago",
            views = "12.7K views",
            category = VideoCategory.TUTORIALS,
            isShort = false,
            tags = listOf("Local AI", "Privacy", "Tutorial")
        ),

        // @kvakfudokapcai
        VideoItem(
            id = "9bZkp7q19f0",
            channelId = "kvakfudokapcai",
            channelHandle = "@kvakfudokapcai",
            channelTitle = "Kvak Fudokapc AI",
            title = "Ultimate AI & 4K Gaming PC Build: Benchmarks & Setup",
            description = "We assemble a custom water-cooled rig optimized for dual AI inference workloads and uncompromised ray-traced gaming.",
            duration = "22:15",
            publishDate = "3 days ago",
            views = "16.2K views",
            category = VideoCategory.GAMING,
            isShort = false,
            tags = listOf("PC Build", "4K Gaming", "Hardware")
        ),
        VideoItem(
            id = "fRh_vgS2dFE",
            channelId = "kvakfudokapcai",
            channelHandle = "@kvakfudokapcai",
            channelTitle = "Kvak Fudokapc AI",
            title = "Does AI Frame Generation Cause Input Lag? Tested! #shorts",
            description = "High-speed camera test comparing native latency vs AI frame generation.",
            duration = "0:52",
            publishDate = "6 days ago",
            views = "28.5K views",
            category = VideoCategory.SHORTS,
            isShort = true,
            tags = listOf("Shorts", "Tech Test", "Hardware")
        ),
        VideoItem(
            id = "JGwWNGJdvx8",
            channelId = "kvakfudokapcai",
            channelHandle = "@kvakfudokapcai",
            channelTitle = "Kvak Fudokapc AI",
            title = "AI Upscaling in Modern Games: Best Settings Explored",
            description = "Comparing DLSS, FSR, and XeSS in 2026: which gives the sharpest visuals and smoothest frame times?",
            duration = "14:40",
            publishDate = "2 weeks ago",
            views = "11.9K views",
            category = VideoCategory.GAMING,
            isShort = false,
            tags = listOf("Upscaling", "PC Gaming", "Graphics")
        ),

        // @kvakkiddiesai
        VideoItem(
            id = "M7lc1UVf-VE",
            channelId = "kvakkiddiesai",
            channelHandle = "@kvakkiddiesai",
            channelTitle = "Kvak Kiddies AI",
            title = "The Sleepy Star's Bedtime Journey: Gentle Kids Story",
            description = "A warm, calming animated bedtime tale filled with soft lullaby melodies and friendly forest animals drifting off to sleep.",
            duration = "16:04",
            publishDate = "1 day ago",
            views = "24.6K views",
            category = VideoCategory.KIDS,
            isShort = false,
            tags = listOf("Bedtime", "Storytime", "Kids")
        ),
        VideoItem(
            id = "C0DPdy98e4c",
            channelId = "kvakkiddiesai",
            channelHandle = "@kvakkiddiesai",
            channelTitle = "Kvak Kiddies AI",
            title = "Learn Colors with Dancing Fruit Friends! #shorts",
            description = "Bright colors, catchy music, and smiling fruits teach little learners red, yellow, green, and blue.",
            duration = "0:38",
            publishDate = "3 days ago",
            views = "45.1K views",
            category = VideoCategory.SHORTS,
            isShort = true,
            tags = listOf("Shorts", "Colors", "Learning")
        ),
        VideoItem(
            id = "kXYiU_JCYtU",
            channelId = "kvakkiddiesai",
            channelHandle = "@kvakkiddiesai",
            channelTitle = "Kvak Kiddies AI",
            title = "Friendly Animal ABCs: Singing from A to Z",
            description = "Join the Kvak Kiddies animal choir as each animal teaches their letter with fun sound effects and rhyming verses.",
            duration = "10:12",
            publishDate = "1 week ago",
            views = "18.3K views",
            category = VideoCategory.KIDS,
            isShort = false,
            tags = listOf("Alphabet", "Nursery Song", "Kids Education")
        ),

        // Krishna Stories Collection (KVAK23 & Kvak Kiddies AI)
        VideoItem(
            id = "w1y1gA_4XHQ",
            channelId = "kvakkiddiesai",
            channelHandle = "@kvakkiddiesai",
            channelTitle = "Kvak Kiddies AI",
            title = "Little Krishna & Makhan Chor: The Great Butter Mystery",
            description = "Wholesome animated story of Little Krishna and his friends on their playful quest for fresh Yashoda butter in Gokul.",
            duration = "14:20",
            publishDate = "Today",
            views = "38.2K views",
            category = VideoCategory.KRISHNA_STORIES,
            isShort = false,
            tags = listOf("Krishna Stories", "Makhan Chor", "Kids Animation", "KVAK23")
        ),
        VideoItem(
            id = "V_4U_gPkW2c",
            channelId = "kvakkiddiesai",
            channelHandle = "@kvakkiddiesai",
            channelTitle = "Kvak Kiddies AI",
            title = "Govardhan Hill Miracle: The Divine Umbrella of Gokul",
            description = "Discover how young Krishna lifted the mighty Govardhan mountain on his little finger to protect all villagers and gentle cows from Indra's storm.",
            duration = "18:05",
            publishDate = "3 days ago",
            views = "52.4K views",
            category = VideoCategory.KRISHNA_STORIES,
            isShort = false,
            tags = listOf("Govardhan", "Little Krishna", "Stories", "KVAK23")
        ),
        VideoItem(
            id = "k9HqM-fX_d8",
            channelId = "kvakkiddiesai",
            channelHandle = "@kvakkiddiesai",
            channelTitle = "Kvak Kiddies AI",
            title = "Baby Krishna's Divine Flute Song in Vrindavan #shorts",
            description = "Enchanting melodic notes from Krishna's bamboo flute that made peacocks dance and calves gather around in pure joy.",
            duration = "0:52",
            publishDate = "4 days ago",
            views = "89.5K views",
            category = VideoCategory.KRISHNA_STORIES,
            isShort = true,
            tags = listOf("Shorts", "Krishna Flute", "Devotional", "Animation")
        ),
        VideoItem(
            id = "y0X7L_2V5jA",
            channelId = "arunkrishna65",
            channelHandle = "@arunkrishna65",
            channelTitle = "Arun Krishna",
            title = "The Inspiration Behind KVAK23 Krishna Stories: App Journey",
            description = "Arun Krishna shares how the Google Play verified app KVAK23 Krishna Stories was conceptualized, voiced, and animated for young minds.",
            duration = "15:10",
            publishDate = "5 days ago",
            views = "14.7K views",
            category = VideoCategory.KRISHNA_STORIES,
            isShort = false,
            tags = listOf("KVAK23", "Arun Krishna", "Storytelling", "Developer")
        ),

        // @kvakeliteai
        VideoItem(
            id = "7xL_8W3J35A",
            channelId = "kvakeliteai",
            channelHandle = "@kvakeliteai",
            channelTitle = "Kvak Elite AI",
            title = "Autonomous Multi-Agent AI Frameworks: 2026 Deep Dive",
            description = "Architecting production-ready AI agents with tool-calling capabilities, persistent memory, and multi-step reasoning chains.",
            duration = "24:18",
            publishDate = "Yesterday",
            views = "7.8K views",
            category = VideoCategory.AI_TECH,
            isShort = false,
            tags = listOf("AI Agents", "Elite AI", "Automation", "Architecture")
        ),
        VideoItem(
            id = "jNQXAC9IVRw",
            channelId = "kvakeliteai",
            channelHandle = "@kvakeliteai",
            channelTitle = "Kvak Elite AI",
            title = "The 10-Second Neural Prompt Chain That Replaces Complex Logic #shorts",
            description = "Supercharge your agent pipeline with this concise chain-of-thought system instruction.",
            duration = "0:49",
            publishDate = "4 days ago",
            views = "19.5K views",
            category = VideoCategory.SHORTS,
            isShort = true,
            tags = listOf("Shorts", "Prompt Chain", "Elite AI")
        ),

        // @arunkrishna65
        VideoItem(
            id = "dQw4w9WgXcQ",
            channelId = "arunkrishna65",
            channelHandle = "@arunkrishna65",
            channelTitle = "Arun Krishna",
            title = "Building a Multi-Channel Media Network: Creator Journey & Philosophy",
            description = "Arun Krishna shares the story behind Kvak & Bubly, content strategy across 6 YouTube channels and Facebook, and future creative plans.",
            duration = "17:40",
            publishDate = "2 days ago",
            views = "11.4K views",
            category = VideoCategory.COMMUNITY,
            isShort = false,
            tags = listOf("Creator Vlog", "Journey", "Strategy", "Arun Krishna")
        ),
        VideoItem(
            id = "oHg5SJYRHA0",
            channelId = "arunkrishna65",
            channelHandle = "@arunkrishna65",
            channelTitle = "Arun Krishna",
            title = "Behind the Scenes: Production Studio Setup & Creator Workflow",
            description = "Take an authentic walk through the recording gear, sound booth, and editing setup behind Arun Krishna's channels.",
            duration = "13:22",
            publishDate = "5 days ago",
            views = "9.2K views",
            category = VideoCategory.COMMUNITY,
            isShort = false,
            tags = listOf("Studio Tour", "Gear", "BTS", "Workflow")
        )
    )

    fun getInitialVideos(): List<VideoItem> = curatedVideos

    fun getVideosForChannel(channelId: String): List<VideoItem> {
        return curatedVideos.filter { it.channelId == channelId }
    }

    fun getVideoById(id: String): VideoItem? {
        return curatedVideos.find { it.id == id }
    }

    fun getChannelById(channelId: String): ChannelInfo? {
        return channels.find { it.id == channelId }
    }

    // Room Database persistence
    val favoriteVideosFlow: Flow<List<SavedVideoEntity>> = videoDao.getFavoriteVideos()
    val watchLaterVideosFlow: Flow<List<SavedVideoEntity>> = videoDao.getWatchLaterVideos()
    val allSavedVideosFlow: Flow<List<SavedVideoEntity>> = videoDao.getAllSavedVideos()
    val channelAlertsFlow: Flow<List<ChannelAlertEntity>> = videoDao.getAllChannelAlerts()

    fun observeVideoStatus(videoId: String): Flow<SavedVideoEntity?> {
        return videoDao.observeSavedVideoById(videoId)
    }

    suspend fun toggleFavorite(video: VideoItem) {
        val existing = videoDao.getSavedVideoById(video.id)
        if (existing != null) {
            val updated = existing.copy(
                isFavorite = !existing.isFavorite,
                savedTimestamp = System.currentTimeMillis()
            )
            videoDao.insertOrUpdate(updated)
        } else {
            val newEntity = SavedVideoEntity.fromVideoItem(video, isFavorite = true)
            videoDao.insertOrUpdate(newEntity)
        }
    }

    suspend fun toggleWatchLater(video: VideoItem) {
        val existing = videoDao.getSavedVideoById(video.id)
        if (existing != null) {
            val updated = existing.copy(
                isWatchLater = !existing.isWatchLater,
                savedTimestamp = System.currentTimeMillis()
            )
            videoDao.insertOrUpdate(updated)
        } else {
            val newEntity = SavedVideoEntity.fromVideoItem(video, isWatchLater = true)
            videoDao.insertOrUpdate(newEntity)
        }
    }

    suspend fun saveUserNote(videoId: String, video: VideoItem, note: String) {
        val existing = videoDao.getSavedVideoById(videoId)
        if (existing != null) {
            videoDao.insertOrUpdate(existing.copy(userNotes = note))
        } else {
            val newEntity = SavedVideoEntity.fromVideoItem(video, userNotes = note)
            videoDao.insertOrUpdate(newEntity)
        }
    }

    suspend fun addCustomVideo(
        rawInput: String,
        channelId: String,
        title: String,
        category: VideoCategory
    ): VideoItem? {
        val extractedId = extractYouTubeId(rawInput) ?: return null
        val channel = getChannelById(channelId) ?: channels.first()

        val item = VideoItem(
            id = extractedId,
            channelId = channel.id,
            channelHandle = channel.handle,
            channelTitle = channel.title,
            title = title.ifBlank { "Featured Video ($extractedId)" },
            description = "Custom video linked to ${channel.title}",
            duration = "Stream",
            publishDate = "Recently Added",
            views = "Custom",
            category = category,
            isShort = rawInput.contains("/shorts/"),
            tags = listOf("Custom", channel.title),
            isCustomUserAdded = true
        )

        // Save to DB so it persists
        val entity = SavedVideoEntity.fromVideoItem(item, isFavorite = true)
        videoDao.insertOrUpdate(entity)
        return item
    }

    suspend fun toggleChannelAlert(channelId: String, enabled: Boolean) {
        videoDao.setChannelAlert(
            ChannelAlertEntity(
                channelId = channelId,
                isSubscribedLocally = true,
                notificationsEnabled = enabled,
                lastNotifiedTimestamp = System.currentTimeMillis()
            )
        )
    }

    companion object {
        fun extractYouTubeId(urlOrId: String): String? {
            val trimmed = urlOrId.trim()
            if (trimmed.length == 11 && !trimmed.contains("/") && !trimmed.contains("?")) {
                return trimmed
            }
            // Check youtu.be/ID
            val youtuBeRegex = Regex("youtu\\.be/([a-zA-Z0-9_-]{11})")
            youtuBeRegex.find(trimmed)?.groupValues?.getOrNull(1)?.let { return it }

            // Check youtube.com/watch?v=ID
            val watchRegex = Regex("v=([a-zA-Z0-9_-]{11})")
            watchRegex.find(trimmed)?.groupValues?.getOrNull(1)?.let { return it }

            // Check youtube.com/shorts/ID
            val shortsRegex = Regex("shorts/([a-zA-Z0-9_-]{11})")
            shortsRegex.find(trimmed)?.groupValues?.getOrNull(1)?.let { return it }

            // Check embed/ID
            val embedRegex = Regex("embed/([a-zA-Z0-9_-]{11})")
            embedRegex.find(trimmed)?.groupValues?.getOrNull(1)?.let { return it }

            return if (trimmed.matches(Regex("[a-zA-Z0-9_-]{11}"))) trimmed else null
        }
    }
}
