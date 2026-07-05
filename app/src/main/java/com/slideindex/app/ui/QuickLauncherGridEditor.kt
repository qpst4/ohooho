package com.slideindex.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
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
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
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

private const val PAGE_EDGE_RESISTANCE = 0.35f
private const val PAGE_COMMIT_FRACTION = 0.22f
/** Finger must reach the outer 12% of the first/last column to auto-turn (not the column center). */
private const val PAGE_EDGE_AUTO_PAGE_CELL_FRACTION = 0.12f
private const val PAGE_AUTO_TURN_COOLDOWN_MS = 400L

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
    var dragFromGlobal by remember { mutableIntStateOf(-1) }
    var dragSlotGlobal by remember { mutableIntStateOf(-1) }
    var dragOffsetX by remember { mutableFloatStateOf(0f) }
    var dragOffsetY by remember { mutableFloatStateOf(0f) }
    var dragStartInGrid by remember { mutableStateOf(Offset.Zero) }
    var currentPage by remember { mutableIntStateOf(0) }
    var pageSwipeOffsetPx by remember { mutableFloatStateOf(0f) }
    var lastAutoPageTurnMs by remember { mutableLongStateOf(0L) }
    var dragEdgePageZone by remember { mutableIntStateOf(0) }
    var dragEdgeAutoPageSeeded by remember { mutableStateOf(false) }
    val columns = settings.quickLauncherColumnsPerPage.coerceIn(2, 5)
    val rows = settings.quickLauncherRowsPerPage.coerceIn(2, 6)
    val pageSize = QuickLauncherGridLogic.pageSize(columns, rows)
    val pageCount = QuickLauncherGridLogic.pageCount(items.size, pageSize)
    val density = LocalDensity.current
    val gridGapPx = with(density) { 8.dp.toPx() }
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    val iconBitmapCache = remember(items, appsByPackage) {
        items.mapIndexed { index, item ->
            index to QuickLauncherIconResolver.iconBitmap(item, appsByPackage, context = context)
        }.toMap()
    }

    LaunchedEffect(pageCount, columns, rows) {
        currentPage = currentPage.coerceIn(0, pageCount - 1)
    }

    LaunchedEffect(editMode, dragFromGlobal) {
        onInteractionActiveChange(editMode || dragFromGlobal >= 0)
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
                        val cellWidthPx = ((pageWidthPx - gridGapPx * (columns - 1)) / columns)
                            .coerceAtLeast(1f)
                        val cellHeightPx = cellWidthPx / 0.82f
                        val stepX = cellWidthPx + gridGapPx
                        val stepY = cellHeightPx + gridGapPx
                        val currentPageState = rememberUpdatedState(currentPage)
                        val itemsState = rememberUpdatedState(items)
                        val pageSizeState = rememberUpdatedState(pageSize)

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

                        fun dragEdgeZone(pointerX: Float): Int {
                            val edgeInset = cellWidthPx * PAGE_EDGE_AUTO_PAGE_CELL_FRACTION
                            val lastColStart = (columns - 1).coerceAtLeast(0) * stepX
                            val rightEdgeStart = lastColStart + cellWidthPx - edgeInset
                            return when {
                                pointerX <= edgeInset -> -1
                                pointerX >= rightEdgeStart -> 1
                                else -> 0
                            }
                        }

                        fun resetDragEdgeAutoPage() {
                            dragEdgeAutoPageSeeded = false
                            dragEdgePageZone = 0
                        }

                        fun tryAutoPageTurn(pointerX: Float) {
                            if (pageCount <= 1 || dragFromGlobal < 0) return
                            val zone = dragEdgeZone(pointerX)
                            if (!dragEdgeAutoPageSeeded) {
                                dragEdgeAutoPageSeeded = true
                                dragEdgePageZone = zone
                                return
                            }
                            val prevZone = dragEdgePageZone
                            dragEdgePageZone = zone
                            if (zone == 0 || zone == prevZone) return
                            val now = System.currentTimeMillis()
                            if (now - lastAutoPageTurnMs < PAGE_AUTO_TURN_COOLDOWN_MS) return
                            val page = currentPageState.value
                            val delta = when (zone) {
                                -1 -> if (page > 0) -1 else 0
                                1 -> if (page < pageCount - 1) 1 else 0
                                else -> 0
                            }
                            if (delta == 0) return
                            currentPage = page + delta
                            lastAutoPageTurnMs = now
                            haptic.performHapticFeedback(HapticFeedbackType.SegmentTick)
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .pointerInput(currentPage, pageCount, editMode, dragFromGlobal, pageWidthPx) {
                                    if (editMode || dragFromGlobal >= 0 || pageCount <= 1) return@pointerInput
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
                                QuickLauncherPageGrid(
                                    pageStart = pageStartIndex,
                                    columns = columns,
                                    rows = rows,
                                    pageSize = pageSize,
                                    items = items,
                                    appsByPackage = appsByPackage,
                                    iconBitmapCache = iconBitmapCache,
                                    editMode = editMode,
                                    dragFromGlobal = dragFromGlobal,
                                    dragSlotGlobal = dragSlotGlobal,
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
                                    QuickLauncherPageGrid(
                                        pageStart = (currentPage + 1) * pageSize,
                                        columns = columns,
                                        rows = rows,
                                        pageSize = pageSize,
                                        items = items,
                                        appsByPackage = appsByPackage,
                                        iconBitmapCache = iconBitmapCache,
                                        editMode = false,
                                        dragFromGlobal = -1,
                                        dragSlotGlobal = -1,
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
                                    QuickLauncherPageGrid(
                                        pageStart = (currentPage - 1) * pageSize,
                                        columns = columns,
                                        rows = rows,
                                        pageSize = pageSize,
                                        items = items,
                                        appsByPackage = appsByPackage,
                                        iconBitmapCache = iconBitmapCache,
                                        editMode = false,
                                        dragFromGlobal = -1,
                                        dragSlotGlobal = -1,
                                    )
                                }
                            }

                            if (editMode) {
                                Box(
                                    modifier = Modifier
                                        .matchParentSize()
                                        .zIndex(1f)
                                        .pointerInput(
                                            editMode,
                                            columns,
                                            rows,
                                            pageSize,
                                            pageCount,
                                            cellWidthPx,
                                            cellHeightPx,
                                            gridGapPx,
                                            pageWidthPx,
                                        ) {
                                            detectDragGesturesAfterLongPress(
                                                onDragStart = { start ->
                                                    dragStartInGrid = start
                                                    val page = currentPageState.value
                                                    val pageStart = page * pageSizeState.value
                                                    val localIndex = QuickLauncherGridLogic.localSlotAt(
                                                        x = start.x,
                                                        y = start.y,
                                                        columns = columns,
                                                        rows = rows,
                                                        pageSize = pageSize,
                                                        cellWidthPx = cellWidthPx,
                                                        cellHeightPx = cellHeightPx,
                                                        gapPx = gridGapPx,
                                                    )
                                                    val globalIndex = pageStart + localIndex
                                                    if (globalIndex in itemsState.value.indices) {
                                                        dragFromGlobal = globalIndex
                                                        dragSlotGlobal = globalIndex
                                                        dragOffsetX = 0f
                                                        dragOffsetY = 0f
                                                        lastAutoPageTurnMs = 0L
                                                        resetDragEdgeAutoPage()
                                                        haptic.performHapticFeedback(
                                                            HapticFeedbackType.GestureThresholdActivate,
                                                        )
                                                    }
                                                },
                                                onDrag = { change, dragAmount ->
                                                    if (dragFromGlobal < 0) {
                                                        return@detectDragGesturesAfterLongPress
                                                    }
                                                    change.consume()
                                                    dragOffsetX += dragAmount.x
                                                    dragOffsetY += dragAmount.y
                                                    val pointerX = dragStartInGrid.x + dragOffsetX
                                                    val pointerY = dragStartInGrid.y + dragOffsetY
                                                    tryAutoPageTurn(pointerX)
                                                    val activePageStart =
                                                        currentPageState.value * pageSizeState.value
                                                    val localSlot = QuickLauncherGridLogic.localSlotAt(
                                                        x = pointerX,
                                                        y = pointerY,
                                                        columns = columns,
                                                        rows = rows,
                                                        pageSize = pageSize,
                                                        cellWidthPx = cellWidthPx,
                                                        cellHeightPx = cellHeightPx,
                                                        gapPx = gridGapPx,
                                                    )
                                                    dragSlotGlobal = QuickLauncherGridLogic.dragSlotGlobal(
                                                        pageStart = activePageStart,
                                                        localSlot = localSlot,
                                                        pageSize = pageSize,
                                                    )
                                                },
                                                onDragEnd = {
                                                    if (dragFromGlobal >= 0 && dragSlotGlobal >= 0) {
                                                        val currentItems = itemsState.value
                                                        val insertIndex =
                                                            QuickLauncherGridLogic.dragInsertIndex(
                                                                dragSlotGlobal = dragSlotGlobal,
                                                                itemCount = currentItems.size,
                                                            )
                                                        if (dragFromGlobal != insertIndex) {
                                                            onItemsChange(
                                                                currentItems.moveIndex(
                                                                    dragFromGlobal,
                                                                    insertIndex,
                                                                ),
                                                            )
                                                        }
                                                    }
                                                    dragFromGlobal = -1
                                                    dragSlotGlobal = -1
                                                    dragOffsetX = 0f
                                                    dragOffsetY = 0f
                                                    resetDragEdgeAutoPage()
                                                    haptic.performHapticFeedback(
                                                        HapticFeedbackType.GestureEnd,
                                                    )
                                                },
                                                onDragCancel = {
                                                    dragFromGlobal = -1
                                                    dragSlotGlobal = -1
                                                    dragOffsetX = 0f
                                                    dragOffsetY = 0f
                                                    resetDragEdgeAutoPage()
                                                },
                                            )
                                        },
                                )
                                QuickLauncherDeleteButtonLayer(
                                    columns = columns,
                                    pageSize = pageSize,
                                    pageStartIndex = pageStartIndex,
                                    items = items,
                                    dragFromGlobal = dragFromGlobal,
                                    dragSlotGlobal = dragSlotGlobal,
                                    stepX = stepX,
                                    stepY = stepY,
                                    cellWidthPx = cellWidthPx,
                                    density = density,
                                    zIndex = if (dragFromGlobal >= 0) 0.5f else 3f,
                                    onRemoveAt = { globalIndex ->
                                        onItemsChange(items.filterIndexed { i, _ -> i != globalIndex })
                                    },
                                )
                            }

                            if (editMode && dragFromGlobal >= 0) {
                                val draggedItem = items.getOrNull(dragFromGlobal)
                                if (draggedItem != null) {
                                    val pointerX = dragStartInGrid.x + dragOffsetX
                                    val pointerY = dragStartInGrid.y + dragOffsetY
                                    val onCurrentPage = dragFromGlobal in pageStartIndex until (pageStartIndex + pageSize)
                                    val floaterX = if (onCurrentPage) {
                                        val localFrom = dragFromGlobal - pageStartIndex
                                        val col = localFrom % columns
                                        col * stepX + dragOffsetX
                                    } else {
                                        pointerX - cellWidthPx / 2f
                                    }
                                    val floaterY = if (onCurrentPage) {
                                        val localFrom = dragFromGlobal - pageStartIndex
                                        val row = localFrom / columns
                                        row * stepY + dragOffsetY
                                    } else {
                                        pointerY - cellHeightPx / 2f
                                    }
                                    QuickLauncherGridCell(
                                        modifier = Modifier
                                            .zIndex(2f)
                                            .offset {
                                                IntOffset(
                                                    floaterX.roundToInt(),
                                                    floaterY.roundToInt(),
                                                )
                                            }
                                            .width(with(density) { cellWidthPx.toDp() }),
                                        item = draggedItem,
                                        appsByPackage = appsByPackage,
                                        iconBitmap = iconBitmapCache[dragFromGlobal],
                                        showEditBadge = false,
                                    )
                                }
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
private fun QuickLauncherPageGrid(
    modifier: Modifier = Modifier,
    pageStart: Int,
    columns: Int,
    rows: Int,
    pageSize: Int,
    items: List<QuickLauncherItem>,
    appsByPackage: Map<String, AppInfo>,
    iconBitmapCache: Map<Int, android.graphics.Bitmap?>,
    editMode: Boolean,
    dragFromGlobal: Int,
    dragSlotGlobal: Int,
) {
    val displayMapping = remember(items.size, dragFromGlobal, dragSlotGlobal, pageStart, pageSize) {
        QuickLauncherGridLogic.displayMappingForPage(
            itemCount = items.size,
            dragFrom = dragFromGlobal,
            dragSlotGlobal = dragSlotGlobal,
            pageStart = pageStart,
            pageSize = pageSize,
        )
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = (rows * 88).dp, max = (rows * 96).dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        for (row in 0 until rows) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                for (col in 0 until columns) {
                    val cellIndex = row * columns + col
                    if (cellIndex >= pageSize) continue
                    Box(modifier = Modifier.weight(1f)) {
                        val originalIndex = displayMapping.getOrNull(cellIndex)
                        val item = originalIndex?.let { items.getOrNull(it) }
                        if (item == null) {
                            QuickLauncherEmptyGridCell()
                        } else {
                            QuickLauncherGridCell(
                                item = item,
                                appsByPackage = appsByPackage,
                                iconBitmap = iconBitmapCache[originalIndex],
                                showEditBadge = editMode && dragFromGlobal != originalIndex,
                            )
                        }
                    }
                }
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
    dragFromGlobal: Int,
    dragSlotGlobal: Int,
    stepX: Float,
    stepY: Float,
    cellWidthPx: Float,
    density: Density,
    zIndex: Float = 3f,
    onRemoveAt: (Int) -> Unit,
) {
    val displayMapping = remember(items.size, dragFromGlobal, dragSlotGlobal, pageStartIndex, pageSize) {
        QuickLauncherGridLogic.displayMappingForPage(
            itemCount = items.size,
            dragFrom = dragFromGlobal,
            dragSlotGlobal = dragSlotGlobal,
            pageStart = pageStartIndex,
            pageSize = pageSize,
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(zIndex),
    ) {
        for (localIndex in 0 until pageSize) {
            val originalIndex = displayMapping.getOrNull(localIndex) ?: continue
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
                        .clickable { onRemoveAt(originalIndex) },
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
