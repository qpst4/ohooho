package com.slideindex.app.util

import android.app.Activity
import android.app.ActivityOptions
import android.app.PendingIntent
import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Process
import android.provider.Settings
import android.util.Log
import com.slideindex.app.service.AssistTrampolineActivity

/**
 * Launch the user's default digital assistant (Gemini, Bixby, 小爱, 小艺, Aicy, etc.).
 *
 * Order: Shizuku (if granted) → system assist APIs → explicit component → trampoline →
 * implicit ASSIST / VOICE_ASSIST fallbacks (may show OEM disambiguation).
 */
object AssistantLauncher {

    private const val TAG = "AssistantLauncher"
    private const val VOICE_INTERACTION_SERVICE = "voiceinteraction"
    private const val SECURE_ASSISTANT = "assistant"
    private const val SECURE_VOICE_INTERACTION_SERVICE = "voice_interaction_service"
    private const val ACTION_VOICE_ASSIST = "android.intent.action.VOICE_ASSIST"
    private const val TRAMPOLINE_REQUEST_CODE = 0x41534953 // "ASIS"
    private const val PER_USER_RANGE = 100_000
    // VoiceInteractionSession.SHOW_SOURCE_ASSIST_GESTURE — for AssistUtils only.
    private const val SHOW_SOURCE_ASSIST_GESTURE = 4
    private val LAUNCH_FLAGS = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
    private val VIA_SHOW_METHODS = setOf("showSession", "show")

    private val mainHandler = Handler(Looper.getMainLooper())

    fun launchDefault(context: Context) {
        val appContext = context.applicationContext
        Thread {
            if (tryLaunchViaShizuku(appContext)) return@Thread
            mainHandler.post {
                if (!tryLaunchInApp(appContext, allowTrampoline = true)) {
                    Log.w(TAG, "all assistant launch paths failed")
                }
            }
        }.start()
    }

    /** Called from [AssistTrampolineActivity] while in the foreground. */
    internal fun launchFromActivity(activity: Activity): Boolean {
        if (tryLaunchCore(activity)) return true
        if (tryLaunchViaShizuku(activity)) return true
        if (tryLaunchFallbacks(activity)) return true
        Log.w(TAG, "assistant launch failed from trampoline")
        return false
    }

    private fun tryLaunchInApp(context: Context, allowTrampoline: Boolean): Boolean =
        tryLaunchCore(context) ||
            (allowTrampoline && startTrampoline(context)) ||
            tryLaunchFallbacks(context)

    private fun tryLaunchCore(context: Context): Boolean =
        launchViaSearchManagerLaunchAssist(context) ||
            launchViaVoiceSession(context) ||
            launchResolvedAssist(context)

    private fun tryLaunchFallbacks(context: Context): Boolean =
        launchViaResolvableIntent(context, Intent.ACTION_ASSIST, preferDefault = true) ||
            launchViaResolvableIntent(context, ACTION_VOICE_ASSIST, preferDefault = false)

    private fun launchViaSearchManagerLaunchAssist(context: Context): Boolean {
        val searchManager = context.getSystemService(Context.SEARCH_SERVICE) ?: return false
        return runCatching {
            val method = searchManager.javaClass.getMethod("launchAssist", Bundle::class.java)
            if (method.invoke(searchManager, Bundle()) == false) return false
            logSuccess("SearchManager.launchAssist")
            true
        }.getOrElse { error ->
            Log.w(TAG, "SearchManager.launchAssist failed", error)
            false
        }
    }

    private fun launchViaVoiceSession(context: Context): Boolean =
        launchViaVoiceInteractionManager(context) || launchViaAssistUtilsShowSession(context)

    private fun launchViaVoiceInteractionManager(context: Context): Boolean {
        val service = context.applicationContext.getSystemService(VOICE_INTERACTION_SERVICE) ?: return false
        for (method in service.javaClass.methods) {
            if (method.name !in VIA_SHOW_METHODS) continue
            val ok = runCatching {
                when (method.parameterCount) {
                    1 -> method.invoke(service, Bundle())
                    2 -> method.invoke(service, Bundle(), 0)
                    else -> null
                }
            }.getOrNull()
            if (ok != false) {
                logSuccess("VoiceInteractionManager.${method.name}")
                return true
            }
        }
        return false
    }

