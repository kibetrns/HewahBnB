package me.adipiscing_elit.hewahbnb.data.dtos.requests


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginReqDTO(
    @SerialName("password")
    val password: String,
    @SerialName("username")
    val userName: String
)