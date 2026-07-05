package com.slideindex.app.util

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import com.slideindex.app.R

object KeepAliveHelper {

    fun gotoSettings(context: Context) {
        try {
            when {
                isHuawei() -> gotoHuaweiSetting(context)
                isXiaomi() -> gotoXiaomiSetting(context)
                isOppo() -> gotoOppoSetting(context)
                isVivo() -> gotoVivoSetting(context)
                isSmartisan() -> gotoSmartisanSetting(context)
                isSamsung() -> gotoSamsungSetting(context)
                isMeizu() -> gotoMeizuSetting(context)
                else -> showManualHint(context)
            }
        } catch (_: Exception) {
            showManualHint(context)
        }
    }

    private fun showManualHint(context: Context) {
        Toast.makeText(
            context,
            context.getString(R.string.auto_start_request_failed),
            Toast.LENGTH_SHORT,
        ).show()
    }

    private fun gotoSmartisanSetting(context: Context) {
        showActivity(context, "com.smartisanos.security")
    }

    private fun gotoSamsungSetting(context: Context) {
        try {
            showActivity(context, "com.samsung.android.sm_cn")
        } catch (_: Exception) {
            showActivity(context, "com.samsung.android.sm")
        }
    }

    private fun gotoMeizuSetting(context: Context) {
        showActivity(context, "com.meizu.safe")
    }

    private fun gotoVivoSetting(context: Context) {
        showActivity(context, "com.iqoo.secure")
    }

    private fun gotoOppoSetting(context: Context) {
        try {
            showActivity(context, "com.coloros.phonemanager")
        } catch (_: Exception) {
            try {
                showActivity(context, "com.oppo.safe")
            } catch (_: Exception) {
                try {
                    showActivity(context, "com.coloros.oppoguardelf")
                } catch (_: Exception) {
                    showActivity(context, "com.coloros.safecenter")
                }
            }
        }
    }

    private fun gotoXiaomiSetting(context: Context) {
        showActivity(
            context,
            "com.miui.securitycenter",
            "com.miui.permcenter.autostart.AutoStartManagementActivity",
        )
    }

    private fun gotoHuaweiSetting(context: Context) {
        try {
            showActivity(
                context,
                "com.huawei.systemmanager",
                "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity",
            )
        } catch (_: Exception) {
            showActivity(
                context,
                "com.huawei.systemmanager",
                "com.huawei.systemmanager.optimize.bootstart.BootStartActivity",
            )
        }
    }

    private fun showActivity(context: Context, packageName: String) {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        } else {
            showManualHint(context)
        }
    }

    private fun showActivity(context: Context, packageName: String, activityClass: String) {
        val intent = Intent().apply {
            component = ComponentName(packageName, activityClass)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    private fun isHuawei(): Boolean = matchesBrand("huawei", "honor")

    private fun isXiaomi(): Boolean = matchesBrand("xiaomi", "redmi", "poco")

    private fun isOppo(): Boolean = matchesBrand("oppo", "realme", "oneplus")

    private fun isVivo(): Boolean = matchesBrand("vivo", "iqoo")

    private fun isSamsung(): Boolean = matchesBrand("samsung")

    private fun isMeizu(): Boolean = matchesBrand("meizu")

    private fun isSmartisan(): Boolean = matchesBrand("smartisan")

    private fun matchesBrand(vararg names: String): Boolean {
        val brand = Build.BRAND.orEmpty().lowercase()
        val manufacturer = Build.MANUFACTURER.orEmpty().lowercase()
        return names.any { name ->
            brand.contains(name) || manufacturer.contains(name)
        }
    }
}
