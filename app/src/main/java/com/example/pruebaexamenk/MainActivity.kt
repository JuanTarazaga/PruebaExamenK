package com.example.pruebaexamenk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pruebaexamenk.ui.components.navigation.Destinations
import com.example.pruebaexamenk.ui.components.navigation.NavGraph
import com.example.pruebaexamenk.ui.components.navigation.getBottomBarForRoute
import com.example.pruebaexamenk.ui.components.navigation.getTopBarForRoute
import com.example.pruebaexamenk.ui.theme.PruebaExamenKTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaExamenKTheme {
                Surface {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val showFAB = remember { mutableStateOf(true) }

    // Lista de destinos donde el FAB debe desaparecer
    val hideFABDestinations = listOf(
        Destinations.PANTALLA_INICIAL,
        Destinations.PANTALLA_SECUNDARIA
    )

    LaunchedEffect(currentRoute) {
        showFAB.value = currentRoute !in hideFABDestinations
    }

    Scaffold (modifier = Modifier.fillMaxSize(),
        topBar = {
            val bottomBarContent = getTopBarForRoute(currentRoute, navController)
            bottomBarContent?.invoke()
        },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                NavGraph(navController)
            }
        },
        bottomBar = {
            val bottomBarContent = getBottomBarForRoute(currentRoute, navController)
            bottomBarContent?.invoke()
        }
    )
}
