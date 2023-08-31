package com.example.scheduler_composeui.domain

import android.util.Log
import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.domain.entity.UserInfo
import com.example.scheduler_composeui.domain.repository.UserRepository

import javax.inject.Inject

class LoginUserUseCaee @Inject constructor(
    private val userRepository: UserRepository
){
    operator suspend fun invoke(id : String, pw : String) : UserInfo? {

        Log.d("hch", "LoginUseCaee - invoke() - called")
        return userRepository.getLogin(id, pw)
    }
}