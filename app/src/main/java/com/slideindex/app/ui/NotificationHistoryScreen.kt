package com.slideindex.app.ui

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumFlexibleTopAppBar
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slideindex.app.R
import com.slideindex.app.SlideIndexApp
import com.slideindex.app.data.AppInfo
import com.slideindex.app.notification.ActiveNotificationEntry
import com.slideindex.app.notification.NotificationFilterRule
import com.slideindex.app.notification.NotificationHistoryItem
import com.slideindex.app.notification.NotificationReplayResult
import com.slideindex.app.notification.NotificationRestoreResult
import com.slideindex.app.notification.NotificationHistoryClassification
import com.slideindex.app.notification.NotificationHistoryItemMeta
import com.slideindex.app.notification.NotificationHistoryUiState
import com.slideindex.app.notification.computeNotificationHistoryUiState
import com.slideindex.app.otp.OtpClipboardHelper
import java.text.DateFormat
import java.util.Date
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private enum class NotificationFilterTab {
    ACTIVE,
    HISTORY,
    HIDDEN,
}

private data class NotificationHistoryQuery(
    val items: List<NotificationHistoryItem>,
    val rules: List<NotificationFilterRule>,
    val listenerEnabled: Boolean,
    val searchQuery: String,
    val refreshGeneration: Int,
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class, FlowPreview::class)
@Composable
fun NotificationHistoryScreen(
    listenerEnabled: Boolean,
    onBack: () -> Unit,
    onRequestListenerAccess: () -> Unit,
) {
    val context = LocalContext.current
    val app = remember { context.applicationContext as SlideIndexApp }
    val items by app.notificationHistoryRepository.items.collectAsStateWithLifecycle()
    val filterRules by app.notificationFilterRepository.rules.collectAsStateWithLifecycle()
    var selectedTab by remember { mutableIntStateOf(NotificationFilterTab.ACTIVE.ordinal) }
    var showRulesScreen by remember { mutableStateOf(false) }
    var showSettingsScreen by remember { mutableStateOf(false) }
    var showMoreMenu by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var refreshGeneration by remember { mutableIntStateOf(0) }
    var uiState by remember { mutableStateOf(NotificationHistoryUiState()) }
    var pendingDeleteItem by remember { mutableStateOf<NotificationHistoryItem?>(null) }
    var showClearAllConfirm by remember { mutableStateOf(false) }
    var replayOpenAppDialog by remember { mutableStateOf<NotificationReplayResult.Failure?>(null) }
    val visibleHistoryItems = uiState.classification.visibleItems
    val hiddenItems = uiState.classification.hiddenItems
    val filteredHistoryItems = uiState.filteredHistoryItems
    val filteredHiddenItems = uiState.filteredHiddenItems
    val activeNotifications = uiState.activeNotifications
    val activeKeys = uiState.activeKeys
    val classification = uiState.classification
    val scope = rememberCoroutineScope()
    val dateFormat = remember { DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT) }
    val historyRepository = app.notificationHistoryRepository

    LaunchedEffect(Unit) {
        app.appRepository.loadApps()
    }

    LaunchedEffect(Unit) {
        snapshotFlow {
            NotificationHistoryQuery(
                items = items,
                rules = filterRules,
                listenerEnabled = listenerEnabled,
                searchQuery = searchQuery,
                refreshGeneration = refreshGeneration,
            )
        }
            .debounce(250)
            .collectLatest { query ->
                val next = withContext(Dispatchers.Default) {
                    computeNotificationHistoryUiState(
                        items = query.items,
                        rules = query.rules,
                        listenerEnabled = query.listenerEnabled,
                        searchQuery = query.searchQuery,
                        activeNotificationsProvider = {
                            historyRepository.getActiveNotifications(query.items)
                        },
                        activeKeysProvider = historyRepository::getActiveNotificationKeys,
                    )
                }
                uiState = next
            }
    }

    val onRefreshActive: () -> Unit = { refreshGeneration++ }

    BackHandler {
        when {
            showRulesScreen -> showRulesScreen = false
            showSettingsScreen -> showSettingsScreen = false
            else -> onBack()
        }
    }

    if (showRulesScreen) {
        NotificationRulesScreen(
            rules = filterRules.filter { it.userCreated },
            app = app,
            onBack = { showRulesScreen = false },
            onUpsertRule = { rule -> app.notificationFilterRepository.upsertRule(rule) },
            onRemoveRule = { id -> app.notificationFilterRepository.removeRule(id) },
            onSetRuleEnabled = { id, enabled ->
                app.notificationFilterRepository.setRuleEnabled(id, enabled)
            },
        )
        return
    }

    if (showSettingsScreen) {
        NotificationFilterSettingsScreen(
            app = app,
            listenerEnabled = listenerEnabled,
            onBack = { showSettingsScreen = false },
            onRequestListenerAccess = onRequestListenerAccess,
        )
        return
    }

    val canClearHistory = selectedTab == NotificationFilterTab.HISTORY.ordinal &&
        visibleHistoryItems.isNotEmpty()

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val listModifier = Modifier
        .fillMaxSize()
        .nestedScroll(scrollBehavior.nestedScrollConnection)

    fun performHide(item: NotificationHistoryItem, historyId: String? = item.id.takeIf { it.isNotBlank() }) {
        if (!listenerEnabled) {
            Toast.makeText(context, R.string.notification_hide_listener_required, Toast.LENGTH_SHORT).show()
            onRequestListenerAccess()
            return
        }
        val hiddenFromShade = app.notificationFilterRepository.hideItemFromShade(item)
        historyId?.let { app.notificationHistoryRepository.markHidden(it, true) }
        onRefreshActive()
        val messageRes = when {
            hiddenFromShade -> R.string.notification_hidden_success
            item.notificationKey != null -> R.string.notification_hide_failed
            else -> R.string.notification_hidden_success
        }
        Toast.makeText(context, messageRes, Toast.LENGTH_SHORT).show()
    }

    val onReplayResult: (NotificationReplayResult) -> Unit = { result ->
        when (result) {
            is NotificationReplayResult.Success -> Unit
            is NotificationReplayResult.Failure -> {
                if (result.offerOpenApp && result.packageName != null) {
                    replayOpenAppDialog = result
                } else {
                    showReplayFailureToast(context, result.reason)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumFlexibleTopAppBar(
                title = { SettingsAppBarTitle(stringResource(R.string.notification_history_title)) },
                subtitle = { Text(stringResource(R.string.notification_history_subtitle)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { showRulesScreen = true }) {
                        Icon(
                            Icons.Default.Tune,
                            contentDescription = stringResource(R.string.notification_filter_rules_action),
                        )
                    }
                    Box {
                        IconButton(onClick = { showMoreMenu = true }) {
                            Icon(
                                Icons.Default.MoreVert,
                                contentDescription = stringResource(R.string.notification_filter_more_menu),
                            )
                        }
                        DropdownMenu(
                            expanded = showMoreMenu,
                            onDismissRequest = { showMoreMenu = false },
                        ) {
                            DropdownMenuItem(
                                text = { Text(stringResource(R.string.notification_filter_settings_title)) },
                                onClick = {
                                    showMoreMenu = false
                                    showSettingsScreen = true
                                },
                            )
                        }
                    }
                    if (canClearHistory) {
                        TextButton(onClick = { showClearAllConfirm = true }) {
                            Text(stringResource(R.string.notification_history_clear_all))
                        }
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
        ) {
            if (!listenerEnabled) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                ) {
                    NotificationHistoryPermissionCard(onGrant = onRequestListenerAccess)
                }
            }
            PrimaryTabRow(selectedTabIndex = selectedTab) {
                Tab(
                    selected = selectedTab == NotificationFilterTab.ACTIVE.ordinal,
                    onClick = { selectedTab = NotificationFilterTab.ACTIVE.ordinal },
                    text = { Text(stringResource(R.string.notification_filter_tab_active)) },
                )
                Tab(
                    selected = selectedTab == NotificationFilterTab.HISTORY.ordinal,
                    onClick = { selectedTab = NotificationFilterTab.HISTORY.ordinal },
                    text = { Text(stringResource(R.string.notification_filter_tab_history)) },
                )
                Tab(
                    selected = selectedTab == NotificationFilterTab.HIDDEN.ordinal,
                    onClick = { selectedTab = NotificationFilterTab.HIDDEN.ordinal },
                    text = { Text(stringResource(R.string.notification_filter_history_hidden)) },
                )
            }
            when (NotificationFilterTab.entries[selectedTab]) {
                NotificationFilterTab.ACTIVE -> ActiveNotificationsTab(
                    listModifier = listModifier,
                    listenerEnabled = listenerEnabled,
                    activeNotifications = activeNotifications,
                    itemMeta = { item -> classification.metaFor(item) },
                    dateFormat = dateFormat,
                    app = app,
                    onRefreshActive = onRefreshActive,
                    onRequestListenerAccess = onRequestListenerAccess,
                    onHideItem = ::performHide,
                    scope = scope,
                    onReplayResult = onReplayResult,
                )
                NotificationFilterTab.HISTORY -> HistoryNotificationsTab(
                    listModifier = listModifier,
                    items = visibleHistoryItems,
                    filteredItems = filteredHistoryItems,
                    searchQuery = searchQuery,
                    onSearchQueryChange = { searchQuery = it },
                    activeKeys = activeKeys,
                    itemMeta = { item -> classification.metaFor(item) },
                    dateFormat = dateFormat,
                    app = app,
                    onRefreshActive = onRefreshActive,
                    onHideItem = ::performHide,
                    onDelete = { pendingDeleteItem = it },
                    scope = scope,
                    onReplayResult = onReplayResult,
                )
                NotificationFilterTab.HIDDEN -> HiddenNotificationsTab(
                    listModifier = listModifier,
                    hiddenItems = hiddenItems,
                    filteredItems = filteredHiddenItems,
                    searchQuery = searchQuery,
                    onSearchQueryChange = { searchQuery = it },
                    activeKeys = activeKeys,
                    itemMeta = { item -> classification.metaFor(item) },
                    dateFormat = dateFormat,
                    app = app,
                    onRefreshActive = onRefreshActive,
                    onDelete = { pendingDeleteItem = it },
                    scope = scope,
                    onReplayResult = onReplayResult,
                )
            }
        }
    }

    pendingDeleteItem?.let { item ->
        AlertDialog(
            onDismissRequest = { pendingDeleteItem = null },
            title = { Text(stringResource(R.string.notification_history_delete_confirm_title)) },
            text = { Text(stringResource(R.string.notification_history_delete_confirm_message)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        app.notificationHistoryRepository.delete(item.id)
                        pendingDeleteItem = null
                    },
                ) {
                    Text(stringResource(R.string.confirm))
                }
            },
            dismissButton = {
                TextButton(onClick = { pendingDeleteItem = null }) {
                    Text(stringResource(R.string.cancel))
                }
            },
        )
    }

    if (showClearAllConfirm) {
        AlertDialog(
            onDismissRequest = { showClearAllConfirm = false },
            title = { Text(stringResource(R.string.notification_history_clear_all_confirm_title)) },
            text = { Text(stringResource(R.string.notification_history_clear_all_confirm_message)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        app.notificationHistoryRepository.clearAll()
                        showClearAllConfirm = false
                    },
                ) {
                    Text(stringResource(R.string.confirm))
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearAllConfirm = false }) {
                    Text(stringResource(R.string.cancel))
                }
            },
        )
    }

    replayOpenAppDialog?.let { failure ->
        val packageName = failure.packageName.orEmpty()
        val appLabel = app.appRepository.getCachedAppInfo(packageName)?.label ?: packageName
        AlertDialog(
            onDismissRequest = { replayOpenAppDialog = null },
            title = { Text(stringResource(R.string.notification_history_recycled_title)) },
            text = { Text(stringResource(R.string.notification_history_recycled_message)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        app.notificationHistoryRepository.openTargetApp(packageName)
                        replayOpenAppDialog = null
                    },
                ) {
                    Text(stringResource(R.string.notification_history_open_app, appLabel))
                }
            },
            dismissButton = {
                TextButton(onClick = { replayOpenAppDialog = null }) {
                    Text(stringResource(R.string.cancel))
                }
            },
        )
    }
}

