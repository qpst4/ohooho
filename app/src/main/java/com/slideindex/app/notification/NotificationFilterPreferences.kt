package com.slideindex.app.notification

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

private val Context.notificationFilterDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "notification_filter_preferences",
)

private const val DEFAULT_NOTIFICATION_HISTORY_MAX_COUNT = 500
private const val MIN_NOTIFICATION_HISTORY_MAX_COUNT = 50
private const val MAX_NOTIFICATION_HISTORY_MAX_COUNT = 2000

data class NotificationFilterSettings(
    val notificationHistoryMaxCount: Int = DEFAULT_NOTIFICATION_HISTORY_MAX_COUNT,
)

class NotificationFilterPreferences(context: Context) {
    private val appContext = context.applicationContext

    val settings: Flow<NotificationFilterSettings> = appContext.notificationFilterDataStore.data.map { prefs ->
        NotificationFilterSettings(
            notificationHistoryMaxCount = (prefs[NOTIFICATION_HISTORY_MAX_COUNT]
                ?: DEFAULT_NOTIFICATION_HISTORY_MAX_COUNT)
                .coerceIn(MIN_NOTIFICATION_HISTORY_MAX_COUNT, MAX_NOTIFICATION_HISTORY_MAX_COUNT),
        )
    }

    suspend fun setNotificationHistoryMaxCount(count: Int) {
        val clamped = count.coerceIn(
            MIN_NOTIFICATION_HISTORY_MAX_COUNT,
            MAX_NOTIFICATION_HISTORY_MAX_COUNT,
        )
        appContext.notificationFilterDataStore.edit { prefs ->
            prefs[NOTIFICATION_HISTORY_MAX_COUNT] = clamped
        }
    }

    fun readSnapshot(): NotificationFilterSettings = runBlocking {
        settings.first()
    }

    companion object {
        const val DEFAULT_NOTIFICATION_HISTORY_MAX_COUNT = 500
        const val MIN_NOTIFICATION_HISTORY_MAX_COUNT = 50
        const val MAX_NOTIFICATION_HISTORY_MAX_COUNT = 2000
        const val NOTIFICATION_HISTORY_MAX_COUNT_STEP = 50

        private val NOTIFICATION_HISTORY_MAX_COUNT = intPreferencesKey("notification_history_max_count")
    }
}
