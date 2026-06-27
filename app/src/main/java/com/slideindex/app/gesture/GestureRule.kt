package com.slideindex.app.gesture

import com.slideindex.app.overlay.PanelSide
import com.slideindex.app.settings.AppSettings

data class GestureRule(
    val id: String,
    val side: PanelSide,
    val trigger: GestureTriggerType,
    val action: GestureAction,
    val priority: Int = 0,
    val enabled: Boolean = true,
) {
    companion object {
        fun slot(
            side: PanelSide,
            trigger: GestureTriggerType,
            action: GestureAction,
        ): GestureRule = GestureRule(
            id = slotId(side, trigger),
            side = side,
            trigger = trigger,
            action = action,
            priority = 0,
            enabled = true,
        )

        fun slotId(side: PanelSide, trigger: GestureTriggerType): String =
            "slot-${side.name.lowercase()}-${trigger.id}"

        fun newId(): String = java.util.UUID.randomUUID().toString()
    }
}

object GestureRuleCodec {
    private const val SEP = "\u001F"

    fun encode(rule: GestureRule): String {
        return listOf(
            rule.id,
            rule.side.ordinal.toString(),
            rule.trigger.id.toString(),
            rule.action.type.id.toString(),
            rule.action.payload,
            rule.priority.toString(),
            if (rule.enabled) "1" else "0",
        ).joinToString(SEP)
    }

    fun decode(raw: String): GestureRule? {
        val parts = raw.split(SEP)
        if (parts.size != 7) return null
        val side = PanelSide.entries.getOrNull(parts[1].toIntOrNull() ?: return null) ?: return null
        val trigger = GestureTriggerType.fromId(parts[2].toIntOrNull() ?: return null) ?: return null
        val actionType = GestureActionType.fromId(parts[3].toIntOrNull() ?: return null)
        return GestureRule(
            id = parts[0],
            side = side,
            trigger = trigger,
            action = GestureAction.from(actionType, parts[4]),
            priority = parts[5].toIntOrNull() ?: 0,
            enabled = parts[6] == "1",
        )
    }

    fun encodeAll(rules: List<GestureRule>): Set<String> = rules.map { encode(it) }.toSet()

    fun decodeAll(raw: Set<String>): List<GestureRule> =
        raw.mapNotNull { decode(it) }.sortedByDescending { it.priority }
}

fun AppSettings.rulesForSide(side: PanelSide): List<GestureRule> =
    gestureRules.filter { it.enabled && it.side == side }.sortedByDescending { it.priority }

fun AppSettings.withSlotAction(
    side: PanelSide,
    trigger: GestureTriggerType,
    action: GestureAction,
): AppSettings {
    val slotId = GestureRule.slotId(side, trigger)
    val others = gestureRules.filterNot { it.id == slotId }
    if (action.type == GestureActionType.NONE) {
        return copy(gestureRules = others)
    }
    return copy(
        gestureRules = others + GestureRule(
            id = slotId,
            side = side,
            trigger = trigger,
            action = action,
        ),
    )
}

fun AppSettings.shortcutGesturesConfiguredCount(): Int =
    gestureRules.count {
        it.enabled && it.action.type == GestureActionType.LAUNCH_APP &&
            it.trigger == GestureTriggerType.SHORT_SWIPE_IN
    }
