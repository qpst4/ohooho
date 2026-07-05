package com.slideindex.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.slideindex.app.R
import com.slideindex.app.data.AppInfo
import com.slideindex.app.launcher.QuickLauncherGridLogic
import com.slideindex.app.launcher.QuickLauncherGridLogic.moveIndex
import com.slideindex.app.launcher.QuickLauncherItem
import com.slideindex.app.launcher.QuickLauncherItemCodec
import com.slideindex.app.launcher.QuickLauncherItemType
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.util.QuickLauncherIconResolver
import kotlin.math.roundToInt
import kotlinx.coroutines.delay
import sh.calvin.reorderable.ReorderableItem
import sh.calvin.reorderable.rememberReorderableLazyGridState

private const val PAGE_EDGE_RESISTANCE = 0.35f
private const val PAGE_COMMIT_FRACTION = 0.22f
private const val PAGE_EDGE_AUTO_PAGE_FRACTION = 0.18f
private const val PAGE_AUTO_TURN_COOLDOWN_MS = 280L

@Composable
fun QuickLauncherGridEditor(
    settings: AppSettings,
    items: List<QuickLauncherItem>,
    appsByPackage: Map<String, AppInfo>,
    onItemsChange: (List<QuickLauncherItem>) -> Unit,
    onAdd: () -> Unit,
    onInteractionActiveChange: (Boolean) -> Unit = {},
) {
    var editMode by remember { mutableStateOf(false) }
    var currentPage by remember { mutableIntStateOf(0) }
    var pageSwipeOffsetPx by remember { mutableFloatStateOf(0f) }
    val columns = settings.quickLauncherColumnsPerPage.coerceIn(2, 5)
    val rows = settings.quickLauncherRowsPerPage.coerceIn(2, 6)
    val pageSize = QuickLauncherGridLogic.pageSize(columns, rows)
    val pageCount = QuickLauncherGridLogic.pageCount(items.size, pageSize)
    val density = LocalDensity.current
    val context = LocalContext.current
    val iconBitmapCache = remember(items, appsByPackage) {
        items.mapIndexed { index, item ->
            index to QuickLauncherIconResolver.iconBitmap(item, appsByPackage, context = context)
        }.toMap()
    }

    LaunchedEffect(pageCount, columns, rows) {
        currentPage = currentPage.coerceIn(0, pageCount - 1)
    }

    LaunchedEffect(editMode) {
        onInteractionActiveChange(editMode)
    }

    val gridMinHeight = (rows * 96).dp

    SettingsCard {
        Column(modifier = Modifier.fillMaxWidth()) {
            QuickLauncherPageSwitcher(
                currentPage = currentPage,
                pageCount = pageCount,
                onPrevious = {
                    if (currentPage > 0) {
                        currentPage -= 1
                        pageSwipeOffsetPx = 0f
                    }
                },
                onNext = {
                    if (currentPage < pageCount - 1) {
                        currentPage += 1
                        pageSwipeOffsetPx = 0f
                    }
                },
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = gridMinHeight)
                        .clip(RoundedCornerShape(12.dp))
                        .clipToBounds(),
                ) {
                    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                        val pageWidthPx = with(density) { maxWidth.toPx().coerceAtLeast(1f) }
                        val pageStartIndex = currentPage * pageSize
                        val cellWidthPx = with(density) {
                            ((maxWidth - 8.dp * (columns - 1)) / columns).toPx().coerceAtLeast(1f)
                        }
                        val cellHeightPx = cellWidthPx / 0.82f
                        val stepX = cellWidthPx + with(density) { 8.dp.toPx() }
                        val stepY = cellHeightPx + with(density) { 8.dp.toPx() }

                        fun finishPageSwipe() {
                            val threshold = pageWidthPx * PAGE_COMMIT_FRACTION
                            val offset = pageSwipeOffsetPx
                            val delta = when {
                                offset <= -threshold && currentPage < pageCount - 1 -> 1
                                offset >= threshold && currentPage > 0 -> -1
                                else -> 0
                            }
                            if (delta != 0) {
                                currentPage += delta
                            }
                            pageSwipeOffsetPx = 0f
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .pointerInput(currentPage, pageCount, editMode, pageWidthPx) {
                                    if (editMode || pageCount <= 1) return@pointerInput
                                    detectHorizontalDragGestures(
                                        onDragEnd = { finishPageSwipe() },
                                        onDragCancel = { pageSwipeOffsetPx = 0f },
                                        onHorizontalDrag = { change, dragAmount ->
                                            change.consume()
                                            val nextOffset = pageSwipeOffsetPx + dragAmount
                                            pageSwipeOffsetPx = when {
                                                currentPage == 0 && nextOffset > 0f ->
                                                    pageSwipeOffsetPx + dragAmount * PAGE_EDGE_RESISTANCE
                                                currentPage >= pageCount - 1 && nextOffset < 0f ->
                                                    pageSwipeOffsetPx + dragAmount * PAGE_EDGE_RESISTANCE
                                                else -> nextOffset
                                            }.coerceIn(-pageWidthPx, pageWidthPx)
                                        },
                                    )
                                },
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .graphicsLayer { translationX = pageSwipeOffsetPx },
                            ) {
                                QuickLauncherReorderablePageGrid(
                                    pageStart = pageStartIndex,
                                    columns = columns,
                                    rows = rows,
                                    pageSize = pageSize,
                                    currentPage = currentPage,
                                    pageCount = pageCount,
                                    pageWidthPx = pageWidthPx,
                                    items = items,
                                    appsByPackage = appsByPackage,
                                    iconBitmapCache = iconBitmapCache,
                                    editMode = editMode,
                                    onMoveItem = { fromGlobal, insertIndex ->
                                        onItemsChange(items.moveIndex(fromGlobal, insertIndex))
                                    },
                                    onCrossPageTurn = { delta, draggingItemKey ->
                                        val itemKeys = quickLauncherStableItemKeys(items)
                                        val fromGlobal = itemKeys.indexOf(draggingItemKey)
                                        if (fromGlobal < 0) return@QuickLauncherReorderablePageGrid
                                        val newPage = (currentPage + delta).coerceIn(0, pageCount - 1)
                                        if (newPage == currentPage) return@QuickLauncherReorderablePageGrid
                                        val insertIndex = when (delta) {
                                            1 -> (newPage * pageSize).coerceIn(0, items.size)
                                            -1 -> (currentPage * pageSize - 1).coerceIn(0, items.size)
                                            else -> return@QuickLauncherReorderablePageGrid
                                        }
                                        if (fromGlobal != insertIndex) {
                                            onItemsChange(items.moveIndex(fromGlobal, insertIndex))
                                        }
                                        currentPage = newPage
                                    },
                                )
                            }

                            if (pageSwipeOffsetPx < 0f && currentPage < pageCount - 1) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .graphicsLayer {
                                            translationX = pageWidthPx + pageSwipeOffsetPx
                                        },
                                ) {
                                    QuickLauncherReadOnlyPageGrid(
                                        pageStart = (currentPage + 1) * pageSize,
                                        columns = columns,
                                        rows = rows,
                                        pageSize = pageSize,
                                        items = items,
                                        appsByPackage = appsByPackage,
                                        iconBitmapCache = iconBitmapCache,
                                    )
                                }
                            }

                            if (pageSwipeOffsetPx > 0f && currentPage > 0) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .graphicsLayer {
                                            translationX = pageSwipeOffsetPx - pageWidthPx
                                        },
                                ) {
                                    QuickLauncherReadOnlyPageGrid(
                                        pageStart = (currentPage - 1) * pageSize,
                                        columns = columns,
                                        rows = rows,
                                        pageSize = pageSize,
                                        items = items,
                                        appsByPackage = appsByPackage,
                                        iconBitmapCache = iconBitmapCache,
                                    )
                                }
                            }

                            if (editMode) {
                                QuickLauncherDeleteButtonLayer(
                                    columns = columns,
                                    pageSize = pageSize,
                                    pageStartIndex = pageStartIndex,
                                    items = items,
                                    stepX = stepX,
                                    stepY = stepY,
                                    cellWidthPx = cellWidthPx,
                                    density = density,
                                    onRemoveAt = { globalIndex ->
                                        onItemsChange(items.filterIndexed { i, _ -> i != globalIndex })
                                    },
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                QuickLauncherEditorToolbar(
                    editMode = editMode,
                    onAdd = onAdd,
                    onToggleEdit = { editMode = !editMode },
                )
            }
        }
    }
}

