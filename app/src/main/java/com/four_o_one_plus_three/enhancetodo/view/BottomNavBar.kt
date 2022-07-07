package com.four_o_one_plus_three.enhancetodo.view

import android.R
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.four_o_one_plus_three.enhancetodo.navigation.BottomRoute

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(BottomRoute.Home, BottomRoute.Test)
    NavigationBar(containerColor = Color.White, modifier = Modifier.border(1.dp, Color.Black)) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            val isSelected =
                { currentDestination?.hierarchy?.any { it.route == screen.route.path } == true }
            NavigationBarItem(
                selected = isSelected(),
                onClick = {
                    navController.navigate(screen.route.path) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        ImageBitmap.imageResource(id = if (isSelected()) R.drawable.ic_menu_mylocation else R.drawable.ic_dialog_map),
                        screen.route.name
                    )
                },
                label={ Text(screen.route.name) }
            )
        }
    }
}