package com.example.fisherman.ui.app

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.fisherman.navigation.FishermanNavHost
import com.example.fisherman.navigation.Routes
import com.example.fisherman.ui.app.components.AppNavigationBar

@Composable
fun FishermanApp() {

    val navController = rememberNavController()
    val startDestination = Routes.AdditionalOptionsScreen.route
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: Routes.AdditionalOptionsScreen.route

    Scaffold(
        bottomBar = {
            AppNavigationBar(
                currentRoute = currentRoute,
                onTabSelected = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        FishermanNavHost(innerPadding, navController, startDestination)
    }
}