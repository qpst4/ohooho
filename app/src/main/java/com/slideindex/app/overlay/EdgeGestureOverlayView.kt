package com.slideindex.app.overlay

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.RectF
import android.util.TypedValue
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import com.slideindex.app.data.AppInfo
import com.slideindex.app.data.AppRepository
import com.slideindex.app.gesture.ActionExecutor
import com.slideindex.app.gesture.GestureAction
import com.slideindex.app.gesture.CollapsedWindowBounds
import com.slideindex.app.gesture.GestureSession
import com.slideindex.app.gesture.GestureZoneLayout
import com.slideindex.app.gesture.IndexSessionHost
import com.slideindex.app.gesture.PanelGridSession
import com.slideindex.app.gesture.SlideAlongRailSession
import com.slideindex.app.gesture.SwipePathRecognizer
import com.slideindex.app.launcher.QuickLauncherItem
import com.slideindex.app.shell.ShellCommand
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.service.QuickLauncherAddTrampoline
import com.slideindex.app.util.ContinuousAdjustController
import com.slideindex.app.util.GestureActionIconBitmap
import com.slideindex.app.util.HapticHelper
import com.slideindex.app.util.OverlayBrightnessControl

/**
 * 边缘手势 Overlay 编排层：触摸分发、会话生命周期与各面板 Controller 协调。
 */
