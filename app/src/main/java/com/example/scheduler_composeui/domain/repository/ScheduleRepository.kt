package com.example.scheduler_composeui.domain.repository

import com.example.scheduler_composeui.data.dto.ScheduleResponse
import com.google.gson.JsonElement

interface ScheduleRepository {
    suspend fun loadSchedule():ArrayList<ScheduleResponse>?
}