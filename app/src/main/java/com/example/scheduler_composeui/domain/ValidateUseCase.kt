package com.example.scheduler_composeui.domain

import android.util.Log
import com.example.scheduler_composeui.domain.entity.ValidationInfo
import com.example.scheduler_composeui.domain.repository.UserRepository
import javax.inject.Inject

class ValidateUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    operator suspend fun invoke(id :String): ValidationInfo? {

        return userRepository.getValidUserId(userID=id)

    }
}