    private fun launchViaAssistUtilsShowSession(context: Context): Boolean {
        val success = withAssistUtils(context) { assistUtils, clazz ->
            val callbackClass =
                Class.forName("com.android.internal.app.IVoiceInteractionSessionShowCallback")
            val method = clazz.getMethod(
                "showSessionForActiveService",
                Bundle::class.java,
                Int::class.javaPrimitiveType,
                callbackClass,
                IBinder::class.java,
            )
            method.invoke(assistUtils, Bundle(), SHOW_SOURCE_ASSIST_GESTURE, null, null) == true
        } ?: false
        if (success) logSuccess("AssistUtils.showSessionForActiveService")
        return success
    }

    private fun launchResolvedAssist(context: Context): Boolean {
        if (launchViaGetAssistIntent(context)) return true

        val component = resolveDefaultAssistantComponent(context) ?: run {
            Log.w(TAG, "no default assistant configured in Settings")
            return false
        }

        return startSafely(
            context,
            assistIntent(Intent.ACTION_ASSIST, component),
            "ACTION_ASSIST explicit $component",
        )
    }

    private fun launchViaGetAssistIntent(context: Context): Boolean {
        val searchManager = context.getSystemService(Context.SEARCH_SERVICE) ?: return false
        return runCatching {
            val method = searchManager.javaClass.getMethod(
                "getAssistIntent",
                Boolean::class.javaPrimitiveType,
            )
            for (requireAssist in listOf(true, false)) {
                val intent = method.invoke(searchManager, requireAssist) as? Intent ?: continue
                if (intent.action.isNullOrBlank()) continue
                if (intent.component == null && intent.`package` == null) continue
                intent.addFlags(LAUNCH_FLAGS)
                if (startSafely(context, intent, "getAssistIntent($requireAssist)")) return true
            }
            false
        }.getOrElse { error ->
            Log.w(TAG, "getAssistIntent failed", error)
            false
        }
    }

    /** Resolves [action] to a single handler when possible; otherwise defers to system/OEM UI. */
    private fun launchViaResolvableIntent(
        context: Context,
        action: String,
        preferDefault: Boolean,
    ): Boolean {
        val intent = assistIntent(action)
        val handlers = context.packageManager.queryIntentActivities(
            intent,
            PackageManager.MATCH_DEFAULT_ONLY,
        )
        if (handlers.isEmpty()) return false

        if (handlers.size == 1) {
            val info = handlers[0].activityInfo
            intent.component = ComponentName(info.packageName, info.name)
            return startSafely(context, intent, "$action sole handler ${intent.component}")
        }

        if (preferDefault) {
            resolveDefaultAssistantComponent(context)?.let { preferred ->
                if (handlers.any { it.activityInfo.packageName == preferred.packageName }) {
                    intent.component = preferred
                    if (startSafely(context, intent, "$action preferred $preferred")) return true
                }
            }
            return startSafely(context, intent, "$action disambiguation")
        }

        return startSafely(context, intent, action)
    }

    private fun tryLaunchViaShizuku(context: Context): Boolean {
        if (!TaskManagerUtil.hasPermission()) return false
        if (TaskManagerUtil.showVoiceAssistant()) {
            logSuccess("shizuku cmd voiceinteraction show")
            return true
        }

        val component = resolveDefaultAssistantComponent(context) ?: return false
        if (isViaComponent(component)) return false

        val command = arrayOf(
            "am", "start",
            "-a", Intent.ACTION_ASSIST,
            "-n", "${component.packageName}/${component.className}",
        )
        if (TaskManagerUtil.runShellCommand(*command)) {
            logSuccess("shizuku am start $component")
            return true
        }
        return false
    }

    private fun isViaComponent(component: ComponentName): Boolean =
        component.className.contains("VoiceInteraction", ignoreCase = true)

