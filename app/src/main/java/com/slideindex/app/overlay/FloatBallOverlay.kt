package com.slideindex.app.overlay

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.PixelFormat
import android.graphics.Rect
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.slideindex.app.di.OverlayDependencyAccess
import com.slideindex.app.service.SlideIndexAccessibilityService
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.FloatBallPositionMode
import com.slideindex.app.settings.FloatBallSide
import com.slideindex.app.ui.theme.SlideIndexTheme
import com.slideindex.app.util.PermissionHelper
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

private const val CROSS_ARM_DP = 14f
private const val CROSS_STROKE_DP = 2.5f

/**
 * Persistent float ball: ball acts as joystick, crosshair/plus acts as screen pointer.
 * Independent from [FloatingPointerOverlayWindow] (edge-gesture virtual pointer).
 */
object FloatBallOverlay {
    private const val TAG = "FloatBallOverlay"
    private const val EDGE_MARGIN_DP = 8f
    private const val PAUSE_MS = 400L
    private const val RECT_MIN_SIDE_DP = 48f

    private val mainHandler = Handler(Looper.getMainLooper())

    private var windowManager: WindowManager? = null
    private var ballView: ComposeView? = null
    private var edgeCaptureView: ComposeView? = null
    private var lineView: ComposeView? = null
    private var cursorView: ComposeView? = null
    private var ballOwner: OverlayComposeOwner? = null
    private var edgeCaptureOwner: OverlayComposeOwner? = null
    private var lineOwner: OverlayComposeOwner? = null
    private var cursorOwner: OverlayComposeOwner? = null
    private var ballParams: WindowManager.LayoutParams? = null
    private var edgeCaptureParams: WindowManager.LayoutParams? = null
    private var lineParams: WindowManager.LayoutParams? = null
    private var appContext: Context? = null
    private var screenOffReceiver: BroadcastReceiver? = null

    private var settingsState: MutableState<AppSettings>? = null
    private var cursorVisibleState: MutableState<Boolean>? = null
    private var cursorPausedState: MutableState<Boolean>? = null
    private var cursorAnchorState: MutableState<Offset>? = null
    private var selectionStartState: MutableState<Offset?>? = null

    private var onPositionPersisted: ((xFraction: Float, yFraction: Float) -> Unit)? = null
    private var onActiveSidePersisted: ((FloatBallSide) -> Unit)? = null
    private var pauseRunnable: Runnable? = null
    private var captureSuppressed = false

    /** Current finger screen position during drag. */
    private var dragFingerX = 0f
    private var dragFingerY = 0f
    private var dragFingerAnchorX = 0f
    private var dragFingerAnchorY = 0f
    private var dragPointerAnchorX = 0f
    private var dragPointerAnchorY = 0f
    private var dragJoystickOffsetX = 0f
    private var dragJoystickOffsetY = 0f
    private var pointerTravelWidth = 0f
    private var pointerTravelHeight = 0f
    private var isDragging = false

    val isShowing: Boolean get() = ballView != null

