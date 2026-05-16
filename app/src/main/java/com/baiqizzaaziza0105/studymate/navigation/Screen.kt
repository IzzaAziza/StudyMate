package com.baiqizzaaziza0105.studymate.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
}