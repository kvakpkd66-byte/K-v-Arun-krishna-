package com.example.data.model

data class WordPressPageItem(
    val id: Int,
    val title: String,
    val category: String,
    val path: String,
    val summary: String,
    val icon: String
) {
    val fullUrl: String
        get() = if (path.startsWith("http")) path else "https://www.kvakbubly.com$path"

    companion object {
        val all25PagesAndPosts: List<WordPressPageItem> = listOf(
            WordPressPageItem(
                id = 1,
                title = "Home: Official Kvak & Bubly Portal",
                category = "Core",
                path = "/",
                summary = "Welcome to Kvak & Bubly Media official hub connecting all channels, stories, and verified apps.",
                icon = "🏠"
            ),
            WordPressPageItem(
                id = 2,
                title = "Divine Childhood in Gokul",
                category = "Krishna Stories",
                path = "/krishna-stories/childhood-gokul/",
                summary = "The miraculous and playful early days of young Krishna with Yashoda and the gopis.",
                icon = "🪈"
            ),
            WordPressPageItem(
                id = 3,
                title = "Makhan Chor: The Butter Thief",
                category = "Krishna Stories",
                path = "/krishna-stories/makhan-chor/",
                summary = "Tales of innocent mischief and unconditional love stealing butter in Gokul.",
                icon = "🏺"
            ),
            WordPressPageItem(
                id = 4,
                title = "Kaliya Daman: Subduing the Venomous Serpent",
                category = "Krishna Stories",
                path = "/krishna-stories/kaliya-daman/",
                summary = "Purifying the sacred Yamuna river by dancing upon the hoods of serpent Kaliya.",
                icon = "🐍"
            ),
            WordPressPageItem(
                id = 5,
                title = "Govardhan Leela: Lifting the Mountain",
                category = "Krishna Stories",
                path = "/krishna-stories/govardhan-leela/",
                summary = "Lifting Mount Govardhan on a single finger to protect Vrindavan from deluge.",
                icon = "⛰️"
            ),
            WordPressPageItem(
                id = 6,
                title = "Deliverance of Putana",
                category = "Krishna Stories",
                path = "/krishna-stories/putana-moksha/",
                summary = "The divine compassion of infant Krishna granting liberation to demoness Putana.",
                icon = "✨"
            ),
            WordPressPageItem(
                id = 7,
                title = "The Sacred Flute of Vrindavan",
                category = "Krishna Stories",
                path = "/krishna-stories/murali-flute/",
                summary = "The enchanting melodies of Krishna's flute calling all souls to divine love.",
                icon = "🎶"
            ),
            WordPressPageItem(
                id = 8,
                title = "Vishwaroopam: The Cosmic Vision",
                category = "Krishna Stories",
                path = "/krishna-stories/vishwaroopam/",
                summary = "Revealing the infinite universal form encompassing the entire cosmos and all beings.",
                icon = "🌌"
            ),
            WordPressPageItem(
                id = 9,
                title = "Bhagavad Gita: Eternal Wisdom for Arjuna",
                category = "Krishna Stories",
                path = "/krishna-stories/bhagavad-gita/",
                summary = "The sublime philosophical dialogue on duty, dharma, and devotion on Kurukshetra.",
                icon = "📜"
            ),
            WordPressPageItem(
                id = 10,
                title = "Krishna & Sudama: True Friendship",
                category = "Krishna Stories",
                path = "/krishna-stories/sudama-friendship/",
                summary = "The heartwarming story of pure friendship where a handful of flattened rice is rewarded with boundless grace.",
                icon = "🤝"
            ),
            WordPressPageItem(
                id = 11,
                title = "Teachings & Quotes of Lord Krishna",
                category = "Krishna Stories",
                path = "/krishna-stories/divine-quotes/",
                summary = "Action without attachment to results and living with inner peace and purpose.",
                icon = "🪷"
            ),
            WordPressPageItem(
                id = 12,
                title = "@kvakbubly Channel: AI Tech, PC & Creative Media",
                category = "Channels",
                path = "/channels/kvakbubly/",
                summary = "The flagship channel featuring creative tech workflows, AI demonstrations, and hardware setups.",
                icon = "🫧"
            ),
            WordPressPageItem(
                id = 13,
                title = "@bublyai Channel: The Future of Artificial Intelligence",
                category = "Channels",
                path = "/channels/bublyai/",
                summary = "Exploring generative AI tools, prompt craft, neural models, and digital transformation.",
                icon = "🤖"
            ),
            WordPressPageItem(
                id = 14,
                title = "@kvakeliteai: High Performance Gaming & AI Benchmarks",
                category = "Channels",
                path = "/channels/kvakeliteai/",
                summary = "Next-level PC gaming, GPU tests, AI acceleration, and enthusiast gear reviews.",
                icon = "⚡"
            ),
            WordPressPageItem(
                id = 15,
                title = "@kvakfudokapcai: Custom PC Builds & Tech Tips",
                category = "Channels",
                path = "/channels/kvakfudokapcai/",
                summary = "Hands-on component guides, custom PC assembly, cooling solutions, and troubleshooting.",
                icon = "🖥️"
            ),
            WordPressPageItem(
                id = 16,
                title = "@kvakkiddiesai: Animated Kids Learning & Stories",
                category = "Channels",
                path = "/channels/kvakkiddiesai/",
                summary = "Joyful rhymes, educational animations, moral stories, and fun learning for kids.",
                icon = "🎨"
            ),
            WordPressPageItem(
                id = 17,
                title = "@arunkrishna65: Personal Journey & Vlogs",
                category = "Channels",
                path = "/channels/arunkrishna65/",
                summary = "Behind-the-scenes vlogs, studio setup insights, and creator life with Arun Krishna.",
                icon = "🎬"
            ),
            WordPressPageItem(
                id = 18,
                title = "Facebook Community & Official Pages",
                category = "Community",
                path = "/community/facebook-pages/",
                summary = "Connect with thousands of followers across Kvak & Bubly Facebook pages and groups.",
                icon = "👥"
            ),
            WordPressPageItem(
                id = 19,
                title = "KVAK23 Android App on Google Play",
                category = "Apps",
                path = "/apps/kvak23-krishna-stories/",
                summary = "The verified Google Play Store app (io.kodular.kvakpkd66.kvak23) by creator Arun Krishna.",
                icon = "📱"
            ),
            WordPressPageItem(
                id = 20,
                title = "KvakBubly Mobile App Features & Guide",
                category = "Apps",
                path = "/apps/kvakbubly-hub/",
                summary = "Complete guide to offline reading, video companion playback, and saved favorites.",
                icon = "📲"
            ),
            WordPressPageItem(
                id = 21,
                title = "Top AI Video Creation Tools in 2024",
                category = "Tech Blog",
                path = "/blog/top-ai-tools-video/",
                summary = "In-depth review of generative video tools, AI voice synthesizers, and script assistants.",
                icon = "💡"
            ),
            WordPressPageItem(
                id = 22,
                title = "Ultimate Budget PC Build Guide",
                category = "Tech Blog",
                path = "/blog/budget-pc-build-guide/",
                summary = "Component-by-component recommendation for cost-effective gaming and editing machines.",
                icon = "⚙️"
            ),
            WordPressPageItem(
                id = 23,
                title = "About Arun Krishna & Creative Vision",
                category = "About",
                path = "/about/",
                summary = "Meet developer and creator Arun Krishna behind Kvak & Bubly Media and mobile applications.",
                icon = "👤"
            ),
            WordPressPageItem(
                id = 24,
                title = "Privacy Policy & Store Verification",
                category = "About",
                path = "/privacy-policy/",
                summary = "Transparent data privacy commitment, verified Google Play developer credentials and compliance.",
                icon = "🛡️"
            ),
            WordPressPageItem(
                id = 25,
                title = "Contact, Collaboration & Support",
                category = "Contact",
                path = "/contact/",
                summary = "Direct contact form, business inquiries email (kvakpkd66@gmail.com), and social links.",
                icon = "✉️"
            )
        )
    }
}
