package com.example.poke.view

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

private const val MIN_COLOR_VALUE = 30
private const val MAX_COLOR_VALUE = 110

internal fun Brush.Companion.randomGradient(): Brush {
    val r = Random.nextInt(MIN_COLOR_VALUE, MAX_COLOR_VALUE)
    val g = Random.nextInt(MIN_COLOR_VALUE, MAX_COLOR_VALUE)
    val b = Random.nextInt(MIN_COLOR_VALUE, MAX_COLOR_VALUE)
    return radialGradient(
        listOf(
            Color(r, g, b),
            Color(r-30, g-30, b-30)
        )
    )
}