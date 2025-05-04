package com.example.halfooddelivery.presentation.onboarding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel : ViewModel() {
    private val _page = MutableStateFlow(0)
    val page: StateFlow<Int> = _page

    fun nextPage() {
        if (_page.value < 1) _page.value++ // 2 pages: 0 & 1
    }

    fun reset() {
        _page.value = 0
    }
}