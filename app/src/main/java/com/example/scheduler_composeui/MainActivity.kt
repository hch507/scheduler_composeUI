package com.example.scheduler_composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scheduler_composeui.ui.theme.Scheduler_ComposeUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scheduler_ComposeUITheme {
                // A surface container using the 'background' color from the theme

                HomeScreen(Modifier.fillMaxWidth())

            }
        }
    }
}

@Composable
fun TopSection(modifier: Modifier = Modifier) {
    Surface(color =  MaterialTheme.colorScheme.primary) {
        Column(
            modifier = modifier.height(225.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "TimeSave")
            Text(text = "MyScheduler", fontSize = 30.sp)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginSection(modifier: Modifier =Modifier){
    Column(
        modifier= modifier.padding(50.dp)
    ) {
        var text by remember { mutableStateOf("Hello") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") }
        )

}


@Composable
fun HomeScreen(modifier: Modifier){
    TopSection(modifier)
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scheduler_ComposeUITheme {
       LoginSection()
    }
}
