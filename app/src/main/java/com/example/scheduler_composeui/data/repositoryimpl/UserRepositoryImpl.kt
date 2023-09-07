package com.example.scheduler_composeui.data.repositoryimpl

import android.util.Log
import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.RegistResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse
import com.example.scheduler_composeui.data.mapper.UserMapper
import com.example.scheduler_composeui.data.retrofit.IRetrofit
import com.example.scheduler_composeui.domain.entity.RegisterInfo
import com.example.scheduler_composeui.domain.entity.UserInfo
import com.example.scheduler_composeui.domain.entity.ValidationInfo
import com.example.scheduler_composeui.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val ApiService:IRetrofit
):UserRepository {
    override suspend fun getLogin(userID: String, userPassword: String) : UserInfo? {
        Log.d("hch", "UserRepositoryImpl - getLogin() - called ")
        return ApiService.loginRequest(userID,userPassword).body()
            ?.let { UserMapper.mapperToUser(it) }
    }

    override suspend fun getValidUserId(userID: String): ValidationInfo?{
        return ApiService.validateRequest(userID).body()
            ?.let { UserMapper.mapperToValidation(it) }
    }

    override suspend fun getRegistMessage(userID:String,userPassword:String,userGender:String, userGrade:String,userName:String): RegisterInfo? {
        return ApiService.registRequset(userID,userPassword,userGender,userGrade,userName).body()
            ?.let { UserMapper.mapperToRegister(it) }
    }


}