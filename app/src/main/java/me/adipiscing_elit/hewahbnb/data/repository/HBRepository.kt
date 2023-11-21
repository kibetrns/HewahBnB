package me.adipiscing_elit.hewahbnb.data.repository

import dagger.hilt.android.scopes.ViewModelScoped
import me.adipiscing_elit.hewahbnb.data.dtos.responses.LoginResDTO
import me.adipiscing_elit.hewahbnb.data.dtos.responses.SignUpResDTO
import me.adipiscing_elit.hewahbnb.data.service.HBService
import javax.inject.Inject

@ViewModelScoped
class HBRepository @Inject constructor(
    private val hBService: HBService
) {
    suspend fun signUp(
        fullName: String,
        mpesaNumber: Long,
        email: String,
        password: String,
        userName: String
    ): SignUpResDTO? {
        return hBService.signUp(
            fullName = fullName,
            mpesaNumber = mpesaNumber,
            email = email,
            password = password,
            userName = userName
        )
    }

    suspend fun login(
        userName: String,
        password: String
    ): LoginResDTO? {
        return hBService.login(
            userName = userName,
            password = password
        )
    }
}