package com.example.scheduler_composeui.utils

import android.graphics.Color
import android.graphics.ColorFilter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scheduler_composeui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppModalDrawer(
    drawerState: DrawerState,
    onClick : () ->Unit,
    content:@Composable () -> Unit){
//    ModalDrawerSheet(
//        drawerShape = DrawerDefaults.shape
//    ) {
        ModalNavigationDrawer(
            modifier = Modifier.fillMaxSize(),
            drawerState = drawerState,

            drawerContent = {
                ModalDrawerSheet(
                    drawerShape = DrawerDefaults.shape
                ) {
                    NavigationDrawer(modifier = Modifier , onClick)
                }

            }
        ){
            content()
        }
 //   }


}
@Composable
fun NavigationDrawer(
    modifier:Modifier,

){

    Column(modifier = modifier.fillMaxSize()) {
        DrawerHeader(modifier)
        DrawerButton(
            painter = painterResource(id = R.drawable.ic_baseline_home_24),
            action = { /*TODO*/ },
            label = "Home",
            modifier = modifier)
        DrawerButton(
            painter = painterResource(id = R.drawable.ic_baseline_app_registration_24),
            action = { /*TODO*/ },
            label = "캘린더",
            modifier = modifier)
        DrawerButton(
            painter = painterResource(id = R.drawable.ic_baseline_article_24),
            action = { onClick },
            label = "요약",
            modifier = modifier)
    }
}
@Composable
private fun DrawerHeader(modifier: Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = "Person",
                modifier = modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .size(size = 100.dp)
                    .clip(shape = CircleShape),

                )
            Text(
                text = "이름",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }

    }


}
@Composable
private fun DrawerButton(
    painter: Painter,
    action : () ->Unit,
    label : String,
    modifier:Modifier
){
    TextButton(
        onClick = action,
        modifier = modifier
            .fillMaxWidth()
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painter,
                contentDescription = null, // decorative
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = label
            )
        }
    }




}

@Preview(showBackground = true)
@Composable
fun PreviewDrawer(){
    NavigationDrawer(Modifier.fillMaxWidth())
}