package com.slideindex.app.notification

import org.json.JSONArray
import org.json.JSONObject

object NotificationFilterCodec {
    fun encode(rules: List<NotificationFilterRule>): String {
        val array = JSONArray()
        rules.forEach { rule ->
            array.put(
                JSONObject()
                    .put("id", rule.id)
                    .put("packageName", rule.packageName)
                    .put("channelId", rule.channelId)
                    .put("titlePattern", rule.titlePattern)
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
                    val packageName = obj.optString("packageName")
                    if (packageName.isBlank()) continue
                    add(
                        NotificationFilterRule(
                            id = obj.optString("id").ifBlank { java.util.UUID.randomUUID().toString() },
                            packageName = packageName,
                            channelId = obj.optString("channelId").takeIf { it.isNotBlank() },
                            titlePattern = obj.optString("titlePattern").takeIf { it.isNotBlank() },
                            createdAtMs = obj.optLong("createdAtMs", System.currentTimeMillis()),
                        ),
                    )
                }
            }
        }.getOrDefault(emptyList())
    }
}