    private fun startTrampoline(context: Context): Boolean =
        startActivityPath(context, AssistTrampolineActivity.createIntent(context).apply {
            addFlags(LAUNCH_FLAGS)
        }, "trampoline via startActivity") ||
            startPendingIntentTrampoline(context)

    private fun startPendingIntentTrampoline(context: Context): Boolean =
        runCatching {
            val intent = AssistTrampolineActivity.createIntent(context)
            val pendingIntent = createTrampolinePendingIntent(context, intent)
            val sendOptions = createPendingIntentSendOptions()
            if (sendOptions != null) {
                pendingIntent.send(context, 0, null, null, null, null, sendOptions)
            } else {
                pendingIntent.send()
            }
            Log.i(TAG, "trampoline via PendingIntent")
            true
        }.getOrElse { error ->
            Log.w(TAG, "PendingIntent trampoline failed", error)
            false
        }

    private fun startActivityPath(context: Context, intent: Intent, label: String): Boolean =
        runCatching {
            context.startActivity(intent)
            Log.i(TAG, label)
            true
        }.getOrElse { error ->
            Log.w(TAG, "$label failed", error)
            false
        }

    private fun createTrampolinePendingIntent(context: Context, intent: Intent): PendingIntent {
        val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            val creatorOptions = ActivityOptions.makeBasic().apply {
                setPendingIntentCreatorBackgroundActivityStartMode(
                    ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOWED,
                )
            }
            return PendingIntent.getActivity(
                context,
                TRAMPOLINE_REQUEST_CODE,
                intent,
                flags,
                creatorOptions.toBundle(),
            )
        }
        return PendingIntent.getActivity(context, TRAMPOLINE_REQUEST_CODE, intent, flags)
    }

    private fun createPendingIntentSendOptions(): Bundle? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.UPSIDE_DOWN_CAKE) return null
        val options = ActivityOptions.makeBasic()
        if (Build.VERSION.SDK_INT >= 36) {
            options.setPendingIntentBackgroundActivityStartMode(
                ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOW_ALWAYS,
            )
        } else {
            @Suppress("DEPRECATION")
            options.setPendingIntentBackgroundActivityStartMode(
                ActivityOptions.MODE_BACKGROUND_ACTIVITY_START_ALLOWED,
            )
        }
        return options.toBundle()
    }

    private fun resolveDefaultAssistantComponent(context: Context): ComponentName? =
        resolveViaAssistUtils(context)
            ?: readSecureComponent(context, SECURE_ASSISTANT)
            ?: readSecureComponent(context, SECURE_VOICE_INTERACTION_SERVICE)

    private fun resolveViaAssistUtils(context: Context): ComponentName? =
        withAssistUtils(context) { assistUtils, clazz ->
            clazz.getMethod("getAssistComponentForUser", Int::class.javaPrimitiveType)
                .invoke(assistUtils, currentUserId()) as? ComponentName
        }

    private inline fun <T> withAssistUtils(context: Context, block: (Any, Class<*>) -> T): T? =
        runCatching {
            val clazz = Class.forName("com.android.internal.app.AssistUtils")
            val instance = clazz.getConstructor(Context::class.java).newInstance(context)
            block(instance, clazz)
        }.getOrNull()

    private fun readSecureComponent(context: Context, key: String): ComponentName? {
        val raw = Settings.Secure.getString(context.contentResolver, key)?.trim().orEmpty()
        if (raw.isBlank()) return null
        return ComponentName.unflattenFromString(raw)
    }

    private fun assistIntent(action: String, component: ComponentName? = null): Intent =
        Intent(action).apply {
            this.component = component
            addFlags(LAUNCH_FLAGS)
        }

    private fun currentUserId(): Int = Process.myUid() / PER_USER_RANGE

    private fun startSafely(context: Context, intent: Intent, label: String): Boolean =
        runCatching {
            context.startActivity(intent)
            logSuccess(label)
            true
        }.getOrElse { error ->
            if (error !is ActivityNotFoundException) {
                Log.w(TAG, "$label startActivity failed", error)
            } else {
                Log.w(TAG, "$label: no activity for action=${intent.action}")
            }
            false
        }

    private fun logSuccess(path: String) {
        Log.i(TAG, "assistant via $path")
    }
}
