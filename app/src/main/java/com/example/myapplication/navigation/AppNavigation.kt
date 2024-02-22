package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.screens.home.HomeScreen
import com.example.myapplication.screens.details.DetailsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.name
    ) {
        composable(AppScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(
            "${AppScreens.DetailScreen.name}/{movie}",
            arguments = listOf(navArgument("movie") {
                type = NavType.StringType
            })
        ) {
            backStackEntry ->
                DetailsScreen(
                    navController = navController,
                    backStackEntry.arguments?.getString("movie")
                )
        }
    }
}