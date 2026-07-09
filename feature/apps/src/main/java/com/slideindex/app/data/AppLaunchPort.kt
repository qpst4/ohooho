package com.slideindex.app.data

import android.content.Intent
import com.slideindex.app.settings.AppSettings

/** Launches intents with app-specific free-window / fullscreen policy. */
interface AppLaunchPort {
    fun launch(intent: Intent, settings: AppSettings, fullscreen: Boolean)
}
