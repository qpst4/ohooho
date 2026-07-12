package com.slideindex.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.slideindex.app.R
import com.slideindex.app.gesture.PointerGestureRecording
import com.slideindex.app.overlay.FloatingPointerGestureRepository
import com.slideindex.app.overlay.PointerGesturePlayback
import com.slideindex.app.ui.settings.components.SettingsHintText

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FloatingPointerGestureSection(
    repository: FloatingPointerGestureRepository,
    onDelete: (String) -> Unit,
    onPlay: (PointerGestureRecording) -> Unit,
) {
    val recordings by repository.recordings.collectAsStateWithLifecycle()
    val recordModeEnabled by repository.recordModeEnabled.collectAsStateWithLifecycle()
    SettingsSectionTitle(stringResource(R.string.floating_pointer_gesture_section_title))
    SettingsHintText(stringResource(R.string.floating_pointer_gesture_section_desc))
    SettingsCard {
        SettingSwitchRow(
            title = stringResource(R.string.floating_pointer_gesture_record_mode_title),
            subtitle = stringResource(R.string.floating_pointer_gesture_record_mode_desc),
            checked = recordModeEnabled,
            enabled = true,
            onCheckedChange = repository::setRecordModeEnabled,
        )
    }
    if (recordings.isEmpty()) {
        SettingsHintText(stringResource(R.string.floating_pointer_gesture_empty))
    } else {
        recordings.forEach { recording ->
            SettingsCard {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = recording.name,
                        style = MaterialTheme.typography.titleSmall,
                    )
                    Text(
                        text = stringResource(
                            R.string.floating_pointer_gesture_points_summary,
                            recording.points.size,
                        ),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Button(onClick = { onPlay(recording) }) {
                            Text(stringResource(R.string.floating_pointer_gesture_play))
                        }
                        OutlinedButton(onClick = { onDelete(recording.id) }) {
                            Text(stringResource(R.string.floating_pointer_gesture_delete))
                        }
                    }
                }
            }
        }
    }
}
