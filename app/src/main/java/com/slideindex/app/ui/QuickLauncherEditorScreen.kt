package com.slideindex.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Shortcut
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.HorizontalDivider
import android.app.Activity
import androidx.compose.material3.TopAppBar
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.SlideIndexApp
import com.slideindex.app.data.AppInfo
import com.slideindex.app.launcher.QuickLauncherItem
import com.slideindex.app.launcher.QuickLauncherItemCodec
import com.slideindex.app.launcher.QuickLauncherItemType
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.overlay.TaskSwitcherMenuItem
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.util.AppShortcutLoader
import com.slideindex.app.util.PinyinHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private sealed class EditorMode {
    data object Main : EditorMode()
    data object AddChooser : EditorMode()
    data object PickApp : EditorMode()
    data object PickShortcut : EditorMode()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickLauncherEditorScreen(
    side: PanelSide,
    settings: AppSettings,
    onBack: () -> Unit,
    onSaveItems: (List<QuickLauncherItem>) -> Unit,
) {
    val context = LocalContext.current
    val appRepository = remember { (context.applicationContext as SlideIndexApp).appRepository }
    var allApps by remember { mutableStateOf<List<AppInfo>>(emptyList()) }
    var mode by remember { mutableStateOf<EditorMode>(EditorMode.Main) }
    var searchQuery by remember { mutableStateOf("") }
    val currentItems = when (side) {
        PanelSide.LEFT -> settings.quickLauncherLeft
        PanelSide.RIGHT -> settings.quickLauncherRight
    }
    var items by remember(currentItems) { mutableStateOf(currentItems) }

    LaunchedEffect(Unit) {
        allApps = appRepository.loadApps(force = true)
    }

    val appsByPackage = remember(allApps) { allApps.associateBy { it.packageName } }
    val configuredAppPackages = remember(items) {
        items.filter { it.type == QuickLauncherItemType.APP }.map { it.payload }.toSet()
    }
    val configuredShortcutKeys = remember(items) {
        items.filter { it.type == QuickLauncherItemType.SHORTCUT }.mapNotNull { item ->
            QuickLauncherItemCodec.parseShortcutPayload(item.payload)?.let { (pkg, id) ->
                QuickLauncherItemCodec.shortcutKey(pkg, id)
            }
        }.toSet()
    }
    val addableApps = remember(allApps, configuredAppPackages, searchQuery) {
        val query = searchQuery.trim().lowercase()
        allApps.filter { it.packageName !in configuredAppPackages }
            .filter { app ->
                query.isEmpty() ||
                    app.label.lowercase().contains(query) ||
                    app.packageName.lowercase().contains(query) ||
                    PinyinHelper.sortKey(app.label).contains(query)
            }
    }

    fun saveAndBack() {
        onSaveItems(items)
        onBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (mode) {
                            EditorMode.PickShortcut ->
                                stringResource(R.string.quick_launcher_add_shortcut)
                            EditorMode.PickApp ->
                                stringResource(R.string.quick_launcher_add_app)
                            else -> stringResource(R.string.quick_launcher_editor_title)
                        },
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        when (mode) {
                            EditorMode.Main -> saveAndBack()
                            else -> {
                                mode = EditorMode.Main
                                searchQuery = ""
                            }
                        }
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { padding ->
        when (mode) {
            EditorMode.Main -> QuickLauncherMainEditor(
                padding = padding,
                items = items,
                appsByPackage = appsByPackage,
                onRemove = { index -> items = items.filterIndexed { i, _ -> i != index } },
                onAdd = { mode = EditorMode.AddChooser },
            )
            EditorMode.AddChooser -> QuickLauncherAddChooser(
                padding = padding,
                onPickApp = {
                    searchQuery = ""
                    mode = EditorMode.PickApp
                },
                onPickShortcut = {
                    searchQuery = ""
                    mode = EditorMode.PickShortcut
                },
            )
            EditorMode.PickApp -> QuickLauncherAppPicker(
                padding = padding,
                searchQuery = searchQuery,
                onSearchChange = { searchQuery = it },
                apps = addableApps,
                onPick = { app ->
                    items = items + QuickLauncherItem.app(app.packageName, app.label)
                    mode = EditorMode.Main
                    searchQuery = ""
                },
            )
            EditorMode.PickShortcut -> QuickLauncherShortcutCatalog(
                padding = padding,
                apps = allApps,
                configuredShortcutKeys = configuredShortcutKeys,
                searchQuery = searchQuery,
                onSearchChange = { searchQuery = it },
                onPick = { app, shortcut ->
                    val shortcutId = shortcut.shortcutId ?: shortcut.label
                    items = items + QuickLauncherItem.dynamicShortcut(
                        packageName = app.packageName,
                        shortcutId = shortcutId,
                        label = shortcut.label,
                    )
                    mode = EditorMode.Main
                    searchQuery = ""
                },
                onCreatedShortcut = { created ->
                    items = items + QuickLauncherItem.shortcut(created.componentFlat, created.label)
                    mode = EditorMode.Main
                    searchQuery = ""
                },
            )
        }
    }
}

@Composable
private fun QuickLauncherMainEditor(
    padding: androidx.compose.foundation.layout.PaddingValues,
    items: List<QuickLauncherItem>,
    appsByPackage: Map<String, AppInfo>,
    onRemove: (Int) -> Unit,
    onAdd: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(horizontal = 20.dp, vertical = 12.dp),
    ) {
        Text(
            text = stringResource(R.string.quick_launcher_editor_desc),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(modifier = Modifier.height(12.dp))
        SettingsCard {
            if (items.isEmpty()) {
                Text(
                    text = stringResource(R.string.quick_launcher_empty),
                    modifier = Modifier.padding(16.dp),
                )
            } else {
                items.forEachIndexed { index, item ->
                    QuickLauncherItemRow(
                        item = item,
                        appsByPackage = appsByPackage,
                        onRemove = { onRemove(index) },
                    )
                }
            }
            SettingNavigationRow(
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                title = stringResource(R.string.quick_launcher_add),
                subtitle = stringResource(R.string.quick_launcher_add_desc),
                onClick = onAdd,
            )
        }
    }
}

@Composable
private fun QuickLauncherAddChooser(
    padding: androidx.compose.foundation.layout.PaddingValues,
    onPickApp: () -> Unit,
    onPickShortcut: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(horizontal = 20.dp, vertical = 12.dp),
    ) {
        SettingsCard {
            SettingNavigationRow(
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                title = stringResource(R.string.quick_launcher_add_app),
                subtitle = stringResource(R.string.quick_launcher_add_app_desc),
                onClick = onPickApp,
            )
            SettingNavigationRow(
                icon = { Icon(Icons.AutoMirrored.Filled.Shortcut, contentDescription = null) },
                title = stringResource(R.string.quick_launcher_add_shortcut),
                subtitle = stringResource(R.string.quick_launcher_add_shortcut_desc),
                onClick = onPickShortcut,
            )
        }
    }
}

@Composable
private fun QuickLauncherAppPicker(
    padding: androidx.compose.foundation.layout.PaddingValues,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    apps: List<AppInfo>,
    onPick: (AppInfo) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(horizontal = 20.dp),
    ) {
        SearchBar(query = searchQuery, onQueryChange = onSearchChange, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(apps, key = { it.packageName }) { app ->
                AppPackageListRow(
                    entry = AppPackageEntry.Installed(app),
                    actionIcon = Icons.Default.Add,
                    actionDescription = stringResource(R.string.quick_launcher_add),
                    missingIcon = Icons.Default.Add,
                    onAction = { onPick(app) },
                )
            }
        }
    }
}

