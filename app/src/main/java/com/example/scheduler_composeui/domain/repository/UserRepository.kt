package com.example.scheduler_composeui.domain.repository

import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse

interface UserRepository {

    suspend fun getLogin(id : String, pw: String):LoginResponse?

    suspend fun getValidUserId(id: String):ValidateResponse?
}