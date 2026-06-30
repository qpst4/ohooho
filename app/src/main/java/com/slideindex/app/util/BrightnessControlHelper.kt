package com.slideindex.app.util



import android.content.Context

import android.content.res.Configuration

import android.provider.Settings

import android.util.Log



object BrightnessControlHelper {

    const val UI_NIGHT_MODE_KEY = "ui_night_mode"



    private const val UI_NIGHT_MODE_AUTO = 0

    private const val UI_NIGHT_MODE_NO = 1

    private const val UI_NIGHT_MODE_YES = 2



    fun hasAccess(context: Context): Boolean =

        PermissionHelper.canWriteSettings(context) || TaskManagerUtil.hasPermission()



    fun hasDarkModeAccess(context: Context): Boolean =

        TaskManagerUtil.hasPermission() || PermissionHelper.canWriteSettings(context)



    fun readAutoBrightnessEnabled(context: Context): Boolean {

        return Settings.System.getInt(

            context.applicationContext.contentResolver,

            Settings.System.SCREEN_BRIGHTNESS_MODE,

            Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL,

        ) == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC

    }



    fun toggleAutoBrightness(context: Context): Boolean? {

        if (!hasAccess(context)) return null

        val appContext = context.applicationContext

        val enable = !readAutoBrightnessEnabled(appContext)

        val mode = if (enable) {

            Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC

        } else {

            Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL

        }

        return if (setAutoBrightnessMode(appContext, mode)) enable else null

    }



    fun readDarkModeEnabled(context: Context): Boolean {

        val appContext = context.applicationContext

        return when (

            Settings.Secure.getInt(

                appContext.contentResolver,

                UI_NIGHT_MODE_KEY,

                UI_NIGHT_MODE_AUTO,

            )

        ) {

            UI_NIGHT_MODE_YES -> true

            UI_NIGHT_MODE_NO -> false

            else -> {

                val nightMask = appContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

                nightMask == Configuration.UI_MODE_NIGHT_YES

            }

        }

    }



    fun toggleDarkMode(context: Context): Boolean? {

        if (!hasDarkModeAccess(context)) return null

        val appContext = context.applicationContext

        val enable = !readDarkModeEnabled(appContext)

        return if (setUiNightMode(appContext, enable)) enable else null

    }



    private fun setAutoBrightnessMode(context: Context, mode: Int): Boolean {

        var synced = false

        if (TaskManagerUtil.hasPermission()) {

            synced = TaskManagerUtil.runShellCommand(

                "settings",

                "put",

                "system",

                "screen_brightness_mode",

                mode.toString(),

            )

        }

        if (PermissionHelper.canWriteSettings(context)) {

            runCatching {

                synced = Settings.System.putInt(

                    context.contentResolver,

                    Settings.System.SCREEN_BRIGHTNESS_MODE,

                    mode,

                ) || synced

            }.onFailure { error ->

                Log.w(TAG, "auto brightness write failed", error)

            }

        }

        return synced

    }



    private fun setUiNightMode(context: Context, enableDark: Boolean): Boolean {

        val mode = if (enableDark) UI_NIGHT_MODE_YES else UI_NIGHT_MODE_NO

        val nightArg = if (enableDark) "yes" else "no"



        if (TaskManagerUtil.hasPermission()) {

            val shellCommands = listOf(

                arrayOf("cmd", "uimode", "night", nightArg),

                arrayOf("settings", "put", "secure", UI_NIGHT_MODE_KEY, mode.toString()),

                arrayOf("settings", "put", "system", UI_NIGHT_MODE_KEY, mode.toString()),

            )

            for (command in shellCommands) {

                if (TaskManagerUtil.runShellCommand(*command)) {

                    Log.d(TAG, "dark mode set via shell: ${command.joinToString(" ")}")

                    return true

                }

            }

        }



        runCatching {

            if (Settings.Secure.putInt(context.contentResolver, UI_NIGHT_MODE_KEY, mode)) {

                Log.d(TAG, "dark mode set via Settings.Secure.putInt mode=$mode")

                return true

            }

        }.onFailure { error ->

            Log.w(TAG, "ui night mode write failed", error)

        }

        return false

    }



    private const val TAG = "BrightnessControlHelper"

}