@Composable
private fun QuickLauncherReorderablePageGrid(
    pageStart: Int,
    columns: Int,
    rows: Int,
    pageSize: Int,
    currentPage: Int,
    pageCount: Int,
    pageWidthPx: Float,
    items: List<QuickLauncherItem>,
    appsByPackage: Map<String, AppInfo>,
    iconBitmapCache: Map<Int, android.graphics.Bitmap?>,
    editMode: Boolean,
    onMoveItem: (fromGlobal: Int, insertIndex: Int) -> Unit,
    onCrossPageTurn: (delta: Int, draggingItemKey: Any) -> Unit,
) {
    val lazyGridState = rememberLazyGridState()
    val haptic = LocalHapticFeedback.current
    val itemKeys = remember(items) { quickLauncherStableItemKeys(items) }
    val reorderableState = rememberReorderableLazyGridState(lazyGridState) { from, to ->
        if (!editMode || from.index == to.index) return@rememberReorderableLazyGridState
        val globalFrom = pageStart + from.index
        val globalToSlot = pageStart + to.index
        val insertIndex = QuickLauncherGridLogic.dragInsertIndex(globalToSlot, items.size)
        if (globalFrom in items.indices && globalFrom != insertIndex) {
            onMoveItem(globalFrom, insertIndex)
        }
    }
    var activeDragKey by remember { mutableStateOf<Any?>(null) }
    var dragPointerX by remember { mutableFloatStateOf(Float.NaN) }
    val currentDragKey = rememberUpdatedState(activeDragKey)

    LaunchedEffect(
        editMode,
        pageWidthPx,
        pageCount,
        currentPage,
        activeDragKey,
        dragPointerX,
    ) {
        if (!editMode || pageCount <= 1 || pageWidthPx <= 0f) return@LaunchedEffect
        var edgeSeeded = false
        var lastEdgeZone = 0
        var turnLocked = false

        snapshotFlow {
            activeDragKey to dragPointerX
        }.collect { (draggingKey, pointerX) ->
            if (draggingKey == null || pointerX.isNaN()) {
                edgeSeeded = false
                lastEdgeZone = 0
                return@collect
            }
            if (turnLocked) return@collect

            val edge = pageWidthPx * PAGE_EDGE_AUTO_PAGE_FRACTION
            val zone = when {
                pointerX >= pageWidthPx - edge && currentPage < pageCount - 1 -> 1
                pointerX <= edge && currentPage > 0 -> -1
                else -> 0
            }
            if (!edgeSeeded) {
                edgeSeeded = true
                lastEdgeZone = zone
                return@collect
            }
            if (zone == 0 || zone == lastEdgeZone) return@collect

            lastEdgeZone = zone
            turnLocked = true
            onCrossPageTurn(zone, draggingKey)
            haptic.performHapticFeedback(HapticFeedbackType.SegmentTick)
            delay(PAGE_AUTO_TURN_COOLDOWN_MS)
            turnLocked = false
            edgeSeeded = false
            lastEdgeZone = 0
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(editMode, pageCount) {
                if (!editMode || pageCount <= 1) return@pointerInput
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent(PointerEventPass.Initial)
                        if (currentDragKey.value != null) {
                            val x = event.changes.firstOrNull { it.pressed }?.position?.x
                            if (x != null) {
                                dragPointerX = x
                            }
                            if (event.changes.none { it.pressed }) {
                                activeDragKey = null
                                dragPointerX = Float.NaN
                            }
                        }
                    }
                }
            },
    ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        state = lazyGridState,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = (rows * 88).dp, max = (rows * 96).dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = false,
    ) {
        items(
            count = pageSize,
            key = { localIndex ->
                val globalIndex = pageStart + localIndex
                if (globalIndex < items.size) itemKeys[globalIndex] else "empty-$localIndex"
            },
        ) { localIndex ->
            val globalIndex = pageStart + localIndex
            if (globalIndex < items.size) {
                val item = items[globalIndex]
                ReorderableItem(
                    state = reorderableState,
                    key = itemKeys[globalIndex],
                    enabled = editMode,
                ) { isDragging ->
                    val itemKey = itemKeys[globalIndex]
                    QuickLauncherGridCell(
                        modifier = if (editMode) {
                            Modifier.longPressDraggableHandle(
                                onDragStarted = {
                                    activeDragKey = itemKey
                                    haptic.performHapticFeedback(HapticFeedbackType.GestureThresholdActivate)
                                },
                                onDragStopped = {
                                    activeDragKey = null
                                    dragPointerX = Float.NaN
                                    haptic.performHapticFeedback(HapticFeedbackType.GestureEnd)
                                },
                            )
                        } else {
                            Modifier
                        },
                        item = item,
                        appsByPackage = appsByPackage,
                        iconBitmap = iconBitmapCache[globalIndex],
                        showEditBadge = editMode && !isDragging,
                    )
                }
            } else {
                QuickLauncherEmptyGridCell()
            }
        }
    }
    }
}

