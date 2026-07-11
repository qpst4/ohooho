@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.slideindex.app.ui

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slideindex.app.R
import com.slideindex.app.ui.settings.components.SettingsHintText
import com.slideindex.app.ui.settings.components.SettingsScreenScaffold
import com.slideindex.app.ui.settings.components.SettingsSectionTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsBackupScreen(
    onBack: () -> Unit,
    onExport: (onJsonReady: (String) -> Unit) -> Unit,
    onImport: (android.net.Uri) -> Unit,
) {
    val context = LocalContext.current
    val resources = LocalResources.current
    val exportLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("application/json"),
    ) { uri ->
        if (uri == null) return@rememberLauncherForActivityResult
        onExport { json ->
            context.contentResolver.openOutputStream(uri)?.use { output ->
                output.write(json.toByteArray(Charsets.UTF_8))
            }
        }
    }
    val importLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument(),
    ) { uri ->
        if (uri != null) {
            onImport(uri)
        }
    }

    SettingsScreenScaffold(
        title = stringResource(R.string.settings_backup_title),
        subtitle = stringResource(R.string.settings_backup_subtitle),
        onBack = onBack,
    ) {
        SettingsSectionTitle(stringResource(R.string.settings_backup_section_actions))
        SettingsHintText(stringResource(R.string.settings_backup_hint))
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = {
                    val defaultName = resources.getString(
                        R.string.settings_backup_default_filename,
                        System.currentTimeMillis(),
                    )
                    exportLauncher.launch(defaultName)
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Default.FileDownload, contentDescription = stringResource(R.string.cd_export_settings))
                Text(
                    text = stringResource(R.string.settings_backup_export),
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.labelLarge,
                )
            }
            OutlinedButton(
                onClick = { importLauncher.launch(arrayOf("application/json", "text/*")) },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Default.FileUpload, contentDescription = stringResource(R.string.cd_import_settings))
                Text(
                    text = stringResource(R.string.settings_backup_import),
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
    }
}
