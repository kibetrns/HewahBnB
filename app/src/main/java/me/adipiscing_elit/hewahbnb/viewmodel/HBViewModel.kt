package me.adipiscing_elit.hewahbnb.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.adipiscing_elit.hewahbnb.data.dtos.requests.LoginReqDTO
import me.adipiscing_elit.hewahbnb.data.dtos.requests.SignUpReqDTO
import me.adipiscing_elit.hewahbnb.data.dtos.responses.LoginResDTO
import me.adipiscing_elit.hewahbnb.data.dtos.responses.SignUpResDTO
import me.adipiscing_elit.hewahbnb.data.repository.HBRepository
import javax.inject.Inject
import me.adipiscing_elit.hewahbnb.util.Result

@HiltViewModel
class HBViewModel @Inject constructor(
    private val repository: HBRepository

) : ViewModel() {

    var password: MutableState<String> = mutableStateOf("")
    var email: MutableState<String> = mutableStateOf("")
    var fullName: MutableState<String> = mutableStateOf("")
    var mpesaNumber: MutableState<Long> = mutableLongStateOf(25475678910)
    var confirmedPassword: MutableState<String> = mutableStateOf("")

    val  errorMessage = mutableStateOf("")

    var isUserCreated: MutableState<Boolean> = mutableStateOf(false)


    private val _createdUser = MutableStateFlow<Result<SignUpResDTO>>(Result.Idle)
    val createdUser: StateFlow<Result<SignUpResDTO>> = _createdUser

    val  sessionToken = mutableStateOf("")

    private val _loggedInUser = MutableStateFlow<Result<LoginResDTO>>(Result.Idle)
    val loggedInUser: StateFlow<Result<LoginResDTO>> = _loggedInUser







    suspend fun signUpUser() {
        _createdUser.value = Result.Loading
        isUserCreated.value = false

        viewModelScope.launch(Dispatchers.IO) {

            Log.d("SIGNUP_VM", SignUpReqDTO(
                email = email.value,
                fullName = fullName.value,
                mpesaNumber = mpesaNumber.value,
                password = password.value,
                userName = email.value
            ).toString()
            )

            val createdUser = repository.signUp(
                fullName = fullName.value,
                mpesaNumber = mpesaNumber.value,
                email = email.value,
                password = password.value,
                userName = email.value
            )

            if (createdUser != null) {
                _createdUser.value = Result.Success(data = createdUser)
                sessionToken.value = createdUser.sessionToken
                isUserCreated.value = true

                Log.d("SIGNUP_VM", _createdUser.value.toString())
                Log.d("SIGNUP_VM", sessionToken.value)
            } else {
                Result.Error(message = "Something went wrong. User not created")
                errorMessage.value = "Something went wrong. User not created"

                Log.e("SIGNUP_VM", _createdUser.value.toString())
            }

        }

    }
    suspend fun loginUser() {

        viewModelScope.launch(Dispatchers.IO) {

            Log.d("LOGIN_VM", LoginReqDTO(
                password = password.value,
                userName = email.value
            ).toString()
            )

            val loggedInUser = repository.login(
                userName = email.value,
                password = password.value,
            )

            if (loggedInUser != null) {
                _loggedInUser.value = Result.Success(data = loggedInUser)
                sessionToken.value = loggedInUser.sessionToken

                Log.d("LOGIN_VM", _createdUser.value.toString())
            } else {
                Result.Error(message = "Something went wrong. Unable to Login")
                errorMessage.value = "Something went wrong. Unable to Login"

                Log.e("LOGIN_VM", _loggedInUser.value.toString())
            }

        }

    }

}


