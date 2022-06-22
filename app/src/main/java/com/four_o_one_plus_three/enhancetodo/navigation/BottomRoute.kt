package com.four_o_one_plus_three.enhancetodo.navigation

sealed class BottomRoute(val route: Pages){
    object Home : BottomRoute(Pages.Home)
    object Test : BottomRoute(Pages.Test)
}