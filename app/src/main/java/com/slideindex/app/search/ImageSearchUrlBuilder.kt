package com.slideindex.app.search

import android.content.Context
import android.webkit.WebSettings
import java.net.URLEncoder

object ImageSearchUrlBuilder {
    fun build(engine: ImageSearchEngine, hostedImageUrl: String): String {
        val encoded = URLEncoder.encode(hostedImageUrl, Charsets.UTF_8.name())
        return when (engine) {
            ImageSearchEngine.Google ->
                "https://lens.google.com/uploadbyurl?url=$encoded"
            ImageSearchEngine.Yandex ->
                "https://yandex.com/images/search?rpt=imageview&url=$encoded"
            ImageSearchEngine.TinEye -> "https://tineye.com/search?url=$encoded"
        }
    }

    /** System default mobile Chrome UA for in-panel WebView engines. */
    fun userAgent(context: Context, engine: ImageSearchEngine): String {
        val defaultUa = WebSettings.getDefaultUserAgent(context)
        return if (engine == ImageSearchEngine.Google) {
            // Dynamically strip out the WebView specific tags from the system's default UA.
            // By NOT having '; wv' and 'Version/X.X', we bypass Catbox's WAF block so the image thumbnail loads,
            // while remaining aligned with the actual device Chrome version.
            defaultUa
                .replace("; wv", "")
                .replace(Regex("Version/[0-9.]+\\s"), "")
        } else {
            defaultUa
        }
    }
}
