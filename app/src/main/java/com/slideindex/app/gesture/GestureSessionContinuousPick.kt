package com.slideindex.app.gesture

internal class GestureSessionContinuousPick {
    var taskSwitcher = false
    var quickLauncher = false
    var shell = false

    fun taskSwitcherActive(): Boolean = taskSwitcher

    fun quickLauncherActive(): Boolean = quickLauncher

    fun shellActive(): Boolean = shell

    fun clearQuickLauncher() {
        quickLauncher = false
    }

    fun clearShell() {
        shell = false
    }

    fun reset() {
        taskSwitcher = false
        quickLauncher = false
        shell = false
    }
}
