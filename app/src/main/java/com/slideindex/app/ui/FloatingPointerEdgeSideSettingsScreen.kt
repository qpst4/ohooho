package com.slideindex.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.slideindex.app.R
import com.slideindex.app.gesture.GestureAction
import com.slideindex.app.gesture.GestureTriggerType
import com.slideindex.app.settings.AppSettings
import com.slideindex.app.settings.FloatingPointerEdgeActionSlot
import com.slideindex.app.settings.FloatingPointerEdgeActionsCodec
import com.slideindex.app.settings.FloatingPointerEdgeSide

private data class EdgeActionPickTarget(val slotIndex: Int)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FloatingPointerEdgeSideSettingsScreen(
    side: FloatingPointerEdgeSide,
    settings: AppSettings,
    onBack: () -> Unit,
    onEnabledChange: (Boolean) -> Unit,
    onSlotActionChange: (Int, GestureAction) -> Unit,
    onAddSlot: () -> Unit,
    onRemoveSlot: (Int) -> Unit,
) {
    val bar = settings.floatingPointerEdgeActionsConfig.bar(side)
    val slots = bar.layoutSlots()
    var pickingTarget by remember { mutableStateOf<EdgeActionPickTarget?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        SettingsScreenScaffold(
            title = edgeSideTitle(side),
            onBack = onBack,
        ) {
            SettingsHintText(stringResource(R.string.floating_pointer_edge_side_enabled_desc))

            SettingsCard {
                SettingSwitchRow(
                    title = edgeSideTitle(side),
                    subtitle = edgeSideSummary(slots.size, bar.enabled),
                    icon = { label -> Icon(edgeSideIcon(side), contentDescription = label) },
                    checked = bar.enabled,
                    enabled = true,
                    onCheckedChange = onEnabledChange,
                )
            }

            SettingsSectionTitle(
                stringResource(R.string.floating_pointer_edge_section_zones_count, slots.size),
            )
            key(side, slots.size, slots.map { it.action }) {
                for (index in slots.indices) {
                    val slot = slots[index]
                    EdgeZoneSettingsCard(
                        index = index,
                        slot = slot,
                        canRemove = slots.size > 1,
                        onPickAction = { pickingTarget = EdgeActionPickTarget(index) },
                        onRemove = { onRemoveSlot(index) },
                    )
                }
            }
            if (slots.size < FloatingPointerEdgeActionsCodec.MAX_SLOTS_PER_EDGE) {
                SettingsCard {
                    SettingNavigationRow(
                        icon = { label -> Icon(Icons.Default.Add, contentDescription = label) },
                        title = stringResource(R.string.floating_pointer_edge_add_zone),
                        subtitle = stringResource(R.string.floating_pointer_edge_add_zone_desc),
                        onClick = onAddSlot,
                    )
                }
            }
        }

        AnimatedFullScreenOverlay(visible = pickingTarget != null) {
            val target = pickingTarget ?: return@AnimatedFullScreenOverlay
            val current = settings.floatingPointerEdgeActionsConfig
                .bar(side)
                .layoutSlots()
                .getOrNull(target.slotIndex)
                ?.action
                ?: GestureAction.None
            GestureActionPickerScreen(
                trigger = GestureTriggerType.SHORT_SWIPE_IN,
                current = current,
                includePointerGestureActions = false,
                onDismiss = { pickingTarget = null },
                onSelect = { action ->
                    onSlotActionChange(target.slotIndex, action)
                    pickingTarget = null
                },
            )
        }
    }
}

@Composable
private fun EdgeZoneSettingsCard(
    index: Int,
    slot: FloatingPointerEdgeActionSlot,
    canRemove: Boolean,
    onPickAction: () -> Unit,
    onRemove: () -> Unit,
) {
    SettingsCard {
        SettingNavigationRow(
            icon = { label -> Icon(gestureActionIcon(slot.action), contentDescription = label) },
            title = stringResource(R.string.floating_pointer_edge_zone_title, index + 1),
            subtitle = gestureActionLabel(slot.action),
            onClick = onPickAction,
            trailingContent = if (canRemove) {
                {
                    IconButton(onClick = onRemove) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(R.string.floating_pointer_edge_remove_zone),
                            tint = MaterialTheme.colorScheme.error,
                        )
                    }
                }
            } else {
                null
            },
        )
    }
}
