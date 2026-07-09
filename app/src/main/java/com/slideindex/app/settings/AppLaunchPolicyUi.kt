package com.slideindex.app.settings

import com.slideindex.app.R

val AppLaunchPolicy.titleRes: Int
    get() = when (this) {
        AppLaunchPolicy.ALWAYS_FULLSCREEN -> R.string.launch_policy_always_fullscreen
        AppLaunchPolicy.ALWAYS_FREE_WINDOW -> R.string.launch_policy_always_free_window
        AppLaunchPolicy.FULLSCREEN_LONG_PRESS_FREE_WINDOW -> R.string.launch_policy_fullscreen_long_press_free_window
        AppLaunchPolicy.FREE_WINDOW_LONG_PRESS_FULLSCREEN -> R.string.launch_policy_free_window_long_press_fullscreen
    }

val AppLaunchPolicy.descRes: Int
    get() = when (this) {
        AppLaunchPolicy.ALWAYS_FULLSCREEN -> R.string.launch_policy_always_fullscreen_desc
        AppLaunchPolicy.ALWAYS_FREE_WINDOW -> R.string.launch_policy_always_free_window_desc
        AppLaunchPolicy.FULLSCREEN_LONG_PRESS_FREE_WINDOW -> R.string.launch_policy_fullscreen_long_press_free_window_desc
        AppLaunchPolicy.FREE_WINDOW_LONG_PRESS_FULLSCREEN -> R.string.launch_policy_free_window_long_press_fullscreen_desc
    }
