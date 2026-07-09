package com.slideindex.app.notification

import android.content.Context
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification

/** Runtime shade operations implemented in :app (hide, rule execution, bulk snooze). */
interface NotificationShadeActions {
    fun hideFromShade(listener: NotificationListenerService, sbn: StatusBarNotification): Boolean

    fun hideFromShade(
        listener: NotificationListenerService,
        key: String,
        sbn: StatusBarNotification?,
    ): Boolean

    fun snoozeMatchingActive(
        context: Context,
        listener: NotificationListenerService,
        shouldHide: (StatusBarNotification) -> Boolean,
    )

    fun executeRules(
        context: Context,
        listener: NotificationListenerService,
        sbn: StatusBarNotification,
        rules: List<NotificationFilterRule>,
    )
}
