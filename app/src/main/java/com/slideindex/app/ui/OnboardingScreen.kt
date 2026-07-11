@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.slideindex.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.slideindex.app.R
import com.slideindex.app.ui.navigation.NavPermissionSnapshot
import kotlinx.coroutines.launch

private enum class OnboardingStep {
    Welcome,
    Overlay,
    Accessibility,
    Notification,
    Done,
}

@Composable
fun OnboardingDialog(
    visible: Boolean,
    permissions: NavPermissionSnapshot,
    overlayGranted: Boolean,
    onRequestOverlay: () -> Unit,
    onRequestAccessibility: () -> Unit,
    onRequestNotification: () -> Unit,
    onComplete: () -> Unit,
    onSkip: () -> Unit,
) {
    if (!visible) return

    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false,
        ),
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface,
        ) {
            OnboardingContent(
                permissions = permissions,
                overlayGranted = overlayGranted,
                onRequestOverlay = onRequestOverlay,
                onRequestAccessibility = onRequestAccessibility,
                onRequestNotification = onRequestNotification,
                onComplete = onComplete,
                onSkip = onSkip,
            )
        }
    }
}

@Composable
private fun OnboardingContent(
    permissions: NavPermissionSnapshot,
    overlayGranted: Boolean,
    onRequestOverlay: () -> Unit,
    onRequestAccessibility: () -> Unit,
    onRequestNotification: () -> Unit,
    onComplete: () -> Unit,
    onSkip: () -> Unit,
) {
    val steps = OnboardingStep.entries
    val pagerState = rememberPagerState(pageCount = { steps.size })
    val scope = rememberCoroutineScope()

    LaunchedEffect(overlayGranted, permissions.accessibilityGranted, permissions.notificationGranted) {
        val target = when {
            !overlayGranted -> OnboardingStep.Overlay
            !permissions.accessibilityGranted -> OnboardingStep.Accessibility
            !permissions.notificationGranted -> OnboardingStep.Notification
            else -> OnboardingStep.Done
        }
        val targetIndex = steps.indexOf(target)
        if (targetIndex > pagerState.currentPage) {
            pagerState.animateScrollToPage(targetIndex)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            TextButton(
                onClick = onSkip,
                modifier = Modifier.align(Alignment.End),
            ) {
                Text(stringResource(R.string.onboarding_skip))
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                userScrollEnabled = false,
            ) { page ->
                when (steps[page]) {
                    OnboardingStep.Welcome -> OnboardingPage(
                        title = stringResource(R.string.onboarding_welcome_title),
                        body = stringResource(R.string.onboarding_welcome_body),
                    )
                    OnboardingStep.Overlay -> OnboardingPage(
                        title = stringResource(R.string.onboarding_overlay_title),
                        body = stringResource(R.string.onboarding_overlay_body),
                        actionLabel = stringResource(R.string.onboarding_grant_overlay),
                        onAction = onRequestOverlay,
                        granted = overlayGranted,
                    )
                    OnboardingStep.Accessibility -> OnboardingPage(
                        title = stringResource(R.string.permission_accessibility_title),
                        body = stringResource(R.string.permission_accessibility_desc),
                        actionLabel = stringResource(R.string.permission_accessibility_grant),
                        onAction = onRequestAccessibility,
                        granted = permissions.accessibilityGranted,
                    )
                    OnboardingStep.Notification -> OnboardingPage(
                        title = stringResource(R.string.permission_notification_title),
                        body = stringResource(R.string.permission_notification_desc),
                        actionLabel = stringResource(R.string.grant_permission),
                        onAction = onRequestNotification,
                        granted = permissions.notificationGranted,
                    )
                    OnboardingStep.Done -> OnboardingPage(
                        title = stringResource(R.string.onboarding_done_title),
                        body = stringResource(R.string.onboarding_done_body),
                    )
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            val isLastPage = pagerState.currentPage == steps.lastIndex
            Button(
                onClick = {
                    if (isLastPage) {
                        onComplete()
                    } else {
                        scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = if (isLastPage) {
                        stringResource(R.string.onboarding_get_started)
                    } else {
                        stringResource(R.string.onboarding_next)
                    },
                )
            }
            if (!isLastPage) {
                Text(
                    text = stringResource(
                        R.string.onboarding_progress,
                        pagerState.currentPage + 1,
                        steps.size,
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}

@Composable
private fun OnboardingPage(
    title: String,
    body: String,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null,
    granted: Boolean = false,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmallEmphasized,
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        if (actionLabel != null && onAction != null) {
            Spacer(modifier = Modifier.height(8.dp))
            if (granted) {
                Text(
                    text = stringResource(R.string.onboarding_permission_granted),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge,
                )
            } else {
                Button(onClick = onAction) {
                    Text(actionLabel)
                }
            }
        }
    }
}