@Composable
private fun rememberResolvableAppInfo(app: SlideIndexApp, packageName: String): AppInfo? {
    var appInfo by remember(packageName) {
        mutableStateOf(app.appRepository.getCachedAppInfo(packageName))
    }
    LaunchedEffect(packageName) {
        if (appInfo == null) {
            appInfo = app.appRepository.resolveAppInfo(packageName)
        }
    }
    return appInfo
}

@Composable
private fun ActiveNotificationsTab(
    listModifier: Modifier,
    listenerEnabled: Boolean,
    activeNotifications: List<ActiveNotificationEntry>,
    itemMeta: (NotificationHistoryItem) -> NotificationHistoryItemMeta,
    dateFormat: DateFormat,
    app: SlideIndexApp,
    onRefreshActive: () -> Unit,
    onRequestListenerAccess: () -> Unit,
    onHideItem: (NotificationHistoryItem, String?) -> Unit,
    scope: kotlinx.coroutines.CoroutineScope,
    onReplayResult: (NotificationReplayResult) -> Unit,
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = listModifier
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (!listenerEnabled) {
            item(key = "active_permission_hint") {
                Text(
                    text = stringResource(R.string.notification_history_permission_desc),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 24.dp),
                )
            }
        } else if (activeNotifications.isEmpty()) {
            item(key = "active_empty") {
                Text(
                    text = stringResource(R.string.notification_filter_active_empty),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 24.dp),
                )
            }
        } else {
            items(activeNotifications, key = { it.key }) { entry ->
                val historyItem = entry.historyItem
                val displayItem = historyItem ?: entry.toHistoryItem()
                val meta = historyItem?.let(itemMeta) ?: itemMeta(displayItem)
                val appInfo = rememberResolvableAppInfo(app, entry.packageName)
                NotificationHistoryRow(
                    item = displayItem,
                    appInfo = appInfo,
                    timeLabel = dateFormat.format(Date(entry.postedAtMs)),
                    isActiveInShade = false,
                    matchingRule = meta.matchingHideRule,
                    showHiddenBadge = meta.isHidden,
                    showRestoreAction = meta.isHidden,
                    showDeleteAction = historyItem != null,
                    onOpen = {
                        scope.launch {
                            when (val result = app.notificationHistoryRepository.replayActive(entry)) {
                                    is NotificationReplayResult.Success -> Unit
                                    is NotificationReplayResult.Failure -> onReplayResult(result)
                                }
                        }
                    },
                    onHide = {
                        onHideItem(displayItem, historyItem?.id)
                    },
                    onUnhide = {
                        scope.launch {
                            val result = app.notificationHistoryRepository.restoreToShade(
                                item = historyItem ?: displayItem,
                                filterRepository = app.notificationFilterRepository,
                            )
                            showRestoreResultToast(context, result)
                            onRefreshActive()
                        }
                    },
                    onDelete = {
                        historyItem?.let { app.notificationHistoryRepository.delete(it.id) }
                    },
                )
            }
        }
    }
}

