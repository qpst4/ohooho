package com.slideindex.app.overlay

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import android.graphics.RectF
import android.graphics.Typeface
import android.view.MotionEvent
import android.view.View
import com.slideindex.app.data.AppInfo
import com.slideindex.app.settings.AppSettings
import kotlin.math.ceil

/**
 * 手势触发后才显示字母索引；单指连续滑选字母、点应用、松手启动。
 */
class ContinuousIndexOverlayView(
    context: Context,
    private val side: PanelSide,
    private val onLaunchApp: (AppInfo) -> Unit,
    private val onSessionStart: () -> Unit,
    private val onSessionEnd: () -> Unit,
) : View(context) {

    private var settings = AppSettings()

    private var apps: List<AppInfo> = emptyList()
    private val railLetters: List<Char> = ('A'..'Z').toList() + '#'
    private var filteredApps: List<AppInfo> = emptyList()

    private var sessionActive = false
    private var previewMode = false
    private var selectedLetter: Char? = null
    private var highlightedApp: AppInfo? = null

    private val iconCache = mutableMapOf<String, Bitmap>()
    private val gridCellBounds = mutableListOf<Pair<AppInfo, RectF>>()

    private val railBgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val panelBgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bubblePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val letterCirclePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val letterPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT
    }
    private val bubbleLetterPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT_BOLD
        color = Color.WHITE
    }
    private val appLabelPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        textSize = sp(11f)
        color = Color.argb(230, 255, 255, 255)
    }
    private val cellHighlightPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val triggerPreviewFillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val triggerPreviewStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
    }

    private val tmpRect = RectF()

    private val cellHeight get() = dp(72f)
    private val cellWidth get() = dp(68f)
    private val gridIconSize get() = dp(44f)
    private val gridPadding get() = dp(10f)
    private val gridIconTopInset get() = dp(6f)
    private val gridIconLabelGap get() = dp(3f)
    private val gridCellInset get() = dp(4f)
    private val bubbleRadius get() = dp(24f)
    private val bubblePanelGap get() = dp(10f)
    private val railCorner get() = dp(14f)
    private val panelCorner get() = dp(18f)
    private val railVisualWidth get() = dp(22f)

    private data class GridLayoutInfo(
        val appsPerRow: Int,
        val panelColumns: Int,
        val rows: Int,
        val panelWidth: Float,
    )

    private fun appsPerRow(): Int = settings.appsPerRow.coerceIn(2, 5)

    private fun gridLayoutInfo(appCount: Int): GridLayoutInfo {
        val m = appsPerRow()
        val panelColumns = if (appCount in 1 until m) appCount else m
        val rows = if (appCount == 0) 1 else ceil(appCount / m.toFloat()).toInt()
        val panelWidth = panelColumns * cellWidth + gridPadding * 2
        return GridLayoutInfo(m, panelColumns, rows, panelWidth)
    }

    private fun visualColumn(index: Int, m: Int, appCount: Int): Int {
        val colInRow = index % m
        val row = index / m
        val appsInRow = minOf(m, appCount - row * m)
        return when (side) {
            PanelSide.RIGHT -> when {
                appCount < m -> appCount - 1 - colInRow
                appsInRow == m -> m - 1 - colInRow
                else -> m - appsInRow + colInRow
            }
            PanelSide.LEFT -> colInRow
        }
    }

    fun applySettings(newSettings: AppSettings, screenWidth: Int) {
        settings = newSettings
        cellHighlightPaint.color = Color.argb(70, 255, 255, 255)
        invalidate()
    }

    fun isSessionActive(): Boolean = sessionActive

    fun isPreviewMode(): Boolean = previewMode

    fun setPreviewMode(enabled: Boolean) {
        if (previewMode == enabled) return
        previewMode = enabled
        invalidate()
    }

    fun setApps(newApps: List<AppInfo>) {
        apps = newApps
        iconCache.clear()
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                if (sessionActive) return true
                if (!isInTriggerZone(event.rawX, event.rawY)) return false
                if (previewMode) {
                    previewMode = false
                }
                sessionActive = true
                onSessionStart()
                post { handleTouch(event.rawX, event.rawY, end = false) }
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                if (!sessionActive) return false
                handleTouch(event.rawX, event.rawY, end = false)
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                if (!sessionActive) return false
                handleTouch(event.rawX, event.rawY, end = true)
                return true
            }
        }
        return false
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (previewMode) {
            drawTriggerZonePreview(canvas)
            drawLetterRail(canvas)
            return
        }
        if (!sessionActive) return
        drawLetterRail(canvas)
        selectedLetter?.let {
            drawAppGrid(canvas)
            drawLetterBubble(canvas)
        }
    }

    private fun handleTouch(rawX: Float, rawY: Float, end: Boolean) {
        val (localX, localY) = rawToLocal(rawX, rawY)
        if (!end) {
            updateSelection(localX, localY)
            invalidate()
        } else {
            highlightedApp?.let(onLaunchApp)
            endSession()
        }
    }

    private fun rawToLocal(rawX: Float, rawY: Float): Pair<Float, Float> {
        val loc = IntArray(2)
        getLocationOnScreen(loc)
        return rawX - loc[0] to rawY - loc[1]
    }

    private fun isInTriggerZone(rawX: Float, rawY: Float): Boolean {
        val (localX, localY) = rawToLocal(rawX, rawY)
        return triggerZoneRect().contains(localX, localY)
    }

    private fun triggerZoneRect(): RectF {
        if (!sessionActive && !previewMode) {
            return RectF(0f, 0f, width.toFloat(), height.toFloat())
        }
        val top = height * settings.triggerTopFraction
        val zoneHeight = height * settings.triggerHeightFraction
        val w = edgeWidthPx().toFloat()
        return when (side) {
            PanelSide.LEFT -> RectF(0f, top, w, top + zoneHeight)
            PanelSide.RIGHT -> RectF(width - w, top, width.toFloat(), top + zoneHeight)
        }
    }

    private fun indexRailRect(): RectF {
        val w = railVisualWidth.coerceAtMost(edgeWidthPx().toFloat())
        val indexH = height * settings.indexHeightFraction
        val trigger = triggerZoneRect()
        var top = trigger.centerY() - indexH / 2f
        top = top.coerceIn(dp(8f), height - indexH - dp(8f))
        return when (side) {
            PanelSide.LEFT -> RectF(0f, top, w, top + indexH)
            PanelSide.RIGHT -> RectF(width - w, top, width.toFloat(), top + indexH)
        }
    }

    private fun edgeWidthPx(): Int {
        return (settings.edgeTriggerWidthDp * resources.displayMetrics.density)
            .toInt()
            .coerceAtLeast(dp(16f).toInt())
    }

    private fun drawTriggerZonePreview(canvas: Canvas) {
        val zone = triggerZoneRect()
        triggerPreviewFillPaint.color = Color.argb(72, 255, 152, 0)
        canvas.drawRoundRect(zone, dp(6f), dp(6f), triggerPreviewFillPaint)
        triggerPreviewStrokePaint.color = Color.argb(210, 255, 167, 38)
        triggerPreviewStrokePaint.strokeWidth = dp(2f)
        canvas.drawRoundRect(zone, dp(6f), dp(6f), triggerPreviewStrokePaint)
    }

    private fun drawLetterRail(canvas: Canvas) {
        val rail = indexRailRect()
        val alphaScale = settings.panelOpacity.coerceIn(0.6f, 1f)
        railBgPaint.color = Color.argb((200 * alphaScale).toInt(), 38, 38, 42)
        canvas.drawRoundRect(rail, railCorner, railCorner, railBgPaint)

        val slotHeight = rail.height() / railLetters.size
        val letterSize = slotHeight.coerceAtMost(dp(11.5f))

        railLetters.forEachIndexed { index, letter ->
            val centerY = rail.top + slotHeight * index + slotHeight * 0.65f
            val centerX = rail.centerX()
            val selected = letter == selectedLetter
            if (selected) {
                letterCirclePaint.color = Color.argb(90, 255, 255, 255)
                canvas.drawCircle(centerX, centerY - letterSize * 0.15f, letterSize * 0.85f, letterCirclePaint)
                letterPaint.color = Color.WHITE
                letterPaint.textSize = letterSize * 1.05f
                letterPaint.typeface = Typeface.DEFAULT_BOLD
            } else {
                letterPaint.color = Color.argb(200, 220, 220, 220)
                letterPaint.textSize = letterSize
                letterPaint.typeface = Typeface.DEFAULT
            }
            canvas.drawText(letter.toString(), centerX, centerY, letterPaint)
        }
    }

    private fun drawLetterBubble(canvas: Canvas) {
        val letter = selectedLetter ?: return
        val center = bubbleCenter()
        bubblePaint.color = Color.argb((240 * settings.panelOpacity).toInt().coerceIn(150, 240), 52, 52, 56)
        canvas.drawCircle(center.x, center.y, bubbleRadius, bubblePaint)
        bubbleLetterPaint.textSize = sp(22f)
        canvas.drawText(
            letter.toString(),
            center.x,
            center.y + sp(22f) * 0.35f,
            bubbleLetterPaint,
        )
    }

    private fun drawAppGrid(canvas: Canvas) {
        if (filteredApps.isEmpty()) return
        val appCount = filteredApps.size
        val layout = gridLayoutInfo(appCount)
        val m = layout.appsPerRow
        val grid = gridPopupRect()
        panelBgPaint.color = Color.argb((215 * settings.panelOpacity).toInt().coerceIn(140, 215), 48, 48, 52)
        canvas.drawRoundRect(grid, panelCorner, panelCorner, panelBgPaint)

        gridCellBounds.clear()
        filteredApps.forEachIndexed { index, app ->
            val row = index / m
            val visualCol = visualColumn(index, m, appCount)
            val left = grid.left + gridPadding + visualCol * cellWidth
            val top = grid.top + gridPadding + row * cellHeight
            val cell = RectF(left, top, left + cellWidth, top + cellHeight)
            gridCellBounds += app to cell

            if (app == highlightedApp) {
                tmpRect.set(cell.left + dp(3f), cell.top + dp(2f), cell.right - dp(3f), cell.bottom - dp(2f))
                canvas.drawRoundRect(tmpRect, dp(10f), dp(10f), cellHighlightPaint)
            }

            val icon = iconFor(app)
            val iconTop = cell.top + gridIconTopInset
            val label = ellipsize(app.label, cellWidth - gridCellInset * 2)
            val labelBaseline = iconTop + gridIconSize + gridIconLabelGap - appLabelPaint.fontMetrics.ascent
            val iconCenterX = cell.centerX()
            canvas.drawBitmap(icon, iconCenterX - gridIconSize / 2f, iconTop, null)
            appLabelPaint.textAlign = Paint.Align.CENTER
            canvas.drawText(label, iconCenterX, labelBaseline, appLabelPaint)
        }
        appLabelPaint.textAlign = Paint.Align.CENTER
    }

    private fun updateSelection(localX: Float, localY: Float) {
        if (isInRailZone(localX)) {
            letterAtY(localY)?.let { letter ->
                if (selectedLetter != letter) {
                    selectedLetter = letter
                    filteredApps = apps.filter { it.letter == letter }
                    highlightedApp = null
                }
            }
        } else {
            highlightedApp = appAtGrid(localX, localY)
        }
    }

    private fun isInRailZone(localX: Float): Boolean {
        val rail = indexRailRect()
        return when (side) {
            PanelSide.LEFT -> localX <= rail.right + dp(10f)
            PanelSide.RIGHT -> localX >= rail.left - dp(10f)
        }
    }

    private fun endSession() {
        sessionActive = false
        selectedLetter = null
        highlightedApp = null
        filteredApps = emptyList()
        gridCellBounds.clear()
        onSessionEnd()
        invalidate()
    }

    private fun letterAtY(localY: Float): Char? {
        val rail = indexRailRect()
        val y = (localY - rail.top).coerceIn(0f, rail.height())
        val index = ((y / rail.height()) * railLetters.size)
            .toInt()
            .coerceIn(0, railLetters.lastIndex)
        return railLetters[index]
    }

    private fun selectedLetterCenterY(): Float? {
        val letter = selectedLetter ?: return null
        val rail = indexRailRect()
        val index = railLetters.indexOf(letter)
        if (index < 0) return null
        val slotHeight = rail.height() / railLetters.size
        return rail.top + slotHeight * index + slotHeight * 0.65f
    }

    private fun anchorColumnIndex(layout: GridLayoutInfo): Int {
        return when (side) {
            PanelSide.LEFT -> 0
            PanelSide.RIGHT -> layout.panelColumns - 1
        }
    }

    private fun columnCenterX(grid: RectF, columnIndex: Int): Float {
        return grid.left + gridPadding + columnIndex * cellWidth + cellWidth / 2f
    }

    private fun bubbleCenter(): PointF {
        if (filteredApps.isNotEmpty()) {
            val grid = gridPopupRect()
            val layout = gridLayoutInfo(filteredApps.size)
            val cx = columnCenterX(grid, anchorColumnIndex(layout))
            val cy = grid.top - bubbleRadius - bubblePanelGap
            return PointF(cx, cy)
        }
        val rail = indexRailRect()
        val cy = selectedLetterCenterY() ?: rail.centerY()
        val cx = when (side) {
            PanelSide.LEFT -> rail.right + bubbleRadius + dp(4f)
            PanelSide.RIGHT -> rail.left - bubbleRadius - dp(4f)
        }
        return PointF(cx, cy)
    }

    private fun gridPopupRect(): RectF {
        val layout = gridLayoutInfo(filteredApps.size)
        val gh = layout.rows * cellHeight + gridPadding * 2
        val gw = layout.panelWidth
        val rail = indexRailRect()
        val letterY = selectedLetterCenterY() ?: rail.centerY()
        val bubbleReserve = bubbleRadius * 2 + bubblePanelGap + dp(8f)
        var top = letterY - gh / 2f
        top = top.coerceIn(bubbleReserve + dp(8f), height - gh - dp(16f))
        val gap = dp(8f)
        val left = when (side) {
            PanelSide.LEFT -> rail.right + gap
            PanelSide.RIGHT -> rail.left - gap - gw
        }
        return RectF(left, top, left + gw, top + gh)
    }

    private fun appAtGrid(localX: Float, localY: Float): AppInfo? {
        gridCellBounds.forEach { (app, rect) ->
            if (rect.contains(localX, localY)) return app
        }
        return null
    }

    private fun ellipsize(text: String, maxWidth: Float): String {
        if (appLabelPaint.measureText(text) <= maxWidth) return text
        var end = text.length
        while (end > 1 && appLabelPaint.measureText(text.substring(0, end) + "…") > maxWidth) end--
        return text.substring(0, end.coerceAtLeast(1)) + "…"
    }

    private fun iconFor(app: AppInfo): Bitmap {
        return iconCache.getOrPut(app.packageName) {
            val size = gridIconSize.toInt().coerceAtLeast(1)
            val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            app.icon.setBounds(0, 0, size, size)
            app.icon.draw(canvas)
            bitmap
        }
    }

    private fun dp(value: Float): Float = value * resources.displayMetrics.density
    private fun sp(value: Float): Float = value * resources.displayMetrics.scaledDensity
}
