package com.example.scheduler_composeui.data.dto

import com.google.gson.annotations.SerializedName

data class ScheduleResponse(
    @SerializedName("userID")
    val userID : String,
    @SerializedName("staffId")
    val staffId : String,
    @SerializedName("patient")
    val patient : String,
    @SerializedName("startTime")
    val startTime : String,
    @SerializedName("endTime")
    val endTime : String,
    @SerializedName("memo")
    val memo : String,
    @SerializedName("startDate")
    val startDate : String,
    @SerializedName("endDate")
    val endDate : String,
)
