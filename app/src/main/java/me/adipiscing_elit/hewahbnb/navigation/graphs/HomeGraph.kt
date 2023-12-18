package me.adipiscing_elit.hewahbnb.navigation.graphs

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.adipiscing_elit.hewahbnb.ui.HomeScreen
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    hbViewModel: HBViewModel
) {

    navigation(
        route = Graph.HOME,
        startDestination = HomeScreen.Home.route
    ) {

        composable(
            route = HomeScreen.Home.route,
        ) { navBackStackEntry: NavBackStackEntry ->

            LaunchedEffect(key1 = true) {
                //hbViewModel.fetchSearchedHouses("TODO")
            }

            HomeScreen(
                hbViewModel = hbViewModel,
                navController = navController,
            )
        }
    }
}

sealed class HomeScreen(val route: String) {
    object Home: HomeScreen(route = "home")

}