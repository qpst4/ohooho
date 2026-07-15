package com.slideindex.app.ocr

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.IOException
import java.security.MessageDigest
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

@Singleton
class OcrModelDownloader @Inject constructor(
    @ApplicationContext private val context: Context,
    private val catalogProvider: OcrModelCatalogProvider,
    private val repository: OcrModelRepository,
    private val mlKitChineseModuleInstaller: MlKitChineseModuleInstaller,
) {
    private val client = OkHttpClient.Builder()
        .followRedirects(true)
        .followSslRedirects(true)
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.MINUTES)
        .writeTimeout(10, TimeUnit.MINUTES)
        .build()

    @Volatile
    private var activeModelId: String? = null

    fun isDownloading(modelId: String): Boolean = activeModelId == modelId

    fun downloadModel(
        modelId: String,
        wifiOnly: Boolean,
    ): Flow<OcrModelDownloadState> = channelFlow {
        if (activeModelId != null && activeModelId != modelId) {
            send(
                OcrModelDownloadState(
                    modelId = modelId,
                    phase = OcrModelDownloadPhase.FAILED,
                    errorMessage = "another_download_in_progress",
                ),
            )
            return@channelFlow
        }
        val entry = catalogProvider.findModel(modelId)
        if (entry == null) {
            send(
                OcrModelDownloadState(
                    modelId = modelId,
                    phase = OcrModelDownloadPhase.FAILED,
                    errorMessage = "model_not_found",
                ),
            )
            return@channelFlow
        }
        if (entry.engine == OcrEngines.MLKIT_CHINESE) {
            activeModelId = modelId
            try {
                mlKitChineseModuleInstaller.install(modelId, wifiOnly).collect { state ->
                    send(state)
                }
            } finally {
                if (activeModelId == modelId) {
                    activeModelId = null
                }
            }
            return@channelFlow
        }
        if (wifiOnly && !isOnWifi()) {
            send(
                OcrModelDownloadState(
                    modelId = modelId,
                    phase = OcrModelDownloadPhase.FAILED,
                    errorMessage = "wifi_required",
                ),
            )
            return@channelFlow
        }

        activeModelId = modelId
        try {
            repository.ensureModelDirectory(modelId)
            var totalDownloaded = 0L
            val totalBytes = entry.sizeBytes.takeIf { it > 0L }

            for ((index, spec) in entry.files.withIndex()) {
                currentCoroutineContext().ensureActive()
                val target = repository.targetFile(modelId, spec.relativePath)
                val partial = repository.partialFile(modelId, spec.relativePath)
                target.parentFile?.mkdirs()

                if (isTargetReady(target, spec.sha256)) {
                    totalDownloaded += target.length()
                    continue
                }
                if (target.exists()) target.delete()
                if (partial.exists()) partial.delete()

                send(
                    OcrModelDownloadState(
                        modelId = modelId,
                        phase = OcrModelDownloadPhase.DOWNLOADING,
                        bytesDownloaded = totalDownloaded,
                        totalBytes = totalBytes,
                        currentFileIndex = index + 1,
                        totalFiles = entry.files.size,
                    ),
                )

                val downloadUrls = buildList {
                    addAll(spec.mirrorUrls)
                    add(spec.url)
                }.distinct().filterNot { it.contains("huggingface.co", ignoreCase = true) }
                    .ifEmpty { listOf(spec.url) }
                downloadFileWithFallback(
                    urls = downloadUrls,
                    output = partial,
                    relativePath = spec.relativePath,
                ) { fileBytesDownloaded ->
                    currentCoroutineContext().ensureActive()
                    trySend(
                        OcrModelDownloadState(
                            modelId = modelId,
                            phase = OcrModelDownloadPhase.DOWNLOADING,
                            bytesDownloaded = totalDownloaded + fileBytesDownloaded,
                            totalBytes = totalBytes,
                            currentFileIndex = index + 1,
                            totalFiles = entry.files.size,
                        ),
                    )
                }

                if (!partial.isFile || partial.length() <= 0L) {
                    partial.delete()
                    throw IOException("download_empty:${spec.relativePath}")
                }

                send(
                    OcrModelDownloadState(
                        modelId = modelId,
                        phase = OcrModelDownloadPhase.VERIFYING,
                        bytesDownloaded = totalDownloaded,
                        totalBytes = totalBytes,
                        currentFileIndex = index + 1,
                        totalFiles = entry.files.size,
                    ),
                )

                val sha256 = spec.sha256
                if (!sha256.isNullOrBlank()) {
                    val actual = sha256Hex(partial)
                    if (!actual.equals(sha256, ignoreCase = true)) {
                        partial.delete()
                        throw IOException("checksum_mismatch:${spec.relativePath}")
                    }
                }

                send(
                    OcrModelDownloadState(
                        modelId = modelId,
                        phase = OcrModelDownloadPhase.FINALIZING,
                        bytesDownloaded = totalDownloaded,
                        totalBytes = totalBytes,
                        currentFileIndex = index + 1,
                        totalFiles = entry.files.size,
                    ),
                )

                finalizeDownloadedFile(partial, target)
                totalDownloaded += target.length()
            }

            repository.writeManifest(
                OcrModelInstallManifest(
                    modelId = modelId,
                    catalogVersion = catalogProvider.catalog.version,
                    installedAtEpochMs = System.currentTimeMillis(),
                    sizeBytes = totalDownloaded,
                ),
            )

            send(
                OcrModelDownloadState(
                    modelId = modelId,
                    phase = OcrModelDownloadPhase.READY,
                    bytesDownloaded = totalDownloaded,
                    totalBytes = totalDownloaded,
                    totalFiles = entry.files.size,
                    currentFileIndex = entry.files.size,
                ),
            )
        } catch (cancelled: CancellationException) {
            send(
                OcrModelDownloadState(
                    modelId = modelId,
                    phase = OcrModelDownloadPhase.CANCELLED,
                ),
            )
            throw cancelled
        } catch (error: Throwable) {
            send(
                OcrModelDownloadState(
                    modelId = modelId,
                    phase = OcrModelDownloadPhase.FAILED,
                    errorMessage = error.message ?: error.javaClass.simpleName,
                ),
            )
        } finally {
            if (activeModelId == modelId) {
                activeModelId = null
            }
        }
    }

    suspend fun deleteModel(modelId: String) = withContext(Dispatchers.IO) {
        val entry = catalogProvider.findModel(modelId)
        if (entry?.engine == OcrEngines.MLKIT_CHINESE) {
            mlKitChineseModuleInstaller.release()
        }
        repository.deleteModel(modelId)
    }

    private fun isTargetReady(target: File, sha256: String?): Boolean {
        if (!target.isFile || target.length() <= 0L) return false
        if (sha256.isNullOrBlank()) return true
        return sha256Hex(target).equals(sha256, ignoreCase = true)
    }

    private fun finalizeDownloadedFile(partial: File, target: File) {
        if (!partial.isFile || partial.length() <= 0L) {
            throw IOException("partial_missing:${partial.absolutePath}")
        }
        target.parentFile?.mkdirs()
        if (target.exists()) target.delete()
        partial.copyTo(target, overwrite = true)
        partial.delete()
        if (!target.isFile || target.length() <= 0L) {
            target.delete()
            throw IOException("finalize_failed:${target.absolutePath}")
        }
    }

    private suspend fun downloadFileWithFallback(
        urls: List<String>,
        output: File,
        relativePath: String,
        onProgress: suspend (Long) -> Unit,
    ) {
        val minBytes = minBytesFor(relativePath)
        var lastError: Throwable? = null
        for (url in urls.distinct()) {
            try {
                if (!output.isFile || output.length() < minBytes) {
                    if (output.exists()) output.delete()
                    downloadFile(
                        url = url,
                        output = output,
                        relativePath = relativePath,
                        onProgress = onProgress,
                    )
                }
                val size = output.length()
                if (output.isFile && size >= minBytes) return
                lastError = IOException("download_too_small:${size}:$url")
                if (output.exists() && size < minBytes) output.delete()
            } catch (error: Throwable) {
                val size = if (output.exists()) output.length() else 0L
                if (output.isFile && size >= minBytes) return
                lastError = error
                if (output.exists() && size < minBytes) output.delete()
            }
        }
        throw IOException(
            "download_failed:${lastError?.message ?: "unknown"}",
            lastError,
        )
    }

    private suspend fun downloadFile(
        url: String,
        output: File,
        relativePath: String,
        onProgress: suspend (Long) -> Unit,
    ) = withContext(Dispatchers.IO) {
        output.parentFile?.mkdirs()
        if (output.exists()) output.delete()
        val request = Request.Builder()
            .url(url)
            .header("User-Agent", DOWNLOAD_USER_AGENT)
            .header("Accept", "application/octet-stream,*/*")
            .apply {
                if (url.contains("modelscope.cn", ignoreCase = true)) {
                    header("Referer", "https://www.modelscope.cn/")
                }
            }
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("http_${response.code}:$url")
            }
            val body = response.body ?: throw IOException("empty_body:$url")
            val expectedLength = body.contentLength()
            body.byteStream().use { input ->
                java.io.FileOutputStream(output).use { stream ->
                    val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
                    var fileDownloaded = 0L
                    while (true) {
                        currentCoroutineContext().ensureActive()
                        val read = input.read(buffer)
                        if (read <= 0) break
                        stream.write(buffer, 0, read)
                        fileDownloaded += read
                        onProgress(fileDownloaded)
                    }
                    stream.fd.sync()
                }
            }
            val actualLength = output.length()
            val minBytes = minBytesFor(relativePath)
            if (!output.isFile || actualLength < minBytes) {
                output.delete()
                throw IOException("download_too_small:${actualLength}:$url")
            }
            if (expectedLength > 0L && actualLength != expectedLength) {
                output.delete()
                throw IOException("download_size_mismatch:expected=$expectedLength,actual=$actualLength:$url")
            }
        }
    }

    private fun minBytesFor(relativePath: String): Long = when {
        relativePath.endsWith(".onnx", ignoreCase = true) -> MIN_ONNX_FILE_BYTES
        relativePath.endsWith(".traineddata", ignoreCase = true) -> MIN_TRAINEDDATA_FILE_BYTES
        else -> 1L
    }

    private fun isOnWifi(): Boolean {
        val connectivity = context.getSystemService(ConnectivityManager::class.java) ?: return true
        val network = connectivity.activeNetwork ?: return false
        val capabilities = connectivity.getNetworkCapabilities(network) ?: return false
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }

    private fun sha256Hex(file: File): String {
        val digest = MessageDigest.getInstance("SHA-256")
        file.inputStream().use { input ->
            val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
            while (true) {
                val read = input.read(buffer)
                if (read <= 0) break
                digest.update(buffer, 0, read)
            }
        }
        return digest.digest().joinToString("") { byte -> "%02x".format(byte) }
    }

    private companion object {
        private const val MIN_ONNX_FILE_BYTES = 64L * 1024L
        private const val MIN_TRAINEDDATA_FILE_BYTES = 512L * 1024L
        private const val DOWNLOAD_USER_AGENT =
            "SlideIndex/1.0 (Android; okhttp) ModelDownloader"
    }
}
