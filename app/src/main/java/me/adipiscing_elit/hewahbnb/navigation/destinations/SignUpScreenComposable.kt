package me.adipiscing_elit.hewahbnb.navigation.destinations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.adipiscing_elit.hewahbnb.ui.SignUpScreen
import me.adipiscing_elit.hewahbnb.util.SIGNUP_SCREEN
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.signUpScreen(
    hbViewModel: HBViewModel,
    navigateToHomeScreen: () -> Unit,
    navigateToLoginScreen: () -> Unit,
) {
    composable(
        route = SIGNUP_SCREEN,
    ) {
        SignUpScreen(
            hbViewModel = hbViewModel,
            navigateToHomeScreen = navigateToHomeScreen,
            navigateToLoginScreen = navigateToLoginScreen
        )
    }
}