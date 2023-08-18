package com.example.scheduler_composeui.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


///uiState
data class LoginUiState(
    val isSign : Boolean=false,
    val userId : String ="",
    val userPw : String =""
)
//ViewModel
class LoginViewmodel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState =_uiState.asStateFlow()

    init {
        _uiState.value=LoginUiState()
    }

    fun Message(userId : String, userPw: String){
        _uiState.value= LoginUiState(true,userId,userPw)
        Log.d("hch", "Message: message 호출")
    }
}