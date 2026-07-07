package com.slideindex.app.receiver

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.service.notification.NotificationListenerService
import android.util.Log
import com.slideindex.app.service.MediaNotificationListener

/**
 * On device boot, request the notification listener to rebind so persisted filter rules
 * can be re-applied via [MediaNotificationListener.onListenerConnected].
 */
class NotificationBootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action != Intent.ACTION_BOOT_COMPLETED) return
        val component = ComponentName(context, MediaNotificationListener::class.java)
        runCatching {
            NotificationListenerService.requestRebind(component)
            Log.d(TAG, "Requested notification listener rebind after boot")
        }.onFailure { error ->
            Log.w(TAG, "Failed to request notification listener rebind after boot", error)
        }
    }

    private companion object {
        const val TAG = "NotificationBootReceiver"
    }
}
