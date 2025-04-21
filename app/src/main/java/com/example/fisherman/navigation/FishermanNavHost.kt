package com.example.fisherman.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fisherman.ui.screens.about.AboutScreen
import com.example.fisherman.ui.screens.additionaloptions.AdditionalOptionsScreen
import com.example.fisherman.ui.screens.allnews.AllNewsScreen
import com.example.fisherman.ui.screens.allregions.AllRegionsScreen
import com.example.fisherman.ui.screens.mymaps.MyMapScreen
import com.example.fisherman.ui.screens.newsdetails.NewsDetailScreen

@Composable
fun FishermanNavHost(
    innerPadding: PaddingValues,
    navController: NavHostController,
    startDestination: String
){
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.MapScreen.route) { }
        composable(Routes.MyMapScreen.route) { MyMapScreen(onClickToAllRegion = { navController.navigate(Routes.AllRegions.route) }) }
        composable(Routes.PointScreen.route) { }
        composable(Routes.TrackScreen.route) { }
        composable(Routes.AdditionalOptionsScreen.route) { AdditionalOptionsScreen(navController) }

        composable(Routes.AllNews.route) {
            val navigationActions = remember { NavigationActions(navController) }
            AllNewsScreen(
                onBackClick = navigationActions::navigateBack,
                onClickNews = navigationActions::navigateToNewsDetails
            )
        }

        composable(
            route = Routes.NewsDetails.route + "/{newsId}",
            arguments = listOf(navArgument("newsId") { type = NavType.StringType })
        ) { backStackEntry ->
            NewsDetailScreen(
                newsId = backStackEntry.arguments?.getString("newsId")!!,
                onBackClick = { navController.popBackStack() },
            )
        }

        composable(Routes.About.route) {
            val navigationActions = remember { NavigationActions(navController) }
            AboutScreen(
                onBackClick = navigationActions::navigateBack
            )
        }

        composable(
            route = Routes.AllRegions.route
        ) {
            val navigationActions = remember { NavigationActions(navController) }
            AllRegionsScreen(
                onClickBack = navigationActions::navigateBack
            )
        }
    }
}