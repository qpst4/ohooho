package com.slideindex.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slideindex.app.gesture.PointerGestureRecording
import com.slideindex.app.overlay.FloatingPointerGestureRepository
import com.slideindex.app.overlay.PointerGesturePlayback
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class FloatingPointerGestureViewModel @Inject constructor(
    val repository: FloatingPointerGestureRepository,
) : ViewModel() {
    val recordings = repository.recordings

    fun deleteRecording(id: String) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }

    fun playRecording(recording: PointerGestureRecording) {
        PointerGesturePlayback.play(recording)
    }
}
