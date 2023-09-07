package com.example.scheduler_composeui.data.mapper

import com.example.scheduler_composeui.data.dto.LoginResponse
import com.example.scheduler_composeui.data.dto.RegistResponse
import com.example.scheduler_composeui.data.dto.ValidateResponse
import com.example.scheduler_composeui.domain.entity.RegisterInfo
import com.example.scheduler_composeui.domain.entity.UserInfo
import com.example.scheduler_composeui.domain.entity.ValidationInfo

object UserMapper {

    fun mapperToUser(loginResponse : LoginResponse):UserInfo{
        return UserInfo(
            success = loginResponse.success,
            userID = loginResponse.userID,
            userPassword = loginResponse.userPassword,
            userGender = loginResponse.userGender,
            userName = loginResponse.userName,
            userGrade = loginResponse.userGrade
        )
    }
    fun mapperToValidation(validateResponse: ValidateResponse):ValidationInfo{
        return ValidationInfo(
            success = validateResponse.success,
            message = validateResponse.message
        )
    }
    fun mapperToRegister(registResponse: RegistResponse):RegisterInfo{
        return RegisterInfo(
            success = registResponse.success
        )
    }
}