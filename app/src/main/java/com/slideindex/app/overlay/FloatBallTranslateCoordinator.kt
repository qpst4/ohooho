package com.slideindex.app.overlay

import android.content.Context
import com.slideindex.app.di.OverlayDependencyAccess
import com.slideindex.app.settings.FloatBallTranslateEngine
import com.slideindex.app.translate.TranslateDependencyAccess
import com.slideindex.app.translate.TranslateEngine
import com.slideindex.app.translate.TranslateResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

object FloatBallTranslateCoordinator {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun translate(context: Context, text: String) {
        val trimmed = text.trim()
        if (trimmed.isEmpty()) return

        val settings = OverlayDependencyAccess.overlayDependencies(context)
            ?.settingsRepository
            ?.readSnapshot()
            ?: return

        if (!settings.floatBallInstantTranslate) {
            FloatBallTextPick.translateText(context, trimmed)
            return
        }

        val targetLang = settings.floatBallTranslateTargetLang.ifBlank { "zh-CN" }
        val engine = when (settings.floatBallTranslateEngine) {
            FloatBallTranslateEngine.GOOGLE -> TranslateEngine.GOOGLE
            FloatBallTranslateEngine.ML_KIT -> TranslateEngine.ML_KIT
        }

        FloatBallTranslatePanel.showLoading(context)
        scope.launch {
            val service = TranslateDependencyAccess.translateService(context)
            if (service == null) {
                FloatBallTranslatePanel.showError(context, "translate_unavailable")
                return@launch
            }
            when (val result = service.translate(trimmed, targetLang, engine)) {
                is TranslateResult.Success -> {
                    FloatBallTranslatePanel.showResult(context, result.translatedText)
                }
                is TranslateResult.Failure -> {
                    FloatBallTranslatePanel.showError(context, mapErrorMessage(result.message))
                }
            }
        }
    }

    private fun mapErrorMessage(code: String): String = when (code) {
        "target_model_not_installed", "source_model_not_installed", "model_download_required" ->
            "mlkit_model_not_installed"
        "wifi_required" -> "wifi_required"
        "unsupported_target_language" -> "unsupported_language"
        else -> code
    }
}
