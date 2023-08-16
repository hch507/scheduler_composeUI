package com.example.scheduler_composeui.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun registerScreen(modifier: Modifier=Modifier){
    Column(modifier) {
        headSection(modifier = modifier.fillMaxWidth())
        bodySection(modifier = modifier.fillMaxWidth())
    }

}

@Composable
fun headSection(modifier: Modifier){
    Surface(color= MaterialTheme.colorScheme.primary) {
        Column(modifier.height(35.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally ) {
            Text(text = "회원가입", fontSize = 25.sp)
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bodySection(modifier: Modifier){
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    Column(
        modifier
            .fillMaxHeight()
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier,
            Arrangement.SpaceEvenly){
            TextField(
                value ="",
                onValueChange ={id = it},
                label = { Text(text = "아이디")},
                )

            Button(onClick = { /*TODO*/ }, shape= CircleShape) {
                Text(text = "중복")
            }
        }
        OutlinedTextField(value = "",
                        onValueChange ={pw = it},
                        label = { Text(text = "비밀번호")},)
        TextField(

            value ="",
            onValueChange ={name = it},
            label = { Text(text = "이름")},
        )


    }
}

@Preview(showBackground = true)
@Composable
fun previewRegisterScreen(){
    registerScreen()
}