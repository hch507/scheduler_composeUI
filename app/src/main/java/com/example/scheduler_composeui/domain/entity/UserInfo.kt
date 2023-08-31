package com.example.scheduler_composeui.domain.entity

import com.google.gson.annotations.SerializedName

data class UserInfo(
    val success: Boolean=false,
    val userID :String?="",
    val userPassword:String?="",
    val userGender:String?="",
    val userName:String?="",
    val userGrade : String?=""
)
