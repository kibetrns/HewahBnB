package me.adipiscing_elit.hewahbnb.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@Composable
fun RootNavigationGraph(
    navController: NavHostController,
    hbViewModel: HBViewModel
) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = navController, hbViewModel = hbViewModel)

        homeNavGraph(navController = navController, hbViewModel = hbViewModel)

        profileNavGraph(navController = navController, hbViewModel = hbViewModel)

    }
}
object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val PROFILE = "profile_graph"
}