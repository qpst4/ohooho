package com.slideindex.app

import android.app.Application
import com.slideindex.app.di.AppDependencies
import com.slideindex.app.di.ShizukuInitializer
import com.slideindex.app.widget.WidgetPanelPage
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltAndroidApp
class SlideIndexApp : Application() {
    @Inject lateinit var deps: AppDependencies
    @Inject lateinit var shizukuInitializer: ShizukuInitializer

    override fun onCreate() {
        super.onCreate()
        shizukuInitializer.start()
        deps.applicationScope.launch {
            deps.appRepository.loadApps()
        }
    }

    fun schedulePersistWidgetPanelPages(pages: List<WidgetPanelPage>) {
        deps.widgetPanelPersistence.schedulePersist(pages)
    }

    suspend fun persistWidgetPanelPagesNow(pages: List<WidgetPanelPage>) {
        deps.widgetPanelPersistence.persistNow(pages)
    }
}
