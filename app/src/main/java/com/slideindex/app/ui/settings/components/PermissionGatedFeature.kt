package com.slideindex.app.ui.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Composable
fun PermissionGatedFeature(
    granted: Boolean,
    permissionTitle: String,
    permissionDescription: String,
    onGrant: () -> Unit,
    grantLabel: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .alpha(if (granted) 1f else 0.45f)
                .fillMaxWidth()
                .weight(1f),
        ) {
            content()
        }
        if (!granted) {
            PermissionCard(
                title = permissionTitle,
                description = permissionDescription,
                onGrant = onGrant,
                grantLabel = grantLabel,
            )
        }
    }
}