@Composable
private fun QuickLauncherReadOnlyPageGrid(
    pageStart: Int,
    columns: Int,
    rows: Int,
    pageSize: Int,
    items: List<QuickLauncherItem>,
    appsByPackage: Map<String, AppInfo>,
    iconBitmapCache: Map<Int, android.graphics.Bitmap?>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = (rows * 88).dp, max = (rows * 96).dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        userScrollEnabled = false,
    ) {
        items(
            count = pageSize,
            key = { localIndex -> "preview-${pageStart + localIndex}" },
        ) { localIndex ->
            val globalIndex = pageStart + localIndex
            val item = items.getOrNull(globalIndex)
            if (item == null) {
                QuickLauncherEmptyGridCell()
            } else {
                QuickLauncherGridCell(
                    item = item,
                    appsByPackage = appsByPackage,
                    iconBitmap = iconBitmapCache[globalIndex],
                    showEditBadge = false,
                )
            }
        }
    }
}

@Composable
private fun QuickLauncherDeleteButtonLayer(
    columns: Int,
    pageSize: Int,
    pageStartIndex: Int,
    items: List<QuickLauncherItem>,
    stepX: Float,
    stepY: Float,
    cellWidthPx: Float,
    density: Density,
    onRemoveAt: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(3f),
    ) {
        for (localIndex in 0 until pageSize) {
            val globalIndex = pageStartIndex + localIndex
            if (globalIndex !in items.indices) continue
            val col = localIndex % columns
            val row = localIndex / columns
            Box(
                modifier = Modifier
                    .offset {
                        IntOffset(
                            (col * stepX).roundToInt(),
                            (row * stepY).roundToInt(),
                        )
                    }
                    .width(with(density) { cellWidthPx.toDp() })
                    .aspectRatio(0.82f),
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(2.dp)
                        .size(22.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE53935))
                        .clickable { onRemoveAt(globalIndex) },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "−",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            }
        }
    }
}

