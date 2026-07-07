package com.slideindex.app.notification

import android.app.Notification
import android.content.Context
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import com.slideindex.app.SlideIndexApp
import com.slideindex.app.otp.NotificationTextExtractor
import com.slideindex.app.otp.OtpAutoFillController
import com.slideindex.app.otp.OtpClipboardHelper
import com.slideindex.app.otp.OtpExtractionConfig
import com.slideindex.app.otp.OtpOfficialRulesLoader
import com.slideindex.app.otp.VerificationCodeExtractor
import com.slideindex.app.service.MediaNotificationListener
import com.slideindex.app.service.SlideIndexAccessibilityService

object NotificationHistoryRecorder {
    private const val TAG = "NotifFilterRecorder"

    fun onListenerConnected(
        context: Context,
        listener: NotificationListenerService,
        notifications: Array<StatusBarNotification>,
    ) {
        NotificationSbnCache.refreshActive(notifications.toList())
        notifications.forEach { onPosted(context, listener, it) }
    }

    fun applyAutoHideToActive(context: Context) {
        val app = context.applicationContext as? SlideIndexApp ?: return
        val listener = MediaNotificationListener.instance ?: return
        val filterSettings = app.notificationFilterPreferences.readSnapshot()
        if (!filterSettings.autoHideOngoingEnabled &&
            app.notificationFilterRepository.rules.value.isEmpty()
        ) {
            return
        }
        val notifications = runCatching { listener.activeNotifications?.toList() }.getOrNull() ?: return
        Log.d(TAG, "applyAutoHideToActive: scanning ${notifications.size} active notifications")
        notifications.forEach { sbn -> onPosted(context, listener, sbn) }
    }

    fun onPosted(
        context: Context,
        listener: NotificationListenerService,
        sbn: StatusBarNotification,
    ) {
        val notification = sbn.notification ?: return
        val extras = notification.extras ?: return
        val content = NotificationTextExtractor.extract(extras)
        val title = content.title
        val text = content.text
        if (title.isBlank() && text.isBlank()) return

        NotificationSbnCache.cacheActive(sbn)

        val app = context.applicationContext as? SlideIndexApp ?: return
        val filterSettings = app.notificationFilterPreferences.readSnapshot()
        val shouldHide = NotificationHider.shouldHide(context, filterSettings, app.notificationFilterRepository, sbn)

        val capturedIntent = NotificationHistoryIntentCapture.capture(sbn, context)
        Log.i(
            TAG,
            "Record ${sbn.packageName} key=${sbn.key} " +
                "pi=${!capturedIntent.pendingIntentBase64.isNullOrBlank()} " +
                "uri=${!capturedIntent.intentUri.isNullOrBlank()} " +
                "parcel=${!capturedIntent.intentParcelBase64.isNullOrBlank()} " +
                "notificationExtras=${!capturedIntent.extrasBase64.isNullOrBlank()}",
        )

        val settings = app.settingsRepository.readSnapshot()
        val officialRules = app.otpOfficialRulesLoader.getRules()
        val extraction = VerificationCodeExtractor.extract(
            packageName = sbn.packageName,
            title = title,
            text = text,
            config = OtpExtractionConfig.build(
                keywordsRegex = settings.otpKeywordsRegex,
                officialRules = officialRules,
                userRules = settings.otpUserMatchRules,
                disabledOfficialRuleIds = settings.otpDisabledOfficialRuleIds,
            ),
        )
        val extractedCode = extraction.code
        if (!extractedCode.isNullOrBlank()) {
            Log.i(TAG, "Extracted OTP from ${sbn.packageName}")
            app.otpRecordsRepository.record(
                code = extractedCode,
                packageName = sbn.packageName,
                title = title,
                text = text,
                timestampMs = sbn.postTime.takeIf { it > 0L } ?: System.currentTimeMillis(),
                ruleName = extraction.ruleName,
            )
            if (settings.otpCopyToClipboard) {
                OtpClipboardHelper.copyCode(context, extractedCode)
            }
            if (settings.otpAutoInputEnabled) {
                OtpAutoFillController.queueCode(extractedCode)
                SlideIndexAccessibilityService.scheduleOtpAutoFill()
            }
        }

        val item = NotificationHistoryItem(
            packageName = sbn.packageName,
            title = title,
            text = text,
            postedAtMs = sbn.postTime.takeIf { it > 0L } ?: System.currentTimeMillis(),
            intentUri = capturedIntent.intentUri,
            intentParcelBase64 = capturedIntent.intentParcelBase64,
            intentExtrasBase64 = capturedIntent.intentExtrasBase64,
            pendingIntentBase64 = capturedIntent.pendingIntentBase64,
            extrasBase64 = capturedIntent.extrasBase64,
            notificationKey = sbn.key,
            hidden = shouldHide,
            extractedCode = extractedCode,
            extractionAttempted = extraction.attempted,
        )
        app.notificationHistoryRepository.record(item)

        if (shouldHide) {
            NotificationHider.hideFromShade(listener, sbn)
        }
    }

    fun onRemoved(context: Context, sbn: StatusBarNotification, reason: Int) {
        NotificationSbnCache.onRemoved(sbn, reason)

        val app = context.applicationContext as? SlideIndexApp ?: return
        val captured = NotificationHistoryIntentCapture.capture(sbn, context)
        val hasCapture = !captured.pendingIntentBase64.isNullOrBlank() ||
            !captured.intentUri.isNullOrBlank() ||
            !captured.intentParcelBase64.isNullOrBlank() ||
            !captured.extrasBase64.isNullOrBlank()
        if (!hasCapture) return
        Log.i(
            TAG,
            "Refresh capture on remove ${sbn.packageName} key=${sbn.key} " +
                "pi=${!captured.pendingIntentBase64.isNullOrBlank()} " +
                "uri=${!captured.intentUri.isNullOrBlank()} " +
                "parcel=${!captured.intentParcelBase64.isNullOrBlank()}",
        )
        app.notificationHistoryRepository.updateCapture(sbn.key, captured)
    }
}
