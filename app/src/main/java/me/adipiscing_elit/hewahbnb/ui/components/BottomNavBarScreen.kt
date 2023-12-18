package me.adipiscing_elit.hewahbnb.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavBarScreen(
        route = "home",
        title = "HOME",
        icon = Icons.Default.Home
    )
    object Profile :  BottomNavBarScreen(
        route = "PROFILE",
        title = "PROFILE",
        icon = Icons.Default.Person
    )

}