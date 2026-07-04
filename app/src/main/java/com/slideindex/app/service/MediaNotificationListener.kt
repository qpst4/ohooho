package com.slideindex.app.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.slideindex.app.util.MediaSessionTracker

/**
 * Notification listener used to read active media sessions (package + play/pause state).
 * Must be enabled in system Settings → Notification access → 边栏媒体会话（可选）.
 */
class MediaNotificationListener : NotificationListenerService() {
    override fun onListenerConnected() {
        super.onListenerConnected()
        instance = this
        MediaSessionTracker.onListenerConnected(this)
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        MediaSessionTracker.onListenerDisconnected()
        if (instance === this) instance = null
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        MediaSessionTracker.onNotificationsChanged(this)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        MediaSessionTracker.onNotificationsChanged(this)
    }

    companion object {
        @Volatile
        var instance: MediaNotificationListener? = null
            private set
    }
}
