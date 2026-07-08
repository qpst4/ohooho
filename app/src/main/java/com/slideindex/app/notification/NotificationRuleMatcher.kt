package com.slideindex.app.notification

import android.app.Notification
import android.os.Build
import android.service.notification.StatusBarNotification

object NotificationRuleMatcher {
    fun findMatching(
        rules: List<NotificationFilterRule>,
        sbn: StatusBarNotification,
    ): List<NotificationFilterRule> {
        val notification = sbn.notification ?: return emptyList()
        val extras = notification.extras ?: return emptyList()
        val title = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
        val text = extras.getCharSequence(Notification.EXTRA_TEXT)?.toString().orEmpty()
        val bigText = extras.getCharSequence(Notification.EXTRA_BIG_TEXT)?.toString().orEmpty()
        val contentText = text.ifBlank { bigText }
        val channelId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification.channelId
        } else {
            null
        }
        return findMatching(
            rules = rules,
            packageName = sbn.packageName,
            channelId = channelId,
            title = title,
            text = contentText,
        )
    }

    fun findMatching(
        rules: List<NotificationFilterRule>,
        packageName: String,
        channelId: String?,
        title: String,
        text: String,
    ): List<NotificationFilterRule> {
        return rules.filter { rule ->
            matches(
                rule = rule,
                packageName = packageName,
                channelId = channelId,
                title = title,
                text = text,
            )
        }
    }

    fun matches(
        rule: NotificationFilterRule,
        packageName: String,
        channelId: String?,
        title: String,
        text: String,
    ): Boolean {
        if (!rule.enabled) return false
        if (rule.packageName.isNotBlank() && rule.packageName != packageName) return false
        if (!rule.channelId.isNullOrBlank() && rule.channelId != channelId) return false
        if (!matchesField(rule.titlePattern, title, rule.useRegex)) return false
        if (!matchesField(rule.textPattern, text, rule.useRegex)) return false
        return true
    }

    private fun matchesField(pattern: String?, value: String, useRegex: Boolean): Boolean {
        if (pattern.isNullOrBlank()) return true
        if (value.isBlank()) return false
        return if (useRegex) {
            runCatching { Regex(pattern).containsMatchIn(value) }.getOrDefault(false)
        } else {
            value.contains(pattern, ignoreCase = true)
        }
    }
}
