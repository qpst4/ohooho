package com.slideindex.app.search

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ImageSearchEngineTest {
    @Test
    fun yandexUsesDirectPostUpload() {
        val yandex = ImageSearchEngine.Yandex
        assertFalse(yandex.usesHostedUrl)
        assertTrue(yandex.usesDirectPost)
        assertEquals(
            "https://yandex.com/images/search?rpt=imageview&cbir_page=sites",
            yandex.postUploadUrl,
        )
        assertEquals("https://yandex.com/images/", yandex.webViewBaseUrl)
        assertTrue(ImageSearchEngine.directPostEngines.contains(yandex))
        assertFalse(ImageSearchEngine.hostedUrlEngines.contains(yandex))
    }
}
