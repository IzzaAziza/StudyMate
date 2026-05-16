package com.baiqizzaaziza0105.studymate.navigation

const val KEY_ID_TUGAS = "idCatatan"
sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")

    data object Trash : Screen("trash")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_TUGAS}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}