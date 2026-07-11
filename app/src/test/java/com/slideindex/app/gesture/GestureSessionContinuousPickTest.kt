package com.slideindex.app.gesture

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class GestureSessionContinuousPickTest {

    @Test
    fun initialFlags_areFalse() {
        val pick = GestureSessionContinuousPick()

        assertFalse(pick.taskSwitcherActive())
        assertFalse(pick.quickLauncherActive())
        assertFalse(pick.shellActive())
    }

    @Test
    fun reset_clearsAllFlags() {
        val pick = GestureSessionContinuousPick().apply {
            taskSwitcher = true
            quickLauncher = true
            shell = true
        }

        pick.reset()

        assertFalse(pick.taskSwitcherActive())
        assertFalse(pick.quickLauncherActive())
        assertFalse(pick.shellActive())
    }

    @Test
    fun clearQuickLauncher_onlyClearsQuickLauncher() {
        val pick = GestureSessionContinuousPick().apply {
            taskSwitcher = true
            quickLauncher = true
            shell = true
        }

        pick.clearQuickLauncher()

        assertTrue(pick.taskSwitcherActive())
        assertFalse(pick.quickLauncherActive())
        assertTrue(pick.shellActive())
    }

    @Test
    fun clearShell_onlyClearsShell() {
        val pick = GestureSessionContinuousPick().apply {
            taskSwitcher = true
            quickLauncher = true
            shell = true
        }

        pick.clearShell()

        assertTrue(pick.taskSwitcherActive())
        assertTrue(pick.quickLauncherActive())
        assertFalse(pick.shellActive())
    }
}
