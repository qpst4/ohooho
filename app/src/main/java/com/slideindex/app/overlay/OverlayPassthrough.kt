package com.slideindex.app.overlay

import android.os.Handler
import android.os.Looper
import android.view.Choreographer
import com.slideindex.app.util.InputTapUtil

/**
 * fv-style passthrough: detach trigger overlays → inject tap → restore.
 */
object OverlayPassthrough {
    private val mainHandler = Handler(Looper.getMainLooper())

    fun run(
        hideTriggers: () -> Unit,
        showTriggers: () -> Unit,
        rawX: Float,
        rawY: Float,
        onComplete: () -> Unit,
        framesBeforeInject: Int = DEFAULT_FRAMES_BEFORE_INJECT,
        restoreDelayMs: Long = DEFAULT_RESTORE_DELAY_MS,
        /** When false, inject asynchronously and restore without waiting for gesture completion. */
        waitForInjection: Boolean = true,
    ) {
        hideTriggers()
        val scheduleInject = {
            runAfterNextFrames(frames = framesBeforeInject) {
                val restore = {
                    showTriggers()
                    onComplete()
                }
                if (waitForInjection) {
                    Thread {
                        InputTapUtil.dispatchTap(rawX, rawY)
                        if (restoreDelayMs <= 0L) {
                            mainHandler.post(restore)
                        } else {
                            mainHandler.postDelayed(restore, restoreDelayMs)
                        }
                    }.start()
                } else {
                    InputTapUtil.dispatchTapAsync(rawX, rawY, onFinished = { _ ->
                        if (restoreDelayMs <= 0L) {
                            mainHandler.post(restore)
                        } else {
                            mainHandler.postDelayed(restore, restoreDelayMs)
                        }
                    })
                }
            }
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            scheduleInject()
        } else {
            mainHandler.post(scheduleInject)
        }
    }

    private fun runAfterNextFrames(frames: Int, action: () -> Unit) {
        if (frames <= 0) {
            action()
            return
        }
        Choreographer.getInstance().postFrameCallback {
            runAfterNextFrames(frames - 1, action)
        }
    }

    private const val DEFAULT_FRAMES_BEFORE_INJECT = 2
    private const val DEFAULT_RESTORE_DELAY_MS = 150L
}
