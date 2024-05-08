package com.example.littlelemon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.ui.screens.Home
import com.example.littlelemon.ui.screens.Onboarding
import com.example.littlelemon.ui.screens.Profile

@Composable
fun LittleLemonNavHost(modifier: Modifier, navHostController: NavHostController, startDestination: String) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Onboarding.route) {
            Onboarding(navHostController)
        }
        composable(NavigationItem.Home.route) {
            Home(navHostController)
        }
        composable(NavigationItem.Profile.route) {
            Profile(navHostController)
        }
    }
}