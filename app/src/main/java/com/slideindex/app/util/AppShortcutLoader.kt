package com.slideindex.app.util

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.LauncherApps
import android.content.pm.PackageManager
import android.content.res.Resources
import android.content.res.XmlResourceParser
import android.net.Uri
import android.os.Build
import android.os.Process
import android.util.AttributeSet
import android.util.Log
import com.slideindex.app.overlay.TaskSwitcherMenuItem
import com.slideindex.app.overlay.TaskSwitcherMenuItemType
import org.xmlpull.v1.XmlPullParser
import java.util.concurrent.ConcurrentHashMap

object AppShortcutLoader {
    private const val TAG = "AppShortcutLoader"
    private const val MAX_SHORTCUTS = 12
    private const val CACHE_TTL_MS = 3 * 60 * 1000L
    private const val ANDROID_NS = "http://schemas.android.com/apk/res/android"
    private const val META_SHORTCUTS = "android.app.shortcuts"

    private val shellCache = ConcurrentHashMap<String, CacheEntry>()

    private data class CacheEntry(val loadedAt: Long, val shortcuts: List<TaskSwitcherMenuItem>)

    /** Zero-I/O shortcuts for WeChat / QQ / Alipay. */
    fun loadInstantShortcuts(packageName: String): List<TaskSwitcherMenuItem> {
        return KnownAppShortcuts.load(packageName)
    }

    /** Fast path: manifest static shortcuts, plus known fallbacks when manifest is empty. */
    fun loadFastShortcuts(context: Context, packageName: String): List<TaskSwitcherMenuItem> {
        val manifest = loadManifestShortcuts(context, packageName)
        if (manifest.isNotEmpty()) return manifest.take(MAX_SHORTCUTS)
        return KnownAppShortcuts.load(packageName).take(MAX_SHORTCUTS)
    }

    private fun mergeWithFallback(
        shortcuts: List<TaskSwitcherMenuItem>,
        packageName: String,
    ): List<TaskSwitcherMenuItem> {
        if (shortcuts.isNotEmpty() && !KnownAppShortcuts.supports(packageName)) {
            return shortcuts.take(MAX_SHORTCUTS)
        }
        val merged = linkedMapOf<String, TaskSwitcherMenuItem>()
        shortcuts.forEach { item ->
            merged[item.shortcutId ?: item.label] = item
        }
        KnownAppShortcuts.load(packageName).forEach { item ->
            merged.putIfAbsent(item.shortcutId ?: item.label, item)
        }
        return merged.values.take(MAX_SHORTCUTS).toList()
    }

    fun finalizeShortcuts(
        shortcuts: List<TaskSwitcherMenuItem>,
        packageName: String,
    ): List<TaskSwitcherMenuItem> {
        return mergeWithFallback(shortcuts, packageName)
    }

    /** Slow path: Shizuku shell query, cached for a few minutes. */
    fun loadShellShortcuts(packageName: String): List<TaskSwitcherMenuItem> {
        val now = System.currentTimeMillis()
        shellCache[packageName]?.takeIf { now - it.loadedAt < CACHE_TTL_MS }?.let { return it.shortcuts }
        val shortcuts = loadShellShortcutsUncached(packageName)
        shellCache[packageName] = CacheEntry(now, shortcuts)
        return shortcuts
    }

    fun loadMenuShortcuts(context: Context, packageName: String): List<TaskSwitcherMenuItem> {
        val merged = mutableListOf<TaskSwitcherMenuItem>()
        val seenIds = mutableSetOf<String>()
        fun addAll(items: List<TaskSwitcherMenuItem>, source: String) {
            var added = 0
            items.forEach { item ->
                val key = item.shortcutId ?: item.label
                if (seenIds.add(key)) {
                    merged += item
                    added++
                }
            }
            Log.d(TAG, "loadMenuShortcuts($packageName) $source -> $added")
        }
        addAll(loadLauncherShortcuts(context, packageName), "launcher")
        addAll(loadManifestShortcuts(context, packageName), "manifest")
        addAll(loadShellShortcuts(packageName), "shell")
        val withFallback = mergeWithFallback(merged, packageName)
        if (withFallback.size > merged.size) {
            Log.d(TAG, "loadMenuShortcuts($packageName) fallback -> ${withFallback.size - merged.size}")
        }
        Log.d(TAG, "loadMenuShortcuts($packageName) total -> ${withFallback.size}")
        return withFallback
    }

