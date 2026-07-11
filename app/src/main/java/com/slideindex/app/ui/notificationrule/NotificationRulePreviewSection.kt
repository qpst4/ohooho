package com.slideindex.app.ui.notificationrule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.data.AppInfo
import com.slideindex.app.ui.SearchBar
import com.slideindex.app.ui.viewmodel.NotificationHistoryViewModel

@Composable
fun NotificationRuleAppPickerDialog(
    viewModel: NotificationHistoryViewModel,
    initialPackageNames: Set<String>,
    onDismiss: () -> Unit,
    onConfirm: (Set<String>) -> Unit,
) {
    var apps by remember { mutableStateOf<List<AppInfo>>(emptyList()) }
    var query by remember { mutableStateOf("") }
    var selected by remember(initialPackageNames) { mutableStateOf(initialPackageNames) }
    LaunchedEffect(Unit) {
        apps = viewModel.loadAppsForPicker()
    }
    val filtered = remember(apps, query) {
        viewModel.searchApps(apps, query)
    }

    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.notification_rule_pick_app)) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SearchBar(
                    query = query,
                    onQueryChange = { query = it },
                    hintResId = R.string.notification_rule_app_search_hint,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    TextButton(
                        onClick = { selected = selected + filtered.map { it.packageName } },
                        enabled = filtered.isNotEmpty(),
                    ) { Text(stringResource(R.string.notification_rule_select_all)) }
                    TextButton(
                        onClick = {
                            val toggled = selected.toMutableSet()
                            filtered.forEach { appInfo ->
                                if (appInfo.packageName in toggled) toggled.remove(appInfo.packageName)
                                else toggled.add(appInfo.packageName)
                            }
                            selected = toggled
                        },
                        enabled = filtered.isNotEmpty(),
                    ) { Text(stringResource(R.string.notification_rule_invert_selection)) }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    items(filtered, key = { it.packageName }) { appInfo ->
                        val checked = appInfo.packageName in selected
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selected = if (checked) selected - appInfo.packageName else selected + appInfo.packageName
                                }
                                .padding(vertical = 4.dp),
                        ) {
                            Checkbox(checked = checked, onCheckedChange = null)
                            Text("${appInfo.label} (${appInfo.packageName})", modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm(selected) }) {
                Text(stringResource(R.string.confirm))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancel))
            }
        },
    )
}
