package com.slideindex.app.receiver

import com.slideindex.app.di.AppDependencies
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PackageChangeReceiver : BroadcastReceiver() {
    @Inject lateinit var deps: AppDependencies

    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action != Intent.ACTION_PACKAGE_ADDED &&
            intent?.action != Intent.ACTION_PACKAGE_REMOVED
        ) {
            return
        }
        deps.appRepository.invalidate()
    }
}
