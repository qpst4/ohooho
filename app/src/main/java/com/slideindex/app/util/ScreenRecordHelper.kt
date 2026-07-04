package com.slideindex.app.util

import android.content.Context
import com.slideindex.app.service.ScreenCapturePermissionActivity
import com.slideindex.app.service.ScreenRecordService

/** Coordinates in-app screen recording via MediaProjection + [ScreenRecordService]. */
object ScreenRecordHelper {
    val isRecording: Boolean
        get() = ScreenRecordService.isRecording

    /**
     * Toggles recording. Starting launches the system capture-consent UI; stopping ends the service.
     * @return true when an action was dispatched.
     */
    fun toggle(context: Context): Boolean {
        val appContext = context.applicationContext
        return if (isRecording) {
            ScreenRecordService.stop(appContext)
            true
        } else {
            appContext.startActivity(ScreenCapturePermissionActivity.createIntent(appContext))
            true
        }
    }
}