    fun showOrUpdate(
        context: Context,
        settings: AppSettings,
        onPositionPersisted: (xFraction: Float, yFraction: Float) -> Unit,
        onActiveSidePersisted: (FloatBallSide) -> Unit = {},
    ) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { showOrUpdate(context, settings, onPositionPersisted, onActiveSidePersisted) }
            return
        }
        if (!PermissionHelper.isAccessibilityServiceEnabledForOverlays(context)) {
            dismiss()
            return
        }
        val hostContext = OverlayDependencyAccess.overlayHostContext()
            ?: run {
                Log.w(TAG, "accessibility service not connected")
                return
            }

        this.onPositionPersisted = onPositionPersisted
        this.onActiveSidePersisted = onActiveSidePersisted
        if (!isShowing) {
            ensureWindows(hostContext, settings)
        } else {
            settingsState?.value = settings
            applyAllLayouts(settings)
        }
    }

    fun dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { dismiss() }
            return
        }
        hideCursor()
        cancelPauseTimer()
        val wm = windowManager
        ballView?.let { view -> wm?.let { runCatching { it.removeView(view) } } }
        edgeCaptureView?.let { view -> wm?.let { runCatching { it.removeView(view) } } }
        lineView?.let { view -> wm?.let { runCatching { it.removeView(view) } } }
        cursorView?.let { view -> wm?.let { runCatching { it.removeView(view) } } }
        screenOffReceiver?.let { receiver ->
            appContext?.let { ctx -> runCatching { ctx.unregisterReceiver(receiver) } }
        }
        OverlayCompose.disposeComposeView(ballView)
        OverlayCompose.disposeComposeView(edgeCaptureView)
        OverlayCompose.disposeComposeView(lineView)
        OverlayCompose.disposeComposeView(cursorView)
        ballOwner?.destroy()
        edgeCaptureOwner?.destroy()
        lineOwner?.destroy()
        cursorOwner?.destroy()
        ballOwner = null
        edgeCaptureOwner = null
        lineOwner = null
        cursorOwner = null
        ballView = null
        edgeCaptureView = null
        lineView = null
        cursorView = null
        ballParams = null
        edgeCaptureParams = null
        lineParams = null
        windowManager = null
        settingsState = null
        cursorVisibleState = null
        cursorPausedState = null
        cursorAnchorState = null
        selectionStartState = null
        onPositionPersisted = null
        onActiveSidePersisted = null
        screenOffReceiver = null
        appContext = null
        isDragging = false
    }

    fun relayout() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { relayout() }
            return
        }
        if (captureSuppressed) return
        val settings = settingsState?.value ?: return
        if (isDragging) {
            updatePickAndBallFromFinger()
        } else {
            applyAllLayouts(settings)
        }
    }

    fun suppressForScreenshotCapture() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { suppressForScreenshotCapture() }
            return
        }
        captureSuppressed = true
        ballView?.visibility = View.GONE
        edgeCaptureView?.visibility = View.GONE
        lineView?.visibility = View.GONE
        hideCursor()
    }

    fun restoreAfterScreenshotCapture() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mainHandler.post { restoreAfterScreenshotCapture() }
            return
        }
        captureSuppressed = false
        val settings = settingsState?.value
        if (settings != null) {
            updateChromeVisibility(settings)
        } else {
            ballView?.visibility = View.VISIBLE
        }
    }

    private fun ensureWindows(hostContext: Context, settings: AppSettings) {
        val wm = hostContext.getSystemService(Context.WINDOW_SERVICE) as? WindowManager ?: return
        val overlayContext = OverlayCompose.themedContext(hostContext)
        val settingsHolder = mutableStateOf(settings)
        val cursorVisible = mutableStateOf(false)
        val cursorPaused = mutableStateOf(false)
        val cursorAnchor = mutableStateOf(Offset.Zero)
        val selectionStart = mutableStateOf<Offset?>(null)

        val dragCallbacks = object {
            fun onStart(localOffset: Offset, windowX: Int, windowY: Int, fromLine: Boolean) {
                val screenX = windowX + localOffset.x
                val screenY = windowY + localOffset.y
                if (fromLine) {
                    flipActiveSide()
                }
                showCursorAtScreenTouch(screenX, screenY)
            }

            fun onDrag(dx: Float, dy: Float) {
                onFingerDrag(dx, dy)
                onDragMoved()
            }

            fun onEnd() {
                finishDrag(settingsHolder.value)
            }

            fun onCancel() {
                hideCursor()
                settingsState?.value?.let { restoreDockPosition(it) }
                updateChromeVisibility(settingsHolder.value)
            }
        }

        val ballDialogOwner = OverlayComposeOwner()
        val ballCompose = OverlayCompose.createComposeView(overlayContext, ballDialogOwner).apply {
            setContent {
                FloatBallContent(
                    settingsState = settingsHolder,
                    onDragStart = { touchInBall ->
                        val params = ballParams ?: return@FloatBallContent
                        dragCallbacks.onStart(touchInBall, params.x, params.y, fromLine = false)
                    },
                    onDrag = { dx, dy -> dragCallbacks.onDrag(dx, dy) },
                    onDragEnd = { dragCallbacks.onEnd() },
                    onDragCancel = { dragCallbacks.onCancel() },
                )
            }
        }

        val edgeCaptureDialogOwner = OverlayComposeOwner()
        val edgeCaptureCompose = OverlayCompose.createComposeView(overlayContext, edgeCaptureDialogOwner).apply {
            setContent {
                FloatBallEdgeCaptureContent(
                    onDragStart = { touchInStrip ->
                        val params = edgeCaptureParams ?: return@FloatBallEdgeCaptureContent
                        dragCallbacks.onStart(touchInStrip, params.x, params.y, fromLine = false)
                    },
                    onDrag = { dx, dy -> dragCallbacks.onDrag(dx, dy) },
                    onDragEnd = { dragCallbacks.onEnd() },
                    onDragCancel = { dragCallbacks.onCancel() },
                )
            }
        }

        val lineDialogOwner = OverlayComposeOwner()
        val lineCompose = OverlayCompose.createComposeView(overlayContext, lineDialogOwner).apply {
            setContent {
                FloatBallLineContent(
                    settingsState = settingsHolder,
                    onDragStart = { touchInStrip ->
                        val params = lineParams ?: return@FloatBallLineContent
                        dragCallbacks.onStart(touchInStrip, params.x, params.y, fromLine = true)
                    },
                    onDrag = { dx, dy -> dragCallbacks.onDrag(dx, dy) },
                    onDragEnd = { dragCallbacks.onEnd() },
                    onDragCancel = { dragCallbacks.onCancel() },
                )
            }
        }

        val cursorDialogOwner = OverlayComposeOwner()
        val cursorCompose = OverlayCompose.createComposeView(overlayContext, cursorDialogOwner).apply {
            isClickable = false
            isFocusable = false
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            setContent {
                val visible by cursorVisible
                val paused by cursorPaused
                val selectionStart by selectionStart
                val pickAnchor by cursorAnchor
                FloatBallCursorContent(
                    visible = visible,
                    paused = paused,
                    selectionStart = selectionStart,
                    pickAnchor = pickAnchor,
                )
            }
        }

        val ballLp = buildTouchableStripLayoutParams(hostContext)
        val edgeCaptureLp = buildTouchableStripLayoutParams(hostContext)
        val lineLp = buildTouchableStripLayoutParams(hostContext)
        val cursorLp = buildCursorLayoutParams(hostContext)

        val edgeAdded = runCatching { wm.addView(edgeCaptureCompose, edgeCaptureLp) }.isSuccess
        if (!edgeAdded) {
            ballDialogOwner.destroy()
            edgeCaptureDialogOwner.destroy()
            lineDialogOwner.destroy()
            cursorDialogOwner.destroy()
            Log.e(TAG, "failed to add edge capture overlay")
            return
        }
        val lineAdded = runCatching { wm.addView(lineCompose, lineLp) }.isSuccess
        if (!lineAdded) {
            runCatching { wm.removeView(edgeCaptureCompose) }
            ballDialogOwner.destroy()
            edgeCaptureDialogOwner.destroy()
            lineDialogOwner.destroy()
            cursorDialogOwner.destroy()
            Log.e(TAG, "failed to add line overlay")
            return
        }
        val ballAdded = runCatching { wm.addView(ballCompose, ballLp) }.isSuccess
        if (!ballAdded) {
            runCatching { wm.removeView(edgeCaptureCompose) }
            runCatching { wm.removeView(lineCompose) }
            ballDialogOwner.destroy()
            edgeCaptureDialogOwner.destroy()
            lineDialogOwner.destroy()
            cursorDialogOwner.destroy()
            Log.e(TAG, "failed to add ball overlay")
            return
        }
        val cursorAdded = runCatching { wm.addView(cursorCompose, cursorLp) }.isSuccess
        if (!cursorAdded) {
            runCatching { wm.removeView(ballCompose) }
            runCatching { wm.removeView(edgeCaptureCompose) }
            runCatching { wm.removeView(lineCompose) }
            ballDialogOwner.destroy()
            edgeCaptureDialogOwner.destroy()
            lineDialogOwner.destroy()
            cursorDialogOwner.destroy()
            Log.e(TAG, "failed to add cursor overlay")
            return
        }

        windowManager = wm
        ballView = ballCompose
        edgeCaptureView = edgeCaptureCompose
        lineView = lineCompose
        cursorView = cursorCompose
        ballOwner = ballDialogOwner
        edgeCaptureOwner = edgeCaptureDialogOwner
        lineOwner = lineDialogOwner
        cursorOwner = cursorDialogOwner
        ballParams = ballLp
        edgeCaptureParams = edgeCaptureLp
        lineParams = lineLp
        settingsState = settingsHolder
        cursorVisibleState = cursorVisible
        cursorPausedState = cursorPaused
        cursorAnchorState = cursorAnchor
        selectionStartState = selectionStart
        appContext = hostContext
        registerScreenOffReceiver(hostContext)

        applyAllLayouts(settings)
    }

    private fun buildTouchableStripLayoutParams(context: Context): WindowManager.LayoutParams {
        return WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            OverlayWindowTypes.overlayWindowType(context),
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            PixelFormat.TRANSLUCENT,
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
    }

    private fun buildCursorLayoutParams(context: Context): WindowManager.LayoutParams {
        return WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            OverlayWindowTypes.overlayWindowType(context),
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            PixelFormat.TRANSLUCENT,
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
    }

    private fun applyAllLayouts(settings: AppSettings) {
        applyBallLayout(settings)
        applyEdgeCaptureLayout(settings)
        applyLineLayout(settings)
        updateChromeVisibility(settings)
    }

    private fun applyBallLayout(settings: AppSettings) {
        val wm = windowManager ?: return
        val view = ballView ?: return
        val params = ballParams ?: return
        val metrics = view.resources.displayMetrics
        val activeSide = FloatBallLayout.resolvedActiveSide(settings)
        val (left, top) = FloatBallLayout.ballTopLeft(settings, metrics, activeSide)
        params.x = left
        params.y = top
        runCatching { wm.updateViewLayout(view, params) }
    }

    private fun applyEdgeCaptureLayout(settings: AppSettings) {
        val wm = windowManager ?: return
        val view = edgeCaptureView ?: return
        val params = edgeCaptureParams ?: return
        val metrics = view.resources.displayMetrics
        val activeSide = FloatBallLayout.resolvedActiveSide(settings)
        val bounds = FloatBallLayout.edgeStripBounds(settings, metrics, activeSide)
        params.x = bounds.left
        params.y = bounds.top
        params.width = bounds.width()
        params.height = bounds.height()
        runCatching { wm.updateViewLayout(view, params) }
    }

    private fun applyLineLayout(settings: AppSettings) {
        val wm = windowManager ?: return
        val view = lineView ?: return
        val params = lineParams ?: return
        val metrics = view.resources.displayMetrics
        if (!FloatBallLayout.shouldShowLine(settings)) return
        val inactiveSide = FloatBallSide.opposite(FloatBallLayout.resolvedActiveSide(settings))
        val bounds = FloatBallLayout.edgeStripBounds(settings, metrics, inactiveSide)
        params.x = bounds.left
        params.y = bounds.top
        params.width = bounds.width()
        params.height = bounds.height()
        runCatching { wm.updateViewLayout(view, params) }
    }

    private fun updateChromeVisibility(settings: AppSettings) {
        if (captureSuppressed) {
            ballView?.visibility = View.GONE
            edgeCaptureView?.visibility = View.GONE
            lineView?.visibility = View.GONE
            return
        }
        if (isDragging) {
            ballView?.visibility = View.VISIBLE
            edgeCaptureView?.visibility = View.GONE
            lineView?.visibility = View.GONE
            return
        }
        ballView?.visibility = View.VISIBLE
        val showEdgeCapture = settings.floatBallPositionMode != FloatBallPositionMode.CUSTOM
        edgeCaptureView?.visibility = if (showEdgeCapture) View.VISIBLE else View.GONE
        lineView?.visibility = if (FloatBallLayout.shouldShowLine(settings)) View.VISIBLE else View.GONE
    }

    private fun flipActiveSide() {
        val settings = settingsState?.value ?: return
        if (settings.floatBallPositionMode != FloatBallPositionMode.BOTH_EDGES) return
        val newSide = FloatBallSide.opposite(FloatBallLayout.resolvedActiveSide(settings))
        val updated = settings.copy(floatBallActiveSide = newSide)
        settingsState?.value = updated
        onActiveSidePersisted?.invoke(newSide)
        applyAllLayouts(updated)
    }

    private fun restoreDockPosition(settings: AppSettings) {
        applyAllLayouts(settings)
    }

    private fun onFingerDrag(dx: Float, dy: Float) {
        if (!isDragging) return
        dragFingerX += dx
        dragFingerY += dy
        updatePickAndBallFromFinger()
    }

    private fun finishDrag(settings: AppSettings) {
        isDragging = false
        handlePickOnRelease(settings)
        hideCursor()
        if (settings.floatBallPositionMode == FloatBallPositionMode.CUSTOM) {
            persistBallCenterFraction()
        }
        restoreDockPosition(settingsState?.value ?: settings)
        updateChromeVisibility(settingsState?.value ?: settings)
    }

    private fun handlePickOnRelease(settings: AppSettings) {
        val start = selectionStartState?.value ?: return
        val end = cursorAnchorState?.value ?: return
        val host = appContext ?: return
        val view = ballView ?: return
        val minSidePx = (RECT_MIN_SIDE_DP * view.resources.displayMetrics.density).roundToInt()
        val rect = rectBetween(start, end)
        val regionalRect = rect.width() >= minSidePx && rect.height() >= minSidePx
        val panelAnchorX = if (regionalRect) rect.centerX().toFloat() else start.x
        val panelAnchorY = if (regionalRect) rect.bottom.toFloat() else start.y

        FloatBallPickResultPanel.showLoading(host, panelAnchorX, panelAnchorY)
        SlideIndexAccessibilityService.pickFloatBallOnRelease(
            context = host,
            startX = start.x,
            startY = start.y,
            endX = end.x,
            endY = end.y,
            regionalRect = regionalRect,
            ocrFallbackEnabled = settings.floatBallOcrFallbackEnabled,
        ) { result ->
            FloatBallPickResultPanel.showResult(host, panelAnchorX, panelAnchorY, result)
        }
    }

    private fun snapBallToEdge(settings: AppSettings) {
        // Kept for compatibility; dock restore handles edge placement.
        restoreDockPosition(settings)
    }

    private fun persistBallCenterFraction() {
        val view = ballView ?: return
        val params = ballParams ?: return
        val settings = settingsState?.value ?: return
        val metrics = view.resources.displayMetrics
        val density = metrics.density
        val ballSizePx = (settings.floatBallSizeDp.coerceIn(36f, 72f) * density).roundToInt()
        val centerX = params.x + ballSizePx / 2f
        val centerY = params.y + ballSizePx / 2f
        val xFraction = (centerX / metrics.widthPixels).coerceIn(0.05f, 0.95f)
        val yFraction = (centerY / metrics.heightPixels).coerceIn(0.05f, 0.95f)
        onPositionPersisted?.invoke(xFraction, yFraction)
    }

    private fun showCursorAtScreenTouch(screenX: Float, screenY: Float) {
        val params = ballParams ?: return
        val view = ballView ?: return
        val settings = settingsState?.value ?: return
        val metrics = view.resources.displayMetrics
        val density = metrics.density
        val ballSizePx = (settings.floatBallSizeDp.coerceIn(36f, 72f) * density).roundToInt()
        val screenWidth = metrics.widthPixels.toFloat()
        val screenHeight = metrics.heightPixels.toFloat()

        edgeCaptureView?.visibility = View.GONE
        lineView?.visibility = View.GONE

        dragFingerX = screenX
        dragFingerY = screenY
        dragFingerAnchorX = screenX
        dragFingerAnchorY = screenY

        val ballCenterX = params.x + ballSizePx / 2f
        val ballCenterY = params.y + ballSizePx / 2f
        dragPointerAnchorX = ballCenterX
        dragPointerAnchorY = ballCenterY
        dragJoystickOffsetX = ballCenterX - screenX
        dragJoystickOffsetY = ballCenterY - screenY

        establishPointerTravel(settings, screenWidth, screenHeight)

        isDragging = true
        selectionStartState?.value = null
        cursorVisibleState?.value = true
        cursorPausedState?.value = false
        updatePickAndBallFromFinger()
        schedulePauseTimer()
    }

    private fun hideCursor() {
        isDragging = false
        cancelPauseTimer()
        cursorVisibleState?.value = false
        cursorPausedState?.value = false
        selectionStartState?.value = null
        settingsState?.value?.let { updateChromeVisibility(it) }
    }

    private fun onDragMoved() {
        if (selectionStartState?.value != null) {
            return
        }
        cursorPausedState?.value = false
        schedulePauseTimer()
    }

    private fun schedulePauseTimer() {
        cancelPauseTimer()
        val runnable = Runnable { onCursorPaused() }
        pauseRunnable = runnable
        mainHandler.postDelayed(runnable, PAUSE_MS)
    }

    private fun onCursorPaused() {
        if (cursorVisibleState?.value != true) return
        selectionStartState?.value = cursorAnchorState?.value
        cursorPausedState?.value = true
    }

    private fun rectBetween(start: Offset, end: Offset): Rect {
        val left = min(start.x, end.x).roundToInt()
        val top = min(start.y, end.y).roundToInt()
        val right = max(start.x, end.x).roundToInt()
        val bottom = max(start.y, end.y).roundToInt()
        return Rect(left, top, right, bottom)
    }

    private fun cancelPauseTimer() {
        pauseRunnable?.let { mainHandler.removeCallbacks(it) }
        pauseRunnable = null
    }

    private fun establishPointerTravel(settings: AppSettings, screenWidth: Float, screenHeight: Float) {
        val speed = settings.floatBallPointerSpeedFraction.coerceIn(
            FloatingPointerBounds.SENSITIVITY_MIN,
            FloatingPointerBounds.SENSITIVITY_MAX,
        )
        val (travelWidth, travelHeight) = FloatingPointerBounds.effectivePointerTravelForSpeed(
            speedFraction = speed,
            screenWidth = screenWidth,
            screenHeight = screenHeight,
        )
        pointerTravelWidth = travelWidth
        pointerTravelHeight = travelHeight
    }

    private fun updatePickAndBallFromFinger() {
        val wm = windowManager ?: return
        val view = ballView ?: return
        val params = ballParams ?: return
        val settings = settingsState?.value ?: return
        val metrics = view.resources.displayMetrics
        val density = metrics.density
        val ballSizePx = (settings.floatBallSizeDp.coerceIn(36f, 72f) * density).roundToInt()
        val marginPx = (EDGE_MARGIN_DP * density).roundToInt()
        val screenWidth = metrics.widthPixels.toFloat()
        val screenHeight = metrics.heightPixels.toFloat()

        if (pointerTravelWidth <= 0f || pointerTravelHeight <= 0f) {
            establishPointerTravel(settings, screenWidth, screenHeight)
        }

        val ballCenterX = dragFingerX + dragJoystickOffsetX
        val ballCenterY = dragFingerY + dragJoystickOffsetY
        val ballLeft = (ballCenterX - ballSizePx / 2f).roundToInt()
            .coerceIn(marginPx, metrics.widthPixels - ballSizePx - marginPx)
        val ballTop = (ballCenterY - ballSizePx / 2f).roundToInt()
            .coerceIn(marginPx, metrics.heightPixels - ballSizePx - marginPx)

        val pick = FloatingPointerBounds.pointerForFingerDeltaInArea(
            deltaX = dragFingerX - dragFingerAnchorX,
            deltaY = dragFingerY - dragFingerAnchorY,
            travelWidth = pointerTravelWidth,
            travelHeight = pointerTravelHeight,
            screenWidth = screenWidth,
            screenHeight = screenHeight,
            pointerAnchorX = dragPointerAnchorX,
            pointerAnchorY = dragPointerAnchorY,
        )
        cursorAnchorState?.value = pick

        params.x = ballLeft
        params.y = ballTop
        runCatching { wm.updateViewLayout(view, params) }
    }

    private fun registerScreenOffReceiver(context: Context) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(receiverContext: Context?, intent: Intent?) {
                if (intent?.action == Intent.ACTION_SCREEN_OFF) hideCursor()
            }
        }
        screenOffReceiver = receiver
        runCatching { context.registerReceiver(receiver, IntentFilter(Intent.ACTION_SCREEN_OFF)) }
    }
}

