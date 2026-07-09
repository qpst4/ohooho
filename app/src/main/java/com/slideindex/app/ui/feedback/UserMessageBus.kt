package com.slideindex.app.ui.feedback

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

sealed interface UserMessage {
    data class Error(val text: String) : UserMessage
    data class Success(val text: String) : UserMessage
}

@Singleton
class UserMessageBus @Inject constructor() {
    private val _messages = MutableSharedFlow<UserMessage>(extraBufferCapacity = 8)
    val messages: SharedFlow<UserMessage> = _messages.asSharedFlow()

    suspend fun emit(message: UserMessage) {
        _messages.emit(message)
    }

    fun showError(text: String) {
        _messages.tryEmit(UserMessage.Error(text))
    }

    fun showSuccess(text: String) {
        _messages.tryEmit(UserMessage.Success(text))
    }
}
