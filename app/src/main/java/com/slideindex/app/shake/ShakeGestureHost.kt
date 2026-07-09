package com.slideindex.app.shake

import com.slideindex.app.di.AppDependencies
import android.app.KeyguardManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.Looper
import android.os.PowerManager
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import com.slideindex.app.gesture.ActionExecutor
import com.slideindex.app.gesture.GestureAction
import com.slideindex.app.service.OverlayService
import com.slideindex.app.service.SlideIndexAccessibilityService
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.util.PermissionHelper
import com.slideindex.app.util.TriggerVisibility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ShakeGestureHost(
    private val context: Context,
    private val scope: CoroutineScope,
    private val deps: AppDependencies,
) {
    private val appContext = context.applicationContext
    private var detector: ShakeGestureDetector? = null
    private var settingsJob: Job? = null
    private var latestSettings: AppSettings? = null
    private val mainHandler = Handler(Looper.getMainLooper())
    private var screenReceiverRegistered = false
    private var screenInteractive = true

    private val screenReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                Intent.ACTION_SCREEN_ON -> {
                    screenInteractive = true
                    latestSettings?.let(::applyRuntime)
                }
                Intent.ACTION_SCREEN_OFF -> {
                    screenInteractive = false
                    latestSettings?.let(::applyRuntime)
                }
                Intent.ACTION_USER_PRESENT -> {
                    latestSettings?.let(::applyRuntime)
                }
            }
        }
    }

    fun start() {
        if (settingsJob != null) return
        screenInteractive = powerManager().isInteractive
        registerScreenReceiver()
        settingsJob = scope.launch {
            deps.settingsRepository.settings.collectLatest { settings ->
                latestSettings = settings
                applyRuntime(settings)
            }
        }
        Log.d(TAG, "started (interactive=$screenInteractive)")
    }

    fun stop() {
        settingsJob?.cancel()
        settingsJob = null
        unregisterScreenReceiver()
        detector?.stop()
        detector = null
        ShakeFeedbackOverlay.detach()
        Log.d(TAG, "stopped")
    }

    private fun registerScreenReceiver() {
        if (screenReceiverRegistered) return
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_USER_PRESENT)
        }
        appContext.registerReceiver(screenReceiver, filter)
        screenReceiverRegistered = true
    }

    private fun unregisterScreenReceiver() {
        if (!screenReceiverRegistered) return
        runCatching { appContext.unregisterReceiver(screenReceiver) }
        screenReceiverRegistered = false
    }

    private fun applyRuntime(settings: AppSettings) {
        val shake = settings.shakeGestureSettings
        val accessibilityEnabled = PermissionHelper.isAccessibilityServiceEnabled(appContext)
        val lockScreenActive = isLockScreenActive()
        val shouldRun = shake.enabled &&
            accessibilityEnabled &&
            screenInteractive &&
            (!lockScreenActive || shake.lockScreenShakeEnabled)

        if (!shouldRun) {
            if (detector != null) {
                val reason = when {
                    !shake.enabled -> "shake disabled"
                    !accessibilityEnabled -> "accessibility disabled"
                    !screenInteractive -> "screen not interactive"
                    lockScreenActive && !shake.lockScreenShakeEnabled -> "lock screen shake disabled"
                    else -> "unknown"
                }
                Log.d(TAG, "stopping detector: $reason")
            }
            detector?.stop()
            detector = null
            return
        }

        val activeDetector = detector ?: ShakeGestureDetector(appContext) { type ->
            if (Looper.myLooper() == Looper.getMainLooper()) {
                handleGestureDetected(type)
            } else {
                mainHandler.post { handleGestureDetected(type) }
            }
        }.also { detector = it }

        if (!activeDetector.isAvailable) {
            Log.w(TAG, "stopping detector: no gyroscope or accelerometer")
            activeDetector.stop()
            detector = null
            return
        }

        activeDetector.setSensitivity(
            global = shake.globalSensitivity,
            independentEnabled = shake.independentSensitivityEnabled,
            perDirection = shake.perDirectionSensitivity,
        )
        activeDetector.start()
        Log.d(
            TAG,
            "detector running enabled=${shake.enabled} sensitivity=${shake.globalSensitivity}",
        )
    }

    private fun handleGestureDetected(type: ShakeGestureType) {
        runCatching {
            handleGestureDetectedInternal(type)
        }.onFailure { error ->
            Log.e(TAG, "handle shake gesture failed: $type", error)
        }
    }

    private fun handleGestureDetectedInternal(type: ShakeGestureType) {
        val settings = latestSettings ?: run {
            Log.d(TAG, "gesture $type blocked: settings not loaded")
            return
        }
        val shake = settings.shakeGestureSettings
        if (!shake.enabled) {
            Log.d(TAG, "gesture $type blocked: shake disabled")
            return
        }

        if (!powerManager().isInteractive) {
            Log.d(TAG, "gesture $type blocked: screen not interactive")
            return
        }

        val foregroundPackage = resolveForegroundPackage()
        if (foregroundPackage != null && foregroundPackage in shake.blacklistedPackages) {
            Log.d(TAG, "gesture $type blocked: blacklisted package $foregroundPackage")
            return
        }
        if (shake.disableInLandscape && TriggerVisibility.isLandscape(appContext)) {
            Log.d(TAG, "gesture $type blocked: landscape disabled")
            return
        }

        val lockScreenActive = isLockScreenActive()
        if (lockScreenActive && !shake.lockScreenShakeEnabled) {
            Log.d(TAG, "gesture $type blocked: lock screen shake disabled")
            return
        }

        val action = resolveAction(shake, type, foregroundPackage, lockScreenActive)
        dispatchAction(action, settings, shake, type)
    }

    private fun resolveAction(
        shake: ShakeGestureSettings,
        type: ShakeGestureType,
        foregroundPackage: String?,
        lockScreenActive: Boolean,
    ): GestureAction {
        if (lockScreenActive && shake.lockScreenShakeEnabled) {
            shake.lockScreenActions[type]?.takeIf { it != GestureAction.None }?.let { return it }
        }

        if (shake.independentAppShakeEnabled && foregroundPackage != null) {
            shake.perAppActions[foregroundPackage]?.get(type)?.takeIf { it != GestureAction.None }?.let { return it }
        }

        return shake.actionFor(type)
    }

    private fun dispatchAction(
        action: GestureAction,
        settings: AppSettings,
        shake: ShakeGestureSettings,
        type: ShakeGestureType,
    ) {
        if (action == GestureAction.None) {
            Log.d(TAG, "gesture $type detected, action is None")
            deliverFeedback(shake, type, action)
            return
        }

        Log.i(TAG, "gesture $type executing action=$action")
        OverlayService.captureGestureForegroundPackage()

        if (requiresAccessibilityService(action)) {
            dispatchAccessibilityAction(action, type, shake, attempt = 0)
            return
        }

        runCatching {
            val ok = actionExecutor().execute(
                action = action,
                settings = settings,
                anchorRawX = readCenterX(),
                anchorRawY = readCenterY(),
            )
            if (ok) {
                Log.i(TAG, "gesture $type action $action succeeded")
            } else {
                Log.w(TAG, "gesture $type action $action returned false")
            }
        }.onFailure { error ->
            Log.e(TAG, "execute shake action failed: $action", error)
        }
        deliverFeedback(shake, type, action)
    }

    private fun dispatchAccessibilityAction(
        action: GestureAction,
        type: ShakeGestureType,
        shake: ShakeGestureSettings,
        attempt: Int,
    ) {
        val ok = SlideIndexAccessibilityService.perform(action)
        if (ok) {
            deliverFeedback(shake, type, action)
            Log.i(TAG, "gesture $type action $action succeeded")
            return
        }
        if (attempt < 2) {
            Log.d(TAG, "gesture $type action $action retry ${attempt + 1}")
            mainHandler.postDelayed({
                dispatchAccessibilityAction(action, type, shake, attempt + 1)
            }, 100L)
            return
        }
        Log.w(TAG, "gesture $type action $action FAILED ??accessibility connected=${SlideIndexAccessibilityService.isConnected()}")
    }

    private fun deliverFeedback(
        shake: ShakeGestureSettings,
        type: ShakeGestureType,
        action: GestureAction,
    ) {
        if (shake.vibrationFeedbackEnabled) {
            ShakeVibrationHelper.vibrate(appContext)
        }
        if (shake.animationFeedbackEnabled) {
            ShakeFeedbackOverlay.showGestureFeedback(appContext, type, action, shake.animationColorArgb)
        }
    }

    private fun resolveForegroundPackage(): String? =
        OverlayService.foregroundPackage ?: SlideIndexAccessibilityService.currentForegroundPackage()

    private fun isLockScreenActive(): Boolean {
        val keyguard = appContext.getSystemService(Context.KEYGUARD_SERVICE) as? KeyguardManager
        return keyguard?.isKeyguardLocked == true
    }

    private fun actionExecutor(): ActionExecutor {
        val ctx = SlideIndexAccessibilityService.overlayHostContext() ?: appContext
        return ActionExecutor(ctx, deps.appRepository, onShellCommandsPersist = { commands ->
            deps.applicationScope.launch {
                deps.settingsRepository.setShellCommands(commands)
            }
        })
    }

    private fun readCenterX(): Float {
        val metrics = DisplayMetrics()
        val wm = appContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        @Suppress("DEPRECATION")
        runCatching { wm.defaultDisplay.getRealMetrics(metrics) }
        return metrics.widthPixels / 2f
    }

    private fun readCenterY(): Float {
        val metrics = DisplayMetrics()
        val wm = appContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        @Suppress("DEPRECATION")
        runCatching { wm.defaultDisplay.getRealMetrics(metrics) }
        return metrics.heightPixels / 2f
    }

    private fun requiresAccessibilityService(action: GestureAction): Boolean = when (action) {
        GestureAction.Back,
        GestureAction.Home,
        GestureAction.Recents,
        GestureAction.OpenNotifications,
        GestureAction.OpenQuickSettings,
        GestureAction.LockScreen,
        GestureAction.Screenshot,
        GestureAction.PowerMenu,
        GestureAction.PreviousApp,
        GestureAction.KeepScreenOn,
        GestureAction.ScrollToTop,
        GestureAction.ScrollToBottom,
        -> true
        else -> false
    }

    private fun powerManager(): PowerManager =
        appContext.getSystemService(Context.POWER_SERVICE) as PowerManager

    companion object {
        private const val TAG = "ShakeGestureHost"
    }
}
