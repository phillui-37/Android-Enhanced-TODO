package com.four_o_one_plus_three.enhancetodo.view

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.four_o_one_plus_three.enhancetodo.navigation.BottomRoute

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(BottomRoute.Home, BottomRoute.Test)
    NavigationBar(containerColor = Color(70,70,70)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route.path } == true,
                onClick = {
                    navController.navigate(screen.route.path) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = { Icon(ImageBitmap.imageResource(id = R.drawable.ic_menu_mylocation), screen.route.name) },
                label={ Text(screen.route.name, color = Color.White) })
        }
    }
}