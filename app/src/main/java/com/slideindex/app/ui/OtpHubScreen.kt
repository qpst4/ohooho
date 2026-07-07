package com.slideindex.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.slideindex.app.R
import com.slideindex.app.otp.OtpMatchRule
import com.slideindex.app.settings.AppSettings

enum class OtpHubTab {
    Home,
    Rules,
    Records,
    Settings,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpHubScreen(
    settings: AppSettings,
    officialRules: List<OtpMatchRule>,
    initialTab: OtpHubTab = OtpHubTab.Home,
    accessibilityGranted: Boolean,
    onExit: () -> Unit,
    onCopyToClipboardChange: (Boolean) -> Unit,
    onKeywordsRegexChange: (String) -> Unit,
    onRefreshOfficialRules: () -> Unit,
    onOfficialRuleEnabledChange: (String, Boolean) -> Unit,
    onUserRulesChange: (List<OtpMatchRule>) -> Unit,
    onAutoInputChange: (Boolean) -> Unit,
    onAutoConfirmChange: (Boolean) -> Unit,
    onAccessibilityAssistChange: (Boolean) -> Unit,
    onDelayChange: (Int) -> Unit,
    onIntervalChange: (Int) -> Unit,
    onRequestAccessibility: () -> Unit,
) {
    var selectedTab by rememberSaveable { mutableStateOf(initialTab) }
    var showTestDialog by rememberSaveable { mutableStateOf(false) }

    BackHandler(onBack = onExit)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedTab == OtpHubTab.Home,
                    onClick = { selectedTab = OtpHubTab.Home },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text(stringResource(R.string.otp_hub_tab_home)) },
                )
                NavigationBarItem(
                    selected = selectedTab == OtpHubTab.Rules,
                    onClick = { selectedTab = OtpHubTab.Rules },
                    icon = { Icon(Icons.Default.GridView, contentDescription = null) },
                    label = { Text(stringResource(R.string.otp_hub_tab_rules)) },
                )
                NavigationBarItem(
                    selected = selectedTab == OtpHubTab.Records,
                    onClick = { selectedTab = OtpHubTab.Records },
                    icon = { Icon(Icons.Default.History, contentDescription = null) },
                    label = { Text(stringResource(R.string.otp_hub_tab_records)) },
                )
                NavigationBarItem(
                    selected = selectedTab == OtpHubTab.Settings,
                    onClick = { selectedTab = OtpHubTab.Settings },
                    icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                    label = { Text(stringResource(R.string.otp_hub_tab_settings)) },
                )
            }
        },
    ) { padding ->
        val contentPadding = PaddingValues(bottom = padding.calculateBottomPadding())
        when (selectedTab) {
            OtpHubTab.Home -> OtpSettingsScreen(
                settings = settings,
                officialRules = officialRules,
                onBack = null,
                onOpenAutoInput = { selectedTab = OtpHubTab.Settings },
                onOpenMatchRules = { selectedTab = OtpHubTab.Rules },
                onOpenRecords = { selectedTab = OtpHubTab.Records },
                onCopyToClipboardChange = onCopyToClipboardChange,
                onKeywordsRegexChange = onKeywordsRegexChange,
                modifier = Modifier.padding(contentPadding),
            )
            OtpHubTab.Rules -> OtpRulesListScreen(
                officialRules = officialRules,
                userRules = settings.otpUserMatchRules,
                disabledOfficialRuleIds = settings.otpDisabledOfficialRuleIds,
                onBack = null,
                onRefreshOfficialRules = onRefreshOfficialRules,
                onOfficialRuleEnabledChange = onOfficialRuleEnabledChange,
                onUserRulesChange = onUserRulesChange,
                modifier = Modifier.padding(contentPadding),
            )
            OtpHubTab.Records -> OtpRecordsScreen(
                onBack = null,
                onOpenTestFlow = {
                    selectedTab = OtpHubTab.Home
                    showTestDialog = true
                },
                contentPadding = contentPadding,
            )
            OtpHubTab.Settings -> OtpAutoInputSettingsScreen(
                settings = settings,
                accessibilityGranted = accessibilityGranted,
                onBack = null,
                onAutoInputChange = onAutoInputChange,
                onAutoConfirmChange = onAutoConfirmChange,
                onAccessibilityAssistChange = onAccessibilityAssistChange,
                onDelayChange = onDelayChange,
                onIntervalChange = onIntervalChange,
                onRequestAccessibility = onRequestAccessibility,
                modifier = Modifier.padding(contentPadding),
            )
        }
    }

    if (showTestDialog && selectedTab == OtpHubTab.Home) {
        OtpTestDialogHost(
            settings = settings,
            officialRules = officialRules,
            onDismiss = { showTestDialog = false },
        )
    }
}
