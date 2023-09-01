package com.example.scheduler_composeui.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.scheduler_composeui.ui.viewmodels.ScheduleViemodel
import com.example.scheduler_composeui.ui.viewmodels.scheduleUiState

@Composable
fun summaryScreen(
    openDrawer :() ->Unit,
    viewmodel: ScheduleViemodel=viewModel()
)

{
    val uiState by viewmodel.uiState.collectAsState()
    viewmodel.getSchedule()
    LazyColumn(
        contentPadding = PaddingValues(16.dp, 8.dp)
    ){
        items(uiState){it->
            scheduleItem(it)
        }
    }
}

@Composable
fun scheduleItem(
    schedule: scheduleUiState
){

        Column() {
            Text(text = "날짜 : ${schedule.date}", fontSize = 30.sp)
            Text(text = "시작 : ${schedule.startTime}")
            Text(text = "종료 : ${schedule.endTime}")
        }

}
