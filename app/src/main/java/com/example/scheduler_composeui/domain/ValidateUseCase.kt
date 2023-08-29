package com.example.scheduler_composeui.domain

import android.util.Log
import com.example.scheduler_composeui.domain.repository.UserRepository
import javax.inject.Inject

class ValidateUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    operator suspend fun invoke(id :String){
        userRepository.getValidUserId(id=id)
        Log.d("hch", "ValidateUseCase-invoke() called${userRepository.getValidUserId(id=id)}")
    }
}