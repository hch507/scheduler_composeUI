package com.example.scheduler_composeui.data.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("userID")
    val userID :String?,
    @SerializedName("userPassword")
    val userPassword:String?
)
