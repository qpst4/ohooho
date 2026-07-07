package com.slideindex.app.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.slideindex.app.notification.NotificationHider
import com.slideindex.app.notification.NotificationHistoryRecorder
import com.slideindex.app.util.MediaSessionTracker

/**
 * Notification listener for media session tracking and notification history recording.
 * Must be enabled in system Settings → Notification access.
 */
class MediaNotificationListener : NotificationListenerService() {
    override fun onListenerConnected() {
        super.onListenerConnected()
        instance = this
        MediaSessionTracker.onListenerConnected(this)
        runCatching {
            NotificationHistoryRecorder.onListenerConnected(this, this, activeNotifications)
        }
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        MediaSessionTracker.onListenerDisconnected()
        if (instance === this) instance = null
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        MediaSessionTracker.onNotificationsChanged(this)
        NotificationHistoryRecorder.onPosted(applicationContext, this, sbn)
    }

    override fun onNotificationRemoved(
        sbn: StatusBarNotification,
        rankingMap: NotificationListenerService.RankingMap,
        reason: Int,
    ) {
        super.onNotificationRemoved(sbn, rankingMap, reason)
        MediaSessionTracker.onNotificationsChanged(this)
        NotificationHistoryRecorder.onRemoved(applicationContext, sbn, reason)
    }

    fun restoreNotificationToShade(key: String): Boolean = NotificationHider.unsnoozeNotification(key)

    companion object {
        @Volatile
        var instance: MediaNotificationListener? = null
            private set
    }
}
