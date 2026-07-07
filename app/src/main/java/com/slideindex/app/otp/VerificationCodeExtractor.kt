package com.slideindex.app.otp

data class OtpExtractionConfig(
    val keywordsRegex: String = VerificationCodeExtractor.DEFAULT_KEYWORDS_REGEX,
    val matchRules: List<OtpMatchRule> = emptyList(),
) {
    companion object {
        fun build(
            keywordsRegex: String,
            officialRules: List<OtpMatchRule>,
            userRules: List<OtpMatchRule>,
            disabledOfficialRuleIds: Set<String>,
        ): OtpExtractionConfig {
            val enabledOfficial = officialRules.map { rule ->
                rule.copy(enabled = rule.id !in disabledOfficialRuleIds)
            }
            return OtpExtractionConfig(
                keywordsRegex = keywordsRegex,
                matchRules = enabledOfficial + userRules,
            )
        }
    }
}

data class OtpExtractionResult(
    val code: String?,
    val attempted: Boolean,
    val ruleName: String? = null,
)

object VerificationCodeExtractor {
  const val LEGACY_DEFAULT_KEYWORDS_REGEX =
      "(?i)\\b(验证码|otp|verification|verify|pin|passcode|password|code|secure\\s*code)\\b"

  const val DEFAULT_KEYWORDS_REGEX =
      "验证码|校验码|检验码|确认码|激活码|动态码|安全码|验证代码|校验代码|检验代码|激活代码|确认代码|动态代码|安全代码|登入码|认证码|识别码|短信口令|动态密码|交易码|上网密码|随机码|动态口令|驗證碼|校驗碼|檢驗碼|確認碼|激活碼|動態碼|驗證代碼|校驗代碼|檢驗代碼|確認代碼|激活代碼|動態代碼|登入碼|認證碼|識別碼|(?i)\\b(otp|verification|verify|pin|passcode|password|code|secure\\s*code)\\b|Код|код|КОД|Пароль|пароль|ПАРОЛЬ|Kod|kod|KOD|(?i)\\b(ma|mã|otp)\\b"

    private val CODE_PATTERN = Regex("(?<!\\d)(\\d{4,8})(?!\\d)")
    private val AFTER_KEYWORD_CODE_PATTERN = Regex("^[：:\\s为、，,.-]*(\\d{4,8})")
    private const val KEYWORD_PROXIMITY_CHARS = 30

    fun extract(
        packageName: String,
        title: String,
        text: String,
        config: OtpExtractionConfig,
    ): OtpExtractionResult {
        val combined = buildString {
            if (title.isNotBlank()) {
                append(title)
                append('\n')
            }
            if (text.isNotBlank()) append(text)
        }.trim()
        if (combined.isBlank()) return OtpExtractionResult(code = null, attempted = false)

        val enabledRules = config.matchRules.filter { it.enabled }
        for (rule in enabledRules) {
            if (!ruleAppliesToPackage(rule, packageName)) continue
            extractWithRule(combined, rule)?.let { code ->
                return OtpExtractionResult(code = code, attempted = true, ruleName = rule.name)
            }
        }

        val keywordRegex = compileRegex(config.keywordsRegex) ?: return OtpExtractionResult(
            code = null,
            attempted = false,
        )
        if (!keywordRegex.containsMatchIn(combined)) {
            return OtpExtractionResult(code = null, attempted = true)
        }

        val code = findCodeDirectlyAfterKeywords(combined, keywordRegex)
            ?: findCodeNearKeywords(combined, keywordRegex)
        return OtpExtractionResult(code = code, attempted = true)
    }

    private fun ruleAppliesToPackage(rule: OtpMatchRule, packageName: String): Boolean {
        val rulePackage = rule.packageName ?: return true
        return rulePackage == packageName
    }

    private fun extractWithRule(text: String, rule: OtpMatchRule): String? {
        if (!text.contains(rule.keyword, ignoreCase = false)) return null
        val regex = compileRegex(rule.regex) ?: return null
        val match = regex.find(text) ?: return null
        for (index in 1 until match.groupValues.size) {
            val group = match.groupValues[index]
            if (isValidCode(group)) return group
        }
        return normalizeCode(match.value)
    }

    private fun isValidCode(value: String): Boolean =
        value.length in 4..8 && value.all { it.isDigit() }

    private fun normalizeCode(value: String): String? {
        val digits = value.filter { it.isDigit() }
        return if (isValidCode(digits)) digits else null
    }

    private fun compileRegex(pattern: String): Regex? =
        runCatching { Regex(pattern) }.getOrNull()

    private fun findCodeDirectlyAfterKeywords(text: String, keywordRegex: Regex): String? {
        for (keywordMatch in keywordRegex.findAll(text)) {
            val afterStart = keywordMatch.range.last + 1
            if (afterStart >= text.length) continue
            val windowEnd = minOf(text.length, afterStart + KEYWORD_PROXIMITY_CHARS)
            val window = text.substring(afterStart, windowEnd)
            AFTER_KEYWORD_CODE_PATTERN.find(window)?.let { match ->
                val code = match.groupValues[1]
                if (isValidCode(code)) return code
            }
        }
        return null
    }

    private fun findCodeNearKeywords(text: String, keywordRegex: Regex): String? {
        val keywordRanges = keywordRegex.findAll(text).map { it.range }.toList()
        if (keywordRanges.isEmpty()) return null

        val candidates = CODE_PATTERN.findAll(text).map { match ->
            val value = match.groupValues[1]
            val distance = keywordRanges.minOf { range ->
                minDistance(match.range, range)
            }
            value to distance
        }.filter { (_, distance) -> distance <= KEYWORD_PROXIMITY_CHARS }
            .sortedWith(compareBy<Pair<String, Int>> { it.second }.thenByDescending { it.first.length })

        return candidates.firstOrNull()?.first
    }

    private fun minDistance(a: IntRange, b: IntRange): Int {
        return when {
            a.last < b.first -> b.first - a.last
            b.last < a.first -> a.first - b.last
            else -> 0
        }
    }
}
