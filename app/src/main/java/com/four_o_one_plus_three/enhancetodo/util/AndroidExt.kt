package com.four_o_one_plus_three.enhancetodo.util

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.colorspace.ColorSpace

fun android.graphics.Color.toComposeColor(): androidx.compose.ui.graphics.Color {
    return androidx.compose.ui.graphics.Color(toArgb())
}

fun Modifier.background(color: android.graphics.Color, shape: Shape = RectangleShape) = apply {
    background(color.toComposeColor(), shape)
}

fun androidx.compose.ui.graphics.Color.getComplementColor() =
    androidx.compose.ui.graphics.Color(1f - red, 1f - green, 1f - blue, alpha)