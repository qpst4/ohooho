package com.slideindex.app.ui

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.SlideIndexApp
import com.slideindex.app.data.AppInfo
import com.slideindex.app.notification.NotificationFilterRule
import com.slideindex.app.notification.NotificationRuleAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun NotificationRulesTab(
    rules: List<NotificationFilterRule>,
    app: SlideIndexApp,
    modifier: Modifier = Modifier,
    onUpsertRule: (NotificationFilterRule) -> Unit,
    onRemoveRule: (String) -> Unit,
    onSetRuleEnabled: (String, Boolean) -> Unit,
) {
    val context = LocalContext.current
    var showEditor by remember { mutableStateOf(false) }
    var editingRule by remember { mutableStateOf<NotificationFilterRule?>(null) }

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item(key = "rules_section") {
                SettingsSectionTitle(stringResource(R.string.notification_rule_section_title))
            }
            if (rules.isEmpty()) {
                item(key = "rules_empty") {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            text = stringResource(R.string.notification_rule_empty),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            } else {
                items(rules, key = { it.id }) { rule ->
                    val appLabel = if (rule.packageName.isBlank()) {
                        null
                    } else {
                        app.appRepository.ensureAppInfo(rule.packageName)?.label
                    }
                    NotificationRuleCard(
                        rule = rule,
                        appLabel = appLabel,
                        onEnabledChange = { enabled -> onSetRuleEnabled(rule.id, enabled) },
                        onEdit = {
                            editingRule = rule
                            showEditor = true
                        },
                        onDelete = { onRemoveRule(rule.id) },
                    )
                }
            }
            item(key = "rules_bottom_spacer") {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        FloatingActionButton(
            onClick = {
                editingRule = null
                showEditor = true
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp),
        ) {
            Icon(Icons.Default.Add, contentDescription = stringResource(R.string.notification_rule_add))
        }
    }

    if (showEditor) {
        NotificationRuleEditorDialog(
            initialRule = editingRule,
            app = app,
            onDismiss = {
                showEditor = false
                editingRule = null
            },
            onSave = { saved ->
                if (saved.actions.isEmpty()) {
                    Toast.makeText(context, R.string.notification_rule_invalid, Toast.LENGTH_SHORT).show()
                    return@NotificationRuleEditorDialog
                }
                onUpsertRule(saved)
                Toast.makeText(context, R.string.notification_rule_saved, Toast.LENGTH_SHORT).show()
                showEditor = false
                editingRule = null
            },
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun NotificationRuleCard(
    rule: NotificationFilterRule,
    appLabel: String?,
    onEnabledChange: (Boolean) -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onEdit),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = rule.displayName().ifBlank { stringResource(R.string.notification_rule_unnamed) },
                    style = MaterialTheme.typography.titleMediumEmphasized,
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onDelete) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = stringResource(R.string.notification_rule_delete),
                            tint = MaterialTheme.colorScheme.error,
                        )
                    }
                    Switch(checked = rule.enabled, onCheckedChange = onEnabledChange)
                }
            }
            val packageLabel = if (rule.packageName.isBlank()) {
                stringResource(R.string.notification_rule_all_apps)
            } else {
                appLabel?.let { "$it (${rule.packageName})" } ?: rule.packageName
            }
            Text(
                text = stringResource(R.string.notification_rule_package_summary, packageLabel),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            if (!rule.titlePattern.isNullOrBlank()) {
                Text(
                    text = stringResource(R.string.notification_rule_title_summary, rule.titlePattern),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            if (!rule.textPattern.isNullOrBlank()) {
                Text(
                    text = stringResource(R.string.notification_rule_text_summary, rule.textPattern),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                rule.actions.forEach { action ->
                    Text(
                        text = actionLabel(action),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(end = 4.dp),
                    )
                }
                if (rule.useRegex) {
                    Text(
                        text = stringResource(R.string.notification_rule_regex_badge),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                }
            }
        }
    }
}

@Composable
private fun actionLabel(action: NotificationRuleAction): String {
    return when (action) {
        NotificationRuleAction.HIDE -> stringResource(R.string.notification_rule_action_hide)
        NotificationRuleAction.TTS -> stringResource(R.string.notification_rule_action_tts)
        NotificationRuleAction.RING -> stringResource(R.string.notification_rule_action_ring)
        NotificationRuleAction.OPEN -> stringResource(R.string.notification_rule_action_open)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun NotificationRuleEditorDialog(
    initialRule: NotificationFilterRule?,
    app: SlideIndexApp,
    onDismiss: () -> Unit,
    onSave: (NotificationFilterRule) -> Unit,
) {
    var name by remember(initialRule) { mutableStateOf(initialRule?.name.orEmpty()) }
    var packageName by remember(initialRule) { mutableStateOf(initialRule?.packageName.orEmpty()) }
    var titlePattern by remember(initialRule) { mutableStateOf(initialRule?.titlePattern.orEmpty()) }
    var textPattern by remember(initialRule) { mutableStateOf(initialRule?.textPattern.orEmpty()) }
    var useRegex by remember(initialRule) { mutableStateOf(initialRule?.useRegex == true) }
    var selectedActions by remember(initialRule) {
        mutableStateOf(initialRule?.actions ?: setOf(NotificationRuleAction.HIDE))
    }
    var showAppPicker by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                if (initialRule == null) {
                    stringResource(R.string.notification_rule_add)
                } else {
                    stringResource(R.string.notification_rule_edit)
                },
            )
        },
        text = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text(stringResource(R.string.notification_rule_name)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                )
                OutlinedTextField(
                    value = packageName,
                    onValueChange = { packageName = it },
                    label = { Text(stringResource(R.string.notification_rule_package)) },
                    placeholder = { Text(stringResource(R.string.notification_rule_package_hint)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = { showAppPicker = true }) {
                            Icon(Icons.AutoMirrored.Filled.List, contentDescription = stringResource(R.string.notification_rule_pick_app))
                        }
                    },
                )
                OutlinedTextField(
                    value = titlePattern,
                    onValueChange = { titlePattern = it },
                    label = { Text(stringResource(R.string.notification_rule_title_pattern)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                )
                OutlinedTextField(
                    value = textPattern,
                    onValueChange = { textPattern = it },
                    label = { Text(stringResource(R.string.notification_rule_text_pattern)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { useRegex = !useRegex },
                ) {
                    Checkbox(checked = useRegex, onCheckedChange = { useRegex = it })
                    Text(stringResource(R.string.notification_rule_use_regex))
                }
                SettingsSectionTitle(stringResource(R.string.notification_rule_actions))
                NotificationRuleAction.entries.forEach { action ->
                    val checked = action in selectedActions
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedActions = if (checked) {
                                    selectedActions - action
                                } else {
                                    selectedActions + action
                                }
                            },
                    ) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { enabled ->
                                selectedActions = if (enabled) {
                                    selectedActions + action
                                } else {
                                    selectedActions - action
                                }
                            },
                        )
                        Text(actionLabel(action))
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onSave(
                        NotificationFilterRule(
                            id = initialRule?.id ?: java.util.UUID.randomUUID().toString(),
                            name = name.trim(),
                            packageName = packageName.trim(),
                            titlePattern = titlePattern.trim().takeIf { it.isNotBlank() },
                            textPattern = textPattern.trim().takeIf { it.isNotBlank() },
                            useRegex = useRegex,
                            enabled = initialRule?.enabled ?: true,
                            actions = selectedActions,
                            userCreated = true,
                            createdAtMs = initialRule?.createdAtMs ?: System.currentTimeMillis(),
                        ),
                    )
                },
            ) {
                Text(stringResource(R.string.confirm))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancel))
            }
        },
    )

    if (showAppPicker) {
        NotificationRuleAppPickerDialog(
            app = app,
            onDismiss = { showAppPicker = false },
            onSelect = { selected ->
                packageName = selected.packageName
                showAppPicker = false
            },
        )
    }
}

@Composable
private fun NotificationRuleAppPickerDialog(
    app: SlideIndexApp,
    onDismiss: () -> Unit,
    onSelect: (AppInfo) -> Unit,
) {
    var apps by remember { mutableStateOf<List<AppInfo>>(emptyList()) }
    var query by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        apps = withContext(Dispatchers.IO) { app.appRepository.loadApps() }
    }
    val filtered = remember(apps, query) {
        app.appRepository.searchApps(apps, query)
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.notification_rule_pick_app)) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SearchBar(
                    query = query,
                    onQueryChange = { query = it },
                    hintResId = R.string.notification_rule_app_search_hint,
                )
                Column(
                    modifier = Modifier
                        .height(320.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    filtered.take(80).forEach { appInfo ->
                        Text(
                            text = "${appInfo.label} (${appInfo.packageName})",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onSelect(appInfo) }
                                .padding(vertical = 8.dp, horizontal = 4.dp),
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancel))
            }
        },
    )
}
