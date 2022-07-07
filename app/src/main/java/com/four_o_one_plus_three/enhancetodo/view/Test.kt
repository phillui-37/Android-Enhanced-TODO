package com.four_o_one_plus_three.enhancetodo.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import arrow.core.Option
import arrow.core.none
import com.four_o_one_plus_three.enhancetodo.trait.THomeComposeScreen

object Test: THomeComposeScreen<ViewModel> {
    override val tag = "Test"

    @Composable
    override fun Screen(vm: Option<ViewModel>) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Test page!")
        }
    }
}