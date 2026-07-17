package com.slideindex.app.util

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build

data class ExportedActivityInfo(
    val packageName: String,
    val className: String,
    val label: String,
    val icon: Drawable,
    val exported: Boolean,
)

object PackageActivityResolver {
    fun listActivities(context: Context, packageName: String): List<ExportedActivityInfo> {
        if (packageName.isBlank()) return emptyList()
        val pm = context.packageManager
        val activities = try {
            val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                pm.getPackageInfo(
                    packageName,
                    PackageManager.PackageInfoFlags.of(PackageManager.GET_ACTIVITIES.toLong()),
                )
            } else {
                @Suppress("DEPRECATION")
                pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            }
            packageInfo.activities.orEmpty()
        } catch (_: PackageManager.NameNotFoundException) {
            return emptyList()
        }
        return activities
            .asSequence()
            .map { info ->
                val className = resolveClassName(info)
                ExportedActivityInfo(
                    packageName = packageName,
                    className = className,
                    label = info.loadLabel(pm).toString().ifBlank { className },
                    icon = loadActivityIcon(pm, info, packageName),
                    exported = info.exported,
                )
            }
            .sortedWith(compareBy({ !it.exported }, { it.className }, { it.label }))
            .toList()
    }

    fun isActivityExported(context: Context, packageName: String, className: String): Boolean {
        if (packageName.isBlank() || className.isBlank()) return false
        val pm = context.packageManager
        val activities = try {
            val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                pm.getPackageInfo(
                    packageName,
                    PackageManager.PackageInfoFlags.of(PackageManager.GET_ACTIVITIES.toLong()),
                )
            } else {
                @Suppress("DEPRECATION")
                pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            }
            packageInfo.activities.orEmpty()
        } catch (_: PackageManager.NameNotFoundException) {
            return false
        }
        for (info in activities) {
            val resolved = resolveClassName(info)
            if (resolved == className || info.name == className) {
                return info.exported
            }
        }
        return false
    }

    fun searchActivities(activities: List<ExportedActivityInfo>, query: String): List<ExportedActivityInfo> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return activities
        return activities.filter { activity ->
            activity.label.lowercase().contains(q) ||
                activity.className.lowercase().contains(q) ||
                activity.className.substringAfterLast('.').lowercase().contains(q)
        }
    }

    private fun loadActivityIcon(
        pm: PackageManager,
        info: ActivityInfo,
        packageName: String,
    ): Drawable {
        return runCatching { info.loadIcon(pm) }.getOrNull()
            ?: runCatching { pm.getApplicationIcon(packageName) }.getOrNull()
            ?: pm.defaultActivityIcon
    }

    private fun resolveClassName(info: ActivityInfo): String {
        val name = info.name.orEmpty()
        return when {
            name.startsWith('.') -> info.packageName + name
            name.isNotBlank() -> name
            else -> info.packageName
        }
    }
}
