package com.slideindex.app.ui.feedback

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun UserMessageSnackbarHost(
    userMessageBus: UserMessageBus,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(userMessageBus) {
        userMessageBus.messages.collect { message ->
            val text = when (message) {
                is UserMessage.Error -> message.text
                is UserMessage.Success -> message.text
            }
            snackbarHostState.showSnackbar(text)
        }
    }
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = modifier,
    )
}
