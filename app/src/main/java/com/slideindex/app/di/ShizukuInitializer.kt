package com.slideindex.app.di

import android.content.Context
import com.slideindex.app.util.TaskManagerUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import rikka.shizuku.Shizuku

@Singleton
class ShizukuInitializer @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val binderListener = Shizuku.OnBinderReceivedListener {
        if (TaskManagerUtil.hasPermission()) {
            TaskManagerUtil.warmUp()
        }
    }

    fun start() {
        TaskManagerUtil.initialize(context)
        Shizuku.addBinderReceivedListenerSticky(binderListener)
        if (TaskManagerUtil.hasPermission()) {
            TaskManagerUtil.warmUp()
        }
    }
}
