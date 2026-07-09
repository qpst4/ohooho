package com.slideindex.app.notification

import android.service.notification.NotificationListenerService

/** Access to the bound [NotificationListenerService] from the app process. */
interface NotificationListenerPort {
    fun listenerOrNull(): NotificationListenerService?
}
