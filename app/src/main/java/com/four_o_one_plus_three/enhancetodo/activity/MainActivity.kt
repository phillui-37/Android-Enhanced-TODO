package com.four_o_one_plus_three.enhancetodo.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import arrow.core.none
import arrow.core.toOption
import com.four_o_one_plus_three.enhancetodo.navigation.BottomRoute
import com.four_o_one_plus_three.enhancetodo.navigation.Host
import com.four_o_one_plus_three.enhancetodo.navigation.Pages
import com.four_o_one_plus_three.enhancetodo.ui.theme.EnhanceTODOTheme
import com.four_o_one_plus_three.enhancetodo.view.BottomNavBar
import com.four_o_one_plus_three.enhancetodo.view.Test
import com.four_o_one_plus_three.enhancetodo.view.Todo
import com.four_o_one_plus_three.enhancetodo.viewmodel.TodoVM

class MainActivity : ComponentActivity() {
    private val navList by lazy {
        listOf(
            Host.NavContent(Pages.Todo.path, TodoVM().toOption(), Todo),
            Host.NavContent(Pages.Test.path, none(), Test)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            EnhanceTODOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold(bottomBar = { BottomNavBar(navController = navController)}, content = {
                        Host(navList).NavigationTree(navController = navController, padding = it)
                    })
                }
            }
        }
    }
}