@Composable
private fun QuickLauncherPageSwitcher(
    currentPage: Int,
    pageCount: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onPrevious,
            enabled = currentPage > 0,
        ) {
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = stringResource(R.string.quick_launcher_page_previous),
            )
        }
        Text(
            text = stringResource(
                R.string.quick_launcher_page_indicator,
                currentPage + 1,
                pageCount,
            ),
            style = MaterialTheme.typography.titleSmall,
        )
        IconButton(
            onClick = onNext,
            enabled = currentPage < pageCount - 1,
        ) {
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(R.string.quick_launcher_page_next),
            )
        }
    }
}

@Composable
private fun QuickLauncherEmptyGridCell() {
    Box(
        modifier = Modifier
            .aspectRatio(0.82f)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)),
    )
}

@Composable
private fun QuickLauncherEditorToolbar(
    editMode: Boolean,
    onAdd: () -> Unit,
    onToggleEdit: () -> Unit,
) {
    Column(
        modifier = Modifier
            .width(52.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.65f))
            .padding(vertical = 6.dp, horizontal = 4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        QuickLauncherToolbarButton(onClick = onAdd) {
            Icon(Icons.Default.Add, contentDescription = stringResource(R.string.quick_launcher_add))
        }
        QuickLauncherToolbarButton(onClick = onToggleEdit, selected = editMode) {
            Text(
                text = if (editMode) "✓" else "−",
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@Composable
private fun QuickLauncherToolbarButton(
    onClick: () -> Unit,
    selected: Boolean = false,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (selected) {
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.22f)
                } else {
                    MaterialTheme.colorScheme.surface.copy(alpha = 0.35f)
                },
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
private fun QuickLauncherGridCell(
    modifier: Modifier = Modifier,
    item: QuickLauncherItem,
    appsByPackage: Map<String, AppInfo>,
    iconBitmap: android.graphics.Bitmap? = null,
    showEditBadge: Boolean = false,
) {
    val label = quickLauncherGridLabel(item, appsByPackage)
    val context = LocalContext.current
    val action = remember(item.payload, item.type) {
        if (item.type == QuickLauncherItemType.ACTION) {
            QuickLauncherItemCodec.parseActionPayload(item.payload)
        } else {
            null
        }
    }
    val resolvedIconBitmap = iconBitmap ?: remember(item.type, item.payload) {
        QuickLauncherIconResolver.iconBitmap(item, appsByPackage, context = context)
    }
    Box(
        modifier = modifier
            .aspectRatio(0.82f)
            .clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 4.dp, end = 4.dp, bottom = 4.dp),
        ) {
            if (resolvedIconBitmap != null) {
                Image(
                    bitmap = resolvedIconBitmap.asImageBitmap(),
                    contentDescription = label,
                    modifier = Modifier.size(40.dp),
                )
            } else if (action != null) {
                Icon(
                    imageVector = gestureActionIcon(action),
                    contentDescription = label,
                    modifier = Modifier.size(40.dp),
                    tint = MaterialTheme.colorScheme.primary,
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        if (showEditBadge) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(2.dp)
                    .size(18.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE53935)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "−",
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }
    }
}

private fun quickLauncherStableItemKeys(items: List<QuickLauncherItem>): List<String> {
    val counts = mutableMapOf<String, Int>()
    return items.map { item ->
        val base = "${item.type.id}:${item.payload}"
        val occurrence = counts.getOrDefault(base, 0)
        counts[base] = occurrence + 1
        "$base#$occurrence"
    }
}

private fun quickLauncherGridLabel(item: QuickLauncherItem, appsByPackage: Map<String, AppInfo>): String =
    when (item.type) {
        QuickLauncherItemType.APP ->
            appsByPackage[item.payload]?.label ?: item.label.ifBlank { item.payload }
        QuickLauncherItemType.SHORTCUT ->
            item.label.ifBlank { "快捷方式" }
        QuickLauncherItemType.ACTION ->
            item.label.ifBlank { "动作" }
        QuickLauncherItemType.WIDGET ->
            item.label.ifBlank { "小组件" }
    }
