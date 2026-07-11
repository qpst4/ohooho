package com.slideindex.app.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.service.notification.StatusBarNotification
import android.util.Log

object NotificationHistoryIntentCapture {

    data class CapturedIntent(
        val intentUri: String?,
        val intentParcelBase64: String?,
        val intentExtrasBase64: String?,
        val pendingIntentBase64: String?,
        val extrasBase64: String?,
    )

    fun capture(sbn: StatusBarNotification, context: Context): CapturedIntent {
        val notification = sbn.notification ?: return emptyCapture()
        val notificationExtras = notification.extras
        val extrasBase64 = NotificationHistoryIntentSerialization.serializeNotificationExtras(notificationExtras)

        val contentPi = notification.contentIntent
        var pendingIntentBase64: String? = null
        if (contentPi != null) {
            pendingIntentBase64 = NotificationHistoryIntentSerialization.serializePendingIntent(contentPi, "contentIntent")
        }

        val pendingIntentSources = NotificationHistoryIntentExtraction.collectPendingIntentSources(
            notification,
            notificationExtras,
        )
        if (pendingIntentBase64.isNullOrBlank()) {
            for ((pendingIntent, source) in pendingIntentSources) {
                if (source == "contentIntent") continue
                pendingIntentBase64 = NotificationHistoryIntentSerialization.serializePendingIntent(pendingIntent, source)
                if (!pendingIntentBase64.isNullOrBlank()) break
            }
        }

        Log.i(
            NotificationHistoryIntentSerialization.TAG,
            "Captured ${sbn.packageName} pi=${contentPi != null} " +
                "piBytes=${pendingIntentBase64?.length} contentIntent=${notification.contentIntent}",
        )

        if (pendingIntentBase64.isNullOrBlank()) {
            Log.w(
                NotificationHistoryIntentSerialization.TAG,
                "No PendingIntent captured for ${sbn.packageName} key=${sbn.key} " +
                    "flags=0x${Integer.toHexString(notification.flags)} " +
                    "category=${notification.category} " +
                    "contentIntent=${notification.contentIntent} " +
                    "fullScreenIntent=${notification.fullScreenIntent} " +
                    "publicVersionPi=${notification.publicVersion?.contentIntent} " +
                    "actions=${notification.actions?.size ?: 0} " +
                    "extrasKeys=${notificationExtras?.keySet()?.joinToString(",")}",
            )
        }

        val extrasIntent = NotificationHistoryIntentExtraction.extractIntentFromNotificationExtras(
            notificationExtras,
            context,
        )
        var resolvedIntent: Intent? = extrasIntent?.takeIf { NotificationHistoryIntentExtraction.isLaunchable(it) }
            ?: extrasIntent
        for ((pendingIntent, source) in pendingIntentSources) {
            val piIntent = NotificationHistoryIntentExtraction.extractIntent(context, pendingIntent)
            if (piIntent == null) {
                Log.d(
                    NotificationHistoryIntentSerialization.TAG,
                    "Could not extract Intent from PendingIntent source=$source for ${sbn.packageName}",
                )
                continue
            }
            resolvedIntent = when {
                NotificationHistoryIntentExtraction.isLaunchable(piIntent) -> piIntent
                resolvedIntent == null -> piIntent
                else -> resolvedIntent
            }
            if (NotificationHistoryIntentExtraction.isLaunchable(piIntent)) break
        }
        if (resolvedIntent == null || !NotificationHistoryIntentExtraction.isLaunchable(resolvedIntent)) {
            NotificationHistoryIntentExtraction.extractMessagingStyleIntent(notificationExtras)?.let { messagingIntent ->
                resolvedIntent = messagingIntent
            }
        }

        return if (resolvedIntent != null) {
            CapturedIntent(
                intentUri = NotificationHistoryIntentSerialization.serializeIntentUri(resolvedIntent, "resolved"),
                intentParcelBase64 = NotificationHistoryIntentSerialization.serializeIntentParcel(resolvedIntent, "resolved"),
                intentExtrasBase64 = NotificationHistoryIntentSerialization.serializeExtras(resolvedIntent, "resolved"),
                pendingIntentBase64 = pendingIntentBase64,
                extrasBase64 = extrasBase64,
            )
        } else {
            CapturedIntent(null, null, null, pendingIntentBase64, extrasBase64)
        }
    }

    fun captureIntentUri(sbn: StatusBarNotification, context: Context): String? =
        capture(sbn, context).intentUri

    fun deserializeIntent(
        intentUri: String?,
        intentParcelBase64: String?,
        intentExtrasBase64: String? = null,
    ): Intent? {
        val fromParcel = NotificationHistoryIntentSerialization.deserializeIntentParcel(intentParcelBase64)?.let {
            Intent(it)
        }
        val parsed = if (fromParcel != null) {
            fromParcel
        } else if (!intentUri.isNullOrBlank()) {
            NotificationHistoryIntentSerialization.parseIntentUri(intentUri)
        } else {
            null
        } ?: return null

        NotificationHistoryIntentSerialization.mergeExtras(parsed, intentExtrasBase64)
        return parsed
    }

    fun deserializeIntentFromNotificationExtras(
        extrasBase64: String?,
        context: Context,
        packageName: String,
    ): Intent? {
        val extras = NotificationHistoryIntentSerialization.deserializeBundle(extrasBase64) ?: return null
        return NotificationHistoryIntentExtraction.extractIntentFromNotificationExtras(extras, context)
            ?.let { prepareIntentForReplay(it, packageName) }
    }

    fun deserializePendingIntent(pendingIntentBase64: String?): PendingIntent? =
        NotificationHistoryIntentSerialization.deserializePendingIntent(pendingIntentBase64)

    fun serializeIntentParcel(intent: Intent): String? =
        NotificationHistoryIntentSerialization.serializeIntentParcel(Intent(intent), "replay")

    fun deserializeIntentParcel(intentParcelBase64: String?): Intent? =
        NotificationHistoryIntentSerialization.deserializeIntentParcel(intentParcelBase64)

    fun serializeBundle(bundle: android.os.Bundle?, source: String): String? =
        NotificationHistoryIntentSerialization.serializeBundle(bundle, source)

    fun deserializeBundle(bundleBase64: String?): android.os.Bundle? =
        NotificationHistoryIntentSerialization.deserializeBundle(bundleBase64)

    fun prepareIntentForReplay(intent: Intent, packageName: String): Intent {
        return Intent(intent).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            if (component == null && `package`.isNullOrBlank()) {
                setPackage(packageName)
            }
        }
    }

    fun enrichIntentForReplay(
        intent: Intent,
        extrasBase64: String?,
        context: Context,
        packageName: String,
    ): Intent {
        val prepared = prepareIntentForReplay(intent, packageName)
        val extras = NotificationHistoryIntentSerialization.deserializeBundle(extrasBase64) ?: return prepared
        NotificationHistoryIntentExtraction.extractIntentFromNotificationExtras(extras, context)?.let { extraIntent ->
            NotificationHistoryIntentExtraction.mergeReplayIntent(prepared, extraIntent)
        }
        return prepared
    }

    fun isLaunchableIntent(intent: Intent?): Boolean =
        NotificationHistoryIntentExtraction.isLaunchable(intent)

    private fun emptyCapture() = CapturedIntent(null, null, null, null, null)
}
