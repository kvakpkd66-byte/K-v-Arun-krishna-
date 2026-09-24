package com.example.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.ChannelInfo
import com.example.data.model.VideoCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddVideoDialog(
    channels: List<ChannelInfo>,
    onDismiss: () -> Unit,
    onAddVideo: (urlOrId: String, channelId: String, title: String, category: VideoCategory) -> Unit
) {
    var inputUrlOrId by remember { mutableStateOf("") }
    var inputTitle by remember { mutableStateOf("") }
    var selectedChannel by remember { mutableStateOf(channels.firstOrNull() ?: ChannelInfo("kvakbubly", "@kvakbubly", "Kvak Bubly", "", "", "", 0L, "", 0, "", "🫧", emptyList())) }
    var selectedCategory by remember { mutableStateOf(VideoCategory.ALL) }
    var channelDropdownExpanded by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Add YouTube Video",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Paste a YouTube link (e.g. youtu.be/xxx, youtube.com/watch?v=xxx) or enter a video ID to add to your personal hub.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                OutlinedTextField(
                    value = inputUrlOrId,
                    onValueChange = { inputUrlOrId = it },
                    label = { Text("YouTube URL or Video ID") },
                    placeholder = { Text("https://youtu.be/...") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("add_video_url_input")
                )

                OutlinedTextField(
                    value = inputTitle,
                    onValueChange = { inputTitle = it },
                    label = { Text("Video Title (Optional)") },
                    placeholder = { Text("e.g. My New Upload") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("add_video_title_input")
                )

                // Channel Selector Dropdown
                ExposedDropdownMenuBox(
                    expanded = channelDropdownExpanded,
                    onExpandedChange = { channelDropdownExpanded = !channelDropdownExpanded },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = "${selectedChannel.title} (${selectedChannel.handle})",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Associate with Channel") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = channelDropdownExpanded) },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = channelDropdownExpanded,
                        onDismissRequest = { channelDropdownExpanded = false }
                    ) {
                        channels.forEach { channel ->
                            DropdownMenuItem(
                                text = { Text("${channel.title} (${channel.handle})") },
                                onClick = {
                                    selectedChannel = channel
                                    channelDropdownExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (inputUrlOrId.isNotBlank()) {
                        onAddVideo(inputUrlOrId, selectedChannel.id, inputTitle, selectedCategory)
                    }
                },
                enabled = inputUrlOrId.isNotBlank(),
                modifier = Modifier.testTag("confirm_add_video_button"),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Add to Hub")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
