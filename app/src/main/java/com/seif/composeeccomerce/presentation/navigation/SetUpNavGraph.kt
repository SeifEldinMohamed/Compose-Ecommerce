package com.seif.composeeccomerce.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Login.route){
        composable(route = Screen.Login.route){
            Text(text = "login", fontSize = 40.sp, modifier = Modifier.clickable {
                navHostController.navigate(Screen.ProductList.route)
            })
        }
        composable(route = Screen.ProductList.route){
            Text(text = "Product List", fontSize = 40.sp, modifier = Modifier.clickable {
                navHostController.navigate(Screen.Login.route)
            })
        }
    }
}
