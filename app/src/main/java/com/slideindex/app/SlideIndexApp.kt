package com.slideindex.app

import android.app.Application
import android.util.Log
import com.slideindex.app.data.AppRepository
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.util.TaskManagerUtil
import rikka.shizuku.Shizuku

class SlideIndexApp : Application() {
    lateinit var appRepository: AppRepository
        private set
    lateinit var settingsRepository: SettingsRepository
        private set

    private val shizukuBinderListener = Shizuku.OnBinderReceivedListener {
        Log.d(TAG, "Shizuku binder received")
        if (TaskManagerUtil.hasPermission()) {
            TaskManagerUtil.warmUp()
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appRepository = AppRepository(this)
        settingsRepository = SettingsRepository(this)
        Shizuku.addBinderReceivedListenerSticky(shizukuBinderListener)
        if (TaskManagerUtil.hasPermission()) {
            TaskManagerUtil.warmUp()
        }
    }

    companion object {
        private const val TAG = "SlideIndexApp"
        lateinit var instance: SlideIndexApp
            private set
    }
}
