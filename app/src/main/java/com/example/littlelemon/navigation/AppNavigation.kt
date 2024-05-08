package com.example.littlelemon.navigation

enum class Screen {
    ONBOARDING,
    HOME,
    PROFILE
}

sealed class NavigationItem(val route: String) {
    data object Onboarding: NavigationItem(Screen.ONBOARDING.name)
    data object Home: NavigationItem(Screen.HOME.name)
    data object Profile: NavigationItem(Screen.PROFILE.name)
}