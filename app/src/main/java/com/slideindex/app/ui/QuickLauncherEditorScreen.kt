package com.slideindex.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumFlexibleTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.slideindex.app.R
import com.slideindex.app.gesture.GestureAction
import com.slideindex.app.launcher.QuickLauncherDefaults
import com.slideindex.app.launcher.QuickLauncherItem
import com.slideindex.app.launcher.QuickLauncherItemCodec
import com.slideindex.app.launcher.QuickLauncherItemType
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.util.AppShortcutLoader.toQuickLauncherItem
import com.slideindex.app.ui.compose.rememberAppRepository
import com.slideindex.app.ui.quicklauncher.QuickLauncherEditorAddPicker
import com.slideindex.app.ui.quicklauncher.QuickLauncherEditorMainSection
import com.slideindex.app.ui.requestPermissionForAdjustAction
import com.slideindex.app.util.AppShortcutLoader

private sealed class EditorMode {
    data object Main : EditorMode()
    data object AddPicker : EditorMode()
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun QuickLauncherEditorScreen(
    settings: AppSettings,
    onBack: () -> Unit,
    onSaveItems: (List<QuickLauncherItem>) -> Unit,
    onColumnsChange: (Int) -> Unit,
    onRowsChange: (Int) -> Unit,
) {
    val context = LocalContext.current
    val appRepository = rememberAppRepository()
    var allApps by remember { mutableStateOf(appRepository.getCachedApps()) }
    var mode by remember { mutableStateOf<EditorMode>(EditorMode.Main) }
    var searchQuery by remember { mutableStateOf("") }
    val currentItems = settings.quickLauncher
    var items by remember(currentItems) { mutableStateOf(currentItems) }
    var gridInteractionActive by remember { mutableStateOf(false) }

    LaunchedEffect(allApps, currentItems) {
        if (allApps.isNotEmpty() && items.isEmpty()) {
            val effective = QuickLauncherDefaults.effectiveItems(currentItems, allApps)
            if (effective.isNotEmpty()) {
                items = effective
                if (currentItems.isEmpty()) {
                    onSaveItems(effective)
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        allApps = appRepository.loadApps(force = false)
    }

    val appsByPackage = remember(allApps) { allApps.associateBy { it.packageName } }
    val configuredAppPackages = remember(items) {
        items.filter { it.type == QuickLauncherItemType.APP }.map { it.payload }.toSet()
    }
    val configuredShortcutKeys = remember(items) {
        items.filter { it.type == QuickLauncherItemType.SHORTCUT }.mapNotNull { item ->
            QuickLauncherItemCodec.shortcutItemKey(item)
        }.toSet()
    }
    val configuredActionKeys = remember(items) {
        items.filter { it.type == QuickLauncherItemType.ACTION }.mapNotNull { item ->
            QuickLauncherItemCodec.parseActionPayload(item.payload)?.let(QuickLauncherItemCodec::actionKey)
        }.toSet()
    }

    fun saveAndBack() {
        onSaveItems(items)
        onBack()
    }

    fun addItem(item: QuickLauncherItem) {
        items = items + item
    }

    fun removeItem(item: QuickLauncherItem) {
        items = when (item.type) {
            QuickLauncherItemType.APP ->
                items.filterNot { it.type == QuickLauncherItemType.APP && it.payload == item.payload }
            QuickLauncherItemType.SHORTCUT -> {
                val key = QuickLauncherItemCodec.shortcutItemKey(item) ?: return
                items.filterNot {
                    it.type == QuickLauncherItemType.SHORTCUT &&
                        QuickLauncherItemCodec.shortcutItemKey(it) == key
                }
            }
            QuickLauncherItemType.ACTION -> {
                val actionKey = QuickLauncherItemCodec.parseActionPayload(item.payload)
                    ?.let(QuickLauncherItemCodec::actionKey) ?: return
                items.filterNot {
                    it.type == QuickLauncherItemType.ACTION &&
                        QuickLauncherItemCodec.parseActionPayload(it.payload)
                            ?.let(QuickLauncherItemCodec::actionKey) == actionKey
                }
            }
            QuickLauncherItemType.WIDGET ->
                items.filterNot { it.type == QuickLauncherItemType.WIDGET && it.payload == item.payload }
        }
    }

    fun toggleItem(item: QuickLauncherItem, added: Boolean) {
        if (added) removeItem(item) else addItem(item)
    }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumFlexibleTopAppBar(
                title = {
                    SettingsAppBarTitle(
                        when (mode) {
                            EditorMode.AddPicker -> stringResource(R.string.quick_launcher_add)
                            else -> stringResource(R.string.quick_launcher_editor_title)
                        },
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        when (mode) {
                            EditorMode.Main -> saveAndBack()
                            EditorMode.AddPicker -> {
                                mode = EditorMode.Main
                                searchQuery = ""
                            }
                        }
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(R.string.cd_navigate_back))
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { padding ->
        when (mode) {
            EditorMode.Main -> QuickLauncherEditorMainSection(
                padding = padding,
                settings = settings,
                items = items,
                appsByPackage = appsByPackage,
                gridInteractionActive = gridInteractionActive,
                onColumnsChange = onColumnsChange,
                onRowsChange = onRowsChange,
                onItemsChange = { items = it },
                onAdd = {
                    searchQuery = ""
                    mode = EditorMode.AddPicker
                },
                onInteractionActiveChange = { gridInteractionActive = it },
            )
            EditorMode.AddPicker -> QuickLauncherEditorAddPicker(
                padding = padding,
                nestedScrollConnection = scrollBehavior.nestedScrollConnection,
                apps = allApps,
                searchQuery = searchQuery,
                onSearchChange = { searchQuery = it },
                configuredAppPackages = configuredAppPackages,
                configuredShortcutKeys = configuredShortcutKeys,
                configuredActionKeys = configuredActionKeys,
                onToggleAction = { action, label, added ->
                    val item = QuickLauncherItem.action(action, label)
                    if (!added) {
                        requestPermissionForAdjustAction(context, action)
                    }
                    toggleItem(item, added)
                },
                onToggleApp = { app, added ->
                    toggleItem(QuickLauncherItem.app(app.packageName, app.label), added)
                },
                onToggleShortcut = { app, shortcut, added ->
                    toggleItem(shortcut.toQuickLauncherItem(app.packageName), added)
                },
                onCreatedShortcut = { created ->
                    addItem(created.toQuickLauncherItem())
                },
            )
        }
    }
}
