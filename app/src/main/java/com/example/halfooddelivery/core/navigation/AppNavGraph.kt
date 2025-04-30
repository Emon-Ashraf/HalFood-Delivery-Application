package com.example.halfooddelivery.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.halfooddelivery.presentation.splash.SplashScreen
import com.example.halfooddelivery.presentation.welcome.WelcomeScreen


object Routes {
    const val SPLASH = "splash"
    const val WELCOME = "welcome"
    const val ONBOARDING = "onboarding"
}

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH
    ) {
        composable(Routes.SPLASH) {
            SplashScreen {
                navController.navigate(Routes.WELCOME) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }
            }
        }

        composable(Routes.WELCOME) {
            WelcomeScreen {
                navController.navigate(Routes.ONBOARDING)
            }
        }

        /*composable(Routes.ONBOARDING) {
            OnboardingScreen {
                // TODO: Navigate to Login/Home later
            }
        }*/
    }
}