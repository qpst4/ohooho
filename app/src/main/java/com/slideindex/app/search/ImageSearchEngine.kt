package com.slideindex.app.search

enum class ImageSearchEngine(
    val displayName: String,
    val usesHostedUrl: Boolean = false,
    val usesDirectPost: Boolean = false,
    val postUploadUrl: String? = null,
    val webViewBaseUrl: String? = null,
    val externalPageUrl: String? = null,
) {
    Google(
        displayName = "Google",
        usesHostedUrl = true,
        externalPageUrl = "https://lens.google.com/",
    ),
    Yandex(
        displayName = "Yandex",
        usesDirectPost = true,
        postUploadUrl = "https://yandex.com/images/search?rpt=imageview&cbir_page=sites",
        webViewBaseUrl = "https://yandex.com/images/",
        externalPageUrl = "https://yandex.com/images/",
    ),
    TinEye(
        displayName = "TinEye",
        usesHostedUrl = true,
        externalPageUrl = "https://tineye.com/",
    ),
    Iqdb(
        displayName = "IQDB",
        usesDirectPost = true,
        postUploadUrl = "https://iqdb.org/",
        webViewBaseUrl = "https://iqdb.org/",
        externalPageUrl = "https://iqdb.org/",
    ),
    SauceNao(
        displayName = "SauceNAO",
        usesDirectPost = true,
        postUploadUrl = "https://saucenao.com/search.php",
        webViewBaseUrl = "https://saucenao.com/",
        externalPageUrl = "https://saucenao.com/",
    ),
    Iqdb3D(
        displayName = "3D-IQDB",
        usesDirectPost = true,
        postUploadUrl = "https://3d.iqdb.org/",
        webViewBaseUrl = "https://3d.iqdb.org/",
        externalPageUrl = "https://3d.iqdb.org/",
    ),
    Ascii2d(
        displayName = "ASCII2D",
        usesDirectPost = true,
        postUploadUrl = "https://ascii2d.net/search/file",
        webViewBaseUrl = "https://ascii2d.net/",
        externalPageUrl = "https://ascii2d.net/",
    ),
    ;

    companion object {
        val hostedUrlEngines: List<ImageSearchEngine> = entries.filter { it.usesHostedUrl }
        val directPostEngines: List<ImageSearchEngine> = entries.filter { it.usesDirectPost }
    }
}
