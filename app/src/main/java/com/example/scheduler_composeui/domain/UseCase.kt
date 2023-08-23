package com.example.scheduler_composeui.domain

import com.example.scheduler_composeui.data.model.LoginModel
import com.example.scheduler_composeui.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class LoginUseCaee @Inject constructor(
    private val userRepository: UserRepository
){
    operator fun invoke(id : String, pw : String):String {
        return userRepository.getLogin()
    }
}