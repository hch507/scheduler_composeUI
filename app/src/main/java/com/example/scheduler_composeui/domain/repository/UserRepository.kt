package com.example.scheduler_composeui.domain.repository

interface UserRepository {

    fun getLogin():String

    fun signInUser()
}