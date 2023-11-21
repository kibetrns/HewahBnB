package me.adipiscing_elit.hewahbnb.navigation.destinations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.adipiscing_elit.hewahbnb.ui.LoginScreen
import me.adipiscing_elit.hewahbnb.util.LOGIN_SCREEN
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.loginScreen(
    hbViewModel: HBViewModel,
    navigateToHomeScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit
) {
    composable(
        route = LOGIN_SCREEN,
    ) {

        LoginScreen(
            hbViewModel = hbViewModel,
            navigateToHomeScreen = navigateToHomeScreen,
            navigateToSignUpScreen = navigateToSignUpScreen
        )
    }
}