package com.slideindex.app.overlay

import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import com.slideindex.app.settings.AppSettings
import kotlin.math.hypot

internal class FloatingPointerInputHandler(
    private val session: FloatingPointerSession,
    private val settingsProvider: () -> AppSettings,
    private val host: Host,
) {
    interface Host {
        fun captureAllPointers()
        fun releaseAllPointers()
        fun onJoystickPositionChanged(centerX: Float, centerY: Float)
        fun onGestureEnd(centerX: Float, centerY: Float, isTap: Boolean)
        fun onPointerClick(rawX: Float, rawY: Float)
        fun onOutsideDismissPrepare()
        fun onQuickSwipeDismiss()
        fun onDismiss()
        fun onRadialMenuOpened()
        fun onRadialMenuClosed()
        fun onRadialMenuAction(slotIndex: Int)
        fun onActivity()
        fun onHaptic()
        fun shouldDismissOnOutsideTouch(event: MotionEvent): Boolean
        fun onTouchCycleComplete()
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    internal var capturing = false
    private var movedBeyondTap = false
    private var longPressTriggered = false
    private var downRawX = 0f
    private var downRawY = 0f
    private var lastRawX = 0f
    private var lastRawY = 0f
    private var restJoystickX = 0f
    private var restJoystickY = 0f
    private var downTimeMs = 0L
    private var longPressRunnable: Runnable? = null

    /**
     * Starts joystick control from an in-flight edge gesture without waiting for a new
     * [MotionEvent.ACTION_DOWN] on this overlay.
     */
    fun beginContinuedGesture(rawX: Float, rawY: Float, downTimeMs: Long) {
        host.onActivity()
        capturing = true
        movedBeyondTap = true
        longPressTriggered = false
        downRawX = rawX
        downRawY = rawY
        this.downTimeMs = downTimeMs
        lastRawX = rawX
        lastRawY = rawY
        restJoystickX = session.joystickCenterX.floatValue
        restJoystickY = session.joystickCenterY.floatValue

        session.joystickActive.value = true
        session.pointerVisible.value = true
        session.beginGesture(rawX, rawY, settingsProvider())
        session.joystickCenterX.floatValue = rawX
        session.joystickCenterY.floatValue = rawY
        host.onJoystickPositionChanged(rawX, rawY)
        host.captureAllPointers()
    }

    /** Forwards MOVE/UP from the edge capture window while the trigger finger stays down. */
    fun forwardContinuedTouch(event: MotionEvent): Boolean {
        if (!capturing) return false
        return when (event.actionMasked) {
            MotionEvent.ACTION_MOVE -> handleTouch(event)
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                val handled = handleTouch(event)
                capturing = false
                handled
            }
            else -> false
        }
    }

    fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.actionMasked == MotionEvent.ACTION_OUTSIDE) {
            val settings = settingsProvider()
            if (settings.floatingPointerHideOnOutsideClick && host.shouldDismissOnOutsideTouch(event)) {
                host.onOutsideDismissPrepare()
            }
            return false
        }

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val handled = handleTouch(event)
                capturing = handled
                return handled
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                if (!capturing) return false
                val handled = handleTouch(event)
                capturing = false
                return handled
            }
            else -> {
                if (!capturing) return false
                return handleTouch(event)
            }
        }
    }

    private fun handleTouch(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                host.onActivity()
                movedBeyondTap = false
                longPressTriggered = false
                downRawX = event.rawX
                downRawY = event.rawY
                downTimeMs = System.currentTimeMillis()
                lastRawX = event.rawX
                lastRawY = event.rawY
                restJoystickX = session.joystickCenterX.floatValue
                restJoystickY = session.joystickCenterY.floatValue

                session.joystickActive.value = true
                session.pointerVisible.value = true
                session.beginGesture(event.rawX, event.rawY, settingsProvider())
                host.captureAllPointers()
                scheduleLongPress()
            }
            MotionEvent.ACTION_MOVE -> {
                host.onActivity()
                if (session.radialMenuActive.value) {
                    if (session.updateRadialHighlight(event.rawX, event.rawY, settingsProvider())) {
                        host.onHaptic()
                    }
                    lastRawX = event.rawX
                    lastRawY = event.rawY
                    return true
                }
                val totalDx = event.rawX - downRawX
                val totalDy = event.rawY - downRawY
                if (!movedBeyondTap &&
                    hypot(totalDx.toDouble(), totalDy.toDouble()) > session.tapSlopPx
                ) {
                    cancelLongPressJob()
                    movedBeyondTap = true
                }
                if (!movedBeyondTap) return true

                session.joystickCenterX.floatValue = event.rawX
                session.joystickCenterY.floatValue = event.rawY
                host.onJoystickPositionChanged(event.rawX, event.rawY)
                session.applyPointerFromTouch(event.rawX, event.rawY, settingsProvider())
                lastRawX = event.rawX
                lastRawY = event.rawY
            }
            MotionEvent.ACTION_UP -> {
                host.onActivity()
                cancelLongPressJob()
                host.releaseAllPointers()
                if (session.radialMenuActive.value) {
                    val slot = session.radialHighlightedSlot.intValue
                    session.closeRadialMenu()
                    host.onRadialMenuClosed()
                    session.joystickActive.value = false
                    host.onGestureEnd(restJoystickX, restJoystickY, false)
                    if (slot >= 0) {
                        host.onRadialMenuAction(slot)
                    }
                    host.onTouchCycleComplete()
                    return true
                }
                val settings = settingsProvider()
                val isTap = !movedBeyondTap && !longPressTriggered
                if (settings.floatingPointerHideWhenJoystickReleased && movedBeyondTap) {
                    session.pointerVisible.value = false
                    session.clearTrail()
                }
                session.joystickActive.value = false
                val endX = if (movedBeyondTap) event.rawX else restJoystickX
                val endY = if (movedBeyondTap) event.rawY else restJoystickY
                if (!movedBeyondTap) {
                    session.joystickCenterX.floatValue = restJoystickX
                    session.joystickCenterY.floatValue = restJoystickY
                } else {
                    host.onJoystickPositionChanged(endX, endY)
                }

                val elapsed = System.currentTimeMillis() - downTimeMs
                val swipeDistance = hypot(
                    (event.rawX - downRawX).toDouble(),
                    (event.rawY - downRawY).toDouble(),
                ).toFloat()
                if (settings.floatingPointerHideOnQuickSwipe &&
                    movedBeyondTap &&
                    swipeDistance >= QUICK_SWIPE_MIN_DISTANCE_PX &&
                    elapsed <= QUICK_SWIPE_MAX_DURATION_MS
                ) {
                    session.clearTrail()
                    host.onQuickSwipeDismiss()
                    host.onTouchCycleComplete()
                    return true
                }

                host.onGestureEnd(endX, endY, isTap)

                if (isTap) {
                    performPointerClick()
                }
                host.onTouchCycleComplete()
            }
            MotionEvent.ACTION_CANCEL -> {
                host.onActivity()
                cancelLongPressJob()
                host.releaseAllPointers()
                if (session.radialMenuActive.value) {
                    session.closeRadialMenu()
                    host.onRadialMenuClosed()
                }
                if (settingsProvider().floatingPointerHideWhenJoystickReleased && movedBeyondTap) {
                    session.pointerVisible.value = false
                    session.clearTrail()
                }
                session.joystickActive.value = false
                session.joystickCenterX.floatValue = restJoystickX
                session.joystickCenterY.floatValue = restJoystickY
                host.onGestureEnd(restJoystickX, restJoystickY, false)
                host.onTouchCycleComplete()
            }
        }
        return true
    }

    private fun performPointerClick() {
        cancelLongPressJob()
        val clickX = session.pointerX.floatValue
        val clickY = session.pointerY.floatValue
        val settings = settingsProvider()
        if (settings.floatingPointerClickHapticEnabled) {
            host.onHaptic()
        }
        if (settings.floatingPointerClickVisualFeedbackEnabled) {
            session.triggerRipple(clickX, clickY)
            session.triggerPointerClick()
            mainHandler.post { host.onPointerClick(clickX, clickY) }
        } else {
            session.triggerPointerClick()
            host.onPointerClick(clickX, clickY)
        }
    }

    private fun scheduleLongPress() {
        cancelLongPressJob()
        val settings = settingsProvider()
        if (!settings.floatingPointerRadialMenuEnabled) {
            val runnable = Runnable {
                if (!movedBeyondTap) {
                    longPressTriggered = true
                    session.joystickActive.value = false
                    mainHandler.post { host.onDismiss() }
                }
            }
            longPressRunnable = runnable
            mainHandler.postDelayed(runnable, LONG_PRESS_DISMISS_MS)
            return
        }
        val delayMs = settings.floatingPointerRadialLongPressMs.coerceIn(200, 2000).toLong()
        val runnable = Runnable {
            if (!movedBeyondTap && !session.radialMenuActive.value) {
                longPressTriggered = true
                host.onHaptic()
                session.openRadialMenu(restJoystickX, restJoystickY)
                host.onRadialMenuOpened()
                session.updateRadialHighlight(lastRawX, lastRawY, settingsProvider())
            }
        }
        longPressRunnable = runnable
        mainHandler.postDelayed(runnable, delayMs)
    }

    private fun cancelLongPressJob() {
        longPressRunnable?.let { mainHandler.removeCallbacks(it) }
        longPressRunnable = null
    }

    companion object {
        private const val LONG_PRESS_DISMISS_MS = 900L
        private const val QUICK_SWIPE_MIN_DISTANCE_PX = 240f
        private const val QUICK_SWIPE_MAX_DURATION_MS = 220L
    }
}
