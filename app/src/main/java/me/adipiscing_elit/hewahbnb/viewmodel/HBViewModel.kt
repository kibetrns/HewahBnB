package me.adipiscing_elit.hewahbnb.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HBViewModel @Inject constructor(

) : ViewModel() {

    var password: MutableState<String> = mutableStateOf("")
    var emailAddress: MutableState<String> = mutableStateOf("")
    var fullName: MutableState<String> = mutableStateOf("")
    var mpesaNumber: MutableState<String> = mutableStateOf("")
    var confirmedPassword: MutableState<String> = mutableStateOf("")


}