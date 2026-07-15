package com.slideindex.app.ui.viewmodel

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.slideindex.app.ocr.OcrInferenceService
import com.slideindex.app.ocr.OcrModelCatalogProvider
import com.slideindex.app.ocr.OcrModelDownloadPhase
import com.slideindex.app.ocr.OcrModelDownloadState
import com.slideindex.app.ocr.OcrModelDownloader
import com.slideindex.app.ocr.OcrModelEntry
import com.slideindex.app.ocr.OcrModelRepository
import com.slideindex.app.settings.SettingsRepository
import com.slideindex.app.ui.feedback.UserMessageBus
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class OcrModelSettingsViewModel @Inject constructor(
    settingsRepository: SettingsRepository,
    userMessageBus: UserMessageBus,
    @ApplicationContext context: Context,
    private val catalogProvider: OcrModelCatalogProvider,
    private val modelRepository: OcrModelRepository,
    private val downloader: OcrModelDownloader,
    private val inferenceService: OcrInferenceService,
) : SettingsViewModel(settingsRepository, userMessageBus, context) {
    val catalogModels: List<OcrModelEntry> = catalogProvider.allModels()

    private val _installedModelIds = MutableStateFlow(modelRepository.installedModelIds())
    val installedModelIds: StateFlow<Set<String>> = _installedModelIds.asStateFlow()

    private val _downloadState = MutableStateFlow<OcrModelDownloadState?>(null)
    val downloadState: StateFlow<OcrModelDownloadState?> = _downloadState.asStateFlow()

    private var downloadJob: Job? = null

    init {
        refreshInstalled()
    }

    fun refreshInstalled() {
        _installedModelIds.value = modelRepository.installedModelIds()
    }

    fun selectModel(modelId: String) = launchSettingsWrite {
        settingsRepository.setFloatBallOcrModelId(modelId).also {
            inferenceService.invalidateIfModelChanged(modelId)
        }
    }

    fun clearSelectedModel() = launchSettingsWrite {
        settingsRepository.setFloatBallOcrModelId("").also {
            inferenceService.invalidateIfModelChanged(null)
        }
    }

    fun setDownloadWifiOnly(enabled: Boolean) = launchSettingsWrite {
        settingsRepository.setOcrDownloadWifiOnly(enabled)
    }

    fun downloadModel(modelId: String) {
        if (downloadJob?.isActive == true) return
        downloadJob = viewModelScope.launch {
            val wifiOnly = settings.value.ocrDownloadWifiOnly
            downloader.downloadModel(modelId, wifiOnly).collect { state ->
                _downloadState.value = state
                when (state.phase) {
                    OcrModelDownloadPhase.READY -> {
                        refreshInstalled()
                        viewModelScope.launch {
                            selectModel(modelId)
                        }
                    }
                    OcrModelDownloadPhase.FAILED,
                    OcrModelDownloadPhase.CANCELLED,
                    -> refreshInstalled()
                    else -> Unit
                }
            }
        }
    }

    fun deleteModel(modelId: String) = viewModelScope.launch {
        downloader.deleteModel(modelId)
        refreshInstalled()
        if (settings.value.floatBallOcrModelId == modelId) {
            clearSelectedModel()
        }
        inferenceService.invalidateIfModelChanged(settings.value.floatBallOcrModelId.ifBlank { null })
    }
}
