package com.example.scheduler_composeui

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class SchedulerScreen(val title :String){
    LOGIN("LOGIN"),
    REGISTER("REGISTER"),
    Main("Main")
}

class NavigationAction(val navController: NavHostController){

    fun navigationToMain(){
        navController.navigate(SchedulerScreen.Main.title)
    }

    fun navigationToRegister(){
        navController.navigate(SchedulerScreen.Main.title)
    }
}