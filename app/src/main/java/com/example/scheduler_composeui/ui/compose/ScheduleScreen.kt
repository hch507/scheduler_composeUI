package com.example.scheduler_composeui.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.scheduler_composeui.ui.viewmodels.ScheduleViemodel
import com.example.scheduler_composeui.ui.viewmodels.scheduleUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun summaryScreen(
    modifier: Modifier,
    openDrawer :() ->Unit,
    viewmodel: ScheduleViemodel= hiltViewModel()
)
{
    Scaffold(
        modifier=modifier,

        topBar = {
            TopAppBar(
                title = { Text(text = "MySchedule")},
                navigationIcon = {
                    IconButton(onClick = openDrawer) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White)

            )
        }
    ){
        it
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

}

@Composable
fun scheduleItem(
    schedule: scheduleUiState
){

        Column() {
            Text(text = "환자 : ${schedule.patient}", fontSize = 30.sp)
            Text(text = "시작 : ${schedule.startTime}")
            Text(text = "종료 : ${schedule.endTime}")
        }

}
