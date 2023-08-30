package com.example.scheduler_composeui.data.dto

import com.google.gson.annotations.SerializedName

data class RegistResponse(
    @SerializedName("success") val success : String,
    @SerializedName("message") val message : String
)
