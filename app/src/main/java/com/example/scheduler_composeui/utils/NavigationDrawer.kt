package com.example.scheduler_composeui.utils

import android.graphics.Color
import android.graphics.ColorFilter
import android.util.Log

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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.scheduler_composeui.NavigationAction
import com.example.scheduler_composeui.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppModalDrawer(
    drawerState: DrawerState,
    navigationAction: NavigationAction,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    content:@Composable () -> Unit){
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet(modifier = Modifier) {
                    NavigationDrawer(
                        modifier=Modifier,
                        naviToHome = {navigationAction.navigationToMain()},
                        naviToSummary = {navigationAction.navigationToSummary()
                            Log.d("hch", "-AppModalDrawer() called 이ㅡ")},
                        closeDrawer = {coroutineScope.launch { drawerState.close() }})
                }



            }
        ){
            content()
        }


}
@Composable
fun NavigationDrawer(

    naviToHome : () ->Unit,
    naviToSummary:()->Unit,
    closeDrawer:()-> Unit,
    modifier: Modifier
){

    Column(modifier = modifier.fillMaxSize()) {
        DrawerHeader()
        DrawerButton(
            painter = painterResource(id = R.drawable.ic_baseline_home_24),
            action = {
                naviToHome()
                closeDrawer()
            },
            label = "Home"
            )
        DrawerButton(
            painter = painterResource(id = R.drawable.ic_baseline_app_registration_24),
            action = { },
            label = "캘린더"
            )
        DrawerButton(
            painter = painterResource(id = R.drawable.ic_baseline_article_24),
            action = {
                naviToSummary()
                closeDrawer()
            },
            label = "요약",
            )
    }
}
@Composable
private fun DrawerHeader() {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

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
                    .padding(bottom = 16.dp)
            )
        }

}
@Composable
private fun DrawerButton(
    painter: Painter,
    action : () ->Unit,
    label : String,

){
    TextButton(
        onClick = action,

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

//@Preview(showBackground = true)
//@Composable
//fun PreviewDrawer(){
//    NavigationDrawer(Modifier.fillMaxWidth(),)
//}