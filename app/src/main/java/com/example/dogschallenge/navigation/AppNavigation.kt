package com.example.dogschallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dogschallenge.ui.detail.Detail
import com.example.dogschallenge.ui.home.Home

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainDestinations.HOME_ROUTE) {
        composable(MainDestinations.HOME_ROUTE ) {
            Home(navController = navController)
        }
        composable(MainDestinations.DETAIL_ROUTE + "/{id}",
            arguments = listOf(
                navArgument("id"){ type = NavType.IntType }
            )) { entry ->
            Detail(
                navController = navController,
                id = entry.arguments?.getInt("id") as Int)
        }
    }
}
