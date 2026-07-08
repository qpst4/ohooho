package com.slideindex.app.overlay

import android.content.Context
import com.slideindex.app.service.SlideIndexAccessibilityService
import com.slideindex.app.util.PermissionHelper

/**
 * Resolves a [Context] suitable for message reminder overlays.
 * Prefers the accessibility service when connected; otherwise falls back to the app
 * context when [PermissionHelper.canDrawOverlays] is granted.
 */
object MessageOverlayHost {
    fun resolveHostContext(context: Context): Context? {
        SlideIndexAccessibilityService.overlayHostContext()?.let { return it }
        val appContext = context.applicationContext
        return if (PermissionHelper.canDrawOverlays(appContext)) appContext else null
    }

    fun canShow(context: Context): Boolean = resolveHostContext(context) != null
}
