package com.example.scheduler_composeui.domain.repository

import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.RegistResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse
import com.example.scheduler_composeui.domain.entity.UserInfo
import com.example.scheduler_composeui.domain.entity.ValidationInfo

interface UserRepository {

    suspend fun getLogin(userID : String, userPassword: String):UserInfo?

    suspend fun getValidUserId(userID: String):ValidationInfo?

    suspend fun getRegistMessage(userID:String,userPassword:String,userGender:String, userGrade:String,userName:String):RegistResponse?
}