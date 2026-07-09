package com.slideindex.app.monitoring

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class PerformanceMonitorTest {
    @Test
    fun setEnabled_isIdempotentWhenDisabled() {
        PerformanceMonitor.setEnabled(false)
        PerformanceMonitor.setEnabled(false)
        assertFalse(PerformanceMonitor.instance.enabled)
    }

    @Test
    fun setEnabled_togglesState() {
        PerformanceMonitor.setEnabled(true)
        assertTrue(PerformanceMonitor.instance.enabled)
        PerformanceMonitor.setEnabled(false)
        assertFalse(PerformanceMonitor.instance.enabled)
    }
}