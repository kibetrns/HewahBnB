package me.adipiscing_elit.hewahbnb.navigation.destinations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.adipiscing_elit.hewahbnb.util.HOME_SCREEN
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeScreen(
    hbViewModel: HBViewModel,
) {
    composable(
        route = HOME_SCREEN,
    ) {

        //TODO("Home Screen Design")

        Text(text = "Home Screen Coming Soon :)", style = MaterialTheme.typography.titleLarge)
    }
}