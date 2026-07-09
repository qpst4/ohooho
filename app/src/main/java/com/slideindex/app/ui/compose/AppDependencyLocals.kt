package com.slideindex.app.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.slideindex.app.data.AppRepository
import com.slideindex.app.di.AppDependencies
import com.slideindex.app.di.AppEntryPoints

@Composable
fun rememberAppDependencies(): AppDependencies {
    val context = LocalContext.current
    return remember(context) { AppEntryPoints.dependencies(context) }
}

@Composable
fun rememberAppRepository(): AppRepository = rememberAppDependencies().appRepository