@Composable
private fun HistoryNotificationsTab(
    listModifier: Modifier,
    items: List<NotificationHistoryItem>,
    filteredItems: List<NotificationHistoryItem>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    activeKeys: Set<String>,
    itemMeta: (NotificationHistoryItem) -> NotificationHistoryItemMeta,
    dateFormat: DateFormat,
    app: SlideIndexApp,
    onRefreshActive: () -> Unit,
    onHideItem: (NotificationHistoryItem, String?) -> Unit,
    onDelete: (NotificationHistoryItem) -> Unit,
    scope: kotlinx.coroutines.CoroutineScope,
    onReplayResult: (NotificationReplayResult) -> Unit,
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = listModifier
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (items.isEmpty()) {
            item(key = "history_empty") {
                Text(
                    text = stringResource(R.string.notification_history_empty),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 24.dp),
                )
            }
        } else {
            item(key = "search") {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = onSearchQueryChange,
                    hintResId = R.string.notification_history_search_hint,
                )
            }
            if (filteredItems.isEmpty()) {
                item(key = "search_empty") {
                    Text(
                        text = stringResource(R.string.notification_history_search_no_results),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 24.dp),
                    )
                }
            } else {
                items(filteredItems, key = { it.id }) { item ->
                    val meta = itemMeta(item)
                    val appInfo = rememberResolvableAppInfo(app, item.packageName)
                    NotificationHistoryRow(
                        item = item,
                        appInfo = appInfo,
                        timeLabel = dateFormat.format(Date(item.postedAtMs)),
                        isActiveInShade = item.notificationKey?.let { it in activeKeys } == true,
                        matchingRule = meta.matchingHideRule,
                        showHiddenBadge = meta.isHidden,
                        showRestoreAction = false,
                        onOpen = {
                            scope.launch {
                                when (val result = app.notificationHistoryRepository.replay(item)) {
                                    is NotificationReplayResult.Success -> Unit
                                    is NotificationReplayResult.Failure -> onReplayResult(result)
                                }
                            }
                        },
                        onHide = { onHideItem(item, item.id) },
                        onUnhide = {},
                        onDelete = { onDelete(item) },
                    )
                }
            }
        }
    }
}

