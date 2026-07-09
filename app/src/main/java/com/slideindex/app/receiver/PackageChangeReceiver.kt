package com.slideindex.app.receiver

import com.slideindex.app.di.AppEntryPoints
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class PackageChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action != Intent.ACTION_PACKAGE_ADDED &&
            intent?.action != Intent.ACTION_PACKAGE_REMOVED
        ) {
            return
        }
        val deps = AppEntryPoints.dependencies(context)
        deps.appRepository.invalidate()
    }
}
