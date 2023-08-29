package com.example.scheduler_composeui.data.repositoryimpl

import android.util.Log
import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse
import com.example.scheduler_composeui.data.retrofit.IRetrofit
import com.example.scheduler_composeui.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val ApiService:IRetrofit
):UserRepository {
    override suspend fun getLogin(id: String, pw: String) : LoginResponse? {
        Log.d("hch", "UserRepositoryImpl - getLogin() - called ${ApiService.loginRequest(id,pw).body()}")
        return ApiService.loginRequest(id,pw).body()
    }

    override suspend fun getValidUserId(id: String): ValidateResponse? {
        return ApiService.validateRequest(id).body()
    }


}