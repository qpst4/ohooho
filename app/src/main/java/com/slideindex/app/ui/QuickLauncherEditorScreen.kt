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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.SlideIndexApp
import com.slideindex.app.data.AppInfo
import com.slideindex.app.launcher.QuickLauncherItem
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.util.PinyinHelper

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
    var picking by remember { mutableStateOf(false) }
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
    val configuredPackages = remember(items) { items.map { it.payload }.toSet() }
    val addableApps = remember(allApps, configuredPackages, searchQuery) {
        val query = searchQuery.trim().lowercase()
        allApps.filter { it.packageName !in configuredPackages }
            .filter { app ->
                query.isEmpty() ||
                    app.label.lowercase().contains(query) ||
                    app.packageName.lowercase().contains(query) ||
                    PinyinHelper.sortKey(app.label).contains(query)
            }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.quick_launcher_editor_title)) },
                navigationIcon = {
                    IconButton(onClick = {
                        onSaveItems(items)
                        onBack()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { padding ->
        if (picking) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 20.dp),
            ) {
                SearchBar(query = searchQuery, onQueryChange = { searchQuery = it }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    items(addableApps, key = { it.packageName }) { app ->
                        AppPackageListRow(
                            entry = AppPackageEntry.Installed(app),
                            actionIcon = Icons.Default.Add,
                            actionDescription = stringResource(R.string.quick_launcher_add),
                            missingIcon = Icons.Default.Add,
                            onAction = {
                                items = items + QuickLauncherItem.app(app.packageName, app.label)
                                picking = false
                                searchQuery = ""
                            },
                        )
                    }
                }
            }
        } else {
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
                        items.forEach { item ->
                            val app = appsByPackage[item.payload]
                            AppPackageListRow(
                                entry = app?.let { AppPackageEntry.Installed(it) }
                                    ?: AppPackageEntry.Missing(item.payload),
                                actionIcon = Icons.Default.Close,
                                actionDescription = stringResource(R.string.quick_launcher_remove),
                                missingIcon = Icons.Default.Close,
                                onAction = { items = items.filterNot { it.payload == item.payload } },
                            )
                        }
                    }
                    SettingNavigationRow(
                        icon = { Icon(Icons.Default.Add, contentDescription = null) },
                        title = stringResource(R.string.quick_launcher_add),
                        subtitle = stringResource(R.string.quick_launcher_add_desc),
                        onClick = { picking = true },
                    )
                }
            }
        }
    }
}
