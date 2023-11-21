package me.adipiscing_elit.hewahbnb.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.ui.theme.HewahBnBTheme
import me.adipiscing_elit.hewahbnb.util.*
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    hbViewModel: HBViewModel,
    navigateToHomeScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {

    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }


    val password by remember { hbViewModel.password }
    val email by remember { hbViewModel.email }

    val errorMessage by remember { hbViewModel.errorMessage }

    val scope = rememberCoroutineScope()
    val loginUser by rememberUpdatedState(hbViewModel.loggedInUser.collectAsState().value)

    LaunchedEffect(loginUser) {
        when (loginUser) {
            is Result.Error -> {
                showToast(context, "Failed: ${hbViewModel.errorMessage.value}")
            }
            else -> {}
        }
    }


    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {

        item() {
            Image(
                painter = painterResource(id = R.drawable.hewabnb_logo),
                contentDescription = stringResource(id = R.string.hewabnbLogo),
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = stringResource(id = R.string.loginn),
                style = MaterialTheme.typography.headlineSmall.copy(
                    MaterialTheme.colorScheme.primary
                ),
            )
            Spacer(modifier = Modifier.height(8.dp))
        }


        item {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.email),
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(4.dp))

                TextField(
                    value = email,
                    onValueChange = { hbViewModel.email.value = it},
                    label = { Text(stringResource(id = R.string.enter_email_address)) },
                    singleLine = true,
                    placeholder = { Text(stringResource(id = R.string.email_address)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )

                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = stringResource(id = R.string.password),
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(4.dp))

                TextField(
                    value = password,
                    onValueChange = { hbViewModel.password.value = it },
                    label = { Text(stringResource(id = R.string.enter_password)) },
                    singleLine = true,
                    placeholder = { Text(stringResource(id = R.string.password)) },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        val description =
                            if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = image, description)
                        }
                    },
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                ) {
                    Text(text = "")
                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        modifier = Modifier.clickable {
                            showToast(context, "TODO")
                        },
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = LocalContentColor.current
                        ),
                        textDecoration = TextDecoration.Underline
                    )
                }

            }
        }

        item {

            Button(
                modifier = Modifier
                    .padding(top = 16.dp),
                onClick = {
                    /*TODO(
                       1.) Fix the button being clicked more than once for navigation to work.
                       2) Fix the toast not showing when the result is success and when
                       there is an error
                       3.) Handle input fields validations
                     */
                    isLoading = true

                    scope.launch {

                        val signUpResult = async {
                            hbViewModel.loginUser()
                        }

                        signUpResult.await()
                    }

                    when (loginUser) {
                        is Result.Success -> {
                            isLoading = false
                            showToast(context, "Login Success")
                            navigateToHomeScreen()
                        }

                        is Result.Loading -> {
                            isLoading = true
                        }

                        is Result.Error -> {
                            showToast(context, errorMessage)
                            Log.d("LoginScreen", errorMessage)
                            isLoading = false
                        }

                        else -> {

                        }
                    }
                }

            ) {
                Text( text = stringResource(id = R.string.login),)
            }

            if (isLoading) {
                Spacer(modifier = Modifier.height(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 8.dp)
                )
            }
        }


        item {
            Row(
                modifier = Modifier
                    .padding(top = 32.dp)
            ) {
                Text(
                    text = "DON'T have an account?  ",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = LocalContentColor.current
                    ),
                )

                Text(
                    text = stringResource(id = R.string.signUp_instead),
                    modifier = Modifier.clickable {
                        navigateToSignUpScreen()
                    },
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Preview(name = "LoginScreenPreview", showBackground = true, showSystemUi = true)
@Composable
fun pLoginScreen() {

    val hbViewModel = hiltViewModel<HBViewModel>()

    HewahBnBTheme {
        LoginScreen(
            hbViewModel = hbViewModel,
            navigateToHomeScreen = {},
            navigateToSignUpScreen = {}
        )
    }
}