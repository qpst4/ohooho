package com.slideindex.app.translate

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class TranslateLanguageInstallManifest(
    val languageCode: String,
    val installedAtEpochMs: Long,
)

@Singleton
class TranslateModelRepository @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val json = Json { ignoreUnknownKeys = true }

    private val rootDir: File
        get() = File(context.filesDir, "translate-models").apply { mkdirs() }

    fun isInstalled(languageCode: String): Boolean =
        manifestFile(languageCode).exists()

    fun installedLanguageCodes(): Set<String> =
        rootDir.listFiles()
            ?.filter { it.isDirectory && manifestFile(it.name).exists() }
            ?.map { it.name }
            ?.toSet()
            .orEmpty()

    fun writeInstalled(languageCode: String) {
        val dir = File(rootDir, languageCode)
        dir.mkdirs()
        manifestFile(languageCode).writeText(
            json.encodeToString(
                TranslateLanguageInstallManifest.serializer(),
                TranslateLanguageInstallManifest(
                    languageCode = languageCode,
                    installedAtEpochMs = System.currentTimeMillis(),
                ),
            ),
        )
    }

    fun deleteLanguage(languageCode: String) {
        File(rootDir, languageCode).deleteRecursively()
    }

    private fun manifestFile(languageCode: String): File =
        File(File(rootDir, languageCode), "manifest.json")
}