@Composable
private fun HiddenNotificationsTab(
    listModifier: Modifier,
    hiddenItems: List<NotificationHistoryItem>,
    filteredItems: List<NotificationHistoryItem>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    activeKeys: Set<String>,
    itemMeta: (NotificationHistoryItem) -> NotificationHistoryItemMeta,
    dateFormat: DateFormat,
    app: SlideIndexApp,
    onRefreshActive: () -> Unit,
    onDelete: (NotificationHistoryItem) -> Unit,
    scope: kotlinx.coroutines.CoroutineScope,
    onReplayResult: (NotificationReplayResult) -> Unit,
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = listModifier
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        if (hiddenItems.isEmpty()) {
            item(key = "hidden_empty") {
                Text(
                    text = stringResource(R.string.notification_filter_hidden_empty),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 24.dp),
                )
            }
        } else {
            item(key = "hidden_search") {
                SearchBar(
                    query = searchQuery,
                    onQueryChange = onSearchQueryChange,
                    hintResId = R.string.notification_history_search_hint,
                )
            }
            if (filteredItems.isEmpty()) {
                item(key = "hidden_search_empty") {
                    Text(
                        text = stringResource(R.string.notification_history_search_no_results),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 24.dp),
                    )
                }
            } else {
                items(filteredItems, key = { it.id }) { item ->
                    val appInfo = rememberResolvableAppInfo(app, item.packageName)
                    NotificationHistoryRow(
                        item = item,
                        appInfo = appInfo,
                        timeLabel = dateFormat.format(Date(item.postedAtMs)),
                        isActiveInShade = item.notificationKey?.let { it in activeKeys } == true,
                        matchingRule = itemMeta(item).matchingHideRule,
                        showHiddenBadge = true,
                        showRestoreAction = true,
                        onOpen = {
                            scope.launch {
                                when (val result = app.notificationHistoryRepository.replay(item)) {
                                    is NotificationReplayResult.Success -> Unit
                                    is NotificationReplayResult.Failure -> onReplayResult(result)
                                }
                            }
                        },
                        onHide = {},
                        onUnhide = {
                            scope.launch {
                                val result = app.notificationHistoryRepository.restoreToShade(
                                    item = item,
                                    filterRepository = app.notificationFilterRepository,
                                )
                                showRestoreResultToast(context, result)
                                onRefreshActive()
                            }
                        },
                        onDelete = { onDelete(item) },
                    )
                }
            }
        }
    }
}

