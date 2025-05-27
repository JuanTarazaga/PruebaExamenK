package com.example.pruebaexamenk.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pruebaexamenk.ui.screens.pantallaInicial.PantallaInicialScreen
import com.example.pruebaexamenk.ui.screens.pantallaSecundaria.PantallaSecundariaScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.PANTALLA_INICIAL
    ) {
        composable(Destinations.PANTALLA_INICIAL) {
            PantallaInicialScreen(navController = navController)
        }

        composable(
            route = "${Destinations.PANTALLA_SECUNDARIA}/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            PantallaSecundariaScreen(id = id)
        }

    }
}