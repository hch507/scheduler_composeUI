package com.example.scheduler_composeui.ui.compose

import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.scheduler_composeui.ui.viewmodels.RegisterViewModel
import com.example.scheduler_composeui.ui.viewmodels.ScheduleViemodel

@Composable
fun registerScreen(
    modifier: Modifier=Modifier.fillMaxWidth(),
    viewmodel : RegisterViewModel = hiltViewModel(),
    OnRegisterClicked : () -> Unit
){

    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        registerHead(modifier = modifier)
        bodySection(
            modifier = modifier,
            viewmodel=viewmodel,
             onClicked = OnRegisterClicked
            )
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
        modifier:Modifier,
        viewmodel: RegisterViewModel,
        onClicked : ()->Unit
        ){
    val validationId by viewmodel.validationState.collectAsState()
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var genderSelectValue by remember{ mutableStateOf("") }
    var gradeSelectValue by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier
            .padding(13.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier,
            Arrangement.SpaceEvenly){
            TextField(
                value =id,
                onValueChange ={id = it},
                label = { Text(text = "아이디")},
                enabled = !validationId.success
            )

            Button(
                onClick ={
                    viewmodel.validUserId(id) },
                shape= CircleShape,
                enabled = !validationId.success) {
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
        selectRadioButton(
            modifier = modifier,
            item1 = "남자",
            item2 = "여자",
            isSelectedItem ={genderSelectValue ==it} ,
            onChangeState = {genderSelectValue=it})
        selectRadioButton(
            modifier = modifier,
            item1 = "직원",
            item2 = "관리자" ,
            isSelectedItem ={gradeSelectValue ==it} ,
            onChangeState = {gradeSelectValue=it})


        Button(onClick ={
            if(validationId.success){
                if (pw.isEmpty()|| name.isEmpty() || genderSelectValue.isEmpty()||gradeSelectValue.isEmpty()){
                    Toast.makeText(context,"공백 없이 채워주세요",Toast.LENGTH_SHORT).show()
                }else{
                    viewmodel.registUser(userID = id, userPassword = pw, userGender = genderSelectValue, userGrade = gradeSelectValue, userName = name)
                    onClicked()
                }
            }else{
                Toast.makeText(context,"먼저 아이디 중복 검사를 해주세요 ",Toast.LENGTH_SHORT).show()
            }}, shape= CircleShape) {
            Text(text = "가입하기")
        }
//        Button(onClick ={ testViewmMdel.getSchedule()}, shape= CircleShape) {
//            Text(text = "가입하기")
//        }
    }
}
@Composable
fun selectRadioButton(
    modifier: Modifier,
    item1 : String,
    item2 : String,
    isSelectedItem : (String) -> Boolean,
    onChangeState : (String)-> Unit
){
    val selectValue = remember{ mutableStateOf("") }
//    var isSelectedItem : (String) -> Boolean ={selectValue.value==it}
//    var onChangeState : (String)-> Unit ={selectValue.value=it }
    val items = listOf(item1,item2)
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
//
//@Preview(showBackground = true)
//@Composable
//fun previewRegisterScreen(){
//    genderRadioButton(Modifier)
//}