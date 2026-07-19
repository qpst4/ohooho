package com.slideindex.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.slideindex.app.R
import com.slideindex.app.search.ImageSearchEngine
import com.slideindex.app.settings.AggregatedImageSearchEngineConfig

fun resolveImageSearchEngine(engineId: String): ImageSearchEngine? =
    ImageSearchEngine.entries.find { it.name == engineId }

@Composable
fun imageSearchEngineModeLabel(engine: ImageSearchEngine): String = stringResource(
    when {
        engine.usesDirectPost -> R.string.image_search_engine_mode_direct_post
        else -> R.string.image_search_engine_mode_hosted_url
    },
)

@Composable
fun imageSearchEngineModeDescription(engine: ImageSearchEngine): String = stringResource(
    when {
        engine.usesDirectPost -> R.string.image_search_engine_mode_direct_post_desc
        else -> R.string.image_search_engine_mode_hosted_url_desc
    },
)

@Composable
fun aggregatedImageSearchEngineRowSubtitle(
    engine: ImageSearchEngine,
    config: AggregatedImageSearchEngineConfig,
): String {
    val mode = imageSearchEngineModeLabel(engine)
    val status = aggregatedImageSearchEngineStatusSummary(config)
    return "$mode · $status"
}

@Composable
fun aggregatedImageSearchEngineStatusSummary(config: AggregatedImageSearchEngineConfig): String {
    if (!config.showInPanel) {
        return stringResource(R.string.image_search_engine_status_hidden)
    }
    return if (config.preloadOnOpen) {
        stringResource(R.string.image_search_engine_status_visible_preload)
    } else {
        stringResource(R.string.image_search_engine_status_visible_on_tab)
    }
}
