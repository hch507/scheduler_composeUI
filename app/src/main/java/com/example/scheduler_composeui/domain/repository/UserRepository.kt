package com.example.scheduler_composeui.domain.repository

import com.example.scheduler_composeui.data.dto.LoginResponse

interface UserRepository {

    suspend fun getLogin(id : String, pw: String):LoginResponse?

    suspend fun signInUser()
}