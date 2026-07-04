package com.slideindex.app.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Shortcut
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.Assistant
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Brightness6
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.CropFree
import androidx.compose.material.icons.filled.DoNotDisturb
import androidx.compose.material.icons.filled.FlashlightOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material.icons.filled.Screenshot
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SignalCellularAlt
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.slideindex.app.gesture.GestureAction
import com.slideindex.app.gesture.GestureActionType
import com.slideindex.app.overlay.OhoPanelIcons

fun gestureActionImageVector(action: GestureAction): ImageVector = when (action) {
    is GestureAction.LaunchApp -> Icons.Default.Apps
    is GestureAction.LaunchShortcut -> Icons.AutoMirrored.Filled.Shortcut
    else -> gestureActionTypeIcon(action.type)
}

@Composable
fun gestureActionIcon(action: GestureAction): ImageVector = gestureActionImageVector(action)

fun gestureActionTypeIcon(type: GestureActionType): ImageVector = when (type) {
    GestureActionType.NONE -> Icons.Default.Block
    GestureActionType.OPEN_INDEX -> Icons.Default.SortByAlpha
    GestureActionType.QUICK_LAUNCHER -> Icons.Default.Apps
    GestureActionType.TASK_SWITCHER -> Icons.Default.ViewCarousel
    GestureActionType.SHELL_COMMAND_PANEL -> Icons.Default.Code
    GestureActionType.QUICK_TOOLS_OVERLAY -> Icons.Default.Tune
    GestureActionType.BACK -> Icons.AutoMirrored.Filled.ArrowBack
    GestureActionType.HOME -> Icons.Default.Home
    GestureActionType.RECENTS -> Icons.Default.Layers
    GestureActionType.CLOSE_CURRENT_APP -> Icons.Default.Close
    GestureActionType.FREE_WINDOW_CURRENT_APP -> Icons.Default.CropFree
    GestureActionType.CLICK_PASSTHROUGH -> Icons.Default.TouchApp
    GestureActionType.FLASHLIGHT -> Icons.Default.FlashlightOn
    GestureActionType.ADJUST_VOLUME -> Icons.AutoMirrored.Filled.VolumeUp
    GestureActionType.ADJUST_BRIGHTNESS -> Icons.Default.Brightness6
    GestureActionType.LAUNCH_ASSISTANT -> Icons.Default.Assistant
    GestureActionType.TOGGLE_MUTE -> Icons.Default.VolumeOff
    GestureActionType.MEDIA_PLAY_PAUSE -> Icons.Default.PlayArrow
    GestureActionType.MEDIA_PREVIOUS -> Icons.Default.SkipPrevious
    GestureActionType.MEDIA_NEXT -> Icons.Default.SkipNext
    GestureActionType.PREVIOUS_APP -> Icons.Default.Restore
    GestureActionType.OPEN_NOTIFICATIONS -> Icons.Default.Notifications
    GestureActionType.OPEN_QUICK_SETTINGS -> Icons.Default.Settings
    GestureActionType.LOCK_SCREEN -> Icons.Default.Lock
    GestureActionType.SCREENSHOT -> Icons.Default.Screenshot
    GestureActionType.POWER_MENU -> Icons.Default.PowerSettingsNew
    GestureActionType.KEEP_SCREEN_ON -> Icons.Default.WbSunny
    GestureActionType.SCROLL_TO_TOP -> Icons.Default.KeyboardArrowUp
    GestureActionType.SCROLL_TO_BOTTOM -> Icons.Default.KeyboardArrowDown
    GestureActionType.TOGGLE_DND -> Icons.Default.DoNotDisturb
    GestureActionType.SCREEN_RECORD -> OhoPanelIcons.ScreenRecord
    GestureActionType.TOGGLE_WIFI -> Icons.Default.Wifi
    GestureActionType.TOGGLE_MOBILE_DATA -> Icons.Default.SignalCellularAlt
    GestureActionType.LAUNCH_APP -> Icons.Default.Apps
    GestureActionType.LAUNCH_SHORTCUT -> Icons.AutoMirrored.Filled.Shortcut
}
