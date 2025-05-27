package com.example.pruebaexamenk.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

object Destinations {
    const val PANTALLA_INICIAL = "pantalla-inicial"
    const val PANTALLA_SECUNDARIA = "pantalla-secundaria"
}

fun getBottomBarForRoute(route: String?,navController: NavController): @Composable (() -> Unit)? {
    return when (route) {

        else -> null
    }
}

fun getTopBarForRoute(route: String?, navController: NavController): @Composable (() -> Unit)? {
    return when (route) {

        else -> null
    }
}