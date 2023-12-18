package me.adipiscing_elit.hewahbnb.navigation

import androidx.navigation.NavController
import me.adipiscing_elit.hewahbnb.util.HOME_SCREEN
import me.adipiscing_elit.hewahbnb.util.LOGIN_SCREEN
import me.adipiscing_elit.hewahbnb.util.SIGNUP_SCREEN

class Screens(navController: NavController) {

    val login: () -> Unit = {
        navController.navigate("Login") {
            popUpTo(LOGIN_SCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val signUp: () -> Unit = {
        navController.navigate("signUp") {
            popUpTo(SIGNUP_SCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    val home: () -> Unit = {
        navController.navigate("home") {
            popUpTo(HOME_SCREEN) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
}