@Composable
private fun QuickLauncherShortcutCatalog(
    padding: androidx.compose.foundation.layout.PaddingValues,
    apps: List<AppInfo>,
    configuredShortcutKeys: Set<String>,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    onPick: (AppInfo, TaskSwitcherMenuItem) -> Unit,
    onCreatedShortcut: (AppShortcutLoader.CreatedShortcut) -> Unit,
) {
    val context = LocalContext.current
    var groups by remember { mutableStateOf<List<AppShortcutLoader.AppShortcutGroup>>(emptyList()) }
    var createHosts by remember { mutableStateOf<List<AppShortcutLoader.CreateShortcutHost>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }
    var pendingCreateHost by remember { mutableStateOf<AppShortcutLoader.CreateShortcutHost?>(null) }

    val createLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { result ->
        val host = pendingCreateHost
        pendingCreateHost = null
        if (result.resultCode != Activity.RESULT_OK || host == null) return@rememberLauncherForActivityResult
        val created = AppShortcutLoader.parseCreateShortcutResult(host.packageName, result.data)
            ?: return@rememberLauncherForActivityResult
        onCreatedShortcut(created)
    }

    LaunchedEffect(apps) {
        loading = true
        withContext(Dispatchers.IO) {
            createHosts = AppShortcutLoader.queryCreateShortcutActivities(context)
            groups = AppShortcutLoader.loadRegisteredShortcutGroups(context, apps)
        }
        loading = false
    }

    val query = searchQuery.trim().lowercase()
    val filteredCreateHosts = remember(createHosts, query) {
        createHosts.filter { host ->
            query.isEmpty() ||
                host.label.lowercase().contains(query) ||
                host.packageName.lowercase().contains(query) ||
                PinyinHelper.sortKey(host.label).contains(query)
        }
    }
    val filteredGroups = remember(groups, query, configuredShortcutKeys) {
        groups.mapNotNull { group ->
            val available = group.shortcuts.filter { shortcut ->
                val id = shortcut.shortcutId ?: shortcut.label
                QuickLauncherItemCodec.shortcutKey(group.app.packageName, id) !in configuredShortcutKeys
            }
            if (available.isEmpty()) return@mapNotNull null
            val appMatches = query.isEmpty() ||
                group.app.label.lowercase().contains(query) ||
                group.app.packageName.lowercase().contains(query) ||
                PinyinHelper.sortKey(group.app.label).contains(query)
            val matchedShortcuts = if (query.isEmpty()) {
                available
            } else if (appMatches) {
                available
            } else {
                available.filter { shortcut ->
                    shortcut.label.lowercase().contains(query) ||
                        (shortcut.shortcutId?.lowercase()?.contains(query) == true)
                }
            }
            if (matchedShortcuts.isEmpty()) null
            else group.copy(shortcuts = matchedShortcuts)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(horizontal = 20.dp),
    ) {
        SearchBar(query = searchQuery, onQueryChange = onSearchChange, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        when {
            loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = stringResource(R.string.quick_launcher_loading_shortcuts),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            filteredCreateHosts.isEmpty() && filteredGroups.isEmpty() -> {
                Text(
                    text = stringResource(R.string.quick_launcher_no_shortcuts_catalog),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(16.dp),
                )
            }
            else -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    if (filteredCreateHosts.isNotEmpty()) {
                        item(key = "header-create") {
                            QuickLauncherShortcutSectionHeader(stringResource(R.string.create_shortcut))
                        }
                        items(filteredCreateHosts, key = { it.qualifiedName }) { host ->
                            val app = apps.firstOrNull { it.packageName == host.packageName }
                            AppPackageListRow(
                                entry = app?.let { AppPackageEntry.Installed(it) }
                                    ?: AppPackageEntry.Missing(host.label),
                                actionIcon = Icons.AutoMirrored.Filled.Shortcut,
                                actionDescription = stringResource(R.string.create_shortcut),
                                missingIcon = Icons.AutoMirrored.Filled.Shortcut,
                                onAction = {
                                    pendingCreateHost = host
                                    runCatching { createLauncher.launch(host.createIntent()) }
                                        .onFailure { pendingCreateHost = null }
                                },
                                title = host.label,
                                subtitle = stringResource(R.string.create_shortcut_tap_hint),
                            )
                        }
                        item(key = "gap-create") { Spacer(modifier = Modifier.height(8.dp)) }
                    }
                    if (filteredGroups.isNotEmpty()) {
                        item(key = "header-launch") {
                            QuickLauncherShortcutSectionHeader(stringResource(R.string.launch_shortcut))
                        }
                        filteredGroups.forEach { group ->
                            item(key = "header-${group.app.packageName}") {
                                AppPackageListRow(
                                    entry = AppPackageEntry.Installed(group.app),
                                    actionIcon = Icons.Default.Add,
                                    actionDescription = null,
                                    missingIcon = Icons.Default.Add,
                                    onAction = {},
                                    showAction = false,
                                )
                            }
                            items(
                                items = group.shortcuts,
                                key = { shortcut ->
                                    "${group.app.packageName}:${shortcut.shortcutId ?: shortcut.label}"
                                },
                            ) { shortcut ->
                                ShortcutCatalogRow(
                                    shortcut = shortcut,
                                    onAdd = { onPick(group.app, shortcut) },
                                )
                            }
                            item(key = "gap-${group.app.packageName}") {
                                Spacer(modifier = Modifier.height(6.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun QuickLauncherShortcutSectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
    )
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
}

@Composable
private fun ShortcutCatalogRow(
    shortcut: TaskSwitcherMenuItem,
    onAdd: () -> Unit,
) {
    AppPackageListRow(
        entry = AppPackageEntry.Missing(shortcut.label),
        actionIcon = Icons.Default.Add,
        actionDescription = stringResource(R.string.quick_launcher_add),
        missingIcon = Icons.AutoMirrored.Filled.Shortcut,
        onAction = onAdd,
        modifier = Modifier.padding(start = 28.dp),
        title = shortcut.label,
        subtitle = null,
    )
}

@Composable
private fun QuickLauncherItemRow(
    item: QuickLauncherItem,
    appsByPackage: Map<String, AppInfo>,
    onRemove: () -> Unit,
) {
    when (item.type) {
        QuickLauncherItemType.APP -> {
            val app = appsByPackage[item.payload]
            AppPackageListRow(
                entry = app?.let { AppPackageEntry.Installed(it) }
                    ?: AppPackageEntry.Missing(item.payload),
                actionIcon = Icons.Default.Close,
                actionDescription = stringResource(R.string.quick_launcher_remove),
                missingIcon = Icons.Default.Close,
                onAction = onRemove,
            )
        }
        QuickLauncherItemType.SHORTCUT -> {
            val packageName = QuickLauncherItemCodec.parseShortcutPayload(item.payload)?.first
                ?: item.payload.substringBefore('\u001C')
            val app = appsByPackage[packageName]
            AppPackageListRow(
                entry = app?.let { AppPackageEntry.Installed(it) }
                    ?: AppPackageEntry.Missing(packageName),
                actionIcon = Icons.Default.Close,
                actionDescription = stringResource(R.string.quick_launcher_remove),
                missingIcon = Icons.Default.Close,
                onAction = onRemove,
                title = item.label.ifBlank { stringResource(R.string.quick_launcher_shortcut_fallback) },
                subtitle = packageName,
            )
        }
        QuickLauncherItemType.WIDGET -> {
            SettingNavigationRow(
                icon = { Icon(Icons.AutoMirrored.Filled.Shortcut, contentDescription = null) },
                title = item.label.ifBlank { "小组件" },
                subtitle = item.payload,
                onClick = onRemove,
            )
        }
    }
}
