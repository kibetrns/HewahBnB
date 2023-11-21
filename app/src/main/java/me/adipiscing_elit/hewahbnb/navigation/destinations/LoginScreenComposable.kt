package me.adipiscing_elit.hewahbnb.navigation.destinations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.adipiscing_elit.hewahbnb.util.LOGIN_SCREEN
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.loginScreen(
    hbViewModel: HBViewModel,
    navigateToHomeScreen: () -> Unit,
) {
    composable(
        route = LOGIN_SCREEN,
    ) {

        //TODO("Login Screen Design")

        Text(text = "Login Screen Coming Soon :)", style = MaterialTheme.typography.titleLarge)
    }
}