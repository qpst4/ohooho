package com.slideindex.app.notification

import android.content.Intent

/** Launches notification history replay intents via app trampolines. */
interface NotificationHistoryLaunchPort {
    fun startPendingIntentTrampoline(pendingIntentBase64: String, fallbackIntent: Intent?): Boolean

    fun launchReplayIntent(intent: Intent, packageName: String, extrasBase64: String?): Boolean
}