private fun ActiveNotificationEntry.toHistoryItem(): NotificationHistoryItem {
    return NotificationHistoryItem(
        packageName = packageName,
        title = title,
        text = text,
        postedAtMs = postedAtMs,
        intentUri = null,
        notificationKey = key,
    )
}

@Composable
private fun NotificationHistoryPermissionCard(onGrant: () -> Unit) {
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun NotificationHistoryRow(
    item: NotificationHistoryItem,
    appInfo: AppInfo?,
    timeLabel: String,
    isActiveInShade: Boolean,
    matchingRule: NotificationFilterRule?,
    showHiddenBadge: Boolean = item.hidden,
    showDeleteAction: Boolean = true,
    showRestoreAction: Boolean = false,
    onOpen: () -> Unit,
    onHide: () -> Unit,
    onUnhide: () -> Unit,
    onDelete: () -> Unit,
) {
    val context = LocalContext.current
    var showMenu by remember { mutableStateOf(false) }
    val displayTitle = item.title.ifBlank { appInfo?.label ?: item.packageName }

    Box {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = onOpen,
                    onLongClick = { showMenu = true },
                ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            ),
            shape = MaterialTheme.shapes.large,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                if (appInfo != null) {
                    Md3PickerAppLeading(appInfo)
                } else {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        modifier = Modifier.size(40.dp),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = displayTitle,
                            style = MaterialTheme.typography.titleSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f),
                        )
                        if (showHiddenBadge) {
                            Icon(
                                imageVector = Icons.Default.VisibilityOff,
                                contentDescription = stringResource(R.string.notification_filter_hidden_badge),
                                modifier = Modifier.size(18.dp),
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    }
                    if (item.text.isNotBlank()) {
                        Text(
                            text = item.text,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    if (!item.extractedCode.isNullOrBlank()) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = stringResource(R.string.otp_extracted_code_label, item.extractedCode!!),
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            IconButton(
                                onClick = {
                                    OtpClipboardHelper.copyCode(context, item.extractedCode!!)
                                },
                                modifier = Modifier.size(32.dp),
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ContentCopy,
                                    contentDescription = stringResource(R.string.otp_copy_action),
                                    modifier = Modifier.size(18.dp),
                                )
                            }
                        }
                    }
                    Text(
                        text = buildString {
                            append(appInfo?.label ?: item.packageName)
                            append(" · ")
                            append(timeLabel)
                            if (isActiveInShade) {
                                append(" · ")
                                append(stringResource(R.string.notification_filter_active_in_shade))
                            }
                        },
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                if (showRestoreAction) {
                    TextButton(
                        onClick = onUnhide,
                        modifier = Modifier.align(Alignment.CenterVertically),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                        )
                        Text(
                            text = stringResource(R.string.notification_restore_action),
                            modifier = Modifier.padding(start = 4.dp),
                        )
                    }
                }
            }
        }
        DropdownMenu(
            expanded = showMenu,
            onDismissRequest = { showMenu = false },
        ) {
            DropdownMenuItem(
                text = { Text(stringResource(R.string.notification_history_menu_reopen)) },
                onClick = {
                    showMenu = false
                    onOpen()
                },
            )
            if (!item.hidden && matchingRule == null) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.notification_filter_hide)) },
                    onClick = {
                        showMenu = false
                        onHide()
                    },
                )
            }
            if (item.hidden || matchingRule != null) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.notification_history_menu_restore)) },
                    onClick = {
                        showMenu = false
                        onUnhide()
                    },
                )
            }
            if (showDeleteAction) {
                DropdownMenuItem(
                    text = { Text(stringResource(R.string.notification_history_delete)) },
                    onClick = {
                        showMenu = false
                        onDelete()
                    },
                )
            }
        }
    }
}

