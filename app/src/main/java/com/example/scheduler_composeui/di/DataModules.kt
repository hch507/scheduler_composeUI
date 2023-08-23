package com.example.scheduler_composeui.di

import com.example.scheduler_composeui.data.repositoryimpl.UserRepositoryImpl
import com.example.scheduler_composeui.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Singleton
    @Binds
    abstract fun bindUserRepository (userRepositoryImpl: UserRepositoryImpl):UserRepository
}