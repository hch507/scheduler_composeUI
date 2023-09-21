package com.example.scheduler_composeui.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scheduler_composeui.data.dto.ScheduleResponse
import com.example.scheduler_composeui.domain.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class scheduleUiState(
    val startTime : String="",
    val endTime : String="",
    val patient : String=""
)
@HiltViewModel
class ScheduleViemodel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) :ViewModel() {

   // private val _uiState = MutableStateFlow<List<scheduleUiState>>(emptyList())
    private val _uiState = MutableStateFlow(ArrayList<scheduleUiState>())
    val uiState = _uiState.asStateFlow()

    var scheduleList = arrayListOf<ScheduleResponse>()

    fun getSchedule(){
        var _uiStateItem =arrayListOf<scheduleUiState>()
        viewModelScope.launch {
            scheduleList= scheduleRepository.loadSchedule()!!
            for (scheduleItem in scheduleList){
                val patient = scheduleItem.patient
                val startDate= scheduleItem.startTime
                val endDate =scheduleItem.endTime
                _uiStateItem.add(scheduleUiState(patient,startDate,endDate))
            }
            _uiState.value=_uiStateItem
           Log.d("hch", "ScheduleViemodel - getSchedule() - called${scheduleList}")
        }
//
    }
}