package com.slideindex.app.widget

import android.appwidget.AppWidgetHostView
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProviderInfo
import android.content.Context
import android.util.Log
import android.view.View

/**
 * Shared [AppWidgetHost] for the widget popup overlay and the settings editor.
 * Host id is arbitrary but must stay stable across process lifetime.
 */
object WidgetPopupHost {
  private const val TAG = "WidgetPopupHost"

  @Volatile
  private var host: SlideIndexAppWidgetHost? = null

  @Volatile
  private var listening = false

  private val cachedHostViews = java.util.concurrent.ConcurrentHashMap<Int, AppWidgetHostView>()

  fun appWidgetHost(context: Context): SlideIndexAppWidgetHost {
    val appContext = context.applicationContext
    return host ?: synchronized(this) {
      host ?: SlideIndexAppWidgetHost(appContext).also { host = it }
    }
  }

  fun appWidgetManager(context: Context): AppWidgetManager =
    AppWidgetManager.getInstance(context.applicationContext)

  fun startListening(context: Context) {
    synchronized(this) {
      if (listening) return
      runCatching {
        appWidgetHost(context).startListening()
        listening = true
      }.onFailure { Log.e(TAG, "startListening failed", it) }
    }
  }

  fun stopListening(context: Context) {
    synchronized(this) {
      if (!listening) return
      runCatching {
        appWidgetHost(context).stopListening()
        listening = false
      }.onFailure { Log.e(TAG, "stopListening failed", it) }
    }
  }

  fun allocateAppWidgetId(context: Context): Int =
    appWidgetHost(context).allocateAppWidgetId()

  fun deleteAppWidgetId(context: Context, appWidgetId: Int) {
    cachedHostViews.remove(appWidgetId)
    runCatching { appWidgetHost(context).deleteAppWidgetId(appWidgetId) }
      .onFailure { Log.w(TAG, "deleteAppWidgetId($appWidgetId) failed", it) }
  }

  fun obtainHostView(context: Context, appWidgetId: Int): AppWidgetHostView? {
    cachedHostViews[appWidgetId]?.let { cached ->
      (cached.parent as? android.view.ViewGroup)?.removeView(cached)
      return cached
    }
    return createView(context, appWidgetId) as? AppWidgetHostView
  }

  fun providerInfo(context: Context, appWidgetId: Int): AppWidgetProviderInfo? =
    runCatching { appWidgetManager(context).getAppWidgetInfo(appWidgetId) }.getOrNull()

  fun createView(context: Context, appWidgetId: Int): View? {
    val manager = appWidgetManager(context)
    val info = manager.getAppWidgetInfo(appWidgetId) ?: return null
    val widgetHost = appWidgetHost(context)
    return runCatching { widgetHost.createView(context, appWidgetId, info) }
      .onFailure { Log.e(TAG, "createView($appWidgetId) failed", it) }
      .getOrNull()
      ?.also { view ->
        if (view is AppWidgetHostView) {
          cachedHostViews[appWidgetId] = view
        }
      }
  }

  fun labelFor(context: Context, appWidgetId: Int): String {
    val info = providerInfo(context, appWidgetId) ?: return ""
    return info.loadLabel(context.packageManager)?.toString().orEmpty()
  }
}
