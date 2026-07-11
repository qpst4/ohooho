package com.slideindex.app.ui.notificationhistory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R

internal enum class NotificationFilterTab {
    ACTIVE,
    HISTORY,
    HIDDEN,
}

@Composable
internal fun NotificationHistoryFilterBar(
    listenerEnabled: Boolean,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    onGrantListenerAccess: () -> Unit,
) {
    if (!listenerEnabled) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
        ) {
            NotificationHistoryPermissionCard(onGrant = onGrantListenerAccess)
        }
    }
    PrimaryTabRow(selectedTabIndex = selectedTab) {
        Tab(
            selected = selectedTab == NotificationFilterTab.ACTIVE.ordinal,
            onClick = { onTabSelected(NotificationFilterTab.ACTIVE.ordinal) },
            text = { Text(stringResource(R.string.notification_filter_tab_active)) },
        )
        Tab(
            selected = selectedTab == NotificationFilterTab.HISTORY.ordinal,
            onClick = { onTabSelected(NotificationFilterTab.HISTORY.ordinal) },
            text = { Text(stringResource(R.string.notification_filter_tab_history)) },
        )
        Tab(
            selected = selectedTab == NotificationFilterTab.HIDDEN.ordinal,
            onClick = { onTabSelected(NotificationFilterTab.HIDDEN.ordinal) },
            text = { Text(stringResource(R.string.notification_filter_history_hidden)) },
        )
    }
}

@Composable
internal fun NotificationHistoryPermissionCard(onGrant: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer,
        ),
        shape = MaterialTheme.shapes.large,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = stringResource(R.string.notification_history_permission_title),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onErrorContainer,
            )
            Text(
                text = stringResource(R.string.notification_history_permission_desc),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onErrorContainer,
            )
            TextButton(onClick = onGrant) {
                Text(stringResource(R.string.notification_history_permission_grant))
            }
        }
    }
}