@Composable
private fun FloatBallEdgeCaptureContent(
    onDragStart: (Offset) -> Unit,
    onDrag: (dx: Float, dy: Float) -> Unit,
    onDragEnd: () -> Unit,
    onDragCancel: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset -> onDragStart(offset) },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        onDrag(dragAmount.x, dragAmount.y)
                    },
                    onDragEnd = { onDragEnd() },
                    onDragCancel = { onDragCancel() },
                )
            },
    )
}

@Composable
private fun FloatBallLineContent(
    settingsState: MutableState<AppSettings>,
    onDragStart: (Offset) -> Unit,
    onDrag: (dx: Float, dy: Float) -> Unit,
    onDragEnd: () -> Unit,
    onDragCancel: () -> Unit,
) {
    val settings = settingsState.value
    val lineColor = Color(settings.themeColorArgb)
        .copy(alpha = settings.floatBallLineOpacity.coerceIn(0.1f, 1f))
    val inactiveSide = FloatBallSide.opposite(FloatBallLayout.resolvedActiveSide(settings))
    val density = LocalDensity.current
    val lineWidth = with(density) { 4.dp }
    val outerAlignment = when (inactiveSide) {
        FloatBallSide.LEFT -> Alignment.CenterStart
        FloatBallSide.RIGHT -> Alignment.CenterEnd
    }
    val roundedEdge = when (inactiveSide) {
        FloatBallSide.LEFT -> RoundedCornerShape(topEnd = 3.dp, bottomEnd = 3.dp)
        FloatBallSide.RIGHT -> RoundedCornerShape(topStart = 3.dp, bottomStart = 3.dp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset -> onDragStart(offset) },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        onDrag(dragAmount.x, dragAmount.y)
                    },
                    onDragEnd = { onDragEnd() },
                    onDragCancel = { onDragCancel() },
                )
            },
        contentAlignment = outerAlignment,
    ) {
        Box(
            modifier = Modifier
                .width(lineWidth)
                .fillMaxHeight()
                .clip(roundedEdge)
                .background(lineColor),
        )
    }
}

