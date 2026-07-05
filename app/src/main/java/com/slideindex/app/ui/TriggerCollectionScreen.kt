package com.slideindex.app.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.slideindex.app.gesture.TriggerHandlePairEntry
import com.slideindex.app.gesture.actionFor
import com.slideindex.app.gesture.isEffective
import com.slideindex.app.gesture.sideTriggerPairs
import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.settings.AppSettings
import kotlinx.coroutines.delay

private const val TRIGGER_PAIR_ENTER_MS = 260
private const val TRIGGER_PAIR_EXIT_MS = 200
private const val TRIGGER_ACTION_ENTER_MS = 220
private const val TRIGGER_ACTION_EXIT_MS = 180

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
    var showRemoveConfirm by remember { mutableStateOf(false) }
    var pendingRemoveHandleId by remember { mutableStateOf<String?>(null) }
    val pairs = remember(settings.leftTriggerHandles, settings.rightTriggerHandles) {
        settings.sideTriggerPairs()
    }
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
            TriggerPairList(
                pairs = pairs,
                pairColors = pairColors,
                settings = settings,
                serviceEnabled = serviceEnabled,
                sideExpanded = sideExpanded,
                onToggleExpanded = { sideExpanded = !sideExpanded },
                onOpenLeftTrigger = onOpenLeftTrigger,
                onOpenRightTrigger = onOpenRightTrigger,
            )
            AnimatedVisibility(
                visible = sideExpanded,
                enter = expandVertically(
                    animationSpec = tween(TRIGGER_ACTION_ENTER_MS),
                    expandFrom = Alignment.Top,
                ),
                exit = shrinkVertically(
                    animationSpec = tween(TRIGGER_ACTION_EXIT_MS),
                    shrinkTowards = Alignment.Top,
                ),
            ) {
                Column {
                    AnimatedVisibility(
                        visible = pairs.size > 1,
                        enter = expandVertically(
                            animationSpec = tween(TRIGGER_ACTION_ENTER_MS),
                            expandFrom = Alignment.Top,
                        ),
                        exit = shrinkVertically(
                            animationSpec = tween(TRIGGER_ACTION_EXIT_MS),
                            shrinkTowards = Alignment.Top,
                        ),
                    ) {
                        TextButton(
                            onClick = {
                                pendingRemoveHandleId = pairs.last().handleId
                                showRemoveConfirm = true
                            },
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
                    AnimatedVisibility(
                        visible = pairs.size >= TriggerHandle.MAX_HANDLES,
                        enter = expandVertically(
                            animationSpec = tween(TRIGGER_ACTION_ENTER_MS),
                            expandFrom = Alignment.Top,
                        ),
                        exit = shrinkVertically(
                            animationSpec = tween(TRIGGER_ACTION_EXIT_MS),
                            shrinkTowards = Alignment.Top,
                        ),
                    ) {
                        SettingsHintText(
                            stringResource(R.string.trigger_handles_max, TriggerHandle.MAX_HANDLES),
                        )
                    }
                }
            }
        }
    }

    if (showRemoveConfirm && pendingRemoveHandleId != null) {
        AlertDialog(
            onDismissRequest = {
                showRemoveConfirm = false
                pendingRemoveHandleId = null
            },
            title = { Text(stringResource(R.string.trigger_remove_confirm_title)) },
            text = { Text(stringResource(R.string.trigger_remove_confirm_message)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        pendingRemoveHandleId?.let(onRemoveTriggerPair)
                        showRemoveConfirm = false
                        pendingRemoveHandleId = null
                    },
                ) {
                    Text(stringResource(R.string.confirm))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showRemoveConfirm = false
                        pendingRemoveHandleId = null
                    },
                ) {
                    Text(stringResource(R.string.cancel))
                }
            },
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun TriggerPairList(
    pairs: List<TriggerHandlePairEntry>,
    pairColors: List<Color>,
    settings: AppSettings,
    serviceEnabled: Boolean,
    sideExpanded: Boolean,
    onToggleExpanded: () -> Unit,
    onOpenLeftTrigger: (handleId: String) -> Unit,
    onOpenRightTrigger: (handleId: String) -> Unit,
) {
    val targetIds = pairs.map { it.handleId }
    var renderingIds by remember { mutableStateOf(targetIds) }
    var exitingIds by remember { mutableStateOf(setOf<String>()) }
    val pairCache = remember { mutableStateMapOf<String, TriggerHandlePairEntry>() }
    pairs.forEach { pairCache[it.handleId] = it }

    LaunchedEffect(targetIds) {
        val renderingSet = renderingIds.toSet()
        val targetSet = targetIds.toSet()
        val removed = renderingSet - targetSet
        val added = targetSet - renderingSet

        when {
            removed.isNotEmpty() -> {
                exitingIds = removed
                delay(TRIGGER_PAIR_EXIT_MS.toLong())
                exitingIds = emptySet()
                renderingIds = targetIds
            }
            added.isNotEmpty() -> {
                renderingIds = targetIds
            }
            renderingIds != targetIds -> {
                renderingIds = targetIds
            }
        }
    }

    val segmentCount = if (sideExpanded) 1 + renderingIds.size * 2 else 1
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(animationSpec = tween(TRIGGER_PAIR_ENTER_MS)),
        verticalArrangement = Arrangement.spacedBy(pickerListSegmentedGap()),
    ) {
        SegmentedListItem(
            onClick = onToggleExpanded,
            shapes = pickerSegmentedShapes(0, segmentCount),
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
        if (sideExpanded) {
            renderingIds.forEachIndexed { displayIndex, handleId ->
                val pair = pairCache[handleId] ?: return@forEachIndexed
                val pairIndex = targetIds.indexOf(handleId).takeIf { it >= 0 } ?: displayIndex
                val dotColor = pairColors.getOrElse(pairIndex) { pairColors.last() }
                val pairLabel = if (targetIds.size > 1) {
                    stringResource(R.string.trigger_pair_index, pairIndex + 1)
                } else {
                    null
                }
                val leftIndex = 1 + displayIndex * 2
                val rightIndex = leftIndex + 1
                AnimatedVisibility(
                    visible = handleId !in exitingIds,
                    enter = expandVertically(
                        animationSpec = tween(TRIGGER_PAIR_ENTER_MS),
                        expandFrom = Alignment.Top,
                    ),
                    exit = shrinkVertically(
                        animationSpec = tween(TRIGGER_PAIR_EXIT_MS),
                        shrinkTowards = Alignment.Top,
                    ),
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(pickerListSegmentedGap()),
                    ) {
                        TriggerSideRow(
                            side = PanelSide.LEFT,
                            segmentIndex = leftIndex,
                            segmentCount = segmentCount,
                            dotColor = dotColor,
                            title = stringResource(R.string.trigger_side_left_item),
                            pairLabel = pairLabel,
                            summary = triggerHandleActionSummary(settings, PanelSide.LEFT, pair.handleId),
                            enabled = serviceEnabled && pair.left.enabled,
                            onClick = { onOpenLeftTrigger(pair.handleId) },
                        )
                        TriggerSideRow(
                            side = PanelSide.RIGHT,
                            segmentIndex = rightIndex,
                            segmentCount = segmentCount,
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
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun TriggerSideRow(
    side: PanelSide,
    segmentIndex: Int,
    segmentCount: Int,
    dotColor: Color,
    title: String,
    pairLabel: String?,
    summary: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
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
