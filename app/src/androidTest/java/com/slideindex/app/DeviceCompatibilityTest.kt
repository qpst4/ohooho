package com.slideindex.app

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.slideindex.app.util.PermissionHelper
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DeviceCompatibilityTest {
    @Test
    fun permissionHelpers_doNotCrashOnCurrentDevice() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        assertNotNull(PermissionHelper.canDrawOverlays(context))
        assertNotNull(PermissionHelper.hasNotificationPermission(context))
        assertNotNull(PermissionHelper.isAccessibilityServiceEnabled(context))
        assertNotNull(PermissionHelper.isBatteryOptimizationExempt(context))
        assertNotNull(PermissionHelper.hasUsageAccess(context))
        assertNotNull(PermissionHelper.canWriteSettings(context))
        assertNotNull(PermissionHelper.hasNotificationPolicyAccess(context))
    }

    @Test
    fun overlaySettingsIntent_isResolvable() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = PermissionHelper.overlaySettingsIntent(context)
        val resolved = context.packageManager.resolveActivity(intent, 0)
        assertNotNull(resolved)
    }
}
