package com.example.littlelemon.navigation

enum class Screen {
    ONBOARDING,
    HOME,
    PROFILE
}

sealed class NavigationItem(val route: String) {
    object Onboarding: NavigationItem(Screen.ONBOARDING.name)
    object Home: NavigationItem(Screen.HOME.name)
    object Profile: NavigationItem(Screen.PROFILE.name)
}