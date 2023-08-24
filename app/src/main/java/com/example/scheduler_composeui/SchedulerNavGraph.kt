package com.example.scheduler_composeui

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scheduler_composeui.ui.compose.LoginScreen
import com.example.scheduler_composeui.ui.compose.MainScreen
import com.example.scheduler_composeui.ui.compose.registerScreen
import com.example.scheduler_composeui.utils.AppModalDrawer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchedulerApp(
                modifier:Modifier=Modifier,
                navController: NavHostController = rememberNavController(),
                coroutineScope:CoroutineScope= rememberCoroutineScope(),
                drawerState : DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
                navActions: NavigationAction = remember(navController) {
                    NavigationAction(navController)
                }
){


    NavHost(navController = navController, startDestination =SchedulerScreen.LOGIN.title  ){
        composable(route = SchedulerScreen.LOGIN.title ){

            LoginScreen(modifier = modifier,
                        OnRegidterClicked = {
                            navActions.navigationToRegister()
                        }
//                        OnLoginClicked = {
//
////                            navActions.navigationToMain()
//                        }
            )
        }
        composable(route = SchedulerScreen.REGISTER.title){

            registerScreen(modifier=modifier)
        }
        composable(route= SchedulerScreen.Main.title){
            AppModalDrawer(drawerState = drawerState) {
                MainScreen(modifier=modifier, openDrawer = {
                     coroutineScope.launch { drawerState.open() }
                })
        }

        }

    }

}



