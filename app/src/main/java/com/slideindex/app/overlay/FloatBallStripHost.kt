package com.slideindex.app.overlay

import android.annotation.SuppressLint
import android.content.Context
import android.view.MotionEvent
import android.widget.FrameLayout

/**
 * Host for the float-ball strip that intercepts all touches before Compose can consume them.
 */
@SuppressLint("ViewConstructor")
internal class FloatBallStripHost(context: Context) : FrameLayout(context) {
    private var onDragStart: ((screenX: Float, screenY: Float) -> Unit)? = null
    private var onDrag: ((dx: Float, dy: Float) -> Unit)? = null
    private var onDragEnd: (() -> Unit)? = null
    private var onDragCancel: (() -> Unit)? = null

    private var dragging = false
    private var lastRawX = 0f
    private var lastRawY = 0f

    fun bindDragCallbacks(
        onDragStart: (screenX: Float, screenY: Float) -> Unit,
        onDrag: (dx: Float, dy: Float) -> Unit,
        onDragEnd: () -> Unit,
        onDragCancel: () -> Unit,
    ) {
        this.onDragStart = onDragStart
        this.onDrag = onDrag
        this.onDragEnd = onDragEnd
        this.onDragCancel = onDragCancel
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean = true

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                dragging = true
                lastRawX = event.rawX
                lastRawY = event.rawY
                onDragStart?.invoke(event.rawX, event.rawY)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                if (!dragging) return false
                val dx = event.rawX - lastRawX
                val dy = event.rawY - lastRawY
                lastRawX = event.rawX
                lastRawY = event.rawY
                onDrag?.invoke(dx, dy)
                return true
            }
            MotionEvent.ACTION_UP -> {
                if (!dragging) return false
                dragging = false
                onDragEnd?.invoke()
                return true
            }
            MotionEvent.ACTION_CANCEL -> {
                if (!dragging) return false
                dragging = false
                onDragCancel?.invoke()
                return true
            }
        }
        return false
    }
}
