package com.example.scheduler_composeui.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.scheduler_composeui.domain.LoginUserUseCaee

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


///uiState
data class LoginUiState(
    val isSign : Boolean=false,
    val userId : String ="",
    val userPassword : String ="",
)

//ViewModel
@HiltViewModel
class UserViewModel @Inject constructor(
    private val loginUserUseCase : LoginUserUseCaee
): ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState =_uiState.asStateFlow()

    init {
        _uiState.value=LoginUiState()
    }

    fun loginRequest(userId: String,userPassword: String ){
        Log.d("hch", "LoginViewmodel - () - called")
        viewModelScope.launch{

            _uiState.value=
            loginUserUseCase(userId,userPassword)
            Log.d("hch", "Message: message 호출${loginUserUseCase(userId,userPassword)}")



        }

    }
}