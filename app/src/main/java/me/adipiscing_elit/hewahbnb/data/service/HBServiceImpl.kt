package me.adipiscing_elit.hewahbnb.data.service

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.contentType
import io.ktor.http.headers
import io.ktor.http.isSuccess
import kotlinx.serialization.json.Json
import me.adipiscing_elit.hewahbnb.data.dtos.requests.LoginReqDTO
import me.adipiscing_elit.hewahbnb.data.dtos.requests.SignUpReqDTO
import me.adipiscing_elit.hewahbnb.data.dtos.responses.LoginResDTO
import me.adipiscing_elit.hewahbnb.data.dtos.responses.SignUpResDTO
import me.adipiscing_elit.hewahbnb.util.APP_ID
import me.adipiscing_elit.hewahbnb.util.HBAPIEndpoints
import me.adipiscing_elit.hewahbnb.util.MASTER_KEY
import me.adipiscing_elit.hewahbnb.util.ServiceResult
import javax.inject.Inject
import javax.inject.Named

class HBServiceImpl@Inject constructor(
    @Named("default") private val defaultCSAService: HttpClient
) : HBService {
    override suspend fun signUp(
        fullName: String,
        mpesaNumber: Long,
        email: String,
        password: String,
        userName: String
    ): SignUpResDTO? {
        try {

            Log.d(
                "SIGNUP_HBServI", SignUpReqDTO(
                    email = email,
                    fullName = fullName,
                    mpesaNumber = mpesaNumber,
                    password = password,
                    userName = userName

                ).toString()
            )

            val response = defaultCSAService.post(HBAPIEndpoints.SignUpUser.url) {
                headers {
                    header("X-Parse-Application-Id", APP_ID)
                    header("X-Parse-REST-API-Key", MASTER_KEY)
                    header("X-Parse-Revocable-Session", "1")
                    header("Content-Type", "application/json")
                }
                contentType(Application.Json)
                setBody(
                    SignUpReqDTO(
                        email = email,
                        fullName = fullName,
                        mpesaNumber = mpesaNumber,
                        password = password,
                        userName = userName
                    ),
                )
                Log.d("SIGNUP_API_REQUEST", this.body.toString())
            }
            Log.d("SIGNUP_API_RESPONSE", response.toString())
            Log.d("SIGNUP_API_RES_Headers", response.headers.toString())
            Log.d("SIGNUP_API_RES_Body", response.body())


            return response.body()

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
    override suspend fun login(userName: String, password: String): LoginResDTO? {

        try {

            Log.d(
                "LOGIN_HBServI", LoginReqDTO(
                    password = password,
                    userName = userName
                ).toString()
            )

            val response = defaultCSAService.post(HBAPIEndpoints.LoginUser.url) {
                headers {
                    header("X-Parse-Application-Id", APP_ID)
                    header("X-Parse-REST-API-Key", MASTER_KEY)
                    header("X-Parse-Revocable-Session", "1")
                    header("Content-Type", "application/json")
                }
                contentType(Application.Json)
                setBody(
                    LoginReqDTO(
                        password = password,
                        userName = userName
                    ),
                )
                Log.d("LOGIN_API_REQUEST", this.body.toString())
            }
            Log.d("LOGIN_API_RESPONSE", response.toString())
            Log.d("LOGIN_API_RES_Headers", response.headers.toString())
            Log.d("LOGIN_API_RES_Body", response.body())

            return Json.decodeFromString<LoginResDTO>(response.body())

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }


    }
}