package com.slideindex.app.notification

import java.util.UUID

data class NotificationFilterRule(
    val id: String = UUID.randomUUID().toString(),
    val packageName: String,
    val channelId: String? = null,
    val titlePattern: String? = null,
    val createdAtMs: Long = System.currentTimeMillis(),
)

fun findMatchingNotificationFilterRule(
    rules: List<NotificationFilterRule>,
    item: NotificationHistoryItem,
): NotificationFilterRule? {
    return rules.firstOrNull { rule ->
        if (rule.packageName != item.packageName) return@firstOrNull false
        val pattern = rule.titlePattern
        if (pattern.isNullOrBlank()) return@firstOrNull true
        item.title.isNotBlank() && item.title.contains(pattern, ignoreCase = true)
    }
}

fun isNotificationHistoryItemHidden(
    item: NotificationHistoryItem,
    rules: List<NotificationFilterRule>,
): Boolean {
    return item.hidden || findMatchingNotificationFilterRule(rules, item) != null
}
