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
import me.adipiscing_elit.hewahbnb.data.dtos.requests.SignUpReqDTO
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
    var mpesaNumber: MutableState<Long> = mutableLongStateOf(2547123456778)
    var confirmedPassword: MutableState<String> = mutableStateOf("")

    val  errorMessage = mutableStateOf("")

    var sessionToken: MutableState<String> = mutableStateOf("")
    var isUserCreated: MutableState<Boolean> = mutableStateOf(false)



    private val _createdUser = MutableStateFlow<Result<SignUpResDTO>>(Result.Idle)
    val createdUser: StateFlow<Result<SignUpResDTO>> = _createdUser



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
            } else {
                Result.Error(message = "Something went wrong. User not created")
                errorMessage.value = "Something went wrong. User not created"

                Log.e("SIGNUP_VM", _createdUser.value.toString())
            }

        }

    }
}