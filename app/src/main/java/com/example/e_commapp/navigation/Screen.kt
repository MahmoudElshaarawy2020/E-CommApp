package com.example.e_commapp.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")
    object Home : Screen("home_screen")
    object Offer : Screen("offer_screen")
    object Account : Screen("account_screen")
    object Explore : Screen("explore_screen")
    object Cart : Screen("cart_screen")
}