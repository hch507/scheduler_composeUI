package com.example.scheduler_composeui

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scheduler_composeui.ui.compose.LoginScreen
import com.example.scheduler_composeui.ui.compose.MainScreen
import com.example.scheduler_composeui.ui.compose.registerScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchedulerApp(
                modifier:Modifier=Modifier,
                navController: NavHostController = rememberNavController(),
                drawerState : DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)){


    NavHost(navController = navController, startDestination =SchedulerScreen.LOGIN.title  ){
        composable(route = SchedulerScreen.LOGIN.title ){
            LoginScreen(modifier = modifier,
                        OnRegidterClicked = {
                            navController.navigate(SchedulerScreen.REGISTER.title)
                        },
                        OnLoginClicked = {
                            navController.navigate(SchedulerScreen.Main.title)
                        }
            )
        }
        composable(route = SchedulerScreen.REGISTER.title){
            registerScreen(modifier=modifier)
        }
        composable(route= SchedulerScreen.Main.title){
            MainScreen(modifier=modifier)
        }

    }

}



enum class SchedulerScreen(val title :String){
    LOGIN("LOGIN"),
    REGISTER("REGISTER"),
    Main("Main")
}
