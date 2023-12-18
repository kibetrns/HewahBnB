package me.adipiscing_elit.hewahbnb.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import me.adipiscing_elit.hewahbnb.navigation.graphs.RootNavigationGraph
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetUpNavigation(navController: NavHostController, hbViewModel: HBViewModel) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    RootNavigationGraph(
        navController = navController,
        hbViewModel = hbViewModel

    )

    /*

    NavHost(navController = navController, startDestination = SIGNUP_SCREEN) {

        signUpScreen(
            hbViewModel = hbViewModel,
            navigateToHomeScreen = screen.home,
            navigateToLoginScreen = screen.login
        )

        loginScreen(
            hbViewModel = hbViewModel,
            navigateToHomeScreen = screen.home,
            navigateToSignUpScreen = screen.signUp
        )

        homeScreen(
            hbViewModel = hbViewModel
        )
    }

     */
}