    fun launchShortcut(context: Context, packageName: String, item: TaskSwitcherMenuItem) {
        val intent = item.shortcutIntent
        if (intent != null) {
            runCatching {
                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
            }.onFailure { error ->
                Log.e(TAG, "launchShortcutIntent($packageName) failed", error)
            }
            return
        }
        val shortcutId = item.shortcutId ?: return
        if (item.useShellLaunch && TaskManagerUtil.startPublishedShortcut(packageName, shortcutId)) {
            return
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return
        val launcherApps = context.getSystemService(LauncherApps::class.java) ?: return
        runCatching {
            launcherApps.startShortcut(
                packageName,
                shortcutId,
                null,
                null,
                Process.myUserHandle(),
            )
        }.onFailure { error ->
            if (TaskManagerUtil.startPublishedShortcut(packageName, shortcutId)) return
            Log.e(TAG, "launchShortcut($packageName, $shortcutId) failed", error)
        }
    }

    private fun loadShellShortcutsUncached(packageName: String): List<TaskSwitcherMenuItem> {
        return TaskManagerUtil.getPublishedShortcuts(packageName).map { (id, label) ->
            TaskSwitcherMenuItem(
                label = label,
                type = TaskSwitcherMenuItemType.SHORTCUT,
                shortcutId = id,
                useShellLaunch = true,
            )
        }
    }

    private fun loadLauncherShortcuts(context: Context, packageName: String): List<TaskSwitcherMenuItem> {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return emptyList()
        val launcherApps = context.getSystemService(LauncherApps::class.java) ?: return emptyList()
        if (!launcherApps.hasShortcutHostPermission()) {
            return emptyList()
        }
        val flags = LauncherApps.ShortcutQuery.FLAG_MATCH_MANIFEST or
            LauncherApps.ShortcutQuery.FLAG_MATCH_DYNAMIC or
            LauncherApps.ShortcutQuery.FLAG_MATCH_PINNED or
            LauncherApps.ShortcutQuery.FLAG_MATCH_CACHED
        val user = Process.myUserHandle()
        val merged = mutableListOf<TaskSwitcherMenuItem>()
        val seenIds = mutableSetOf<String>()

        fun addShortcuts(query: LauncherApps.ShortcutQuery) {
            val shortcuts = try {
                launcherApps.getShortcuts(query, user)
            } catch (error: Exception) {
                Log.w(TAG, "getShortcuts($packageName) failed", error)
                null
            } ?: return
            shortcuts.forEach { shortcut ->
                if (!shortcut.isEnabled || seenIds.contains(shortcut.id)) return@forEach
                seenIds += shortcut.id
                val label = shortcut.shortLabel?.toString()?.takeIf { it.isNotBlank() }
                    ?: shortcut.longLabel?.toString()?.takeIf { it.isNotBlank() }
                    ?: shortcut.id
                merged += TaskSwitcherMenuItem(
                    label = label,
                    type = TaskSwitcherMenuItemType.SHORTCUT,
                    shortcutId = shortcut.id,
                )
            }
        }

        addShortcuts(
            LauncherApps.ShortcutQuery().apply {
                setPackage(packageName)
                setQueryFlags(flags)
            },
        )

        launcherComponents(context.packageManager, packageName).forEach { component ->
            addShortcuts(
                LauncherApps.ShortcutQuery().apply {
                    setActivity(component)
                    setQueryFlags(flags)
                },
            )
        }

        return merged
    }

    private fun loadManifestShortcuts(context: Context, packageName: String): List<TaskSwitcherMenuItem> {
        return try {
            val pm = context.packageManager
            val appInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                pm.getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(PackageManager.GET_META_DATA.toLong()))
            } else {
                @Suppress("DEPRECATION")
                pm.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            }
            val pkgContext = context.createPackageContext(
                packageName,
                Context.CONTEXT_IGNORE_SECURITY or Context.CONTEXT_INCLUDE_CODE,
            )
            val resources = pm.getResourcesForApplication(appInfo)
            val merged = mutableListOf<TaskSwitcherMenuItem>()
            val seenIds = mutableSetOf<String>()
            launcherComponents(pm, packageName).forEach { component ->
                val activityInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    pm.getActivityInfo(component, PackageManager.ComponentInfoFlags.of(PackageManager.GET_META_DATA.toLong()))
                } else {
                    @Suppress("DEPRECATION")
                    pm.getActivityInfo(component, PackageManager.GET_META_DATA)
                }
                val resId = shortcutsXmlResId(resources, activityInfo)
                if (resId == 0) return@forEach
                parseShortcutsXml(
                    parser = resources.getXml(resId),
                    pkgContext = pkgContext,
                    packageName = packageName,
                    seenIds = seenIds,
                    output = merged,
                )
            }
            merged
        } catch (error: Exception) {
            Log.w(TAG, "loadManifestShortcuts($packageName) failed", error)
            emptyList()
        }
    }

    private fun shortcutsXmlResId(resources: Resources, activityInfo: ActivityInfo): Int {
        val fromMeta = activityInfo.metaData?.getInt(META_SHORTCUTS, 0) ?: 0
        if (fromMeta != 0) return fromMeta
        return resources.getIdentifier("shortcuts", "xml", activityInfo.packageName)
    }

    private fun launcherComponents(pm: PackageManager, packageName: String): Set<ComponentName> {
        val components = linkedSetOf<ComponentName>()
        val launcherIntent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
            setPackage(packageName)
        }
        val queryFlags = PackageManager.GET_META_DATA or PackageManager.MATCH_DISABLED_COMPONENTS
        val resolveInfos = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            pm.queryIntentActivities(
                launcherIntent,
                PackageManager.ResolveInfoFlags.of(queryFlags.toLong()),
            )
        } else {
            @Suppress("DEPRECATION")
            pm.queryIntentActivities(launcherIntent, queryFlags)
        }
        resolveInfos.forEach { info ->
            val activityInfo = info.activityInfo ?: return@forEach
            components += ComponentName(activityInfo.packageName, activityInfo.name)
        }
        val packageFlags = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            PackageManager.PackageInfoFlags.of(
                (PackageManager.GET_ACTIVITIES or PackageManager.GET_META_DATA).toLong(),
            )
        } else {
            null
        }
        val activities = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            pm.getPackageInfo(packageName, packageFlags!!).activities
        } else {
            @Suppress("DEPRECATION")
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES or PackageManager.GET_META_DATA).activities
        }
        activities?.forEach { activityInfo ->
            components += ComponentName(activityInfo.packageName, activityInfo.name)
        }
        return components
    }

    private fun parseShortcutsXml(
        parser: XmlResourceParser,
        pkgContext: Context,
        packageName: String,
        seenIds: MutableSet<String>,
        output: MutableList<TaskSwitcherMenuItem>,
    ) {
        try {
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && parser.name == "shortcut") {
                    parseShortcutElement(parser, pkgContext, packageName, seenIds, output)
                }
                eventType = parser.next()
            }
        } finally {
            parser.close()
        }
    }

    private fun parseShortcutElement(
        parser: XmlPullParser,
        pkgContext: Context,
        packageName: String,
        seenIds: MutableSet<String>,
        output: MutableList<TaskSwitcherMenuItem>,
    ) {
        val enabled = parser.getAttributeValue(ANDROID_NS, "enabled") != "false"
        if (!enabled) {
            skipCurrentElement(parser)
            return
        }
        val id = parser.getAttributeValue(ANDROID_NS, "shortcutId")?.takeIf { it.isNotBlank() } ?: return
        if (seenIds.contains(id)) {
            skipCurrentElement(parser)
            return
        }
        val shortLabelRes = parser.attributeResourceValue("shortcutShortLabel")
        val longLabelRes = parser.attributeResourceValue("shortcutLongLabel")
        val label = when {
            shortLabelRes != 0 -> runCatching { pkgContext.resources.getString(shortLabelRes) }.getOrNull()
            longLabelRes != 0 -> runCatching { pkgContext.resources.getString(longLabelRes) }.getOrNull()
            else -> null
        }?.takeIf { it.isNotBlank() } ?: id

        var launchIntent: Intent? = null
        val depth = parser.depth
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.eventType == XmlPullParser.END_TAG && parser.name == "shortcut" && parser.depth == depth) {
                break
            }
            if (parser.eventType == XmlPullParser.START_TAG && parser.name == "intent") {
                launchIntent = readIntentTag(parser, packageName)
            }
        }
        if (launchIntent == null) return
        seenIds += id
        output += TaskSwitcherMenuItem(
            label = label,
            type = TaskSwitcherMenuItemType.SHORTCUT,
            shortcutId = id,
            shortcutIntent = launchIntent,
        )
    }

    private fun readIntentTag(parser: XmlPullParser, defaultPackage: String): Intent? {
        val action = parser.getAttributeValue(ANDROID_NS, "action")
        val targetPackage = parser.getAttributeValue(ANDROID_NS, "targetPackage") ?: defaultPackage
        val targetClass = parser.getAttributeValue(ANDROID_NS, "targetClass")
        val data = parser.getAttributeValue(ANDROID_NS, "data")
        val mimeType = parser.getAttributeValue(ANDROID_NS, "mimeType")
        return when {
            !targetClass.isNullOrBlank() -> Intent(action ?: Intent.ACTION_MAIN).apply {
                setClassName(targetPackage, targetClass)
                data?.takeIf { it.isNotBlank() }?.let { setData(Uri.parse(it)) }
                mimeType?.takeIf { it.isNotBlank() }?.let { setType(it) }
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            action != null || data != null -> Intent(action ?: Intent.ACTION_VIEW).apply {
                setPackage(targetPackage)
                data?.takeIf { it.isNotBlank() }?.let { setData(Uri.parse(it)) }
                mimeType?.takeIf { it.isNotBlank() }?.let { setType(it) }
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            else -> null
        }
    }

    private fun skipCurrentElement(parser: XmlPullParser) {
        val depth = parser.depth
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.eventType == XmlPullParser.END_TAG && parser.name == "shortcut" && parser.depth == depth) {
                break
            }
        }
    }

    private fun XmlPullParser.attributeResourceValue(name: String): Int {
        return (this as AttributeSet).getAttributeResourceValue(ANDROID_NS, name, 0)
    }
}
