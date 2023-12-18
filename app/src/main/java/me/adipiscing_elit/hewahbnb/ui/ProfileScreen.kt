package me.adipiscing_elit.hewahbnb.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import me.adipiscing_elit.hewahbnb.ui.components.BottomNavBar
import me.adipiscing_elit.hewahbnb.viewmodel.HBViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    hbViewModel: HBViewModel,
    navController: NavHostController,
) {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "HewaBnB")
            })
        },
        content = { innerPadding: PaddingValues ->
            LazyColumn(
                contentPadding = innerPadding,
            ) {
                item {
                    Text(text = "PROFILE SCREEN COMING SOON")
                }
            }

        },
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    )
}