package com.slideindex.app.overlay



import android.content.Context

import android.graphics.Canvas

import android.graphics.Color

import android.graphics.Paint

import android.graphics.RectF

import android.graphics.Typeface

import android.view.MotionEvent

import com.slideindex.app.data.AppInfo

import com.slideindex.app.launcher.QuickLauncherDefaults

import com.slideindex.app.launcher.QuickLauncherGridLogic

import com.slideindex.app.launcher.QuickLauncherItem

import com.slideindex.app.launcher.QuickLauncherItemCodec

import com.slideindex.app.launcher.QuickLauncherItemType

import com.slideindex.app.settings.AppSettings



class QuickLauncherPanelController(

    private val host: Host,

) {

    interface Host {

        val context: Context

        fun settings(): AppSettings

        fun side(): PanelSide

        fun apps(): List<AppInfo>

        fun isPanelReady(): Boolean

        fun isAddDialogShowing(): Boolean

        fun dp(value: Float): Float

        fun sp(value: Float): Float

        fun invalidate()

        fun hapticTick()

        fun showAddDialog(

            configuredAppPackages: Set<String>,

            configuredShortcutKeys: Set<String>,

            configuredActionKeys: Set<String>,

            onAdd: (QuickLauncherItem) -> Unit,

            onRemove: (QuickLauncherItem) -> Unit,

        )

        fun onPersist(items: List<QuickLauncherItem>)

        fun quickLauncherPageSize(): Int

        fun onEditDragMove(touchX: Float, localY: Float, panelRect: RectF)

        fun onEditDragBegan()

        fun resolveEditDragTargetGlobal(touchX: Float, localY: Float, panelRect: RectF): Int

    }



    enum class ToolbarAction { ADD, EDIT }



    data class ToolbarLayoutMetrics(

        val toolbarWidth: Float,

        val toolbarPanelGap: Float,

        val edgeInset: Float,

        val buttonSize: Float,

        val buttonGap: Float,

    )



    private val addButtonRect = RectF()

    private val editButtonRect = RectF()

    private val toolbarRect = RectF()

    private val deleteBadgeRects = mutableListOf<RectF>()

    var editMode: Boolean = false
        private set

    var itemPageOffset: Int = 0
        private set

    fun setItemPageOffset(offset: Int) {
        itemPageOffset = offset.coerceAtLeast(0)
    }



    private var localItems: List<QuickLauncherItem> = emptyList()

    private var defaultsPersisted = false

    private var dragFromIndex = -1

    private var dragTargetIndex = -1

    private var dragFromGlobal = -1

    private var dragToGlobal = -1

    private var dragStartX = 0f

    private var dragStartY = 0f

    private var dragCurrentX = 0f

    private var dragCurrentY = 0f

    private var managementTouchActive = false

    private var armedToolbarAction: ToolbarAction? = null



    private val toolbarBgPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val toolbarButtonPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val toolbarIconPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

        color = Color.WHITE

        textAlign = Paint.Align.CENTER

        typeface = Typeface.DEFAULT_BOLD

    }

    private val deleteBadgePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

        color = Color.parseColor("#E53935")

    }

    private val deleteBadgeTextPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

        color = Color.WHITE

        textAlign = Paint.Align.CENTER

        typeface = Typeface.DEFAULT_BOLD

    }



    fun reset() {

        editMode = false

        dragFromIndex = -1

        dragTargetIndex = -1

        dragFromGlobal = -1

        dragToGlobal = -1

        managementTouchActive = false

        armedToolbarAction = null

        deleteBadgeRects.clear()

    }

    fun setEditMode(enabled: Boolean) {
        if (editMode == enabled) return
        editMode = enabled
        if (!enabled) {
            dragFromIndex = -1
            dragTargetIndex = -1
            dragFromGlobal = -1
            dragToGlobal = -1
            deleteBadgeRects.clear()
        }
        host.invalidate()
    }



    fun syncSettings(settings: AppSettings) {
        if (!editMode && dragFromIndex < 0) {
            val configured = configuredItems(settings)
            if (localItems.isEmpty() || configured == localItems) {
                localItems = configured
            }
        }
    }



    fun displayItems(settings: AppSettings): List<QuickLauncherItem> {

        if (localItems.isNotEmpty()) return localItems

        return QuickLauncherDefaults.effectiveItems(configuredItems(settings), host.apps())

    }



    fun ensureDefaultsPersisted(settings: AppSettings) {

        if (defaultsPersisted || configuredItems(settings).isNotEmpty()) return

        val defaults = QuickLauncherDefaults.fromApps(host.apps())

        if (defaults.isEmpty()) return

        defaultsPersisted = true

        localItems = defaults

        host.onPersist(defaults)

    }



    fun shouldShowToolbar(settings: AppSettings): Boolean =

        host.isPanelReady() &&

            displayItems(settings).isNotEmpty() &&

            !host.isAddDialogShowing()



    fun toolbarLayoutMetrics(): ToolbarLayoutMetrics = ToolbarLayoutMetrics(
        toolbarWidth = host.dp(44f),
        toolbarPanelGap = host.dp(10f),
        edgeInset = host.dp(8f),
        buttonSize = host.dp(36f),
        buttonGap = host.dp(6f),
    )



    fun contentReserveWidth(settings: AppSettings): Float {
        if (displayItems(settings).isEmpty()) return 0f
        val metrics = toolbarLayoutMetrics()
        return metrics.toolbarWidth + metrics.toolbarPanelGap + metrics.edgeInset
    }



    fun toolbarBounds(): RectF = RectF(toolbarRect)



    fun toolbarContains(localX: Float, localY: Float): Boolean =

        toolbarRect.contains(localX, localY)



    fun combinedContentRect(panelRect: RectF): RectF {

        layoutToolbar(panelRect)

        if (toolbarRect.isEmpty) return RectF(panelRect)

        return RectF(

            minOf(panelRect.left, toolbarRect.left),

            minOf(panelRect.top, toolbarRect.top),

            maxOf(panelRect.right, toolbarRect.right),

            maxOf(panelRect.bottom, toolbarRect.bottom),

        )

    }



    fun layoutToolbar(panelRect: RectF) {

        if (!shouldShowToolbar(host.settings())) {

            toolbarRect.setEmpty()

            addButtonRect.setEmpty()

            editButtonRect.setEmpty()

            return

        }

        val metrics = toolbarLayoutMetrics()
        val buttonSize = metrics.buttonSize
        val gap = metrics.buttonGap
        val padding = host.dp(6f)
        val toolbarWidth = buttonSize + padding * 2f
        val toolbarHeight = buttonSize * 2f + gap + padding * 2f
        val left = when (host.side()) {
            PanelSide.LEFT -> panelRect.right + metrics.toolbarPanelGap
            PanelSide.RIGHT -> panelRect.left - metrics.toolbarPanelGap - toolbarWidth
        }
        val top = panelRect.bottom - toolbarHeight - host.dp(8f)
        toolbarRect.set(left, top, left + toolbarWidth, top + toolbarHeight)
        val insetX = (toolbarWidth - buttonSize) / 2f
        val buttonsLeft = toolbarRect.left + insetX
        var buttonTop = toolbarRect.top + padding
        addButtonRect.set(
            buttonsLeft,
            buttonTop,
            buttonsLeft + buttonSize,
            buttonTop + buttonSize,
        )
        buttonTop += buttonSize + gap
        editButtonRect.set(
            buttonsLeft,
            buttonTop,
            buttonsLeft + buttonSize,
            buttonTop + buttonSize,
        )

    }



    fun drawToolbar(canvas: Canvas, panelRect: RectF) {

        layoutToolbar(panelRect)

        if (toolbarRect.isEmpty) return

        val theme = OverlayPanelTheme.colors(host.context)

        val corner = host.dp(14f)

        toolbarBgPaint.color = Color.argb(235, 32, 32, 36)
        canvas.drawRoundRect(toolbarRect, corner, corner, toolbarBgPaint)
        canvas.drawRoundRect(
            RectF(
                toolbarRect.left + host.dp(1f),
                toolbarRect.top + host.dp(1f),
                toolbarRect.right - host.dp(1f),
                toolbarRect.bottom - host.dp(1f),
            ),
            corner - host.dp(1f),
            corner - host.dp(1f),
            Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.argb(40, 255, 255, 255) },
        )

        drawToolbarButton(canvas, addButtonRect, ToolbarAction.ADD, theme.accent, active = false)

        drawToolbarButton(

            canvas,

            editButtonRect,

            ToolbarAction.EDIT,

            if (editMode) theme.accent else Color.argb(230, 255, 255, 255),

            active = editMode,

        )

    }



    private fun drawToolbarButton(

        canvas: Canvas,

        rect: RectF,

        action: ToolbarAction,

        color: Int,

        active: Boolean,

    ) {

        val buttonCorner = host.dp(12f)

        toolbarButtonPaint.color = if (active) {
            Color.argb(90, Color.red(color), Color.green(color), Color.blue(color))
        } else {
            Color.argb(80, 255, 255, 255)
        }

        canvas.drawRoundRect(rect, buttonCorner, buttonCorner, toolbarButtonPaint)

        toolbarIconPaint.color = color

        toolbarIconPaint.textSize = if (action == ToolbarAction.ADD) host.sp(22f) else host.sp(18f)

        val glyph = when (action) {

            ToolbarAction.ADD -> "+"

            ToolbarAction.EDIT -> if (editMode) "✓" else "−"

        }

        canvas.drawText(

            glyph,

            rect.centerX(),

            rect.centerY() - (toolbarIconPaint.descent() + toolbarIconPaint.ascent()) / 2f,

            toolbarIconPaint,

        )

    }



    fun layoutDeleteBadges(cells: List<RectF>) {

        deleteBadgeRects.clear()

        if (!editMode) return

        val radius = host.dp(8f)

        cells.forEachIndexed { index, cell ->
            if (index == dragFromIndex && dragFromIndex >= 0) return@forEachIndexed
            deleteBadgeRects += RectF(
                cell.left + host.dp(2f),
                cell.top + host.dp(2f),
                cell.left + host.dp(2f) + radius * 2f,
                cell.top + host.dp(2f) + radius * 2f,
            )
        }

    }



    fun drawDeleteBadges(canvas: Canvas) {

        if (!editMode) return

        deleteBadgeTextPaint.textSize = host.sp(11f)

        deleteBadgeRects.forEach { badge ->

            canvas.drawCircle(badge.centerX(), badge.centerY(), badge.width() / 2f, deleteBadgePaint)

            canvas.drawText(

                "−",

                badge.centerX(),

                badge.centerY() - (deleteBadgeTextPaint.descent() + deleteBadgeTextPaint.ascent()) / 2f,

                deleteBadgeTextPaint,

            )

        }

    }



    fun resolveToolbarAction(localX: Float, localY: Float, panelRect: RectF): ToolbarAction? {
        if (!shouldShowToolbar(host.settings())) return null
        layoutToolbar(panelRect)
        toolbarActionAt(localX, localY)?.let { return it }
        if (!toolbarRect.contains(localX, localY)) return null
        val splitY = (addButtonRect.bottom + editButtonRect.top) / 2f
        return if (localY < splitY) ToolbarAction.ADD else ToolbarAction.EDIT
    }

    /**
     * @param allowSlideRelease When true (continuous pick), commit if [localX]/[localY] hit a toolbar
     *   button on release without requiring a stationary tap or prior DOWN on the toolbar.
     */
    fun commitToolbarAtRelease(
        localX: Float,
        localY: Float,
        panelRect: RectF,
        tapGesture: Boolean,
        toolbarCommitAllowed: Boolean,
        allowSlideRelease: Boolean = false,
    ): Boolean {
        if (!toolbarCommitAllowed || !shouldShowToolbar(host.settings())) return false
        layoutToolbar(panelRect)
        val action = when {
            allowSlideRelease -> resolveToolbarAction(localX, localY, panelRect)
            tapGesture -> armedToolbarAction
            else -> null
        } ?: return false
        when (action) {
            ToolbarAction.ADD -> {
                openAddDialog()
                host.hapticTick()
            }
            ToolbarAction.EDIT -> {
                editMode = !editMode
                if (!editMode) {
                    persistLocalItems()
                }
                host.hapticTick()
            }
        }
        armedToolbarAction = null
        managementTouchActive = false
        host.invalidate()
        return true
    }



    fun handleManagementTouch(

        event: MotionEvent,

        localX: Float,

        localY: Float,

        panelRect: RectF,

        cellBounds: List<Pair<Any, RectF>>,

        tapGesture: Boolean = false,

        toolbarCommitAllowed: Boolean = true,

    ): Boolean {

        val settings = host.settings()

        if (!shouldShowToolbar(settings)) return false

        layoutToolbar(panelRect)

        val quickCells = cellBounds.mapNotNull { (item, rect) ->

            (item as? QuickLauncherItem)?.let { it to rect }

        }

        layoutDeleteBadges(quickCells.map { it.second })



        when (event.actionMasked) {

            MotionEvent.ACTION_DOWN -> {

                val toolbarAction = resolveToolbarAction(localX, localY, panelRect)
                armedToolbarAction = toolbarAction
                managementTouchActive = toolbarRect.contains(localX, localY) ||
                    toolbarAction != null ||
                    (editMode && deleteBadgeRects.any { it.contains(localX, localY) }) ||
                    (editMode && indexAt(localX, localY, quickCells) >= 0)

                if (toolbarAction == ToolbarAction.ADD) {
                    return true
                }
                if (toolbarAction == ToolbarAction.EDIT) {
                    return true
                }

                if (editMode) {

                    val badgeIndex = deleteBadgeIndexAt(localX, localY)

                    if (badgeIndex >= 0) return true

                    val cellIndex = indexAt(localX, localY, quickCells)

                    if (cellIndex >= 0) {

                        dragFromGlobal = itemPageOffset + cellIndex

                        dragToGlobal = dragFromGlobal

                        dragFromIndex = cellIndex

                        dragTargetIndex = cellIndex

                        dragStartX = localX

                        dragStartY = localY

                        dragCurrentX = localX

                        dragCurrentY = localY

                        host.onEditDragBegan()

                        return true

                    }

                }

                return false

            }

            MotionEvent.ACTION_MOVE -> {

                if (dragFromGlobal >= 0) {
                    dragCurrentX = localX
                    dragCurrentY = localY
                    host.onEditDragMove(localX, localY, panelRect)
                    updateEditDragTarget(localX, localY, panelRect, quickCells)
                    host.invalidate()
                    return true
                }

                return managementTouchActive

            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {

                var handled = managementTouchActive

                if (commitToolbarAtRelease(
                        localX = localX,
                        localY = localY,
                        panelRect = panelRect,
                        tapGesture = tapGesture,
                        toolbarCommitAllowed = toolbarCommitAllowed,
                        allowSlideRelease = false,
                    )
                ) {
                    handled = true
                }

                if (editMode) {
                    val badgeIndex = deleteBadgeIndexAt(localX, localY)
                    if (badgeIndex >= 0) {
                        removeItemAt(badgeIndex)
                        handled = true
                    } else if (dragFromGlobal >= 0) {
                        updateEditDragTarget(localX, localY, panelRect, quickCells)
                        val itemCount = workingItems().size
                        val insertIndex = QuickLauncherGridLogic.dragInsertIndex(
                            dragSlotGlobal = dragToGlobal,
                            itemCount = itemCount,
                        )
                        if (insertIndex in 0..itemCount && dragFromGlobal != insertIndex) {
                            moveItemGlobal(dragFromGlobal, insertIndex)
                            handled = true
                        }
                    }
                }
                dragFromIndex = -1
                dragTargetIndex = -1
                dragFromGlobal = -1
                dragToGlobal = -1

                managementTouchActive = false

                if (handled) host.invalidate()

                return handled

            }

        }

        return false

    }



    fun isDragging(): Boolean = dragFromGlobal >= 0

    fun dragSourceIndex(): Int = dragFromIndex

    fun dragDestinationIndex(): Int = dragTargetIndex

    fun dragSourceGlobal(): Int = dragFromGlobal

    fun dragDestinationGlobal(): Int = dragToGlobal

    fun dragSourceOnPage(pageStart: Int, pageSize: Int): Boolean {
        if (dragFromGlobal < 0) return false
        return dragFromGlobal in pageStart until pageStart + pageSize
    }

    fun dragSourceOnCurrentPage(): Boolean {
        val pageSize = host.quickLauncherPageSize().coerceAtLeast(1)
        return dragSourceOnPage(itemPageOffset, pageSize)
    }

    fun dragPointerX(): Float = dragCurrentX

    fun dragPointerY(): Float = dragCurrentY

    fun dragVisualOffsetForPage(pageStart: Int, pageSize: Int): Pair<Float, Float> {
        if (!dragSourceOnPage(pageStart, pageSize)) return 0f to 0f
        return (dragCurrentX - dragStartX) to (dragCurrentY - dragStartY)
    }

    fun dragVisualOffset(index: Int): Pair<Float, Float> {
        if (index != dragFromIndex || dragFromIndex < 0 || !dragSourceOnCurrentPage()) {
            return 0f to 0f
        }
        return (dragCurrentX - dragStartX) to (dragCurrentY - dragStartY)
    }

    fun syncPageLocalDragTarget() {
        val pageSize = host.quickLauncherPageSize().coerceAtLeast(1)
        dragTargetIndex = if (dragToGlobal in itemPageOffset until itemPageOffset + pageSize) {
            dragToGlobal - itemPageOffset
        } else {
            -1
        }
        dragFromIndex = if (dragFromGlobal in itemPageOffset until itemPageOffset + pageSize) {
            dragFromGlobal - itemPageOffset
        } else {
            -1
        }
    }



    private fun toolbarActionAt(localX: Float, localY: Float): ToolbarAction? {
        if (addButtonRect.contains(localX, localY)) return ToolbarAction.ADD
        if (editButtonRect.contains(localX, localY)) return ToolbarAction.EDIT

        val slop = host.dp(10f)
        fun slopRect(rect: RectF) = RectF(
            rect.left - slop,
            rect.top - slop,
            rect.right + slop,
            rect.bottom + slop,
        )
        val addSlop = slopRect(addButtonRect)
        val editSlop = slopRect(editButtonRect)
        val inAddSlop = addSlop.contains(localX, localY)
        val inEditSlop = editSlop.contains(localX, localY)
        return when {
            inAddSlop && !inEditSlop -> ToolbarAction.ADD
            inEditSlop && !inAddSlop -> ToolbarAction.EDIT
            inAddSlop && inEditSlop -> {
                val addDistance = kotlin.math.abs(localY - addButtonRect.centerY())
                val editDistance = kotlin.math.abs(localY - editButtonRect.centerY())
                if (addDistance <= editDistance) ToolbarAction.ADD else ToolbarAction.EDIT
            }
            else -> null
        }
    }



    private fun openAddDialog() {

        if (host.isAddDialogShowing()) return

        val items = workingItems()

        val configuredAppPackages = items

            .filter { it.type == QuickLauncherItemType.APP }

            .map { it.payload }

            .toSet()

        val configuredShortcutKeys = items

            .filter { it.type == QuickLauncherItemType.SHORTCUT }

            .mapNotNull { item ->
                QuickLauncherItemCodec.shortcutItemKey(item)
            }

            .toSet()

        val configuredActionKeys = items

            .filter { it.type == QuickLauncherItemType.ACTION }

            .mapNotNull { QuickLauncherItemCodec.parseActionPayload(it.payload)?.let(QuickLauncherItemCodec::actionKey) }

            .toSet()

        host.showAddDialog(configuredAppPackages, configuredShortcutKeys, configuredActionKeys,
            onAdd = { added ->
                localItems = workingItems() + added
                persistLocalItems()
                host.invalidate()
            },
            onRemove = { removed ->
                val current = workingItems()
                val removeIndex = current.indexOfFirst { item ->
                    item.type == removed.type && item.payload == removed.payload
                }
                if (removeIndex >= 0) {
                    localItems = current.filterIndexed { index, _ -> index != removeIndex }
                    persistLocalItems()
                    host.invalidate()
                }
            },
        )

    }



    private fun workingItems(): List<QuickLauncherItem> {

        if (localItems.isNotEmpty()) return localItems

        return QuickLauncherDefaults.effectiveItems(configuredItems(host.settings()), host.apps())

    }



    private fun removeItemAt(pageLocalIndex: Int) {

        val index = itemPageOffset + pageLocalIndex

        val current = workingItems()

        if (index !in current.indices) return

        localItems = current.filterIndexed { i, _ -> i != index }

        host.hapticTick()

        persistLocalItems()

        host.invalidate()

    }



    private fun moveItemGlobal(from: Int, to: Int) {

        val current = workingItems().toMutableList()

        if (from !in current.indices || to !in 0..current.size) return

        if (from == to) return

        val item = current.removeAt(from)

        current.add(to.coerceIn(0, current.size), item)

        localItems = current

        persistLocalItems()

    }



    private fun updateEditDragTarget(
        localX: Float,
        localY: Float,
        panelRect: RectF,
        quickCells: List<Pair<QuickLauncherItem, RectF>>,
    ) {
        if (dragFromGlobal < 0) return
        val globalTarget = host.resolveEditDragTargetGlobal(localX, localY, panelRect)
        if (globalTarget >= 0) {
            dragToGlobal = globalTarget
            syncPageLocalDragTarget()
            return
        }
        dragTargetIndex = targetIndexForDrag(localX, localY, quickCells)
        if (dragTargetIndex >= 0) {
            dragToGlobal = itemPageOffset + dragTargetIndex
            syncPageLocalDragTarget()
        }
    }



    private fun moveItem(pageLocalFrom: Int, pageLocalTo: Int) {

        moveItemGlobal(itemPageOffset + pageLocalFrom, itemPageOffset + pageLocalTo)

    }



    private fun persistLocalItems() {

        val items = localItems.ifEmpty { return }

        host.onPersist(items)

    }



    private fun configuredItems(settings: AppSettings): List<QuickLauncherItem> =
        settings.quickLauncher



    private fun indexAt(

        localX: Float,

        localY: Float,

        cellBounds: List<Pair<QuickLauncherItem, RectF>>,

    ): Int {

        cellBounds.forEachIndexed { index, (_, rect) ->

            if (rect.contains(localX, localY)) return index

        }

        return -1

    }



    private fun deleteBadgeIndexAt(localX: Float, localY: Float): Int {

        deleteBadgeRects.forEachIndexed { index, rect ->

            if (rect.contains(localX, localY)) return index

        }

        return -1

    }



    private fun targetIndexForDrag(

        localX: Float,

        localY: Float,

        cellBounds: List<Pair<QuickLauncherItem, RectF>>,

    ): Int {

        if (cellBounds.isEmpty()) return dragFromIndex

        cellBounds.forEachIndexed { index, (_, rect) ->

            if (rect.contains(localX, localY)) return index

        }

        var best = dragFromIndex

        var bestDist = Float.MAX_VALUE

        cellBounds.forEachIndexed { index, (_, rect) ->

            val dx = localX - rect.centerX()

            val dy = localY - rect.centerY()

            val dist = dx * dx + dy * dy

            if (dist < bestDist) {

                bestDist = dist

                best = index

            }

        }

        return best

    }

}

