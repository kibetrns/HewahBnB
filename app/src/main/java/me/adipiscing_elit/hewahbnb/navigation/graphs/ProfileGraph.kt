package me.adipiscing_elit.hewahbnb.navigation.graphs

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.adipiscing_elit.hewahbnb.ui.ProfileScreen
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

fun NavGraphBuilder.profileNavGraph(
    navController: NavHostController,
    hbViewModel: HBViewModel
) {

    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileScreen.Profile.route
    ) {

        composable(
            route = ProfileScreen.Profile.route,
        ) {

            LaunchedEffect(key1 = true) {
                //hbViewModel.("TODO")
            }
            ProfileScreen(
                hbViewModel = hbViewModel,
                navController = navController,
            )
        }
    }
}

sealed class ProfileScreen(val route: String) {
    object Profile: HomeScreen(route = "profile")

}