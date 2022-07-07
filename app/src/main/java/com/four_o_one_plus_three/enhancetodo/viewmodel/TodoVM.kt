package com.four_o_one_plus_three.enhancetodo.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class TodoVM: ViewModel() {
    val state = MutableStateFlow(0)
}