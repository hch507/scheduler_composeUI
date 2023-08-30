package com.example.scheduler_composeui.data.repositoryimpl

import android.util.Log
import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.RegistResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse
import com.example.scheduler_composeui.data.retrofit.IRetrofit
import com.example.scheduler_composeui.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val ApiService:IRetrofit
):UserRepository {
    override suspend fun getLogin(userID: String, userPassword: String) : LoginResponse? {
        Log.d("hch", "UserRepositoryImpl - getLogin() - called ${ApiService.loginRequest(userID,userPassword).body()}")
        return ApiService.loginRequest(userID,userPassword).body()
    }

    override suspend fun getValidUserId(userID: String): ValidateResponse? {
        return ApiService.validateRequest(userID).body()
    }

    override suspend fun getRegistMessage(userID:String,userPassword:String,userGender:String, userGrade:String,userName:String): RegistResponse? {
        return ApiService.registRequset(userID,userPassword,userGender,userGrade,userName).body()
    }


}