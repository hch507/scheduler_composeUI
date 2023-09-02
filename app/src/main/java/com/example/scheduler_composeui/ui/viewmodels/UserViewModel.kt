package com.example.scheduler_composeui.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.scheduler_composeui.domain.LoginUserUseCaee
import com.example.scheduler_composeui.domain.entity.UserInfo

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


///uiState

//ViewModel
@HiltViewModel
class UserViewModel @Inject constructor(
    private val loginUserUseCase : LoginUserUseCaee
): ViewModel() {
    private val _userInfoState = MutableStateFlow(UserInfo())
    val userInfoState =_userInfoState.asStateFlow()

    init {
        _userInfoState.value=UserInfo()
    }

    fun loginRequest(userId: String,userPassword: String ){
        Log.d("hch", "LoginViewmodel - () - called")

        var job =viewModelScope.launch{
            _userInfoState.value= loginUserUseCase(userId,userPassword)!!
            Log.d("hch", "Message: message 호출")
        }



    }
}