package com.example.fisherman.ui.app


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fisherman.navigation.FishermanNavHost
import com.example.fisherman.navigation.Routes

@Composable
fun FishermanApp(

) {

    val navController = rememberNavController()
    val startDestination = Routes.AdditionalOptionsScreen.route

    Scaffold(
        bottomBar = { BottomAppBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            FishermanNavHost(navController, startDestination)
        }
    }
}