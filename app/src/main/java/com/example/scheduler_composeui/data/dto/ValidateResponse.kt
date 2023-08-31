package com.example.scheduler_composeui.data.dto

import com.google.gson.annotations.SerializedName

data class ValidateResponse(
    @SerializedName("success")
    val success : Boolean,

    @SerializedName("message")
    val message : String
)