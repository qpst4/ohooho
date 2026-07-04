package com.slideindex.app.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.SwipeRight
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.gesture.GestureTriggerType
import com.slideindex.app.gesture.TriggerHandle
import com.slideindex.app.gesture.actionFor
import com.slideindex.app.gesture.isEffective
import com.slideindex.app.gesture.sideTriggerPairs
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.settings.AppSettings

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun TriggerCollectionScreen(
    settings: AppSettings,
    serviceEnabled: Boolean,
    onBack: () -> Unit,
    onOpenLeftTrigger: (handleId: String) -> Unit,
    onOpenRightTrigger: (handleId: String) -> Unit,
    onAddTriggerPair: () -> Unit,
    onRemoveTriggerPair: (handleId: String) -> Unit,
) {
    var sideExpanded by rememberSaveable { mutableStateOf(true) }
    val pairs = settings.sideTriggerPairs()
    val pairColors = listOf(
        Color(0xFF7E57C2),
        Color(0xFF26A69A),
        Color(0xFFFF7043),
    )

    SettingsScreenScaffold(
        title = stringResource(R.string.trigger_collection_title),
        subtitle = stringResource(R.string.trigger_collection_desc),
        onBack = onBack,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            SettingsCard {
                RegisterSettingsSegment { segmentIndex, segmentCount ->
                    SegmentedListItem(
                        onClick = { sideExpanded = !sideExpanded },
                        shapes = pickerSegmentedShapes(segmentIndex, segmentCount),
                        colors = pickerSegmentedColors(),
                        trailingContent = {
                            Icon(
                                imageVector = if (sideExpanded) {
                                    Icons.Default.ExpandLess
                                } else {
                                    Icons.Default.ExpandMore
                                },
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        },
                        content = {
                            Text(
                                text = stringResource(R.string.trigger_collection_side),
                                style = MaterialTheme.typography.titleMedium,
                            )
                        },
                    )
                }
                AnimatedVisibility(visible = sideExpanded) {
                    pairs.forEachIndexed { pairIndex, pair ->
                        val dotColor = pairColors.getOrElse(pairIndex) { pairColors.last() }
                        val pairLabel = if (pairs.size > 1) {
                            stringResource(R.string.trigger_pair_index, pairIndex + 1)
                        } else {
                            null
                        }
                        TriggerSideRow(
                            side = PanelSide.LEFT,
                            dotColor = dotColor,
                            title = stringResource(R.string.trigger_side_left_item),
                            pairLabel = pairLabel,
                            summary = triggerHandleActionSummary(settings, PanelSide.LEFT, pair.handleId),
                            enabled = serviceEnabled && pair.left.enabled,
                            onClick = { onOpenLeftTrigger(pair.handleId) },
                        )
                        TriggerSideRow(
                            side = PanelSide.RIGHT,
                            dotColor = dotColor,
                            title = stringResource(R.string.trigger_side_right_item),
                            pairLabel = pairLabel,
                            summary = triggerHandleActionSummary(
                                settings,
                                PanelSide.RIGHT,
                                pair.handleId,
                            ),
                            enabled = serviceEnabled && (pair.right?.enabled != false),
                            onClick = { onOpenRightTrigger(pair.handleId) },
                        )
                    }
                }
            }
            AnimatedVisibility(visible = sideExpanded) {
                Column {
                    if (pairs.size > 1) {
                        TextButton(
                            onClick = { onRemoveTriggerPair(pairs.last().handleId) },
                            enabled = serviceEnabled,
                            modifier = Modifier.padding(horizontal = 4.dp),
                        ) {
                            Text(stringResource(R.string.trigger_remove_pair))
                        }
                    }
                    TextButton(
                        onClick = onAddTriggerPair,
                        enabled = serviceEnabled && pairs.size < TriggerHandle.MAX_HANDLES,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                    ) {
                        Text(stringResource(R.string.trigger_handles_add))
                    }
                    if (pairs.size >= TriggerHandle.MAX_HANDLES) {
                        SettingsHintText(
                            stringResource(R.string.trigger_handles_max, TriggerHandle.MAX_HANDLES),
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun TriggerSideRow(
    side: PanelSide,
    dotColor: Color,
    title: String,
    pairLabel: String?,
    summary: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    RegisterSettingsSegment { segmentIndex, segmentCount ->
        SegmentedListItem(
            onClick = onClick,
            enabled = enabled,
            shapes = pickerSegmentedShapes(segmentIndex, segmentCount),
            colors = pickerSegmentedColors(),
            leadingContent = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(dotColor),
                    )
                    Icon(
                        imageVector = Icons.Default.SwipeRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = if (side == PanelSide.RIGHT) {
                            Modifier.graphicsLayer { scaleX = -1f }
                        } else {
                            Modifier
                        },
                    )
                }
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            },
            content = {
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(text = title, style = MaterialTheme.typography.titleMedium)
                    if (pairLabel != null) {
                        Text(
                            text = pairLabel,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                }
            },
            supportingContent = {
                Text(
                    text = summary,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                )
            },
        )
    }
}

@Composable
private fun triggerHandleActionSummary(
    settings: AppSettings,
    side: PanelSide,
    handleId: String,
): String {
    val labels = buildList {
        GestureTriggerType.shortDistanceEntries().forEach { trigger ->
            val action = settings.actionFor(side, trigger, handleId)
            if (action.isEffective()) add(gestureActionLabel(action))
        }
        GestureTriggerType.pressTapEntries().forEach { trigger ->
            val action = settings.actionFor(side, trigger, handleId)
            if (action.isEffective()) add(gestureActionLabel(action))
        }
        GestureTriggerType.longDistanceEntries().forEach { trigger ->
            val action = settings.actionFor(side, trigger, handleId)
            if (action.isEffective()) add(gestureActionLabel(action))
        }
    }.distinct()
    return if (labels.isEmpty()) {
        stringResource(R.string.trigger_summary_none)
    } else {
        labels.take(5).joinToString("、")
    }
}
