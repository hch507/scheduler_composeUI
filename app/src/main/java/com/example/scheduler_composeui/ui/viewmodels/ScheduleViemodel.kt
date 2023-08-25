package com.example.scheduler_composeui.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class scheduleUiState(
    val date:String ="",
    val startTime : String="",
    val endTime : String="",
    val patient : String=""
)
class ScheduleViemodel:ViewModel() {

    private val _uiState = MutableStateFlow<List<scheduleUiState>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getSchedule(){
        val sample = listOf(scheduleUiState("2023.5.26","9:30","10:00","충"),
            scheduleUiState("2023.5.26","9:30","10:00","충"),
            scheduleUiState("2023.5.27","9:30","10:00","충"),
            scheduleUiState("2023.5.28","9:30","10:00","충"),
            scheduleUiState("2023.5.29","9:30","10:00","충"),
            scheduleUiState("2023.5.30","9:30","10:00","충"),)
        _uiState.value=sample
    }
}