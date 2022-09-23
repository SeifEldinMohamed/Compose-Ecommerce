package com.seif.composeeccomerce.presentation.navigation

sealed class Screen(
    val route: String
) {
    object Login : Screen("login")
    object ProductList : Screen("product_list")
}
