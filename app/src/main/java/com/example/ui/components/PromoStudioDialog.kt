package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import com.example.data.model.ChannelInfo
import com.example.data.model.FacebookPageInfo
import com.example.data.model.SisterAppInfo

data class PromoItem(
    val title: String,
    val targetType: String,
    val url: String,
    val emoji: String,
    val brandColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoStudioDialog(
    channels: List<ChannelInfo>,
    facebookPages: List<FacebookPageInfo>,
    sisterApp: SisterAppInfo = SisterAppInfo(),
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabTitles = listOf("Facebook Post", "YouTube Community", "Video Description", "QR Codes", "Krishna Stories App", "Official Website")

    val promoItems = remember(channels, facebookPages, sisterApp) {
        val list = mutableListOf<PromoItem>()
        // Official Website first
        list.add(
            PromoItem(
                title = "Official Website",
                targetType = "Web Portal (www.kvakbubly.com)",
                url = "https://www.kvakbubly.com",
                emoji = "🌐",
                brandColor = Color(0xFF00E5FF)
            )
        )
        // Sister App for quick promotion
        list.add(
            PromoItem(
                title = sisterApp.title,
                targetType = "Google Play Verified App (${sisterApp.packageName})",
                url = sisterApp.playStoreUrl,
                emoji = sisterApp.avatarEmoji,
                brandColor = Color(0xFF0F9D58)
            )
        )
        channels.forEach { ch ->
            list.add(
                PromoItem(
                    title = ch.title,
                    targetType = ch.handle,
                    url = "https://www.youtube.com/${ch.handle}?sub_confirmation=1",
                    emoji = ch.avatarEmoji,
                    brandColor = Color(ch.accentColorHex)
                )
            )
        }
        facebookPages.forEach { fb ->
            list.add(
                PromoItem(
                    title = fb.title,
                    targetType = "${fb.handle} (Facebook)",
                    url = fb.pageUrl,
                    emoji = fb.avatarEmoji,
                    brandColor = Color(0xFF1877F2)
                )
            )
        }
        list
    }

    var selectedPromoItem by remember { mutableStateOf(promoItems.first()) }
    var dropdownExpanded by remember { mutableStateOf(false) }

    // Pre-crafted write-ups
    val facebookWriteUp = remember {
        """
🚀 Welcome to the Official Kvak & Bubly Media Network! 🌟

Hey friends & creators! We are thrilled to invite you to connect with our creative digital network. Follow our official channels and pages for high-impact AI innovations, gaming tech, kids bedtime stories, and behind-the-scenes vlogs:

📺 YOUTUBE CHANNELS (Subscribe with 1-Tap):
🫧 Kvak Bubly (@kvakbubly):
👉 https://www.youtube.com/@kvakbubly?sub_confirmation=1

⚡ Bubly AI (@bublyai) - Future Tech & AI Prompts:
👉 https://www.youtube.com/@bublyai?sub_confirmation=1

👑 Kvak Elite AI (@kvakeliteai) - Advanced AI & Workflows:
👉 https://www.youtube.com/@kvakeliteai?sub_confirmation=1

🎮 Kvak Fudokapc AI (@kvakfudokapcai) - PC Builds & Gaming:
👉 https://www.youtube.com/@kvakfudokapcai?sub_confirmation=1

🧸 Kvak Kiddies AI (@kvakkiddiesai) - Stories & Animation:
👉 https://www.youtube.com/@kvakkiddiesai?sub_confirmation=1

🌟 Arun Krishna (@arunkrishna65) - Creator Insights & Vlogs:
👉 https://www.youtube.com/@arunkrishna65?sub_confirmation=1

📘 OFFICIAL FACEBOOK COMMUNITY PAGES:
💙 Kvak Bubble: https://www.facebook.com/kvakbubble
💙 Kvak Kiddies AI: https://www.facebook.com/kvakkiddiesaifb

Scan the QR codes attached or tap the links above to subscribe and follow! Thank you so much for your continuous love and support! ❤️

#KvakBubly #ArunKrishna #ArtificialIntelligence #GamingPC #KidsStories #Animation #ContentCreator #Subscribe
        """.trimIndent()
    }

    val youtubeCommunityWriteUp = remember {
        """
🎉 BIG ANNOUNCEMENT: Connect with our Full Media Network! 🌐

To our amazing community: You can now explore all 6 of our dedicated YouTube channels and our official Facebook pages! Whether you love cutting-edge AI experiments, family stories, PC hardware benchmarks, or behind-the-scenes vlogs, we have something tailored just for you:

✨ EXPLORE OUR CHANNELS:
• @kvakbubly - Creative AI & Visual Narratives
• @bublyai - Smart AI Tools & Prompt Guides
• @kvakeliteai - Elite Autonomous AI Workflows
• @kvakfudokapcai - Custom PC Builds & AI Gaming
• @kvakkiddiesai - Charming Stories & Family Fun
• @arunkrishna65 - Creator Philosophy & Behind The Scenes

📲 Join us on Facebook:
• @kvakbubble: https://www.facebook.com/kvakbubble
• @kvakkiddiesaifb: https://www.facebook.com/kvakkiddiesaifb

Hit that SUBSCRIBE button on each channel and turn on the 🔔 notification bell! Which channel is your favorite? Let us know in the comments below! 👇
        """.trimIndent()
    }

    val videoDescriptionTemplate = remember {
        """
🔔 SUBSCRIBE & CONNECT WITH OUR ENTIRE NETWORK:
--------------------------------------------------
🫧 @kvakbubly: https://www.youtube.com/@kvakbubly?sub_confirmation=1
⚡ @bublyai: https://www.youtube.com/@bublyai?sub_confirmation=1
👑 @kvakeliteai: https://www.youtube.com/@kvakeliteai?sub_confirmation=1
🎮 @kvakfudokapcai: https://www.youtube.com/@kvakfudokapcai?sub_confirmation=1
🧸 @kvakkiddiesai: https://www.youtube.com/@kvakkiddiesai?sub_confirmation=1
🌟 @arunkrishna65: https://www.youtube.com/@arunkrishna65?sub_confirmation=1

📘 FOLLOW US ON FACEBOOK:
• Kvak Bubble: https://www.facebook.com/kvakbubble
• Kvak Kiddies AI: https://www.facebook.com/kvakkiddiesaifb

📩 Creator Inquiries & Collaborations: kvakpkd66@gmail.com
--------------------------------------------------
Thank you for watching! Don't forget to Like, Share & Subscribe!
        """.trimIndent()
    }

    val krishnaStoriesWriteUp = remember {
        """
🪈 OFFICIAL RELEASE: KVAK23 – KRISHNA STORIES APP ON GOOGLE PLAY! 🌟

Dear Family, Devotees & Friends,

We are thrilled to announce that our official app "KVAK23 – Krishna Stories" is Google Play Verified and available for download!

Experience the enchanting adventures of Little Krishna:
✨ Makhan Chor (The Great Butter Mystery)
✨ Govardhan Hill Miracle & Divine Umbrella
✨ Baby Krishna & Kaliya Serpent Victory
✨ Heartwarming Bedtime Stories & Flute Melodies
✨ Safe, educational, and devotional fun for kids and the whole family!

📲 Download on Google Play:
👉 ${sisterApp.playStoreUrl}
(Verified Package: ${sisterApp.packageName})

🌐 Also Explore Online on Our Official Website:
👉 https://www.kvakbubly.com

📱 Official Sister App of KvakBubly Hub:
Created with love by Arun Krishna (kvakpkd66@gmail.com).

Please Download, Rate 5 Stars ⭐⭐⭐⭐⭐, and Share with friends & family!
        """.trimIndent()
    }

    val websiteWriteUp = remember {
        """
🌐 VISIT THE OFFICIAL WEBSITE: WWW.KVAKBUBLY.COM 🌟

Welcome to the digital headquarters of Kvak & Bubly Media Network!

Explore our entire creative universe in one single destination:
✨ All 6 Official YouTube Channels (@kvakbubly, @bublyai, @kvakeliteai, @kvakfudokapcai, @kvakkiddiesai, @arunkrishna65)
✨ Official Facebook Communities (@kvakbubble, @kvakkiddiesaifb)
✨ KVAK23 – Krishna Stories Online Reader, Audio Tales & Kids Quizzes
✨ Advanced AI Workflows, Video Prompts & Custom Gaming PC Builds
✨ Direct Creator Inquiries & Collaboration: kvakpkd66@gmail.com

🔗 Bookmark & Visit Now:
👉 https://www.kvakbubly.com

Scan our QR code or share this link with friends, family, and fellow creators! ❤️
#KvakBubly #OfficialWebsite #AIStudio #KrishnaStories #ContentCreator
        """.trimIndent()
    }

    fun copyToClipboard(text: String, label: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "Copied $label to clipboard!", Toast.LENGTH_SHORT).show()
    }

    fun shareText(text: String, title: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, text)
        }
        context.startActivity(Intent.createChooser(intent, "Share via"))
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .clip(RoundedCornerShape(24.dp))
                .testTag("promo_studio_dialog"),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Top Header Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFE50914).copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.QrCode,
                                contentDescription = null,
                                tint = Color(0xFFE50914),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "Publish & Promo Studio",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Copy post write-ups & generate QR codes",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Scrollable Tabs
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    edgePadding = 0.dp,
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    tabTitles.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    text = title,
                                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal,
                                    fontSize = 12.sp
                                )
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Tab Content with vertical scroll
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = false)
                        .verticalScroll(rememberScrollState())
                ) {
                    when (selectedTab) {
                        // 0: Facebook Post Write-up
                        0 -> WriteUpTabContent(
                            headline = "Facebook Announcement Post",
                            subhead = "Formatted with emojis, tags, and one-tap subscribe URLs for Facebook.",
                            content = facebookWriteUp,
                            onCopy = { copyToClipboard(facebookWriteUp, "Facebook Post") },
                            onShare = { shareText(facebookWriteUp, "Kvak & Bubly Network on Facebook") }
                        )

                        // 1: YouTube Community Post Write-up
                        1 -> WriteUpTabContent(
                            headline = "YouTube Community Tab Post",
                            subhead = "Ideal for posting under Community on @kvakbubly, @bublyai, etc.",
                            content = youtubeCommunityWriteUp,
                            onCopy = { copyToClipboard(youtubeCommunityWriteUp, "YouTube Community Post") },
                            onShare = { shareText(youtubeCommunityWriteUp, "YouTube Community Post") }
                        )

                        // 2: Video Description Template
                        2 -> WriteUpTabContent(
                            headline = "Universal Video Description Template",
                            subhead = "Paste into the description of any video/Short on all 6 channels.",
                            content = videoDescriptionTemplate,
                            onCopy = { copyToClipboard(videoDescriptionTemplate, "Video Description") },
                            onShare = { shareText(videoDescriptionTemplate, "Video Description Template") }
                        )

                        // 3: QR Codes Generator
                        3 -> {
                            val qrUrl = "https://api.qrserver.com/v1/create-qr-code/?size=400x400&data=" +
                                    java.net.URLEncoder.encode(selectedPromoItem.url, "UTF-8")

                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Select Channel or Page to Generate QR Code",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                // Dropdown to pick channel or Facebook page
                                ExposedDropdownMenuBox(
                                    expanded = dropdownExpanded,
                                    onExpandedChange = { dropdownExpanded = !dropdownExpanded },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    OutlinedTextField(
                                        value = "${selectedPromoItem.emoji} ${selectedPromoItem.title} - ${selectedPromoItem.targetType}",
                                        onValueChange = {},
                                        readOnly = true,
                                        label = { Text("Selected Target") },
                                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownExpanded) },
                                        modifier = Modifier
                                            .menuAnchor()
                                            .fillMaxWidth()
                                    )
                                    ExposedDropdownMenu(
                                        expanded = dropdownExpanded,
                                        onDismissRequest = { dropdownExpanded = false }
                                    ) {
                                        promoItems.forEach { item ->
                                            DropdownMenuItem(
                                                text = { Text("${item.emoji} ${item.title} (${item.targetType})") },
                                                onClick = {
                                                    selectedPromoItem = item
                                                    dropdownExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                // QR Code Display Card
                                Card(
                                    modifier = Modifier.size(240.dp),
                                    shape = RoundedCornerShape(20.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(14.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        AsyncImage(
                                            model = qrUrl,
                                            contentDescription = "QR Code for ${selectedPromoItem.title}",
                                            modifier = Modifier
                                                .size(210.dp)
                                                .clip(RoundedCornerShape(12.dp)),
                                            contentScale = ContentScale.Fit
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Scan with any smartphone camera to open",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )

                                Text(
                                    text = selectedPromoItem.url,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = selectedPromoItem.brandColor,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                // QR Actions Row
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    FilledTonalButton(
                                        onClick = {
                                            copyToClipboard(selectedPromoItem.url, "${selectedPromoItem.title} Link")
                                        },
                                        modifier = Modifier.weight(1f),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.ContentCopy,
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("Copy Link", fontSize = 12.sp)
                                    }

                                    Button(
                                        onClick = {
                                            shareText(
                                                text = "Scan or visit: ${selectedPromoItem.title} (${selectedPromoItem.targetType})\n👉 ${selectedPromoItem.url}\nQR Code Image: $qrUrl",
                                                title = "Share QR for ${selectedPromoItem.title}"
                                            )
                                        },
                                        modifier = Modifier.weight(1.2f),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = selectedPromoItem.brandColor
                                        ),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Share,
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("Share QR", fontSize = 12.sp, color = Color.White)
                                    }
                                }
                            }
                        }

                        // 4: Krishna Stories App Promo Write-up
                        4 -> WriteUpTabContent(
                            headline = "KVAK23 – Krishna Stories Launch Announcement",
                            subhead = "Official announcement ready to share on Facebook, WhatsApp, and YouTube Community tab.",
                            content = krishnaStoriesWriteUp,
                            onCopy = { copyToClipboard(krishnaStoriesWriteUp, "Krishna Stories Announcement") },
                            onShare = { shareText(krishnaStoriesWriteUp, "KVAK23 – Krishna Stories App Announcement") }
                        )

                        // 5: Official Website Promo
                        5 -> WriteUpTabContent(
                            headline = "Official Website (www.kvakbubly.com) Announcement",
                            subhead = "Promote your official web domain across all social media, Discord, and WhatsApp groups.",
                            content = websiteWriteUp,
                            onCopy = { copyToClipboard(websiteWriteUp, "Official Website Announcement") },
                            onShare = { shareText(websiteWriteUp, "Visit www.kvakbubly.com - Official Website") }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WriteUpTabContent(
    headline: String,
    subhead: String,
    content: String,
    onCopy: () -> Unit,
    onShare: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = headline,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = subhead,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Write up content container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.surfaceVariant,
                    RoundedCornerShape(14.dp)
                )
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.outlineVariant,
                    RoundedCornerShape(14.dp)
                )
                .padding(14.dp)
        ) {
            Text(
                text = content,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            FilledTonalButton(
                onClick = onCopy,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ContentCopy,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Copy Write-up", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }

            Button(
                onClick = onShare,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text("Post / Share", fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }
    }
}
