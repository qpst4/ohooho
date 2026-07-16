package com.slideindex.app.util

import android.content.Context
import android.graphics.Bitmap
import android.os.SystemClock
import android.widget.Toast
import com.slideindex.app.R
import com.slideindex.app.perf.PickPerf
import com.slideindex.app.service.ScreenCapturePermissionActivity
import com.slideindex.app.service.ScreenCaptureService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/** MediaProjection-based screen capture for float-ball regional picks. */
object ScreenCaptureHelper {
    private const val REQUEST_DEBOUNCE_MS = 3_000L

    @Volatile
    private var lastRequestUptimeMs = 0L

    val sessionActive: Boolean
        get() = ScreenCaptureService.sessionActive

    /** Start capture service when consent was already granted (incl. ADB). */
    fun ensureSessionIfAuthorized(context: Context) {
        if (ScreenCaptureService.sessionActive) return
        val stored = MediaProjectionStore.read(context) ?: return
        ScreenCaptureService.start(context, stored.resultCode, stored.data)
    }

    suspend fun captureDisplayBitmap(context: Context): Bitmap? {
        val start = SystemClock.elapsedRealtime()
        val appContext = context.applicationContext
        PickPerf.mark("screenCapture_helper_start", "sessionActive=${ScreenCaptureService.sessionActive}")
        if (!ScreenCaptureService.sessionActive) {
            requestSession(appContext)
            PickPerf.markStepDuration("screenCapture_helper_end", start, "no_session")
            return null
        }
        val bitmap = ScreenCaptureService.captureDisplayBitmap(appContext)
        PickPerf.markStepDuration("screenCapture_helper_end", start, "bitmap=${bitmap != null}")
        return bitmap
    }

    suspend fun requestSession(context: Context) {
        val now = SystemClock.uptimeMillis()
        if (now - lastRequestUptimeMs < REQUEST_DEBOUNCE_MS) return
        lastRequestUptimeMs = now
        withContext(Dispatchers.Main.immediate) {
            val appContext = context.applicationContext
            Toast.makeText(appContext, R.string.screen_capture_permission_required, Toast.LENGTH_SHORT).show()
            appContext.startActivity(
                ScreenCapturePermissionActivity.createIntent(
                    context = appContext,
                    purpose = ScreenCapturePermissionActivity.Purpose.SCREEN_CAPTURE,
                ),
            )
        }
    }
}
