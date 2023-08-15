package com.example.scheduler_composeui

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
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
        modifier= modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //구성 가능한 함수는 remember API를 사용하여 메모리에 객체를 저장할 수 있습니다. remember에 의해 계산된 값은 초기
        // 컴포지션 중에 컴포지션에 저장되고 저장된 값은 리컴포지션 중에 반환됩니다.
        // remember는 변경 가능한 객체뿐만 아니라 변경할 수 없는 객체를 저장하는 데 사용할 수 있습니다.
        var id by remember { mutableStateOf("ID") }
        var pw by remember { mutableStateOf("PW") }
        OutlinedTextField(
            value = "",
            onValueChange = { id = it },
            label = { Text("아이디") }
        )
        OutlinedTextField(
            value = "",
            onValueChange = { pw = it },
            label = { Text("비밀번호") }

        )
        Spacer(modifier.height(25.dp))
        Button(onClick = {
                         /*TODO*/ } ,
            ) {
            Text(text = "로그인")
        }
    }
}
@Composable
fun RegisterSecton(modifier: Modifier=Modifier){
    Column(modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
        Text(text="아직 회원이 아니신가요?")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "회원 가입")
        }

    }
}


@Composable
fun HomeScreen(modifier: Modifier){
    Column(modifier = modifier.fillMaxSize()) {
        TopSection(modifier)
        LoginSection(modifier)
        Spacer(modifier = Modifier.padding(20.dp))
        RegisterSecton(modifier)
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scheduler_ComposeUITheme {
        HomeScreen(modifier = Modifier.fillMaxWidth())
    }
}
