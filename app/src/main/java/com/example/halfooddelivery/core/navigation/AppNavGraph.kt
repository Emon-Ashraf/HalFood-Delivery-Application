package com.example.halfooddelivery.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.halfooddelivery.presentation.auth.AuthSelectionScreen
import com.example.halfooddelivery.presentation.auth.LoginScreen
import com.example.halfooddelivery.presentation.auth.RegisterScreen
import com.example.halfooddelivery.presentation.onboarding.OnboardingScreen
import com.example.halfooddelivery.presentation.splash.SplashScreen
import com.example.halfooddelivery.presentation.welcome.WelcomeScreen

object Routes {
    const val SPLASH = "splash"
    const val WELCOME = "welcome"
    const val ONBOARDING = "onboarding"
    const val AUTH_SELECTION = "auth_selection"
    const val LOGIN = "login"
    const val REGISTER = "register"
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

        composable(Routes.ONBOARDING) {
            OnboardingScreen(
                onDone = {
                    navController.navigate(Routes.AUTH_SELECTION) {
                        popUpTo(Routes.ONBOARDING) { inclusive = true }
                    }
                }
            )
        }

        composable(Routes.AUTH_SELECTION) {
            AuthSelectionScreen(
                onLoginClick = { navController.navigate(Routes.LOGIN) },
                onRegisterClick = { navController.navigate(Routes.REGISTER) }
            )
        }

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginClick = {
                    // TODO: Navigate to Home or show toast
                },
                onRegisterClick = {
                    navController.navigate(Routes.REGISTER)
                }
            )
        }

        composable(Routes.REGISTER) {
            RegisterScreen(
                onRegisterClick = {
                    // TODO: Navigate to Home or show toast
                },
                onLoginRedirect = {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }
    }
}
