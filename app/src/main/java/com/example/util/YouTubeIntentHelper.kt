package com.example.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object YouTubeIntentHelper {

    fun openChannel(context: Context, handle: String) {
        val cleanHandle = handle.removePrefix("@")
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://www.youtube.com/@$cleanHandle"))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@$cleanHandle"))

        try {
            appIntent.setPackage("com.google.android.youtube")
            context.startActivity(appIntent)
        } catch (_: Exception) {
            try {
                context.startActivity(webIntent)
            } catch (e: Exception) {
                Toast.makeText(context, "Cannot open YouTube link", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun openSubscription(context: Context, handle: String) {
        val cleanHandle = handle.removePrefix("@")
        val url = "https://www.youtube.com/@$cleanHandle?sub_confirmation=1"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Cannot open subscription link", Toast.LENGTH_SHORT).show()
        }
    }

    fun openVideo(context: Context, videoId: String) {
        val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId"))
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=$videoId"))

        try {
            appIntent.setPackage("com.google.android.youtube")
            context.startActivity(appIntent)
        } catch (_: Exception) {
            try {
                context.startActivity(webIntent)
            } catch (e: Exception) {
                Toast.makeText(context, "Cannot play video", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun shareVideo(context: Context, title: String, videoId: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, "Check out \"$title\" on YouTube: https://youtu.be/$videoId")
        }
        context.startActivity(Intent.createChooser(shareIntent, "Share video via"))
    }

    fun shareChannel(context: Context, channelTitle: String, handle: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, channelTitle)
            putExtra(Intent.EXTRA_TEXT, "Subscribe to $channelTitle on YouTube! https://www.youtube.com/$handle")
        }
        context.startActivity(Intent.createChooser(shareIntent, "Share channel via"))
    }

    fun openFacebookPage(context: Context, handleOrUrl: String) {
        val cleanHandle = handleOrUrl.removePrefix("@").removePrefix("https://www.facebook.com/").removePrefix("https://facebook.com/")
        val webUrl = "https://www.facebook.com/$cleanHandle"
        val appUri = Uri.parse("fb://facewebmodal/f?href=$webUrl")
        val appIntent = Intent(Intent.ACTION_VIEW, appUri).apply {
            setPackage("com.facebook.katana")
        }
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))

        try {
            context.startActivity(appIntent)
        } catch (_: Exception) {
            try {
                context.startActivity(webIntent)
            } catch (e: Exception) {
                Toast.makeText(context, "Cannot open Facebook link", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun shareFacebookPage(context: Context, title: String, handle: String) {
        val cleanHandle = handle.removePrefix("@")
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, title)
            putExtra(Intent.EXTRA_TEXT, "Follow $title on Facebook! https://www.facebook.com/$cleanHandle")
        }
        context.startActivity(Intent.createChooser(shareIntent, "Share Facebook page via"))
    }

    fun sendEmailToCreator(context: Context, recipient: String, subject: String, body: String = "") {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$recipient")
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }
        try {
            context.startActivity(Intent.createChooser(emailIntent, "Send email to creator"))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "No email app found", Toast.LENGTH_SHORT).show()
        }
    }

    fun openWebsite(context: Context, url: String = "https://www.kvakbubly.com") {
        try {
            val targetUri = if (url.startsWith("http://") || url.startsWith("https://")) {
                Uri.parse(url)
            } else {
                Uri.parse("https://$url")
            }
            val intent = Intent(Intent.ACTION_VIEW, targetUri)
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Cannot open website: $url", Toast.LENGTH_SHORT).show()
        }
    }

    fun shareWebsite(context: Context, url: String = "https://www.kvakbubly.com") {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Visit Kvak & Bubly Media Official Website")
            putExtra(
                Intent.EXTRA_TEXT,
                "Explore the official website of Kvak & Bubly Media: $url\n\nDiscover all 6 YouTube channels (@kvakbubly, @bublyai, @kvakkiddiesai), Facebook pages, and interactive Krishna Stories!"
            )
        }
        context.startActivity(Intent.createChooser(shareIntent, "Share Website via"))
    }
}

