package com.example.scheduler_composeui

import android.util.Log
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scheduler_composeui.ui.compose.LoginScreen
import com.example.scheduler_composeui.ui.compose.MainScreen
import com.example.scheduler_composeui.ui.compose.registerScreen
import com.example.scheduler_composeui.ui.compose.summaryScreen
import com.example.scheduler_composeui.ui.viewmodels.ScheduleViemodel
import com.example.scheduler_composeui.ui.viewmodels.UserViewModel
import com.example.scheduler_composeui.utils.AppModalDrawer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchedulerApp(
    modifier:Modifier=Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope:CoroutineScope= rememberCoroutineScope(),
    userViewModel : UserViewModel = hiltViewModel(),
    drawerState : DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    navActions: NavigationAction = remember(navController) {
                    NavigationAction(navController)
                },
){


    NavHost(navController = navController, startDestination =SchedulerScreen.LOGIN.title  ){
        composable(route = SchedulerScreen.LOGIN.title ){

            LoginScreen(
                modifier = modifier,
                OnLoginCliked = {navActions.navigationToMain()},
                OnRegidterClicked = {navActions.navigationToRegister() },
                viewmodel = userViewModel

            )

        }
        composable(route = SchedulerScreen.REGISTER.title){

            registerScreen(
                modifier=modifier ,
                OnRegisterClicked = {navActions.navigationToLogin()} )
        }
        composable(route= SchedulerScreen.Main.title){
            AppModalDrawer(drawerState = drawerState,navActions) {
                MainScreen(modifier=modifier, openDrawer = {
                     coroutineScope.launch { drawerState.open() }
                })
        }

        }
        composable(route = SchedulerScreen.Summary.title){
            AppModalDrawer(drawerState = drawerState,navActions) {
                summaryScreen(modifier=modifier,openDrawer = {
                    Log.d("hch", "-SchedulerApp() called ")
                    coroutineScope.launch { drawerState.open() }
                })
            }
        }

    }

}