class EdgeGestureOverlayView(
    context: Context,
    private val side: PanelSide,
    private val appRepository: AppRepository,
    private val onSessionStartCallback: () -> Unit,
    private val onSessionEndCallback: () -> Unit,
    private val onGestureTrackingStartCallback: () -> Unit = {},
    private val onAdjustPanelLayoutCallback: (Float) -> Unit = {},
    private val onAdjustPanelDismissCallback: () -> Unit = {},
    private val onClickPassthroughCallback: (Float, Float, () -> Unit) -> Unit = { _, _, onComplete -> onComplete() },
    private val onShellCommandsPersist: (List<ShellCommand>) -> Unit = {},
    private val onQuickLauncherItemsPersist: (List<QuickLauncherItem>) -> Unit = {},
    private val onShellPanelFocusChange: (Boolean) -> Unit = {},
    private val onOverlayWindowSuspend: () -> Unit = {},
    private val onOverlayWindowResume: () -> Unit = {},
    private val onOverlayPresentationSuspend: () -> Unit = {},
    private val onOverlayPresentationResume: () -> Unit = {},
    private val onShellPanelAuxiliaryPrepare: () -> Unit = {},
    private val onShellPanelAuxiliaryDismiss: () -> Unit = {},
    overlayBrightness: OverlayBrightnessControl? = null,
) : View(context), IndexSessionHost, GestureSession.Callbacks {

    private var settings = AppSettings()
    private var apps: List<AppInfo> = emptyList()
    private var previewMode = false
    private var previewContent: LayoutPreviewContent = LayoutPreviewContent.TRIGGER_ONLY

    private sealed class OverlayTouchLayout {
        data class TriggerCollapsed(val bounds: CollapsedWindowBounds) : OverlayTouchLayout()
        data class GestureTracking(val bounds: CollapsedWindowBounds) : OverlayTouchLayout()
        data object FullScreen : OverlayTouchLayout()
        data object AdjustPanel : OverlayTouchLayout()
    }

    private var overlayTouchLayout: OverlayTouchLayout = OverlayTouchLayout.FullScreen
    private val zoneLayout = GestureZoneLayout(side)
    private val indexSession = SlideAlongRailSession(side, zoneLayout, this)
    private val panelGridSession = PanelGridSession()
    private val actionExecutor = ActionExecutor(
        context = context,
        appRepository = appRepository,
        clickPassthroughHandler = onClickPassthroughCallback,
        overlayBrightness = overlayBrightness,
        side = side,
        onShellCommandsPersist = onShellCommandsPersist,
    )
    private val pathRecognizer = SwipePathRecognizer(side, resources.displayMetrics.density)
    private val gestureSession = GestureSession(
        side = side,
        zoneLayout = zoneLayout,
        indexSession = indexSession,
        pathRecognizer = pathRecognizer,
        actionExecutor = actionExecutor,
        callbacks = this,
    )
    private val panelContentRect = RectF()
    private val panelEnterAnimator = OverlayPanelEnterAnimator(side, ::dp) { invalidate() }
    private var lastAdjustInvalidateMs = 0L
    private var edgeCaptureTouchActive = false
    private val iconCache = mutableMapOf<String, Bitmap>()
    private val iconSizePx get() = dp(44f)

    private val overlayHosts = EdgeGestureOverlayHosts(
        view = this,
        side = side,
        appRepository = appRepository,
        zoneLayout = zoneLayout,
        indexSession = indexSession,
        panelGridSession = panelGridSession,
        actionExecutor = actionExecutor,
        pathRecognizer = pathRecognizer,
        gestureSession = gestureSession,
        panelEnterAnimator = panelEnterAnimator,
        panelContentRect = panelContentRect,
        settingsProvider = { settings },
        appsProvider = { apps },
        iconForFn = { app -> iconFor(app) },
        dpFn = ::dp,
        spFn = ::sp,
        runAfterLayoutFn = ::runAfterLayout,
        activeTriggerZoneRectFn = ::activeTriggerZoneRect,
        clearEdgeCaptureTouchActiveFn = { edgeCaptureTouchActive = false },
        notifyPresentationTouchRequirementChangedFn = ::notifyPresentationTouchRequirementChanged,
        notifyOverlayLayoutIfNeededFn = ::notifyOverlayLayoutIfNeeded,
        onAdjustPanelDismissFn = onAdjustPanelDismissCallback,
        onSessionStartFn = onSessionStartCallback,
        onShellCommandsPersistFn = onShellCommandsPersist,
        onQuickLauncherItemsPersistFn = onQuickLauncherItemsPersist,
        onShellPanelFocusChangeFn = onShellPanelFocusChange,
        onOverlayWindowSuspendFn = onOverlayWindowSuspend,
        onOverlayWindowResumeFn = onOverlayWindowResume,
        onShellPanelAuxiliaryPrepareFn = onShellPanelAuxiliaryPrepare,
        onShellPanelAuxiliaryDismissFn = onShellPanelAuxiliaryDismiss,
    )
    private val shellCoordinator = ShellPanelOverlayController(overlayHosts)
    private val quickLauncherController = QuickLauncherOverlayController(overlayHosts)
    private val indexPanelRenderer = IndexPanelRenderer(overlayHosts)
    private val adjustPanelController = AdjustPanelOverlayController(overlayHosts)
    private val taskSwitcherController = TaskSwitcherOverlayController(overlayHosts)
    private val gestureAnimationCoordinator = GestureAnimationCoordinator(
        side = side,
        gestureSessionProvider = { gestureSession },
        pathRecognizerProvider = { pathRecognizer },
        settingsProvider = { settings },
        post = { action -> post(action) },
    )
    private val touchDispatcher = EdgeGestureTouchDispatcher(
        gestureSession = gestureSession,
        adjustPanelController = adjustPanelController,
        quickLauncherController = quickLauncherController,
        shellCoordinator = shellCoordinator,
        taskSwitcherController = taskSwitcherController,
        indexPanelRenderer = indexPanelRenderer,
        gestureAnimationCoordinator = gestureAnimationCoordinator,
        rawToLocal = ::rawToLocal,
        forEachGesturePoint = ::forEachGesturePoint,
        isPreviewMode = { previewMode },
        onGestureTrackingStart = onGestureTrackingStartCallback,
        onSyncZoneLayout = ::syncZoneLayout,
        onForceRecoverInteractionState = ::forceRecoverInteractionState,
        edgeCaptureTouchActive = { edgeCaptureTouchActive },
        setEdgeCaptureTouchActive = { edgeCaptureTouchActive = it },
        composeOverlayDialogShowing = ::composeOverlayDialogShowing,
    )

    init {
        isClickable = true
        isFocusableInTouchMode = true
        setOnKeyListener { _, keyCode, event ->
            if (keyCode != KeyEvent.KEYCODE_BACK || event.action != KeyEvent.ACTION_UP) {
                return@setOnKeyListener false
            }
            shellCoordinator.handleBackPress()
        }
    }

    fun applySettings(newSettings: AppSettings, screenWidth: Int) {
        settings = newSettings
        shellCoordinator.syncSettings(newSettings)
        quickLauncherController.syncSettings(newSettings)
        indexPanelRenderer.syncSettings(newSettings)
        gestureSession.applySettings(newSettings)
        quickLauncherController.invalidateDerivedCaches()
        gestureAnimationCoordinator.applySettings(newSettings)
        syncZoneLayout()
        invalidate()
    }

    fun dispatchExternalAction(action: GestureAction, anchorRawY: Float): Boolean {
        applyExpandedOverlayLayout()
        runAfterLayout {
            val loc = IntArray(2)
            getLocationOnScreen(loc)
            val screenHeight = resources.displayMetrics.heightPixels.toFloat().coerceAtLeast(1f)
            val viewHeight = if (height > 0) height.toFloat() else screenHeight
            val localY = (anchorRawY - loc[1]).coerceIn(0f, viewHeight)
            val screenWidth = resources.displayMetrics.widthPixels.toFloat().coerceAtLeast(1f)
            val localX = if (width > 0) width / 2f else screenWidth / 2f
            val anchorRawX = if (width > 0) loc[0] + localX else screenWidth / 2f
            when (action) {
                is GestureAction.TaskSwitcher -> taskSwitcherController.setExternalAnchor(anchorRawY)
                is GestureAction.QuickLauncher -> quickLauncherController.setAnchorRawY(anchorRawY)
                else -> Unit
            }
            gestureSession.openDiscretePanel(action, localX, localY, anchorRawX, anchorRawY)
            notifyPresentationTouchRequirementChanged()
            invalidate()
        }
        return true
    }

    private fun runAfterLayout(block: () -> Unit) {
        if (isAttachedToWindow && width > 0 && height > 0) {
            block()
            return
        }
        val observer = viewTreeObserver
        if (!observer.isAlive) {
            post { runAfterLayout(block) }
            return
        }
        observer.addOnGlobalLayoutListener(
            object : ViewTreeObserver.OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (width <= 0 || height <= 0) return
                    viewTreeObserver.removeOnGlobalLayoutListener(this)
                    block()
                }
            },
        )
        requestLayout()
    }

    fun isSessionActive(): Boolean = gestureSession.isActive()

    fun applyCollapsedTriggerLayout(bounds: CollapsedWindowBounds) {
        applyExpandedOverlayLayout()
    }

    fun applyExpandedOverlayLayout() {
        overlayTouchLayout = OverlayTouchLayout.FullScreen
        syncZoneLayout()
    }

    fun needsPresentationDirectTouch(): Boolean {
        if (previewMode) return false
        if (adjustPanelController.hasAdjustPanel()) return true
        if (gestureSession.panelMode() != OverlayPanelMode.NONE) return true
        if (quickLauncherController.isOverlayDialogShowing() ||
            shellCoordinator.isAuxiliaryDialogShowing()
        ) return true
        return false
    }

    fun presentationShouldPassthroughTouches(): Boolean =
        QuickLauncherAddTrampoline.isActive() ||
            shellCoordinator.isAuxiliaryDialogShowing() ||
            quickLauncherController.isOverlayDialogShowing()

    private fun composeOverlayDialogShowing(): Boolean =
        QuickLauncherAddTrampoline.isActive() ||
            shellCoordinator.isAuxiliaryDialogShowing() ||
            shellCoordinator.isPanelTrampolineBlockingPassthrough() ||
            quickLauncherController.isOverlayDialogShowing()

    fun syncOverlayDialogZOrder() {
        quickLauncherController.syncOverlayDialogZOrder()
    }

    var onPresentationTouchRequirementChanged: (() -> Unit)? = null

    private fun notifyPresentationTouchRequirementChanged() {
        onPresentationTouchRequirementChanged?.invoke()
    }

    fun handleOverlayTouch(event: MotionEvent): Boolean = touchDispatcher.handleTouch(event)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (composeOverlayDialogShowing()) return false
        if (!needsPresentationDirectTouch()) return false
        return handleOverlayTouch(event)
    }

    fun applyGestureTrackingLayout(bounds: CollapsedWindowBounds) {
        overlayTouchLayout = OverlayTouchLayout.GestureTracking(bounds)
        syncZoneLayout()
    }

    fun applyAdjustPanelOverlayLayout() {
        overlayTouchLayout = OverlayTouchLayout.AdjustPanel
        syncZoneLayout()
    }

    fun hasAdjustPanel(): Boolean = adjustPanelController.hasAdjustPanel()

    fun keepsOverlayExpanded(): Boolean =
        gestureSession.isActive() ||
            gestureSession.panelMode() != OverlayPanelMode.NONE ||
            adjustPanelController.hasAdjustPanel() ||
            (gestureSession.panelMode() == OverlayPanelMode.SHELL_COMMANDS &&
                shellCoordinator.hasActiveUi())

    fun forceRecoverInteractionState() {
        if (adjustPanelController.isDismissing()) return
        shellCoordinator.closePanelTrampolineIfActive()
        shellCoordinator.clearShellContinuousPick()
        gestureAnimationCoordinator.hide()
        edgeCaptureTouchActive = false
        adjustPanelController.forceRecover()
        gestureSession.forceReset(notifySessionEnd = false)
        syncZoneLayout()
        invalidate()
    }

    fun isPreviewMode(): Boolean = previewMode

    fun setPreviewMode(enabled: Boolean, content: LayoutPreviewContent = LayoutPreviewContent.TRIGGER_ONLY) {
        val changed = previewMode != enabled || previewContent != content
        if (!changed) return
        previewMode = enabled
        previewContent = content
        syncZoneLayout()
        invalidate()
    }

    fun setApps(newApps: List<AppInfo>) {
        apps = newApps
        indexSession.setApps(newApps)
        iconCache.clear()
        quickLauncherController.setApps(newApps)
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        quickLauncherController.onSizeChanged()
        syncZoneLayout()
        adjustPanelController.onSizeChanged()
    }

    override fun onDetachedFromWindow() {
        gestureAnimationCoordinator.hide()
        adjustPanelController.onDetachedFromWindow()
        GestureActionIconBitmap.clear()
        super.onDetachedFromWindow()
    }

    private fun notifyOverlayLayoutIfNeeded() {
        if (!keepsOverlayExpanded() && !gestureSession.isActive()) {
            onSessionEndCallback()
        }
    }

    fun showAdjustPanel(
        mode: ContinuousAdjustController.Mode,
        fraction: Float,
        anchorRawY: Float,
        @Suppress("UNUSED_PARAMETER") deferWindowLayout: Boolean = false,
    ) {
        onAdjustPanelLayoutCallback(anchorRawY)
        adjustPanelController.showAdjustPanel(mode, fraction, anchorRawY)
    }

    private fun activeTriggerZoneRect(): RectF =
        if (gestureSession.isActive()) {
            zoneLayout.triggerZoneRect(gestureSession.activeHandleId())
        } else {
            zoneLayout.triggerZoneUnionRect()
        }

    override fun onDraw(canvas: Canvas) {
        if (width > 0 && height > 0 && gestureSession.isActive()) {
            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
        }
        super.onDraw(canvas)
        if (width <= 0 || height <= 0) return
        syncZoneLayout()
        if (previewMode) {
            when (previewContent) {
                LayoutPreviewContent.TRIGGER_ONLY -> TriggerZonePreviewRenderer.draw(
                    canvas = canvas,
                    side = side,
                    settings = settings,
                    zoneLayout = zoneLayout,
                    density = resources.displayMetrics.density,
                    dp = ::dp,
                )
                LayoutPreviewContent.INDEX_ONLY -> indexPanelRenderer.drawLetterRail(canvas)
            }
            return
        }
        adjustPanelController.drawVisibleIndicator(canvas)
        if (!gestureSession.isActive() && !adjustPanelController.hasAdjustPanel()) return
        when (gestureSession.panelMode()) {
            OverlayPanelMode.INDEX -> {
                panelEnterAnimator.drawWithAnimation(canvas, indexPanelRenderer.indexPanelContentRect()) {
                    indexPanelRenderer.drawLetterRail(canvas)
                    if (indexSession.selectedLetter != null) {
                        indexPanelRenderer.drawAppGrid(canvas)
                        indexPanelRenderer.drawLetterBubble(canvas)
                    }
                }
            }
            OverlayPanelMode.QUICK_LAUNCHER -> {
                val contentRect = quickLauncherController.enterContentRect()
                panelEnterAnimator.drawWithAnimation(canvas, contentRect) {
                    quickLauncherController.draw(canvas)
                }
            }
            OverlayPanelMode.TASK_SWITCHER -> taskSwitcherController.draw(canvas)
            OverlayPanelMode.SHELL_COMMANDS ->
                shellCoordinator.draw(canvas, panelEnterAnimator.progress, panelContentRect)
            OverlayPanelMode.NONE -> adjustPanelController.syncAdjustIndicatorAnimation()
        }
    }

    override fun hapticLetterTick() = HapticHelper.letterTick(this, settings)
    override fun hapticAppTick() = HapticHelper.appTick(this, settings)
    override fun hapticGestureStart() = HapticHelper.gestureStart(this, settings)
    override fun hapticLongThreshold() = HapticHelper.longThreshold(this, settings)
    override fun hapticConfirmLaunch() = HapticHelper.confirmLaunch(this, settings)
    override fun scheduleDelayed(runnable: Runnable, delayMs: Long) {
        postDelayed(runnable, delayMs)
    }

    override fun cancelDelayed(runnable: Runnable) {
        removeCallbacks(runnable)
    }

    override fun requestInvalidate() {
        if (gestureSession.isAdjustMode()) {
            val now = android.os.SystemClock.uptimeMillis()
            if (now - lastAdjustInvalidateMs < 16L) return
            lastAdjustInvalidateMs = now
        }
        invalidate()
    }

    override fun onShowAdjustPanel(
        mode: ContinuousAdjustController.Mode,
        fraction: Float,
        anchorRawY: Float,
        deferWindowLayout: Boolean,
    ) = showAdjustPanel(mode, fraction, anchorRawY, deferWindowLayout)

    override fun onOpenShellCommandPanel(continuousPick: Boolean) {
        shellCoordinator.onOpenShellCommandPanel(continuousPick)
    }

    override fun onShellCommandPanelContinuousRelease() {
        shellCoordinator.onShellCommandPanelContinuousRelease()
    }

    override fun onSessionStart(mode: OverlayPanelMode) {
        syncZoneLayout()
        panelEnterAnimator.cancel()
        when (mode) {
            OverlayPanelMode.TASK_SWITCHER -> {
                panelEnterAnimator.resetToHidden()
                taskSwitcherController.onSessionStart()
            }
            OverlayPanelMode.INDEX, OverlayPanelMode.QUICK_LAUNCHER,
            OverlayPanelMode.SHELL_COMMANDS -> {
                panelEnterAnimator.resetToHidden()
                if (mode == OverlayPanelMode.SHELL_COMMANDS) {
                    shellCoordinator.onSessionStart()
                }
                if (mode == OverlayPanelMode.QUICK_LAUNCHER) {
                    quickLauncherController.onSessionStart()
                }
            }
            OverlayPanelMode.NONE -> {
                panelEnterAnimator.resetToComplete()
                if (gestureSession.isAdjustMode()) {
                    adjustPanelController.onSessionStartAdjustMode()
                }
            }
        }
        panelGridSession.reset()
        onSessionStartCallback()
        notifyPresentationTouchRequirementChanged()
        if (mode != OverlayPanelMode.NONE || gestureSession.isAdjustMode()) {
            gestureAnimationCoordinator.onSessionStartDismissIfNeeded()
        }
        if (mode != OverlayPanelMode.NONE) {
            runAfterLayout {
                if (gestureSession.panelMode() != mode) return@runAfterLayout
                syncZoneLayout()
                if (mode == OverlayPanelMode.TASK_SWITCHER) {
                    taskSwitcherController.onLayoutReady()
                }
                if (mode == OverlayPanelMode.QUICK_LAUNCHER) {
                    quickLauncherController.onLayoutReady()
                }
                panelEnterAnimator.startEnter(
                    panelMode = mode,
                    onShellEnterEnded = { shellCoordinator.onPanelEnterAnimationEnded() },
                    onQuickLauncherEnterEnded = { quickLauncherController.onPanelEnterAnimationEnded() },
                )
            }
        }
    }

    override fun onSessionEnd() {
        panelEnterAnimator.cancel()
        gestureAnimationCoordinator.hide()
        adjustPanelController.onSessionEnd()
        panelEnterAnimator.resetToComplete()
        syncZoneLayout()
        panelGridSession.reset()
        taskSwitcherController.onSessionEnd()
        quickLauncherController.onSessionEnd()
        shellCoordinator.onSessionEnd()
        notifyOverlayLayoutIfNeeded()
        notifyPresentationTouchRequirementChanged()
    }

    override fun onRequestInvalidate() = invalidate()

    private fun syncZoneLayout() {
        val screenH = resources.displayMetrics.heightPixels.coerceAtLeast(1)
        val screenW = resources.displayMetrics.widthPixels.coerceAtLeast(1)
        zoneLayout.update(
            settings = settings,
            viewWidth = screenW,
            viewHeight = screenH,
            density = resources.displayMetrics.density,
            sessionActive = gestureSession.isActive(),
            previewMode = previewMode,
            layoutHeight = screenH,
            windowOffsetY = 0f,
            screenWidthPx = screenW,
            screenHeightPx = screenH,
        )
    }

    private fun forEachGesturePoint(
        event: MotionEvent,
        localX: Float,
        localY: Float,
        includeHistory: Boolean,
        block: (rawX: Float, rawY: Float, localX: Float, localY: Float) -> Unit,
    ) {
        if (includeHistory) {
            val rawOffsetX = event.rawX - event.x
            val rawOffsetY = event.rawY - event.y
            for (i in 0 until event.historySize) {
                val rawX = event.getHistoricalX(i) + rawOffsetX
                val rawY = event.getHistoricalY(i) + rawOffsetY
                val (lx, ly) = rawToLocal(rawX, rawY)
                block(rawX, rawY, lx, ly)
            }
        }
        block(event.rawX, event.rawY, localX, localY)
    }

    private fun rawToLocal(rawX: Float, rawY: Float): Pair<Float, Float> {
        val loc = IntArray(2)
        getLocationOnScreen(loc)
        return rawX - loc[0] to rawY - loc[1]
    }

    private fun iconFor(app: AppInfo): Bitmap =
        iconCache.getOrPut(app.packageName) {
            val size = iconSizePx.toInt().coerceAtLeast(1)
            val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            val drawable = app.icon.constantState?.newDrawable()?.mutate() ?: app.icon.mutate()
            drawable.setBounds(0, 0, size, size)
            drawable.draw(canvas)
            bitmap
        }

    private fun dp(value: Float): Float = value * resources.displayMetrics.density
    private fun sp(value: Float): Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, resources.displayMetrics)
}
