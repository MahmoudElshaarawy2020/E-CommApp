package com.example.e_commapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.e_commapp.R
import com.example.e_commapp.navigation.navigation_bar.BottomNavItem
import com.example.e_commapp.navigation.navigation_bar.BottomNavigationBar
import com.example.e_commapp.presentation.account.AccountScreen
import com.example.e_commapp.presentation.cart.CartScreen
import com.example.e_commapp.presentation.explore.ExploreScreen
import com.example.e_commapp.presentation.home.HomeScreen
import com.example.e_commapp.presentation.login.LoginScreen
import com.example.e_commapp.presentation.offer.OfferScreen
import com.example.e_commapp.presentation.register.RegisterScreen

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    val bottomNavItems = listOf(
        BottomNavItem("Home", R.drawable.home_nav_ic),
        BottomNavItem("Explore", R.drawable.search_nav_ic),
        BottomNavItem("Offer", R.drawable.offer_nav_ic),
        BottomNavItem("Cart", R.drawable.cart_nav_ic),
        BottomNavItem("Account", R.drawable.profile_nav_ic)
    )

    val selectedItemIndex = bottomNavItems.indexOfFirst { it.label.lowercase() in (currentRoute ?: "") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (currentRoute != Screen.Login.route && currentRoute != Screen.Register.route) {
                BottomNavigationBar(
                    items = bottomNavItems,
                    selectedItem = if (selectedItemIndex != -1) selectedItemIndex else 0,
                    onItemSelected = { index ->
                        val route = when (index) {
                            0 -> Screen.Home.route
                            1 -> Screen.Explore.route
                            2 -> Screen.Offer.route
                            3 -> Screen.Cart.route
                            4 -> Screen.Account.route
                            else -> Screen.Home.route
                        }
                        navController.navigate(route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Login.route) {
                LoginScreen(
                    navController,
                    onRegisterClick = { navController.navigate(Screen.Register.route) }
                )
            }
            composable(Screen.Register.route) {
                RegisterScreen(
                    navController,
                    onLoginClick = { navController.popBackStack() }
                )
            }
            composable(Screen.Home.route) { HomeScreen(navController = navController) }
            composable(Screen.Explore.route) { ExploreScreen(navController = navController) }
            composable(Screen.Offer.route) { OfferScreen(navController = navController) }
            composable(Screen.Cart.route) { CartScreen(navController = navController) }
            composable(Screen.Account.route) { AccountScreen(navController = navController) }
        }
    }
}
