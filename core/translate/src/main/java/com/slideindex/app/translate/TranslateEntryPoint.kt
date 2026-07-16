package com.slideindex.app.translate

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface TranslateEntryPoint {
    fun translateService(): TranslateService
    fun translateModelRepository(): TranslateModelRepository
    fun mlKitTranslateModelInstaller(): MlKitTranslateModelInstaller
}

object TranslateDependencyAccess {
    fun translateService(context: Context): TranslateService? =
        entryPoint(context)?.translateService()

    fun modelRepository(context: Context): TranslateModelRepository? =
        entryPoint(context)?.translateModelRepository()

    fun modelInstaller(context: Context): MlKitTranslateModelInstaller? =
        entryPoint(context)?.mlKitTranslateModelInstaller()

    private fun entryPoint(context: Context): TranslateEntryPoint? =
        runCatching {
            EntryPointAccessors.fromApplication(
                context.applicationContext,
                TranslateEntryPoint::class.java,
            )
        }.getOrNull()
}
