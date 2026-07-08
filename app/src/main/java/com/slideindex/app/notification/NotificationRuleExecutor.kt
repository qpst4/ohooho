package com.slideindex.app.notification

import android.app.Notification
import android.content.Context
import android.media.RingtoneManager
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.Locale
import java.util.concurrent.atomic.AtomicReference

object NotificationRuleExecutor {
    private const val TAG = "NotificationRuleExecutor"

    private val ttsRef = AtomicReference<TextToSpeech?>(null)

    fun execute(
        context: Context,
        listener: NotificationListenerService,
        sbn: StatusBarNotification,
        rules: List<NotificationFilterRule>,
    ) {
        if (rules.isEmpty()) return
        val notification = sbn.notification ?: return
        val extras = notification.extras ?: return
        val title = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
        val text = extras.getCharSequence(Notification.EXTRA_TEXT)?.toString().orEmpty()
        val bigText = extras.getCharSequence(Notification.EXTRA_BIG_TEXT)?.toString().orEmpty()
        val contentText = text.ifBlank { bigText }

        val actions = rules.flatMap { it.actions }.toSet()
        if (NotificationRuleAction.TTS in actions) {
            speak(context, title, contentText)
        }
        if (NotificationRuleAction.RING in actions) {
            playRingtone(context)
        }
        if (NotificationRuleAction.OPEN in actions) {
            openNotification(sbn)
        }
        if (NotificationRuleAction.HIDE in actions) {
            NotificationHider.hideFromShade(listener, sbn)
        }
    }

    private fun speak(context: Context, title: String, text: String) {
        val message = listOf(title, text).filter { it.isNotBlank() }.joinToString("，")
        if (message.isBlank()) return
        val appContext = context.applicationContext
        var tts = ttsRef.get()
        if (tts == null) {
            tts = TextToSpeech(appContext) { status ->
                if (status != TextToSpeech.SUCCESS) {
                    Log.w(TAG, "TTS init failed: $status")
                }
            }
            ttsRef.set(tts)
        }
        tts.language = Locale.getDefault()
        tts.speak(message, TextToSpeech.QUEUE_ADD, null, "notification_rule_${System.currentTimeMillis()}")
    }

    private fun playRingtone(context: Context) {
        runCatching {
            val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(context.applicationContext, uri) ?: return
            ringtone.play()
        }.onFailure { error ->
            Log.w(TAG, "Failed to play ringtone", error)
        }
    }

    private fun openNotification(sbn: StatusBarNotification) {
        val notification = sbn.notification ?: return
        val pendingIntent = notification.contentIntent ?: notification.fullScreenIntent ?: return
        runCatching {
            pendingIntent.send()
        }.onFailure { error ->
            Log.w(TAG, "Failed to open notification for ${sbn.packageName}", error)
        }
    }
}
