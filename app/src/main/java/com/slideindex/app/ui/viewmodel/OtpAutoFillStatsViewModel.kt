package com.slideindex.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slideindex.app.otp.OtpAutoFillStatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class OtpAutoFillStatsViewModel @Inject constructor(
    private val statsRepository: OtpAutoFillStatsRepository,
) : ViewModel() {
    val stats = statsRepository.stats

    fun resetStats() {
        viewModelScope.launch {
            statsRepository.reset()
        }
    }
}
