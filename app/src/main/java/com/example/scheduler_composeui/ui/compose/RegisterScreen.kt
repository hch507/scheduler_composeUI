package com.example.scheduler_composeui.ui.compose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.scheduler_composeui.ui.viewmodels.RegisterViewModel

@Composable
fun registerScreen(
    modifier: Modifier=Modifier.fillMaxWidth(),
    viewmodel : RegisterViewModel = hiltViewModel()
){
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        registerHead(modifier = modifier)
        bodySection(
            modifier = modifier,
            viewmodel=viewmodel
            )
        genderRadioButton(modifier=modifier)
    }

}

@Composable
fun registerHead(modifier: Modifier){
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
fun bodySection(
        modifier: Modifier,
        viewmodel: RegisterViewModel
        ){
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    Column(
        modifier
            .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier,
            Arrangement.SpaceEvenly){
            TextField(
                value =id,
                onValueChange ={id = it},
                label = { Text(text = "아이디")},
                )

            Button(onClick ={viewmodel.validUserId(id)}, shape= CircleShape) {
                Text(text = "중복")
            }
        }
        OutlinedTextField(value = pw,
                        onValueChange ={pw = it},
                        label = { Text(text = "비밀번호")},)
        TextField(
            value =name,
            onValueChange ={name = it},
            label = { Text(text = "이름")},
        )
        


    }
}
@Composable
fun genderRadioButton(modifier: Modifier){
    val selectValue = remember{ mutableStateOf("") }
    var isSelectedItem : (String) -> Boolean ={selectValue.value==it}
    var onChangeState : (String)-> Unit ={selectValue.value=it }
    val items = listOf("남자","여자")
    Row(modifier.selectableGroup()
    ){
        items.forEach{item->
            Row(modifier = Modifier
                .selectable(
                    selected = isSelectedItem(item),
                    onClick = { onChangeState(item) },
                    role = Role.RadioButton
                )
                .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                RadioButton(selected = isSelectedItem(item),
                            onClick = null)
                Text(text = item)
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun previewRegisterScreen(){
    genderRadioButton(Modifier)
}