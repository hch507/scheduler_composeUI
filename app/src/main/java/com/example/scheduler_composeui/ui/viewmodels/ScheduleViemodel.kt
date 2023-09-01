package com.example.scheduler_composeui.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scheduler_composeui.domain.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class scheduleUiState(
    val date:String ="",
    val startTime : String="",
    val endTime : String="",
    val patient : String=""
)
@HiltViewModel
class ScheduleViemodel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) :ViewModel() {

    private val _uiState = MutableStateFlow<List<scheduleUiState>>(emptyList())
    val uiState = _uiState.asStateFlow()

    fun getSchedule(){
//        viewModelScope.launch {
//            val sample = listOf(scheduleUiState("2023.5.26","9:30","10:00","충"),
//                scheduleUiState("2023.5.26","9:30","10:00","충"),
//                scheduleUiState("2023.5.27","9:30","10:00","충"),
//                scheduleUiState("2023.5.28","9:30","10:00","충"),
//                scheduleUiState("2023.5.29","9:30","10:00","충"),
//                scheduleUiState("2023.5.30","9:30","10:00","충"),)
//            _uiState.value=sample
// //           Log.d("hch", "ScheduleViemodel - getSchedule() - called${scheduleRepository.loadSchedule()}")
//        }
//
    }
}