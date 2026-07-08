package com.slideindex.app.notification

import org.json.JSONArray
import org.json.JSONObject

object NotificationFilterCodec {
    fun encode(rules: List<NotificationFilterRule>): String {
        val array = JSONArray()
        rules.forEach { rule ->
            val actions = JSONArray()
            rule.actions.forEach { action ->
                actions.put(action.name)
            }
            array.put(
                JSONObject()
                    .put("id", rule.id)
                    .put("name", rule.name)
                    .put("packageName", rule.packageName)
                    .put("channelId", rule.channelId)
                    .put("titlePattern", rule.titlePattern)
                    .put("textPattern", rule.textPattern)
                    .put("useRegex", rule.useRegex)
                    .put("enabled", rule.enabled)
                    .put("actions", actions)
                    .put("userCreated", rule.userCreated)
                    .put("createdAtMs", rule.createdAtMs),
            )
        }
        return array.toString()
    }

    fun decode(raw: String): List<NotificationFilterRule> {
        if (raw.isBlank()) return emptyList()
        return runCatching {
            val array = JSONArray(raw)
            buildList(array.length()) {
                for (index in 0 until array.length()) {
                    val obj = array.optJSONObject(index) ?: continue
                    add(decodeRule(obj))
                }
            }
        }.getOrDefault(emptyList())
    }

    private fun decodeRule(obj: JSONObject): NotificationFilterRule {
        val actionsArray = obj.optJSONArray("actions")
        val actions = if (actionsArray != null && actionsArray.length() > 0) {
            buildSet {
                for (index in 0 until actionsArray.length()) {
                    val actionName = actionsArray.optString(index)
                    NotificationRuleAction.entries.firstOrNull { it.name == actionName }?.let(::add)
                }
            }.ifEmpty { setOf(NotificationRuleAction.HIDE) }
        } else {
            setOf(NotificationRuleAction.HIDE)
        }
        return NotificationFilterRule(
            id = obj.optString("id").ifBlank { java.util.UUID.randomUUID().toString() },
            name = obj.optString("name"),
            packageName = obj.optString("packageName"),
            channelId = obj.optString("channelId").takeIf { it.isNotBlank() },
            titlePattern = obj.optString("titlePattern").takeIf { it.isNotBlank() },
            textPattern = obj.optString("textPattern").takeIf { it.isNotBlank() },
            useRegex = obj.optBoolean("useRegex", false),
            enabled = obj.optBoolean("enabled", true),
            actions = actions,
            userCreated = obj.optBoolean("userCreated", false),
            createdAtMs = obj.optLong("createdAtMs", System.currentTimeMillis()),
        )
    }
}
