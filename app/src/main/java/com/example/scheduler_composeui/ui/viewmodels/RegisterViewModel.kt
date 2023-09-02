package com.example.scheduler_composeui.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.scheduler_composeui.domain.RegistUserUseCase
import com.example.scheduler_composeui.domain.ValidateUseCase
import com.example.scheduler_composeui.domain.entity.ValidationInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val validateUseCase: ValidateUseCase,
    private val registUserUseCase: RegistUserUseCase
): ViewModel() {
    private val _validationState = MutableStateFlow(ValidationInfo())
    val validationState = _validationState.asStateFlow()

    fun validUserId(id:String){
        viewModelScope.launch {
            _validationState.value=validateUseCase(id)!!

        }
    }

    fun registUser(userID: String,userPassword:String,userGender: String,userGrade: String,userName: String){
        viewModelScope.launch {
            Log.d("hch", "RegisterViewModel - registUser() - called${registUserUseCase(userID,userPassword,userGender,userGrade,userName)}")
        }
    }
}