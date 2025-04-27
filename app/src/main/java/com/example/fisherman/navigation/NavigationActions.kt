package com.example.fisherman.navigation

import androidx.navigation.NavHostController

class NavigationActions(private val navController: NavHostController) {

    fun navigateToNewsDetails(newsId: String) {
        navController.navigate("${Routes.NewsDetails.route}/$newsId")
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    fun navigateToRegionsMaps(water_id : String) {
        navController.navigate("${Routes.RegionMaps.route}/$water_id")
    }
}