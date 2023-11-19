package me.adipiscing_elit.hewahbnb.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.adipiscing_elit.hewahbnb.R
import me.adipiscing_elit.hewahbnb.ui.theme.HewahBnBTheme
import me.adipiscing_elit.hewahbnb.util.*
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    hbViewModel: HBViewModel
) {

    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current


    var password by remember { hbViewModel.password }
    var emailAddress by remember { hbViewModel.emailAddress }
    var fullName by remember { hbViewModel.fullName }
    var mpesaNumber by remember { hbViewModel.mpesaNumber }
    var confirmedPassword by remember { hbViewModel.confirmedPassword }


    LazyColumn(
            verticalArrangement = Arrangement.Center,
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
                    text = stringResource(id = R.string.signUp),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        MaterialTheme.colorScheme.primary
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
            }


            item {
                Text(
                    text = stringResource(id = R.string.fullName),
                    style = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
                    value = fullName,
                    onValueChange = { hbViewModel.fullName.value = it },
                    label = { Text(stringResource(id = R.string.enter_fullName)) },
                    singleLine = true,
                    placeholder = { Text(stringResource(id = R.string.fullName)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Spacer(modifier = Modifier.height(4.dp))


                Text(
                    text = stringResource(id = R.string.mpesaNumber),
                    style = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
                    value = mpesaNumber,
                    onValueChange = { hbViewModel.mpesaNumber.value = it},
                    label = { Text(stringResource(id = R.string.enter_mpesaNumber)) },
                    singleLine = true,
                    placeholder = { Text(stringResource(id = R.string.mpesaNumber)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
                Spacer(modifier = Modifier.height(4.dp))


                Text(
                    text = stringResource(id = R.string.email),
                    style = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
                    value = emailAddress,
                    onValueChange = { hbViewModel.emailAddress.value = it},
                    label = { Text(stringResource(id = R.string.enter_email_address)) },
                    singleLine = true,
                    placeholder = { Text(stringResource(id = R.string.email_address)) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )
                Spacer(modifier = Modifier.height(4.dp))


                Text(
                    text = stringResource(id = R.string.password),
                    style = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
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
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = stringResource(id = R.string.confirmPassword),
                    style = MaterialTheme.typography.titleLarge,
                )

                OutlinedTextField(
                    value = confirmedPassword,
                    onValueChange = { hbViewModel.confirmedPassword.value = it },
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
                Spacer(modifier = Modifier.height(4.dp))
                
            }

        item {

            Button(
                onClick = {
            /*TODO(
               1.) Implement signup functionality
               2.) Implement navigation to the next screen
               3.) Add error handling, and loading components; that show based on
               the state of the signup process
             */
                    showToast(context, "TODO")
                }) {
                Text(text = stringResource(id = R.string.createAccount))

            }

        }

        item {
            Row(
                modifier = Modifier
                    .padding(top = 32.dp)
            ) {
                Text(
                    text = "Already have an account?  ",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = LocalContentColor.current
                    ),
                )

                Text(
                    text = stringResource(id = R.string.login_instead),
                    modifier = Modifier.clickable {
                        showToast(context, "TODO")
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
fun pSignUpScreen() {

    val hbViewModel = hiltViewModel<HBViewModel>()

    HewahBnBTheme {
        SignUpScreen(hbViewModel = hbViewModel)
    }
}


