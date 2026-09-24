package com.example.data.model

enum class VideoCategory(val displayName: String) {
    ALL("All"),
    KRISHNA_STORIES("Krishna Stories"),
    AI_TECH("AI & Tech"),
    ANIMATION("Animations"),
    GAMING("Gaming & PC"),
    KIDS("Kids & Stories"),
    SHORTS("Shorts"),
    TUTORIALS("Tutorials"),
    COMMUNITY("Community & BTS")
}

data class ChannelInfo(
    val id: String,
    val handle: String,
    val title: String,
    val tagline: String,
    val description: String,
    val badge: String,
    val accentColorHex: Long,
    val subscriberCount: String,
    val videoCount: Int,
    val youtubeUrl: String,
    val avatarEmoji: String,
    val primaryTags: List<String>
)

data class FacebookPageInfo(
    val id: String,
    val handle: String,
    val title: String,
    val tagline: String,
    val description: String,
    val pageUrl: String,
    val avatarEmoji: String,
    val badge: String = "Facebook Page",
    val followersCount: String = "Growing Community"
) {
    val fbAppUri: String
        get() = "fb://facewebmodal/f?href=$pageUrl"
}

data class VideoItem(
    val id: String,
    val channelId: String,
    val channelHandle: String,
    val channelTitle: String,
    val title: String,
    val description: String,
    val duration: String,
    val publishDate: String,
    val views: String,
    val category: VideoCategory,
    val isShort: Boolean = false,
    val tags: List<String> = emptyList(),
    val isCustomUserAdded: Boolean = false
) {
    val thumbnailUrl: String
        get() = "https://img.youtube.com/vi/$id/hqdefault.jpg"

    val youtubeWatchUrl: String
        get() = if (isShort) "https://www.youtube.com/shorts/$id" else "https://www.youtube.com/watch?v=$id"

    val youtubeAppUri: String
        get() = "vnd.youtube:$id"
}

data class SisterAppInfo(
    val id: String = "kvak23_krishna_stories",
    val title: String = "KVAK23 – Krishna Stories",
    val packageName: String = "io.kodular.kvakpkd66.kvak23",
    val friendlyName: String = "KVAK23 – Krishna Stories",
    val status: String = "Registered",
    val verifiedKeysCount: Int = 1,
    val description: String = "Official devotional & moral storytelling application featuring animated tales of Little Krishna, butter stories, Govardhan hill miracle, and interactive audio adventures.",
    val developer: String = "Arun Krishna (kvakpkd66@gmail.com)",
    val category: String = "Devotional & Stories",
    val playStoreUrl: String = "https://play.google.com/store/apps/details?id=io.kodular.kvakpkd66.kvak23",
    val avatarEmoji: String = "🪈"
)

data class CreatorProfile(
    val name: String = "Arun Krishna (Kvak & Bubly Media)",
    val email: String = "kvakpkd66@gmail.com",
    val bio: String = "Multi-platform digital creator directing six specialized YouTube channels and active Facebook community pages spanning cutting-edge AI, gaming & PC hardware, creative storytelling, family animation, and personal behind-the-scenes vlogs.",
    val channelHandles: List<String> = listOf(
        "@kvakbubly",
        "@bublyai",
        "@kvakfudokapcai",
        "@kvakkiddiesai",
        "@kvakeliteai",
        "@arunkrishna65"
    ),
    val facebookPages: List<String> = listOf(
        "@kvakbubble",
        "@kvakkiddiesaifb"
    ),
    val googlePlayVerifiedPackages: List<String> = listOf(
        "KvakBubly Hub (com.aistudio.kvaktube.xjkvpy) • Registered (3 Keys)",
        "KVAK23 – Krishna Stories (io.kodular.kvakpkd...) • Registered (1 Key)"
    ),
    val websiteUrl: String = "https://www.kvakbubly.com",
    val websiteDomain: String = "www.kvakbubly.com"
)
