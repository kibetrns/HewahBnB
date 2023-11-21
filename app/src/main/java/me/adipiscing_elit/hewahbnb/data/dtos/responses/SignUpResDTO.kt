package me.adipiscing_elit.hewahbnb.data.dtos.responses


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpResDTO(
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("objectId")
    val objectId: String,
    @SerialName("sessionToken")
    val sessionToken: String
)