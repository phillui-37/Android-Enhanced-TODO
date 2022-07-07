package com.four_o_one_plus_three.enhancetodo.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import arrow.core.Option
import arrow.core.Tuple4
import arrow.core.none
import arrow.core.toOption
import com.four_o_one_plus_three.enhancetodo.trait.THomeComposeScreen
import com.four_o_one_plus_three.enhancetodo.view.Test
import com.four_o_one_plus_three.enhancetodo.view.Todo
import com.four_o_one_plus_three.enhancetodo.viewmodel.TodoVM


// doc https://developer.android.com/jetpack/compose/navigation
// ref https://proandroiddev.com/jetpack-compose-navigation-architecture-with-viewmodels-1de467f19e1c
class Host(private val navList: List<NavContent<out ViewModel>>) {
    data class NavContent<VM : ViewModel>(
        val path: String,
        val vm: Option<VM>,
        val screen: THomeComposeScreen<VM>
    ) {
        @Composable
        operator fun invoke() {
            screen.Screen(vm = vm)
        }
    }

    @Composable
    fun NavigationTree(navController: NavHostController, padding: PaddingValues) {
        NavHost(
            navController = navController,
            startDestination = Pages.Todo.path,
            modifier = Modifier.padding(padding)
        ) {
            navList.forEach { nav ->
                composable(nav.path) { nav() }
            }
        }
    }
}