package com.example.scheduler_composeui.di

import com.example.scheduler_composeui.data.repositoryimpl.ScheduleRepositoryImpl
import com.example.scheduler_composeui.data.repositoryimpl.UserRepositoryImpl
import com.example.scheduler_composeui.domain.repository.ScheduleRepository
import com.example.scheduler_composeui.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule{

    @Binds
    abstract fun bindUserRepository (userRepositoryImpl: UserRepositoryImpl):UserRepository
    @Binds
    abstract fun bindScheduleRepository(scheduleRepositoryImpl: ScheduleRepositoryImpl): ScheduleRepository
}