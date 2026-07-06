package com.serenemind.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.serenemind.ui.home.HomeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    onLogout: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            // Dashboard UI (ပုံထဲကမျက်နှာပြင်)
            HomeScreen(onLogout = onLogout)
        }

        composable(Screen.Journal.route) {
            SampleScreen(title = "Journal Screen")
        }

        composable(Screen.Mood.route) {
            SampleScreen(title = "Mood Screen")
        }

        composable(Screen.Community.route) {
            SampleScreen(title = "Community Screen")
        }

        composable(Screen.Profile.route) {
            SampleScreen(title = "Profile Screen")
        }
    }
}

@Composable
fun SampleScreen(title: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = title)
    }
}