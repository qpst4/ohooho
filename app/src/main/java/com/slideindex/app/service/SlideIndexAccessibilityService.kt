package com.slideindex.app.service

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import com.slideindex.app.gesture.GestureAction

class SlideIndexAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) = Unit

    override fun onInterrupt() = Unit

    companion object {
        @Volatile
        private var instance: SlideIndexAccessibilityService? = null

        fun perform(action: GestureAction): Boolean {
            val service = instance ?: return false
            val globalAction = when (action) {
                GestureAction.Back -> GLOBAL_ACTION_BACK
                GestureAction.Home -> GLOBAL_ACTION_HOME
                GestureAction.Recents -> GLOBAL_ACTION_RECENTS
                else -> return false
            }
            return service.performGlobalAction(globalAction)
        }
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
    }

    override fun onDestroy() {
        instance = null
        super.onDestroy()
    }
}
