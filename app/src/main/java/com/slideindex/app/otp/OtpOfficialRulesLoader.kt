package com.slideindex.app.otp

import android.content.Context
import org.json.JSONObject

class OtpOfficialRulesLoader(private val context: Context) {
    @Volatile
    private var cachedRules: List<OtpMatchRule> = emptyList()

    fun getRules(): List<OtpMatchRule> {
        if (cachedRules.isEmpty()) {
            cachedRules = loadFromAssets()
        }
        return cachedRules
    }

    fun refresh(): List<OtpMatchRule> {
        cachedRules = loadFromAssets()
        return cachedRules
    }

    private fun loadFromAssets(): List<OtpMatchRule> =
        runCatching {
            context.assets.open(ASSET_FILE).bufferedReader().use { reader ->
                parseRules(reader.readText())
            }
        }.getOrElse { emptyList() }

    private fun parseRules(jsonText: String): List<OtpMatchRule> {
        val root = JSONObject(jsonText)
        val rulesArray = root.optJSONArray("rules") ?: return emptyList()
        return buildList {
            for (index in 0 until rulesArray.length()) {
                val item = rulesArray.optJSONObject(index) ?: continue
                val id = item.optString("id").takeIf { it.isNotBlank() } ?: continue
                val name = item.optString("name").takeIf { it.isNotBlank() } ?: continue
                val keyword = item.optString("keyword").takeIf { it.isNotBlank() } ?: continue
                val regex = item.optString("regex").takeIf { it.isNotBlank() } ?: continue
                val packageName = item.optString("packageName").takeIf { it.isNotBlank() }
                add(
                    OtpMatchRule(
                        id = id,
                        name = name,
                        keyword = keyword,
                        regex = regex,
                        packageName = packageName,
                        isOfficial = true,
                        enabled = true,
                    ),
                )
            }
        }
    }

    companion object {
        private const val ASSET_FILE = "smscode-rules.json"
    }
}
