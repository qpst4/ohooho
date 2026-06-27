package com.slideindex.app.util

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.resolvedFreeWindowMode

object FreeWindowLauncher {
    private const val KEY_WINDOWING_MODE = "android.activity.windowingMode"

    fun launch(context: Context, intent: Intent, settings: AppSettings, fullscreen: Boolean) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (fullscreen || !settings.freeWindowEnabled) {
            context.startActivity(intent)
            return
        }

        val options = ActivityOptions.makeBasic()
        val mode = settings.resolvedFreeWindowMode().windowingMode
        applyWindowingMode(options, mode)

        val bounds = launchBounds(context, settings)
        options.setLaunchBounds(bounds)

        val bundle = options.toBundle() ?: Bundle()
        if (bundle.getInt(KEY_WINDOWING_MODE, -1) == -1) {
            bundle.putInt(KEY_WINDOWING_MODE, mode)
        }
        runCatching {
            context.startActivity(intent, bundle)
        }.onFailure { error ->
            android.util.Log.e("FreeWindowLauncher", "startActivity failed", error)
        }
    }

    fun launchBounds(context: Context, settings: AppSettings): Rect {
        val metrics = context.resources.displayMetrics
        val widthPx = (metrics.widthPixels * settings.freeWindowWidthFraction).toInt()
            .coerceAtLeast(1)
        val heightPx = (metrics.heightPixels * settings.freeWindowHeightFraction).toInt()
            .coerceAtLeast(1)
        val leftPx = (metrics.widthPixels * settings.freeWindowLeftFraction).toInt()
            .coerceIn(0, (metrics.widthPixels - widthPx).coerceAtLeast(0))
        val topPx = (metrics.heightPixels * settings.freeWindowTopFraction).toInt()
            .coerceIn(0, (metrics.heightPixels - heightPx).coerceAtLeast(0))
        return Rect(leftPx, topPx, leftPx + widthPx, topPx + heightPx)
    }

    private fun applyWindowingMode(options: ActivityOptions, mode: Int) {
        try {
            val method = ActivityOptions::class.java.getMethod(
                "setLaunchWindowingMode",
                Int::class.javaPrimitiveType,
            )
            method.invoke(options, mode)
        } catch (_: Exception) {
            // Hidden API unavailable; bundle fallback applied in launch().
        }
    }
}
