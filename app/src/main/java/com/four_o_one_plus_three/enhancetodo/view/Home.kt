package com.four_o_one_plus_three.enhancetodo.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.four_o_one_plus_three.enhancetodo.navigation.Pages

@Composable
fun HomeScreen(navController: NavController) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = "Hello World")
        Button(onClick = { navController.navigate(Pages.Test.path) }) {
            Text(text = "To Test Page")
        }
    }
}