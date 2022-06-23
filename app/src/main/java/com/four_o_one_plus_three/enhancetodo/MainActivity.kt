package com.four_o_one_plus_three.enhancetodo

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
import com.four_o_one_plus_three.enhancetodo.navigation.BottomRoute
import com.four_o_one_plus_three.enhancetodo.navigation.NavigationTree
import com.four_o_one_plus_three.enhancetodo.ui.theme.EnhanceTODOTheme
import com.four_o_one_plus_three.enhancetodo.view.BottomNavBar

class MainActivity : ComponentActivity() {
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
                        NavigationTree(navController = navController, padding = it)
                    })
                }
            }
        }
    }
}
