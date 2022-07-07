package com.four_o_one_plus_three.enhancetodo.trait

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import arrow.core.Option

interface THomeComposeScreen<in VM: ViewModel> {
    val tag: String
    @Composable fun Screen(vm: Option<VM>)
}