package com.example.scheduler_composeui.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scheduler_composeui.domain.RegistUserUseCase
import com.example.scheduler_composeui.domain.ValidateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RegisterState (
    var validateId:Boolean=false,
    var userID :String = "",
    var userPassword : String="",
    var userGender : String="",
    var userGrade : String="",
    var userName : String=""
)
@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val validateUseCase: ValidateUseCase,
    private val registUserUseCase: RegistUserUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(RegisterState())
    val uiState = _uiState.asStateFlow()

    fun validUserId(id:String){
        viewModelScope.launch {
            Log.d("hch", "RegisterViewModel-validUserId() called ${validateUseCase(id)}")
        }
    }

    fun registUser(userID: String,userPassword:String,userGender: String,userGrade: String,userName: String){
        viewModelScope.launch {
            Log.d("hch", "RegisterViewModel - registUser() - called${registUserUseCase(userID,userPassword,userGender,userGrade,userName)}")
        }
    }
}