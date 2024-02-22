package com.example.myapplication.navigation

enum class AppScreens {
    HomeScreen,
    DetailScreen;
    companion object {
        @Suppress("UNUSED")
        fun fromRoute(route: String?): AppScreens =
            when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route doesn't exists")
        }
    }
}