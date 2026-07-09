package com.slideindex.app.ui.viewmodel

import com.slideindex.app.ui.navigation.MainNavContext

class MainNavHomeEffects(
    private val ctx: MainNavContext,
) : HomeScreenEffects {
    override fun refreshServiceState() = ctx.refreshServiceState()

    override fun requestNotificationPermission() = ctx.requestNotificationPermission()

    override fun requestShizuku() = ctx.requestShizuku()

    override fun openAccessibilitySettings() = ctx.openAccessibilitySettings()

    override fun previewHaptic(enabled: Boolean, strengthLevel: Int?) {
        ctx.previewHaptic(enabled, strengthLevel)
    }
}
