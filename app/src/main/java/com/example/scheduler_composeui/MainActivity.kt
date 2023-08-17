package com.example.scheduler_composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.example.scheduler_composeui.ui.theme.Scheduler_ComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scheduler_ComposeUITheme {
                // A surface container using the 'background' color from the theme

                SchedulerApp(Modifier.fillMaxWidth())

            }
        }
    }
}

