package com.slideindex.app.settings

import com.slideindex.app.otp.OtpKeywords
import com.slideindex.app.otp.OtpMatchRuleCodec
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OtpSettingsMutator @Inject constructor(
    private val editor: SettingsPreferencesEditor,
) {
    suspend fun setOtpCopyToClipboard(enabled: Boolean) = editor.edit { it[SettingsPreferenceKeys.OTP_COPY_TO_CLIPBOARD] = enabled }

    suspend fun setOtpKeywordsRegex(value: String) = editor.edit {
        it[SettingsPreferenceKeys.OTP_KEYWORDS_REGEX] = value.ifBlank {
            OtpKeywords.DEFAULT_KEYWORDS_REGEX
        }
    }

    suspend fun setOtpUserMatchRules(rules: List<com.slideindex.app.otp.OtpMatchRule>) = editor.edit {
        it[SettingsPreferenceKeys.OTP_USER_MATCH_RULES] = OtpMatchRuleCodec.encodeAll(rules)
    }

    suspend fun setOtpDisabledOfficialRuleIds(ids: Set<String>) = editor.edit {
        it[SettingsPreferenceKeys.OTP_DISABLED_OFFICIAL_RULE_IDS] = ids
    }

    suspend fun setOtpOfficialRuleEnabled(ruleId: String, enabled: Boolean) = editor.edit { prefs ->
        val current = prefs[SettingsPreferenceKeys.OTP_DISABLED_OFFICIAL_RULE_IDS]?.toMutableSet() ?: mutableSetOf()
        if (enabled) {
            current.remove(ruleId)
        } else {
            current.add(ruleId)
        }
        prefs[SettingsPreferenceKeys.OTP_DISABLED_OFFICIAL_RULE_IDS] = current
    }

    suspend fun setOtpAutoInputEnabled(enabled: Boolean) = editor.edit { it[SettingsPreferenceKeys.OTP_AUTO_INPUT_ENABLED] = enabled }

    suspend fun setOtpAutoConfirmEnabled(enabled: Boolean) = editor.edit { it[SettingsPreferenceKeys.OTP_AUTO_CONFIRM_ENABLED] = enabled }

    suspend fun setOtpAutoInputDelayMs(value: Int) = editor.edit {
        it[SettingsPreferenceKeys.OTP_AUTO_INPUT_DELAY_MS] = value.coerceIn(0, 5000)
    }

    suspend fun setOtpAutoInputIntervalMs(value: Int) = editor.edit {
        it[SettingsPreferenceKeys.OTP_AUTO_INPUT_INTERVAL_MS] = value.coerceIn(0, 500)
    }

    suspend fun setOtpLsposedSmsCaptureEnabled(enabled: Boolean) =
        editor.edit { it[SettingsPreferenceKeys.OTP_LSPOSED_SMS_CAPTURE_ENABLED] = enabled }

    suspend fun setOtpLsposedSystemInjectEnabled(enabled: Boolean) =
        editor.edit { it[SettingsPreferenceKeys.OTP_LSPOSED_SYSTEM_INJECT_ENABLED] = enabled }
}
