package com.slideindex.app.data

import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.slideindex.app.util.FreeWindowLauncher
import com.slideindex.app.util.PinyinHelper
import com.slideindex.app.settings.AppSettings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepository(private val context: Context) {
    @Volatile
    private var cachedApps: List<AppInfo> = emptyList()

    @Volatile
    private var appsByPackage: Map<String, AppInfo> = emptyMap()

    suspend fun loadApps(force: Boolean = false): List<AppInfo> {
        if (!force && cachedApps.isNotEmpty()) return cachedApps
        val apps = withContext(Dispatchers.IO) { queryLaunchableApps() }
        cacheApps(apps)
        return apps
    }

    fun getCachedApps(): List<AppInfo> = cachedApps

    fun hasCachedApps(): Boolean = cachedApps.isNotEmpty()

    fun lookupApp(packageName: String): AppInfo? {
        if (packageName == context.packageName) return null
        appsByPackage[packageName]?.let { return it }
        return queryAppInfo(packageName)?.also { info ->
            appsByPackage = appsByPackage + (packageName to info)
        }
    }

    fun invalidate() {
        cachedApps = emptyList()
        appsByPackage = emptyMap()
    }

    private fun cacheApps(apps: List<AppInfo>) {
        cachedApps = apps
        appsByPackage = apps.associateBy { it.packageName }
    }

    fun groupedItems(apps: List<AppInfo>): List<AppListItem> {
        val sorted = apps.sortedWith(
            compareBy<AppInfo> { it.letter }.thenBy { PinyinHelper.sortKey(it.label) },
        )
        val items = mutableListOf<AppListItem>()
        var currentLetter: Char? = null
        sorted.forEach { app ->
            if (app.letter != currentLetter) {
                currentLetter = app.letter
                items += AppListItem.Header(app.letter)
            }
            items += AppListItem.App(app)
        }
        return items
    }

    fun searchApps(apps: List<AppInfo>, query: String): List<AppInfo> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return apps
        return apps.filter { app ->
            app.label.lowercase().contains(q) ||
                app.packageName.lowercase().contains(q) ||
                PinyinHelper.sortKey(app.label).contains(q)
        }.sortedBy { PinyinHelper.sortKey(it.label) }
    }

    fun availableLetters(items: List<AppListItem>): List<Char> =
        items.filterIsInstance<AppListItem.Header>().map { it.letter }

    fun launchApp(appInfo: AppInfo, settings: AppSettings, fullscreen: Boolean) {
        val intent = context.packageManager.getLaunchIntentForPackage(appInfo.packageName)
            ?: return
        FreeWindowLauncher.launch(context, intent, settings, fullscreen)
    }

    private fun queryLaunchableApps(): List<AppInfo> {
        val pm = context.packageManager
        val mainIntent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
        val resolveInfos = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            pm.queryIntentActivities(mainIntent, PackageManager.ResolveInfoFlags.of(0))
        } else {
            @Suppress("DEPRECATION")
            pm.queryIntentActivities(mainIntent, 0)
        }

        val seen = mutableSetOf<String>()
        val apps = mutableListOf<AppInfo>()
        resolveInfos.forEach { info ->
            val pkg = info.activityInfo.packageName
            if (!seen.add(pkg)) return@forEach
            if (pkg == context.packageName) return@forEach
            val appInfo = try {
                pm.getApplicationInfo(pkg, 0)
            } catch (_: PackageManager.NameNotFoundException) {
                return@forEach
            }
            if (appInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0 &&
                pm.getLaunchIntentForPackage(pkg) == null
            ) {
                return@forEach
            }
            val label = pm.getApplicationLabel(appInfo).toString()
            val icon = pm.getApplicationIcon(appInfo)
            apps += AppInfo(
                packageName = pkg,
                label = label,
                letter = PinyinHelper.firstLetter(label),
                icon = icon,
            )
        }
        return apps
    }

    private fun queryAppInfo(packageName: String): AppInfo? {
        val pm = context.packageManager
        return try {
            val appInfo = pm.getApplicationInfo(packageName, 0)
            val label = pm.getApplicationLabel(appInfo).toString()
            AppInfo(
                packageName = packageName,
                label = label,
                letter = PinyinHelper.firstLetter(label),
                icon = pm.getApplicationIcon(appInfo),
            )
        } catch (_: PackageManager.NameNotFoundException) {
            null
        }
    }
}