@Composable
private fun FloatBallContent(
    settingsState: MutableState<AppSettings>,
    onDragStart: (touchInBall: Offset) -> Unit,
    onDrag: (dx: Float, dy: Float) -> Unit,
    onDragEnd: () -> Unit,
    onDragCancel: () -> Unit,
) {
    val settings = settingsState.value
    val sizeDp = settings.floatBallSizeDp.coerceIn(36f, 72f).dp
    val ballColor = Color(settings.themeColorArgb).copy(alpha = settings.floatBallOpacity.coerceIn(0.3f, 1f))

    SlideIndexTheme {
        Box(
            modifier = Modifier
                .size(sizeDp)
                .shadow(8.dp, CircleShape)
                .clip(CircleShape)
                .background(ballColor)
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = { offset -> onDragStart(offset) },
                        onDrag = { change, dragAmount ->
                            change.consume()
                            onDrag(dragAmount.x, dragAmount.y)
                        },
                        onDragEnd = { onDragEnd() },
                        onDragCancel = { onDragCancel() },
                    )
                },
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .size((sizeDp.value * 0.35f).dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.9f)),
            )
        }
    }
}

@Composable
private fun FloatBallCursorContent(
    visible: Boolean,
    paused: Boolean,
    selectionStart: Offset?,
    pickAnchor: Offset,
) {
    if (!visible) return
    val crossColor = if (paused) Color(0xFFFFC107) else Color(0xFFE53935)
    val markerCenter = selectionStart ?: pickAnchor
    val density = LocalDensity.current
    val armPx = with(density) { CROSS_ARM_DP.dp.toPx() }
    val strokePx = with(density) { CROSS_STROKE_DP.dp.toPx() }
    val plusRadiusPx = with(density) { 11.dp.toPx() }

    Canvas(modifier = Modifier.fillMaxSize()) {
        if (selectionStart != null && paused) {
            val left = min(selectionStart.x, pickAnchor.x)
            val top = min(selectionStart.y, pickAnchor.y)
            val right = max(selectionStart.x, pickAnchor.x)
            val bottom = max(selectionStart.y, pickAnchor.y)
            drawRect(
                color = Color(0x33FFC107),
                topLeft = Offset(left, top),
                size = androidx.compose.ui.geometry.Size(right - left, bottom - top),
            )
            drawRect(
                color = Color(0xFFFFC107),
                topLeft = Offset(left, top),
                size = androidx.compose.ui.geometry.Size(right - left, bottom - top),
                style = Stroke(width = strokePx),
            )
        }
        if (paused) {
            drawCircle(
                color = crossColor,
                radius = plusRadiusPx,
                center = markerCenter,
            )
            val plusArm = plusRadiusPx * 0.42f
            val plusStroke = strokePx * 1.1f
            drawLine(
                color = Color.White,
                start = Offset(markerCenter.x - plusArm, markerCenter.y),
                end = Offset(markerCenter.x + plusArm, markerCenter.y),
                strokeWidth = plusStroke,
            )
            drawLine(
                color = Color.White,
                start = Offset(markerCenter.x, markerCenter.y - plusArm),
                end = Offset(markerCenter.x, markerCenter.y + plusArm),
                strokeWidth = plusStroke,
            )
        } else {
            drawLine(
                color = crossColor,
                start = Offset(markerCenter.x - armPx, markerCenter.y),
                end = Offset(markerCenter.x + armPx, markerCenter.y),
                strokeWidth = strokePx,
            )
            drawLine(
                color = crossColor,
                start = Offset(markerCenter.x, markerCenter.y - armPx),
                end = Offset(markerCenter.x, markerCenter.y + armPx),
                strokeWidth = strokePx,
            )
            drawCircle(
                color = crossColor,
                radius = strokePx * 1.2f,
                center = markerCenter,
                style = Stroke(width = strokePx),
            )
        }
    }
}