private fun showReplayFailureToast(context: android.content.Context, reason: String) {
    Toast.makeText(
        context,
        context.getString(R.string.notification_history_reopen_failed_reason, reason),
        Toast.LENGTH_LONG,
    ).show()
}

private fun showRestoreResultToast(context: android.content.Context, result: NotificationRestoreResult) {
    val messageRes = when (result) {
        NotificationRestoreResult.RESTORED_TO_SHADE -> R.string.notification_restore_success_shade
        NotificationRestoreResult.RULE_REMOVED_ONLY -> R.string.notification_restore_success_rule_only
        NotificationRestoreResult.UNSNOOZE_FAILED -> R.string.notification_restore_unsnooze_failed
    }
    Toast.makeText(context, messageRes, Toast.LENGTH_SHORT).show()
}

@Composable
fun NotificationHistoryEntryCard(
    itemCount: Int,
    listenerEnabled: Boolean,
    onClick: () -> Unit,
) {
    SettingNavigationRow(
        icon = { Icon(Icons.Default.Notifications, contentDescription = null) },
        title = stringResource(R.string.notification_history_entry_title),
        subtitle = when {
            !listenerEnabled -> stringResource(R.string.notification_history_entry_permission_needed)
            itemCount > 0 -> stringResource(R.string.notification_history_entry_summary, itemCount)
            else -> stringResource(R.string.notification_history_entry_desc)
        },
        onClick = onClick,
    )
}
