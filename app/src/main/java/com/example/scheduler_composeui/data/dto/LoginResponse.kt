package com.example.scheduler_composeui.data.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("userID")
    val userID :String,
    @SerializedName("userPassword")
    val userPassword:String,
    @SerializedName("userGender")
    val userGender:String,
    @SerializedName("userName")
    val userName:String,
    @SerializedName("userGrade")
    val userGrade : String
)
