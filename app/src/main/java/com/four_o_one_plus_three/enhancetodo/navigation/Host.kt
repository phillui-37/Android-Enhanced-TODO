package com.four_o_one_plus_three.enhancetodo.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.four_o_one_plus_three.enhancetodo.view.HomeScreen
import com.four_o_one_plus_three.enhancetodo.view.TestScreen


// doc https://developer.android.com/jetpack/compose/navigation
// ref https://proandroiddev.com/jetpack-compose-navigation-architecture-with-viewmodels-1de467f19e1c
@Composable
fun NavigationTree(navController: NavHostController, /*padding: PaddingValues*/) {
    NavHost(navController = navController, startDestination = Pages.Home.path, /*modifier = Modifier.padding(padding)*/) {
        composable(Pages.Home.path) { HomeScreen(navController) }
        composable(Pages.Test.path) { TestScreen(navController) }
    }
}