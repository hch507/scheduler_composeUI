package com.example.scheduler_composeui.domain

import com.example.scheduler_composeui.domain.repository.UserRepository
import javax.inject.Inject

class RegistUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator suspend fun invoke(userID:String,userPassword:String,userGender:String, userGrade:String,userName:String){
        userRepository.getRegistMessage(userID,userPassword,userGender,userGrade, userName)
    }
}