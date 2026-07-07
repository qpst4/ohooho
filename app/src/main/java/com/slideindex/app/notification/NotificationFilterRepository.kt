package com.slideindex.app.notification

import android.app.Notification
import android.content.Context
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.slideindex.app.service.MediaNotificationListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.io.File

class NotificationFilterRepository(context: Context) {
    private val appContext = context.applicationContext
    private val rulesFile = File(appContext.filesDir, RULES_FILE_NAME)
    private val mutex = Mutex()
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val _rules = MutableStateFlow<List<NotificationFilterRule>>(emptyList())
    val rules: StateFlow<List<NotificationFilterRule>> = _rules.asStateFlow()

    init {
        scope.launch { _rules.value = readFromDisk() }
    }

    fun matches(sbn: StatusBarNotification): Boolean {
        val notification = sbn.notification ?: return false
        val extras = notification.extras ?: return false
        val title = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
        val channelId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification.channelId
        } else {
            null
        }
        return matches(packageName = sbn.packageName, channelId = channelId, title = title)
    }

    fun matches(packageName: String, channelId: String?, title: String): Boolean {
        return _rules.value.any { rule -> rule.matches(packageName, channelId, title) }
    }

    fun addRule(rule: NotificationFilterRule) {
        scope.launch {
            mutex.withLock {
                val current = readFromDisk()
                val duplicate = current.any { it.isSameTarget(rule) }
                if (duplicate) return@withLock
                val next = listOf(rule) + current
                writeToDisk(next)
                _rules.value = next
            }
            snoozeMatchingActive(rule)
        }
    }

    fun addRuleFromItem(item: NotificationHistoryItem): Boolean {
        addRule(
            NotificationFilterRule(
                packageName = item.packageName,
                titlePattern = item.title.takeIf { it.isNotBlank() },
            ),
        )
        val key = item.notificationKey ?: return true
        val listener = MediaNotificationListener.instance ?: return false
        val sbn = runCatching {
            listener.activeNotifications?.firstOrNull { it.key == key }
        }.getOrNull()
        return if (sbn != null) {
            NotificationHider.hideFromShade(listener, sbn)
        } else {
            NotificationHider.hideFromShade(listener, key, sbn)
        }
    }

    fun removeRule(id: String) {
        scope.launch {
            mutex.withLock {
                val next = readFromDisk().filterNot { it.id == id }
                writeToDisk(next)
                _rules.value = next
            }
        }
    }

    fun findMatchingRule(item: NotificationHistoryItem): NotificationFilterRule? {
        return _rules.value.firstOrNull { rule -> rule.matchesItem(item) }
    }

    suspend fun removeRuleForItem(item: NotificationHistoryItem): Boolean {
        val rule = findMatchingRule(item) ?: return false
        mutex.withLock {
            val next = readFromDisk().filterNot { it.id == rule.id }
            writeToDisk(next)
            _rules.value = next
        }
        return true
    }

    /** Re-apply persisted filter rules to currently active shade notifications. */
    fun snoozeMatchingActiveNotifications(listener: NotificationListenerService) {
        NotificationHider.snoozeMatchingActive(appContext, listener)
    }

    private fun snoozeMatchingActive(rule: NotificationFilterRule) {
        val listener = MediaNotificationListener.instance ?: return
        listener.activeNotifications?.forEach { sbn ->
            val notification = sbn.notification ?: return@forEach
            val extras = notification.extras ?: return@forEach
            val title = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
            val channelId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notification.channelId
            } else {
                null
            }
            if (rule.matches(sbn.packageName, channelId, title)) {
                NotificationHider.hideFromShade(listener, sbn)
            }
        }
    }

    private suspend fun readFromDisk(): List<NotificationFilterRule> = withContext(Dispatchers.IO) {
        if (!rulesFile.exists()) return@withContext emptyList()
        runCatching {
            NotificationFilterCodec.decode(rulesFile.readText())
        }.getOrDefault(emptyList())
    }

    private suspend fun writeToDisk(rules: List<NotificationFilterRule>) = withContext(Dispatchers.IO) {
        rulesFile.writeText(NotificationFilterCodec.encode(rules))
    }

    companion object {
        private const val RULES_FILE_NAME = "notification_filter_rules.json"

        private fun NotificationFilterRule.matches(
            packageName: String,
            channelId: String?,
            title: String,
        ): Boolean {
            if (this.packageName != packageName) return false
            if (!this.channelId.isNullOrBlank() && this.channelId != channelId) return false
            val pattern = this.titlePattern
            if (!pattern.isNullOrBlank() && !title.contains(pattern, ignoreCase = true)) return false
            return true
        }

        private fun NotificationFilterRule.isSameTarget(other: NotificationFilterRule): Boolean {
            return packageName == other.packageName &&
                channelId == other.channelId &&
                titlePattern == other.titlePattern
        }

        private fun NotificationFilterRule.matchesItem(item: NotificationHistoryItem): Boolean {
            if (packageName != item.packageName) return false
            val pattern = titlePattern
            if (pattern.isNullOrBlank()) return true
            return item.title.isNotBlank() && item.title.contains(pattern, ignoreCase = true)
        }
    }
}
