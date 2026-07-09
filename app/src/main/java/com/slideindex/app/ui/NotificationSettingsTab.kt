package com.slideindex.app.ui

import com.slideindex.app.di.AppDependencies
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slideindex.app.R
import com.slideindex.app.notification.NotificationFilterPreferences
import com.slideindex.app.notification.NotificationFilterSettings
import kotlin.math.roundToInt
import kotlinx.coroutines.launch

@Composable
fun NotificationSettingsTab(
    deps: AppDependencies,
    listenerEnabled: Boolean,
    onRequestListenerAccess: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val filterSettings by deps.notificationFilterPreferences.settings.collectAsStateWithLifecycle(
        initialValue = NotificationFilterSettings(),
    )
    val maxCountRange = NotificationFilterPreferences.MIN_NOTIFICATION_HISTORY_MAX_COUNT.toFloat()..
        NotificationFilterPreferences.MAX_NOTIFICATION_HISTORY_MAX_COUNT.toFloat()
    val maxCountSteps = (
        (NotificationFilterPreferences.MAX_NOTIFICATION_HISTORY_MAX_COUNT -
            NotificationFilterPreferences.MIN_NOTIFICATION_HISTORY_MAX_COUNT) /
            NotificationFilterPreferences.NOTIFICATION_HISTORY_MAX_COUNT_STEP
        ) - 1
    val snapMaxCount: (Float) -> Float = { value ->
        val step = NotificationFilterPreferences.NOTIFICATION_HISTORY_MAX_COUNT_STEP
        val snapped = ((value / step).roundToInt() * step)
            .coerceIn(
                NotificationFilterPreferences.MIN_NOTIFICATION_HISTORY_MAX_COUNT,
                NotificationFilterPreferences.MAX_NOTIFICATION_HISTORY_MAX_COUNT,
            )
        snapped.toFloat()
    }
    val formatMaxCountLabel = remember(context) {
        { value: Float ->
            context.getString(
                R.string.notification_history_max_count_value,
                value.roundToInt(),
            )
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item(key = "restore_snoozed") {
            SettingsCard {
                Text(
                    text = stringResource(R.string.notification_restore_snoozed_desc),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 12.dp),
                )
                Button(
                    onClick = {
                        if (!listenerEnabled) {
                            Toast.makeText(
                                context,
                                R.string.notification_hide_listener_required,
                                Toast.LENGTH_SHORT,
                            ).show()
                            onRequestListenerAccess()
                            return@Button
                        }
                        val restored = deps.notificationHistoryRepository.restoreAllSnoozed()
                        val messageRes = if (restored > 0) {
                            R.string.notification_restore_snoozed_result
                        } else {
                            R.string.notification_restore_snoozed_empty
                        }
                        Toast.makeText(
                            context,
                            if (restored > 0) {
                                context.getString(messageRes, restored)
                            } else {
                                context.getString(messageRes)
                            },
                            Toast.LENGTH_SHORT,
                        ).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                ) {
                    Text(stringResource(R.string.notification_restore_snoozed_action))
                }
            }
        }
        item(key = "history_section") {
            SettingsSectionTitle(stringResource(R.string.notification_settings_history_section))
        }
        item(key = "history_max_count") {
            SettingsCard {
                SettingsSliderRow(
                    title = stringResource(R.string.notification_history_max_count_title),
                    value = filterSettings.notificationHistoryMaxCount.toFloat(),
                    valueRange = maxCountRange,
                    steps = maxCountSteps,
                    enabled = true,
                    label = formatMaxCountLabel(filterSettings.notificationHistoryMaxCount.toFloat()),
                    formatLabel = formatMaxCountLabel,
                    snapValue = snapMaxCount,
                    onValueChange = { value ->
                        val count = snapMaxCount(value).roundToInt()
                        scope.launch {
                            deps.notificationFilterPreferences.setNotificationHistoryMaxCount(count)
                            deps.notificationHistoryRepository.applyMaxCountLimit(count)
                        }
                    },
                )
            }
        }
        item(key = "settings_hint") {
            Text(
                text = stringResource(R.string.notification_settings_rules_hint),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
            )
        }
    }
}
