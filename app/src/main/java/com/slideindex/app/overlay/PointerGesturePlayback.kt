package com.slideindex.app.overlay

import android.os.Handler
import android.os.Looper
import com.slideindex.app.gesture.PointerGesturePoint
import com.slideindex.app.gesture.PointerGestureRecording
import com.slideindex.app.util.InputTapUtil

object PointerGesturePlayback {
    private val mainHandler = Handler(Looper.getMainLooper())

    fun play(
        recording: PointerGestureRecording,
        onFinished: (Boolean) -> Unit = {},
    ) {
        val points = recording.points
        if (points.isEmpty()) {
            onFinished(false)
            return
        }
        FloatingPointerOverlayWindow.prepareGesturePlaybackPreview(points)
        playPoint(points, index = 0, onFinished = onFinished)
    }

    private fun playPoint(
        points: List<PointerGesturePoint>,
        index: Int,
        onFinished: (Boolean) -> Unit,
    ) {
        val point = points[index]
        FloatingPointerOverlayWindow.showGesturePlaybackPoint(point.x, point.y)
        InputTapUtil.dispatchPointerTapAsync(point.x, point.y) { success ->
            if (!success) {
                FloatingPointerOverlayWindow.clearGesturePlaybackPreview()
                onFinished(false)
                return@dispatchPointerTapAsync
            }
            val nextIndex = index + 1
            if (nextIndex >= points.size) {
                mainHandler.postDelayed(
                    { FloatingPointerOverlayWindow.clearGesturePlaybackPreview() },
                    PLAYBACK_TRAIL_HOLD_MS,
                )
                onFinished(true)
                return@dispatchPointerTapAsync
            }
            val delayMs = (points[nextIndex].offsetMs - point.offsetMs).coerceAtLeast(16L)
            mainHandler.postDelayed({
                playPoint(points, nextIndex, onFinished)
            }, delayMs)
        }
    }

    private const val PLAYBACK_TRAIL_HOLD_MS = 900L
}
