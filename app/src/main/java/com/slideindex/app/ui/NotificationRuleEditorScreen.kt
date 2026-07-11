package com.slideindex.app.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.notification.AppTarget
import com.slideindex.app.notification.NotificationFilterRule
import com.slideindex.app.notification.NotificationRuleChargeMask
import com.slideindex.app.notification.ScreenMode
import com.slideindex.app.ui.notificationrule.NotificationRuleActionPicker
import com.slideindex.app.ui.notificationrule.NotificationRuleAppPickerDialog
import com.slideindex.app.ui.notificationrule.NotificationRuleConditionEditor
import com.slideindex.app.ui.notificationrule.msToTimeString
import com.slideindex.app.ui.notificationrule.parseLines
import com.slideindex.app.ui.notificationrule.parseTimeMs
import com.slideindex.app.ui.notificationrule.resolveChargeMask
import com.slideindex.app.ui.notificationrule.resolveScreenMode
import com.slideindex.app.ui.viewmodel.NotificationHistoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationRuleEditorScreen(
    initialRule: NotificationFilterRule?,
    viewModel: NotificationHistoryViewModel,
    onBack: () -> Unit,
    onSave: (NotificationFilterRule) -> Unit,
) {
    val context = LocalContext.current
    val seed = remember(initialRule) { (initialRule ?: NotificationFilterRule()).normalized() }

    var name by remember(seed) { mutableStateOf(seed.name) }
    var channelId by remember(seed) { mutableStateOf(seed.channelId.orEmpty()) }
    var appMode by remember(seed) { mutableStateOf(seed.appMode) }
    var appTargets by remember(seed) { mutableStateOf(seed.appTargets) }
    var textMode by remember(seed) { mutableStateOf(seed.textMode) }
    var keywordsText by remember(seed) { mutableStateOf(seed.keywords.joinToString("\n")) }
    var keywordsExcludeText by remember(seed) { mutableStateOf(seed.keywordsExclude.joinToString("\n")) }
    var regex by remember(seed) { mutableStateOf(seed.regex.orEmpty()) }
    var advancedJson by remember(seed) { mutableStateOf(seed.advancedFilterJson.orEmpty()) }
    var timeStart by remember(seed) { mutableStateOf(msToTimeString(seed.timeStartMs)) }
    var timeEnd by remember(seed) { mutableStateOf(msToTimeString(seed.timeEndMs)) }
    var weekDays by remember(seed) { mutableStateOf(seed.weekDays) }
    var screenOn by remember(seed) { mutableStateOf(seed.screenMode != ScreenMode.OFF) }
    var screenOff by remember(seed) { mutableStateOf(seed.screenMode != ScreenMode.ON) }
    var chargeBattery by remember(seed) {
        mutableStateOf(seed.chargeMask and NotificationRuleChargeMask.BATTERY != 0)
    }
    var chargeWired by remember(seed) {
        mutableStateOf(seed.chargeMask and NotificationRuleChargeMask.WIRED != 0)
    }
    var chargeWireless by remember(seed) {
        mutableStateOf(seed.chargeMask and NotificationRuleChargeMask.WIRELESS != 0)
    }
    var actionEntries by remember(seed) { mutableStateOf(seed.actionEntries) }
    var showAppPicker by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (initialRule == null) {
                            stringResource(R.string.notification_rule_add)
                        } else {
                            stringResource(R.string.notification_rule_edit)
                        },
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    TextButton(
                        onClick = {
                            if (actionEntries.isEmpty()) {
                                Toast.makeText(context, R.string.notification_rule_invalid, Toast.LENGTH_SHORT).show()
                                return@TextButton
                            }
                            onSave(
                                NotificationFilterRule(
                                    id = initialRule?.id ?: java.util.UUID.randomUUID().toString(),
                                    name = name.trim(),
                                    enabled = initialRule?.enabled ?: true,
                                    userCreated = true,
                                    createdAtMs = initialRule?.createdAtMs ?: System.currentTimeMillis(),
                                    channelId = channelId.trim().takeIf { it.isNotBlank() },
                                    appMode = appMode,
                                    appTargets = appTargets,
                                    textMode = textMode,
                                    keywords = parseLines(keywordsText),
                                    keywordsExclude = parseLines(keywordsExcludeText),
                                    regex = regex.trim().takeIf { it.isNotBlank() },
                                    advancedFilterJson = advancedJson.trim().takeIf { it.isNotBlank() },
                                    timeStartMs = parseTimeMs(timeStart),
                                    timeEndMs = parseTimeMs(timeEnd),
                                    weekDays = weekDays,
                                    screenMode = resolveScreenMode(screenOn, screenOff),
                                    chargeMask = resolveChargeMask(chargeBattery, chargeWired, chargeWireless),
                                    actionEntries = actionEntries,
                                ),
                            )
                        },
                    ) {
                        Text(stringResource(R.string.confirm))
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            NotificationRuleConditionEditor(
                name = name,
                onNameChange = { name = it },
                channelId = channelId,
                onChannelIdChange = { channelId = it },
                appMode = appMode,
                onAppModeChange = { appMode = it },
                appTargets = appTargets,
                onPickApps = { showAppPicker = true },
                textMode = textMode,
                onTextModeChange = { textMode = it },
                keywordsText = keywordsText,
                onKeywordsTextChange = { keywordsText = it },
                keywordsExcludeText = keywordsExcludeText,
                onKeywordsExcludeTextChange = { keywordsExcludeText = it },
                regex = regex,
                onRegexChange = { regex = it },
                advancedJson = advancedJson,
                onAdvancedJsonChange = { advancedJson = it },
                timeStart = timeStart,
                onTimeStartChange = { timeStart = it },
                timeEnd = timeEnd,
                onTimeEndChange = { timeEnd = it },
                weekDays = weekDays,
                onWeekDaysChange = { weekDays = it },
                screenOn = screenOn,
                onScreenOnChange = { screenOn = it },
                screenOff = screenOff,
                onScreenOffChange = { screenOff = it },
                chargeBattery = chargeBattery,
                onChargeBatteryChange = { chargeBattery = it },
                chargeWired = chargeWired,
                onChargeWiredChange = { chargeWired = it },
                chargeWireless = chargeWireless,
                onChargeWirelessChange = { chargeWireless = it },
            )

            NotificationRuleActionPicker(
                actionEntries = actionEntries,
                onActionEntriesChange = { actionEntries = it },
            )
        }
    }

    if (showAppPicker) {
        NotificationRuleAppPickerDialog(
            viewModel = viewModel,
            initialPackageNames = appTargets.map { it.packageName }.toSet(),
            onDismiss = { showAppPicker = false },
            onConfirm = { selected ->
                appTargets = selected.map { AppTarget(it) }
                showAppPicker = false
            },
        )
    }
}
