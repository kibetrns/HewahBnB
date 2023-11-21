package me.adipiscing_elit.hewahbnb.data.service

import me.adipiscing_elit.hewahbnb.data.dtos.responses.LoginResDTO
import me.adipiscing_elit.hewahbnb.data.dtos.responses.SignUpResDTO
import me.adipiscing_elit.hewahbnb.util.ServiceResult

interface HBService {

    suspend fun signUp(
        fullName: String,
        mpesaNumber: Long,
        email: String,
        password: String,
        userName: String
    ): SignUpResDTO?

    suspend fun login(userName: String, password: String): LoginResDTO?
}
