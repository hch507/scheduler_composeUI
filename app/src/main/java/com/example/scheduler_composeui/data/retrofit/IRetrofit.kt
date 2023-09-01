package com.example.scheduler_composeui.data.retrofit

import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.RegistResponse
import com.example.scheduler_composeui.data.dto.ScheduleResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse
import com.example.scheduler_composeui.utils.API
import com.google.gson.JsonElement
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IRetrofit {
    @FormUrlEncoded
    @POST(API.loginPhp)
    suspend fun loginRequest(
        @Field("userID") userID : String?,
        @Field("userPassword") userPassword: String?
    ):Response<LoginResponse>

    @FormUrlEncoded
    @POST(API.validatePhp)
    suspend fun validateRequest(
        @Field("userID") userID: String?
    ):Response<ValidateResponse>

    @FormUrlEncoded
    @POST(API.registerPhp)
    suspend fun registRequset(
        @Field("userID") userID: String?,
        @Field("userPassword") userPassword: String?,
        @Field("userGender") userGender: String?,
        @Field("userGrade") userGrade: String?,
        @Field("userName") userName: String?
    ):Response<RegistResponse>


    @GET(API.loadSchedulePhp)
    suspend fun loadSchedule():Response<ArrayList<ScheduleResponse>>
}