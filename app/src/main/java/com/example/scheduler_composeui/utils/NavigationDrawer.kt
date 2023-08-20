package com.example.scheduler_composeui.utils

import android.graphics.Color
import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scheduler_composeui.R

@Composable
fun NavigationDrawer(modifier:Modifier){
    Column(modifier = modifier.fillMaxSize()) {

    }
}
@Composable
private fun DrawerHeader() {
    Image(
        painter = painterResource(id = R.drawable.baseline_person_24),
        contentDescription = "Person",
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .size(size = 100.dp)
            .clip(shape = CircleShape),
        
    )

    Text(
        text = "이름",
        fontSize = 24.sp,
        modifier = Modifier
            .padding(start = 16.dp, bottom = 16.dp)
    )

}
@Composable
private fun DrawerButton(
    action : () ->Unit
){


}

@Preview(showBackground = true)
@Composable
fun PreviewDrawer(){
    NavigationDrawer()
}