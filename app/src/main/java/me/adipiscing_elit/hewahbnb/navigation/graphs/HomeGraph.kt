package me.adipiscing_elit.hewahbnb.navigation.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import me.adipiscing_elit.hewahbnb.ui.HomeScreen
import me.adipiscing_elit.hewahbnb.ui.HouseDetailsScreen
import me.adipiscing_elit.hewahbnb.ui.MostPopularListScreen
import me.adipiscing_elit.hewahbnb.ui.RecommendedListScreen
import me.adipiscing_elit.hewahbnb.ui.ReviewsScreen
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@RequiresApi(Build.VERSION_CODES.O)
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
            arguments = listOf(navArgument("houseId") {
                type = NavType.StringType
            })
        ) { navBackStackEntry: NavBackStackEntry ->

            LaunchedEffect(key1 = true) {
                //hbViewModel.fetchSearchedHouses("TODO")
            }

            HomeScreen(
                hbViewModel = hbViewModel,
                navController = navController,
                navigateToMostPopularListScreen = {
                    navController.navigate(HomeScreen.MostPopularHousesList.route)
                },
                navigateToRecommendedListScreen = {
                    navController.navigate(HomeScreen.RecommendedHousesList.route)
                },
                navigateToHouseDetailsScreen = { houseId: String ->
                    navController.navigate("houseDetails/${houseId}") {
                        popUpTo(HomeScreen.Home.route)
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = HomeScreen.RecommendedHousesList.route,
        ) { navBackStackEntry: NavBackStackEntry ->
            
            RecommendedListScreen(
                hbViewModel = hbViewModel,
                navController = navController,
                navigateToHouseDetailsScreen = { houseId: String -> 
                    navController.navigate("houseDetails/${houseId}") {
                        popUpTo(HomeScreen.Home.route)
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = HomeScreen.MostPopularHousesList.route,

        ) { navBackStackEntry: NavBackStackEntry ->

            LaunchedEffect(key1 = true) {
                //hbViewModel.fetchSearchedHouses("TODO")
            }

            MostPopularListScreen(
                hbViewModel = hbViewModel,
                navController = navController,
                navigateToHouseDetailsScreen = { houseId: String ->
                    navController.navigate("houseDetails/${houseId}") {
                        popUpTo(HomeScreen.Home.route)
                        launchSingleTop = true
                    }
                }

            )
        }

        composable(
            route = HomeScreen.HouseDetails.route,
            arguments = listOf(navArgument("houseId") {
                type = NavType.StringType
            })
        ) { navBackStackEntry: NavBackStackEntry ->

            /*TODO("The nav argument and the details of the launch effect are to be put in previous screens ")

             */

            val houseId = navBackStackEntry.arguments?.getString("houseId").toString()


            LaunchedEffect(key1 = true) {
                hbViewModel.fetchSingleHouse(houseId = houseId)
            }
            
            HouseDetailsScreen(
                navController = navController,
                houseId = houseId,
                navigateToReviewsScreen = { houseId: String ->
                    navController.navigate("reviews/${houseId}") {
                        popUpTo(HomeScreen.Home.route)
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(
            route = HomeScreen.Reviews.route,
            arguments = listOf(navArgument("houseId") {
                type = NavType.StringType
            })
        ) { navBackStackEntry: NavBackStackEntry ->

            /*TODO("The nav argument and the details of the launch effect are to be put in previous screens ")

             */

            val houseId = navBackStackEntry.arguments?.getString("houseId").toString()


            LaunchedEffect(key1 = true) {
                hbViewModel.fetchSingleHouse(houseId = houseId)
            }

            ReviewsScreen(
                hbViewModel = hbViewModel,
                navController = navController,
                navigateToPreviousScreen = {
                    navController.navigateUp()
                }
            )
        }
    }
}

sealed class HomeScreen(val route: String) {
    object Home: HomeScreen(route = "home")
    object RecommendedHousesList: HomeScreen(route = "recommendedHousesList")

    object MostPopularHousesList: HomeScreen(route = "mostPopularHousesList")

    object HouseDetails: HomeScreen(route = "houseDetails/{houseId}")

    object Reviews: HomeScreen(route = "reviews/{houseId}")
}