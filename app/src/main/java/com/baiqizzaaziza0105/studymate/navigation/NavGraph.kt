package com.baiqizzaaziza0105.studymate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.baiqizzaaziza0105.studymate.screen.DetailScreen
import com.baiqizzaaziza0105.studymate.screen.MainScreen
import com.baiqizzaaziza0105.studymate.screen.TrashScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            MainScreen(navController)
        }
        composable(route = Screen.FormBaru.route) {
            DetailScreen(navController)
        }
        composable(Screen.Trash.route) {
            TrashScreen(navController)
        }

        composable(
            route = Screen.FormUbah.route,
            arguments = listOf(
                navArgument(KEY_ID_TUGAS) {type = NavType.LongType}
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong(KEY_ID_TUGAS)
            DetailScreen(navController, id)
        }
    }
}