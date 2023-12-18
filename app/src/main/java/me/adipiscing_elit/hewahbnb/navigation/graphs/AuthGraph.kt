package me.adipiscing_elit.hewahbnb.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.adipiscing_elit.hewahbnb.ui.LoginScreen
import me.adipiscing_elit.hewahbnb.ui.SignUpScreen
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

fun NavGraphBuilder.authNavGraph(navController: NavHostController, hbViewModel: HBViewModel) {

    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.SignUP.route
    ) {
        composable(route = AuthScreen.SignUP.route) {
            SignUpScreen(
                hbViewModel = hbViewModel,
                navigateToHomeScreen = {
                    navController.navigate(HomeScreen.Home.route)
                },
            navigateToLoginScreen = {
                navController.navigate(AuthScreen.Login.route) {
                    launchSingleTop = true
                }
            }
            )
        }
        composable(route = AuthScreen.Login.route) {
            LoginScreen(
                hbViewModel = hbViewModel,
                navigateToHomeScreen = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME) {
                        launchSingleTop = true
                    }

                },
                navigateToSignUpScreen = {
                    navController.navigate(AuthScreen.SignUP.route) {
                    launchSingleTop = true
                    popUpTo(AuthScreen.SignUP.route)
                    }
                }
            )
        }
    }
}


sealed class AuthScreen(val route: String) {
    object Login: AuthScreen(route = "logIn")
    object SignUP : AuthScreen(route = "signUp")
}