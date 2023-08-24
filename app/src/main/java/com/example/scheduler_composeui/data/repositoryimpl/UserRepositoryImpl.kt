package com.example.scheduler_composeui.data.repositoryimpl

import android.util.Log
import com.example.scheduler_composeui.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor():UserRepository {
    override fun getLogin() :String {
        Log.d("hch", "ImplgetLogin: ")
        return "hch507"
    }

    override fun signInUser() {
        TODO("Not yet implemented")
    }


}