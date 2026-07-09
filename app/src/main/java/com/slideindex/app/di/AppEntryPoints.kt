package com.slideindex.app.di

import android.content.Context
import dagger.hilt.android.EntryPointAccessors

object AppEntryPoints {
    fun dependencies(context: Context): AppDependencies =
        EntryPointAccessors.fromApplication(
            context.applicationContext,
            AppGraphEntryPoint::class.java,
        ).dependencies()
}
