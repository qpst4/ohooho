package com.slideindex.app.search

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Assert.assertThrows

class ImageSearchUrlBuilderTest {
    @Test
    fun build_googleHostedUrl() {
        val url = ImageSearchUrlBuilder.build(
            ImageSearchEngine.Google,
            "https://example.com/image.jpg",
        )
        assertEquals(
            "https://lens.google.com/uploadbyurl?url=https%3A%2F%2Fexample.com%2Fimage.jpg",
            url,
        )
    }

    @Test
    fun build_rejectsDirectPostEngines() {
        assertThrows(IllegalArgumentException::class.java) {
            ImageSearchUrlBuilder.build(
                ImageSearchEngine.Yandex,
                "https://example.com/image.jpg",
            )
        }
    }
}
