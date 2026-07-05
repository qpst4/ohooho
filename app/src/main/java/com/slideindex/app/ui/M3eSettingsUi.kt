@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.slideindex.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

internal val LocalSettingsSegmentRegistrar =
    compositionLocalOf<((@Composable (Int, Int) -> Unit) -> Unit)?> { null }

/**
 * Collects child settings rows and renders them as one M3E segmented group.
 * Replaces the legacy Card wrapper — each row is a [SegmentedListItem].
 */
@Composable
fun SettingsCard(content: @Composable () -> Unit) {
    val entries = remember { mutableListOf<@Composable (Int, Int) -> Unit>() }
    entries.clear()
    val registrar: (@Composable (Int, Int) -> Unit) -> Unit = { lambda -> entries.add(lambda) }
    CompositionLocalProvider(LocalSettingsSegmentRegistrar provides registrar) {
        content()
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(pickerListSegmentedGap()),
    ) {
        val count = entries.size
        key(count) {
            entries.forEachIndexed { index, entry ->
                entry(index, count)
            }
        }
    }
}

@Composable
internal fun RegisterSettingsSegment(
    content: @Composable (segmentIndex: Int, segmentCount: Int) -> Unit,
) {
    val registrar = LocalSettingsSegmentRegistrar.current
    if (registrar != null) {
        registrar { index, count -> content(index, count) }
    } else {
        content(0, 1)
    }
}
