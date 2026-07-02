package com.slideindex.app.overlay

import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.max

/**
 * Pure animation state for a Pixel/Android Q style back gesture affordance.
 *
 * Drag updates follow the finger immediately on Y, while X size and release/cancel
 * transitions are smoothed with a small damped spring integrator.
 */
class PixelBackGestureAnimationState(
    density: Float,
) {
    enum class Phase {
        IDLE,
        DRAGGING,
        RELEASING,
        CANCELING,
    }

    data class Metrics(
        val heightPx: Float,
        val minWidthPx: Float,
        val maxWidthPx: Float,
        val triggerThresholdPx: Float,
        val arrowReleaseDistancePx: Float,
    )

    data class Snapshot(
        val phase: Phase,
        val centerY: Float,
        val widthPx: Float,
        val alpha: Float,
        val arrowCenterOffsetPx: Float,
        val arrowReleaseOffsetPx: Float,
        val triggerProgress: Float,
        val isTriggerReady: Boolean,
    ) {
        val isVisible: Boolean
            get() = alpha > 0.01f && widthPx > 0.5f
    }

    private data class SpringResult(
        val value: Float,
        val velocity: Float,
    )

    var metrics: Metrics = defaultMetrics(density)
        private set

    private var phase = Phase.IDLE
    private var centerY = 0f
    private var inwardPx = 0f
    private var widthPx = 0f
    private var widthVelocity = 0f
    private var widthTargetPx = 0f
    private var alpha = 0f
    private var alphaVelocity = 0f
    private var alphaTarget = 0f
    private var arrowCenterOffsetPx = 0f
    private var arrowCenterVelocity = 0f
    private var arrowCenterTargetPx = 0f
    private var arrowReleaseOffsetPx = 0f
    private var arrowReleaseVelocity = 0f
    private var arrowReleaseTargetPx = 0f

    fun updateMetrics(metrics: Metrics) {
        this.metrics = metrics.sanitized()
        if (phase == Phase.IDLE) {
            reset()
        }
    }

    fun start(centerY: Float) {
        this.centerY = centerY
        phase = Phase.DRAGGING
        inwardPx = 0f
        widthTargetPx = 0f
        alphaTarget = 0f
        arrowCenterTargetPx = 0f
        arrowReleaseTargetPx = 0f
        arrowReleaseOffsetPx = 0f
        arrowReleaseVelocity = 0f
    }

    fun drag(centerY: Float, inwardPx: Float) {
        this.centerY = centerY
        this.inwardPx = inwardPx.coerceAtLeast(0f)
        phase = Phase.DRAGGING

        val pull = this.inwardPx
        widthTargetPx = targetWidthForPull(pull)
        alphaTarget = (pull / (metrics.heightPx * 0.42f)).coerceIn(0f, 1f)
        arrowCenterTargetPx = targetArrowOffsetForWidth(widthTargetPx)
        arrowReleaseTargetPx = 0f
    }

    fun release() {
        if (phase == Phase.IDLE) return
        phase = Phase.RELEASING
        widthTargetPx = max(widthPx, metrics.minWidthPx) + metrics.heightPx * 0.08f
        alphaTarget = 0f
        arrowCenterTargetPx = targetArrowOffsetForWidth(max(widthTargetPx, metrics.minWidthPx))
        arrowReleaseTargetPx = metrics.arrowReleaseDistancePx
    }

    fun cancel() {
        if (phase == Phase.IDLE) return
        phase = Phase.CANCELING
        inwardPx = 0f
        widthTargetPx = 0f
        alphaTarget = 0f
        arrowCenterTargetPx = 0f
        arrowReleaseTargetPx = 0f
    }

    fun isTriggerReady(): Boolean = inwardPx >= metrics.triggerThresholdPx

    fun snapshot(): Snapshot {
        val threshold = metrics.triggerThresholdPx.coerceAtLeast(1f)
        return Snapshot(
            phase = phase,
            centerY = centerY,
            widthPx = widthPx.coerceAtLeast(0f),
            alpha = alpha.coerceIn(0f, 1f),
            arrowCenterOffsetPx = arrowCenterOffsetPx.coerceAtLeast(0f),
            arrowReleaseOffsetPx = arrowReleaseOffsetPx.coerceAtLeast(0f),
            triggerProgress = (inwardPx / threshold).coerceIn(0f, 1f),
            isTriggerReady = isTriggerReady(),
        )
    }

    fun step(deltaSeconds: Float): Boolean {
        if (phase == Phase.IDLE) return false
        val dt = deltaSeconds.coerceIn(MIN_FRAME_SECONDS, MAX_FRAME_SECONDS)
        val width = spring(
            current = widthPx,
            target = widthTargetPx,
            velocity = widthVelocity,
            deltaSeconds = dt,
            stiffness = WIDTH_STIFFNESS,
            damping = WIDTH_DAMPING,
        )
        widthPx = width.value
        widthVelocity = width.velocity

        val nextAlpha = spring(
            current = alpha,
            target = alphaTarget,
            velocity = alphaVelocity,
            deltaSeconds = dt,
            stiffness = ALPHA_STIFFNESS,
            damping = ALPHA_DAMPING,
        )
        alpha = nextAlpha.value
        alphaVelocity = nextAlpha.velocity

        val arrowCenter = spring(
            current = arrowCenterOffsetPx,
            target = arrowCenterTargetPx,
            velocity = arrowCenterVelocity,
            deltaSeconds = dt,
            stiffness = ARROW_STIFFNESS,
            damping = ARROW_DAMPING,
        )
        arrowCenterOffsetPx = arrowCenter.value
        arrowCenterVelocity = arrowCenter.velocity

        val arrowRelease = spring(
            current = arrowReleaseOffsetPx,
            target = arrowReleaseTargetPx,
            velocity = arrowReleaseVelocity,
            deltaSeconds = dt,
            stiffness = RELEASE_STIFFNESS,
            damping = RELEASE_DAMPING,
        )
        arrowReleaseOffsetPx = arrowRelease.value
        arrowReleaseVelocity = arrowRelease.velocity

        if ((phase == Phase.RELEASING || phase == Phase.CANCELING) && isSettled()) {
            reset()
            return false
        }
        return true
    }

    fun reset() {
        phase = Phase.IDLE
        centerY = 0f
        inwardPx = 0f
        widthPx = 0f
        widthVelocity = 0f
        widthTargetPx = 0f
        alpha = 0f
        alphaVelocity = 0f
        alphaTarget = 0f
        arrowCenterOffsetPx = 0f
        arrowCenterVelocity = 0f
        arrowCenterTargetPx = 0f
        arrowReleaseOffsetPx = 0f
        arrowReleaseVelocity = 0f
        arrowReleaseTargetPx = 0f
    }

    private fun targetWidthForPull(pull: Float): Float {
        if (pull <= 0.5f) return 0f
        val threshold = metrics.triggerThresholdPx.coerceAtLeast(1f)
        val linear = (pull / threshold).coerceIn(0f, 1f)
        val overscroll = if (pull <= threshold) {
            linear
        } else {
            1f + (1f - exp(-((pull - threshold) / threshold) * 0.9f)) * 0.16f
        }
        val range = metrics.maxWidthPx - metrics.minWidthPx
        return (metrics.minWidthPx + range * overscroll).coerceIn(0f, metrics.maxWidthPx + range * 0.16f)
    }

    private fun targetArrowOffsetForWidth(width: Float): Float {
        if (width <= 0f) return 0f
        val lowerBound = metrics.heightPx * 0.38f
        val upperBound = max(lowerBound, width - metrics.heightPx * 0.24f)
        return (width * 0.58f + (width - metrics.minWidthPx).coerceAtLeast(0f) * 0.18f)
            .coerceIn(lowerBound, upperBound)
    }

    private fun isSettled(): Boolean {
        return abs(widthPx - widthTargetPx) < SETTLE_EPSILON &&
            abs(widthVelocity) < SETTLE_VELOCITY &&
            abs(alpha - alphaTarget) < 0.01f &&
            abs(alphaVelocity) < SETTLE_ALPHA_VELOCITY &&
            abs(arrowCenterOffsetPx - arrowCenterTargetPx) < SETTLE_EPSILON &&
            abs(arrowReleaseOffsetPx - arrowReleaseTargetPx) < SETTLE_EPSILON &&
            abs(arrowReleaseVelocity) < SETTLE_VELOCITY
    }

    private fun spring(
        current: Float,
        target: Float,
        velocity: Float,
        deltaSeconds: Float,
        stiffness: Float,
        damping: Float,
    ): SpringResult {
        val displacement = current - target
        val acceleration = -stiffness * displacement - damping * velocity
        val nextVelocity = velocity + acceleration * deltaSeconds
        return SpringResult(
            value = current + nextVelocity * deltaSeconds,
            velocity = nextVelocity,
        )
    }

    private fun Metrics.sanitized(): Metrics {
        val height = heightPx.coerceAtLeast(1f)
        val minWidth = minWidthPx.coerceAtLeast(height * 0.5f)
        val maxWidth = maxWidthPx.coerceAtLeast(minWidth)
        return copy(
            heightPx = height,
            minWidthPx = minWidth,
            maxWidthPx = maxWidth,
            triggerThresholdPx = triggerThresholdPx.coerceAtLeast(1f),
            arrowReleaseDistancePx = arrowReleaseDistancePx.coerceAtLeast(height),
        )
    }

    companion object {
        private const val MIN_FRAME_SECONDS = 0.001f
        private const val MAX_FRAME_SECONDS = 0.032f
        private const val WIDTH_STIFFNESS = 620f
        private const val WIDTH_DAMPING = 38f
        private const val ARROW_STIFFNESS = 780f
        private const val ARROW_DAMPING = 42f
        private const val RELEASE_STIFFNESS = 520f
        private const val RELEASE_DAMPING = 28f
        private const val ALPHA_STIFFNESS = 520f
        private const val ALPHA_DAMPING = 34f
        private const val SETTLE_EPSILON = 0.65f
        private const val SETTLE_VELOCITY = 4f
        private const val SETTLE_ALPHA_VELOCITY = 0.04f

        fun defaultMetrics(density: Float): Metrics {
            return Metrics(
                heightPx = 52f * density,
                minWidthPx = 34f * density,
                maxWidthPx = 64f * density,
                triggerThresholdPx = 60f * density,
                arrowReleaseDistancePx = 72f * density,
            )
        }
    }
}
