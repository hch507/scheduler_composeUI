package com.example.scheduler_composeui.domain

import android.util.Log
import com.example.scheduler_composeui.domain.repository.UserRepository

import javax.inject.Inject

class LoginUseCaee @Inject constructor(
    private val userRepository: UserRepository
){
    operator suspend fun invoke(id : String, pw : String) {
        userRepository.getLogin(id, pw)
        Log.d("hch", "LoginUseCaee - invoke() - called${userRepository.getLogin(id, pw)}")

    }
}