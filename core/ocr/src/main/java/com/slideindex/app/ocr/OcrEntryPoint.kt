package com.slideindex.app.ocr

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface OcrEntryPoint {
    fun ocrInferenceService(): OcrInferenceService
    fun ocrModelRepository(): OcrModelRepository
    fun ocrModelDownloader(): OcrModelDownloader
    fun ocrModelCatalogProvider(): OcrModelCatalogProvider
}

object OcrDependencyAccess {
    fun inferenceService(context: Context): OcrInferenceService? =
        entryPoint(context)?.ocrInferenceService()

    fun modelRepository(context: Context): OcrModelRepository? =
        entryPoint(context)?.ocrModelRepository()

    fun modelDownloader(context: Context): OcrModelDownloader? =
        entryPoint(context)?.ocrModelDownloader()

    fun catalogProvider(context: Context): OcrModelCatalogProvider? =
        entryPoint(context)?.ocrModelCatalogProvider()

    private fun entryPoint(context: Context): OcrEntryPoint? =
        runCatching {
            EntryPointAccessors.fromApplication(
                context.applicationContext,
                OcrEntryPoint::class.java,
            )
        }.getOrNull()
}
