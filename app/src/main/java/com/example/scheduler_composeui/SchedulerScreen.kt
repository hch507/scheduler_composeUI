package com.example.scheduler_composeui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scheduler_composeui.ui.compose.HomeScreen
import com.example.scheduler_composeui.ui.compose.registerScreen

@Composable
fun SchedulerApp(modifier:Modifier=Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination =SchedulerScreen.LOGIN.title  ){
        composable(route = SchedulerScreen.LOGIN.title ){
            HomeScreen(modifier = modifier,
                        OnRegidterClicked = {
                            navController.navigate(SchedulerScreen.REGISTER.title)
                        })
        }
        composable(route = SchedulerScreen.REGISTER.title){
            registerScreen(modifier=modifier)
        }
    }

}



enum class SchedulerScreen(val title :String){
    LOGIN("LOGIN"),
    REGISTER("REGISTER")
}
