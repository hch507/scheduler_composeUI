package com.example.scheduler_composeui.domain.repository

import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.RegistResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse

interface UserRepository {

    suspend fun getLogin(userID : String, userPassword: String):LoginResponse?

    suspend fun getValidUserId(userID: String):ValidateResponse?

    suspend fun getRegistMessage(userID:String,userPassword:String,userGender:String, userGrade:String,userName:String):RegistResponse?
}