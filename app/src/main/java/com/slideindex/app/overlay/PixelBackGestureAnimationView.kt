package com.slideindex.app.overlay

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Standalone Android Q+/Pixel style back gesture animation.
 *
 * Add this view above your content or overlay, then assign [onBackTriggered] to
 * perform the actual back action when the drag crosses [triggerThresholdPx].
 */
class PixelBackGestureAnimationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {
    var side: PanelSide = PanelSide.LEFT
        set(value) {
            field = value
            invalidate()
        }

    var containerColor: Int = DEFAULT_CONTAINER_COLOR
        set(value) {
            field = value
            invalidate()
        }

    var arrowColor: Int = Color.WHITE
        set(value) {
            field = value
            invalidate()
        }

    var triggerThresholdPx: Float = dp(DEFAULT_TRIGGER_THRESHOLD_DP)
        set(value) {
            field = value.coerceAtLeast(dp(24f))
            updateStateMetrics()
        }

    var edgeTouchWidthPx: Float = dp(DEFAULT_EDGE_TOUCH_WIDTH_DP)
        set(value) {
            field = value.coerceAtLeast(dp(8f))
        }

    var onBackTriggered: (() -> Unit)? = null

    private val animationState = PixelBackGestureAnimationState(resources.displayMetrics.density)
    private val capsuleRect = RectF()
    private val capsulePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }
    private val arrowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }
    private val arrowPath = Path()

    private var activePointerId = MotionEvent.INVALID_POINTER_ID
    private var tracking = false
    private var lastFrameNanos = 0L
    private var framePosted = false

    private val frameRunnable = object : Runnable {
        override fun run() {
            framePosted = false
            val now = System.nanoTime()
            val deltaSeconds = if (lastFrameNanos == 0L) {
                FRAME_SECONDS_60HZ
            } else {
                (now - lastFrameNanos) / NANOS_PER_SECOND
            }
            lastFrameNanos = now
            val needsMoreFrames = animationState.step(deltaSeconds)
            invalidate()
            if (needsMoreFrames || tracking) {
                postFrame()
            } else {
                lastFrameNanos = 0L
            }
        }
    }

    init {
        isClickable = false
        updateStateMetrics()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateStateMetrics()
    }

    override fun onDetachedFromWindow() {
        removeCallbacks(frameRunnable)
        framePosted = false
        tracking = false
        activePointerId = MotionEvent.INVALID_POINTER_ID
        animationState.reset()
        super.onDetachedFromWindow()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!isEnabled) return false
        return when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> handleDown(event)
            MotionEvent.ACTION_POINTER_UP -> handlePointerUp(event)
            MotionEvent.ACTION_MOVE -> handleMove(event)
            MotionEvent.ACTION_UP -> handleUp(event, canceled = false)
            MotionEvent.ACTION_CANCEL -> handleUp(event, canceled = true)
            else -> tracking
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val snapshot = animationState.snapshot()
        if (!snapshot.isVisible) return

        val metrics = animationState.metrics
        val halfHeight = metrics.heightPx / 2f
        val centerY = snapshot.centerY.coerceIn(halfHeight, height - halfHeight)
        val alpha = (snapshot.alpha * 255f).toInt().coerceIn(0, 255)

        capsulePaint.color = withAlpha(containerColor, alpha)
        arrowPaint.color = withAlpha(arrowColor, alpha)
        arrowPaint.strokeWidth = metrics.heightPx * 0.075f

        val visibleWidth = snapshot.widthPx.coerceAtLeast(0f)
        when (side) {
            PanelSide.LEFT -> capsuleRect.set(
                -halfHeight,
                centerY - halfHeight,
                visibleWidth,
                centerY + halfHeight,
            )
            PanelSide.RIGHT -> capsuleRect.set(
                width - visibleWidth,
                centerY - halfHeight,
                width + halfHeight,
                centerY + halfHeight,
            )
        }
        canvas.drawRoundRect(capsuleRect, halfHeight, halfHeight, capsulePaint)

        val inwardSign = if (side == PanelSide.LEFT) 1f else -1f
        val arrowBaseX = when (side) {
            PanelSide.LEFT -> snapshot.arrowCenterOffsetPx
            PanelSide.RIGHT -> width - snapshot.arrowCenterOffsetPx
        }
        val arrowCenterX = arrowBaseX + inwardSign * snapshot.arrowReleaseOffsetPx
        drawArrow(
            canvas = canvas,
            centerX = arrowCenterX,
            centerY = centerY,
            size = metrics.heightPx * 0.34f,
            pointsLeft = side == PanelSide.LEFT,
        )
    }

    fun setColors(containerColor: Int, arrowColor: Int = Color.WHITE) {
        this.containerColor = containerColor
        this.arrowColor = arrowColor
    }

    fun setDimensionsDp(
        heightDp: Float = DEFAULT_HEIGHT_DP,
        minWidthDp: Float = DEFAULT_MIN_WIDTH_DP,
        maxWidthDp: Float = DEFAULT_MAX_WIDTH_DP,
        triggerThresholdDp: Float = DEFAULT_TRIGGER_THRESHOLD_DP,
        arrowReleaseDistanceDp: Float = DEFAULT_ARROW_RELEASE_DISTANCE_DP,
    ) {
        triggerThresholdPx = dp(triggerThresholdDp)
        animationState.updateMetrics(
            PixelBackGestureAnimationState.Metrics(
                heightPx = dp(heightDp),
                minWidthPx = dp(minWidthDp),
                maxWidthPx = dp(maxWidthDp),
                triggerThresholdPx = dp(triggerThresholdDp),
                arrowReleaseDistancePx = dp(arrowReleaseDistanceDp),
            ),
        )
        invalidate()
    }

    private fun handleDown(event: MotionEvent): Boolean {
        if (!isInsideGestureEdge(event.x)) return false
        parent?.requestDisallowInterceptTouchEvent(true)
        tracking = true
        activePointerId = event.getPointerId(0)
        animationState.start(centerY = event.y)
        animationState.drag(centerY = event.y, inwardPx = inwardDistance(event.x))
        postFrame()
        invalidate()
        return true
    }

    private fun handleMove(event: MotionEvent): Boolean {
        if (!tracking) return false
        val pointerIndex = event.findPointerIndex(activePointerId)
        if (pointerIndex < 0) return false
        animationState.drag(
            centerY = event.getY(pointerIndex),
            inwardPx = inwardDistance(event.getX(pointerIndex)),
        )
        postFrame()
        invalidate()
        return true
    }

    private fun handlePointerUp(event: MotionEvent): Boolean {
        if (!tracking) return false
        val pointerIndex = event.actionIndex
        if (event.getPointerId(pointerIndex) != activePointerId) return true
        val nextIndex = if (pointerIndex == 0) 1 else 0
        if (nextIndex < event.pointerCount) {
            activePointerId = event.getPointerId(nextIndex)
            animationState.drag(
                centerY = event.getY(nextIndex),
                inwardPx = inwardDistance(event.getX(nextIndex)),
            )
            return true
        }
        return handleUp(event, canceled = true)
    }

    private fun handleUp(event: MotionEvent, canceled: Boolean): Boolean {
        if (!tracking) return false
        val pointerIndex = event.findPointerIndex(activePointerId).takeIf { it >= 0 } ?: 0
        if (event.pointerCount > pointerIndex) {
            animationState.drag(
                centerY = event.getY(pointerIndex),
                inwardPx = inwardDistance(event.getX(pointerIndex)),
            )
        }
        tracking = false
        activePointerId = MotionEvent.INVALID_POINTER_ID
        parent?.requestDisallowInterceptTouchEvent(false)

        if (!canceled && animationState.isTriggerReady()) {
            onBackTriggered?.invoke()
            animationState.release()
        } else {
            animationState.cancel()
        }
        postFrame()
        invalidate()
        return true
    }

    private fun drawArrow(
        canvas: Canvas,
        centerX: Float,
        centerY: Float,
        size: Float,
        pointsLeft: Boolean,
    ) {
        val direction = if (pointsLeft) -1f else 1f
        val half = size / 2f
        val tipX = centerX + direction * half
        val tailX = centerX - direction * half * 0.55f

        arrowPath.reset()
        arrowPath.moveTo(tailX, centerY - half)
        arrowPath.lineTo(tipX, centerY)
        arrowPath.lineTo(tailX, centerY + half)
        canvas.drawPath(arrowPath, arrowPaint)
    }

    private fun isInsideGestureEdge(x: Float): Boolean {
        return when (side) {
            PanelSide.LEFT -> x <= edgeTouchWidthPx
            PanelSide.RIGHT -> x >= width - edgeTouchWidthPx
        }
    }

    private fun inwardDistance(x: Float): Float {
        return when (side) {
            PanelSide.LEFT -> x
            PanelSide.RIGHT -> width - x
        }.coerceAtLeast(0f)
    }

    private fun postFrame() {
        if (framePosted) return
        framePosted = true
        postOnAnimation(frameRunnable)
    }

    private fun updateStateMetrics() {
        val default = PixelBackGestureAnimationState.defaultMetrics(resources.displayMetrics.density)
        animationState.updateMetrics(
            default.copy(
                triggerThresholdPx = triggerThresholdPx,
                arrowReleaseDistancePx = dp(DEFAULT_ARROW_RELEASE_DISTANCE_DP),
            ),
        )
    }

    private fun withAlpha(color: Int, alpha: Int): Int {
        val colorAlpha = Color.alpha(color)
        val resolvedAlpha = ((colorAlpha / 255f) * alpha).toInt().coerceIn(0, 255)
        return Color.argb(resolvedAlpha, Color.red(color), Color.green(color), Color.blue(color))
    }

    private fun dp(value: Float): Float = value * resources.displayMetrics.density

    companion object {
        private const val DEFAULT_HEIGHT_DP = 52f
        private const val DEFAULT_MIN_WIDTH_DP = 34f
        private const val DEFAULT_MAX_WIDTH_DP = 64f
        private const val DEFAULT_TRIGGER_THRESHOLD_DP = 60f
        private const val DEFAULT_ARROW_RELEASE_DISTANCE_DP = 72f
        private const val DEFAULT_EDGE_TOUCH_WIDTH_DP = 32f
        private const val DEFAULT_CONTAINER_COLOR = 0xE61E1B2E.toInt()
        private const val FRAME_SECONDS_60HZ = 1f / 60f
        private const val NANOS_PER_SECOND = 1_000_000_000f
    }
}
