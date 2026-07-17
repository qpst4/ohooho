package com.slideindex.app.search

import android.content.Intent
import android.util.Log
import com.slideindex.app.util.TaskManagerUtil

/**
 * Launch non-exported activities via Shizuku `am start`.
 *
 * Normal [Context.startActivity] cannot open these components (Permission Denial);
 * shell with Shizuku is required, same as QuickShortcut / SearchEVO Shizuku mode.
 */
object NonExportedActivityLauncher {
    private const val TAG = "NonExportedActivityLauncher"

    fun launch(packageName: String, activityName: String): Boolean {
        if (packageName.isBlank() || activityName.isBlank()) return false
        if (!TaskManagerUtil.hasPermission()) {
            Log.w(TAG, "Shizuku permission missing for $packageName/$activityName")
            return false
        }
        val component = "$packageName/$activityName"
        val started = TaskManagerUtil.runShellCommand(
            "am",
            "start",
            "-n",
            component,
            "-f",
            "0x${Integer.toHexString(Intent.FLAG_ACTIVITY_NEW_TASK)}",
        )
        if (started) {
            Log.i(TAG, "launched via Shizuku: $component")
        } else {
            Log.w(TAG, "Shizuku am start failed: $component")
        }
        return started
    }
}
