package com.slideindex.app.gesture

import com.slideindex.app.util.AppShortcutLoader

fun launchShortcutFromCreated(created: AppShortcutLoader.CreatedShortcut): GestureAction.LaunchShortcut {
    created.intentUri?.let { uri ->
        return GestureAction.LaunchShortcut.intent(uri, created.label)
    }
    val component = created.componentFlat
        ?: error("CreatedShortcut missing component and intent")
    return GestureAction.LaunchShortcut.component(component, created.label)
}
