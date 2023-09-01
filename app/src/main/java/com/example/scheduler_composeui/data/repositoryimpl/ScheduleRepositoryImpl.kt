package com.example.scheduler_composeui.data.repositoryimpl

import android.util.Log
import com.example.scheduler_composeui.data.dto.ScheduleResponse
import com.example.scheduler_composeui.data.retrofit.IRetrofit
import com.example.scheduler_composeui.domain.repository.ScheduleRepository
import com.google.gson.JsonElement
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val apiService : IRetrofit
) : ScheduleRepository {
    override suspend fun loadSchedule() : ArrayList<ScheduleResponse>? {
        Log.d("hch", "ScheduleRepositoryImpl - loadSchedule() - called${apiService.loadSchedule().body()}")
        return apiService.loadSchedule().body()
    }
}