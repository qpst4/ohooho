package com.slideindex.app.notification

import java.util.UUID

data class NotificationFilterRule(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    /** Blank means all installed apps. */
    val packageName: String = "",
    val channelId: String? = null,
    val titlePattern: String? = null,
    val textPattern: String? = null,
    val useRegex: Boolean = false,
    val enabled: Boolean = true,
    val actions: Set<NotificationRuleAction> = setOf(NotificationRuleAction.HIDE),
    val createdAtMs: Long = System.currentTimeMillis(),
    /** False for legacy entries created by swipe-to-hide; those are not task rules. */
    val userCreated: Boolean = true,
) {
    fun displayName(): String {
        if (name.isNotBlank()) return name
        if (packageName.isNotBlank()) return packageName
        return ""
    }

    fun hidesNotification(): Boolean = NotificationRuleAction.HIDE in actions
}

fun findMatchingNotificationFilterRule(
    rules: List<NotificationFilterRule>,
    item: NotificationHistoryItem,
): NotificationFilterRule? {
    return rules.firstOrNull { rule ->
        rule.userCreated &&
            rule.hidesNotification() &&
            NotificationRuleMatcher.matches(
                rule = rule,
                packageName = item.packageName,
                channelId = null,
                title = item.title,
                text = item.text,
            )
    }
}

fun isNotificationHistoryItemHidden(
    item: NotificationHistoryItem,
    rules: List<NotificationFilterRule>,
): Boolean {
    return item.hidden || findMatchingNotificationFilterRule(rules, item) != null
}
