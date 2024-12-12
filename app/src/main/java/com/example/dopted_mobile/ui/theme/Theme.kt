package com.example.dopted_mobile.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFFFB6C1), // Light pink
    onPrimary = Color(0xFFFFFFFF), // White

    secondary = Color(0xFF000000), // Black
    onSecondary = Color(0xFFFFFFFF), // White

    tertiary = Color(0xFFFFFFFF), // White
    onTertiary = Color(0xFF000000), // Black

    background = Color(0xFFFFF8F9), // Off-white
    onBackground = Color(0xFF000000), // Black

    surface = Color(0xFFFFFFFF), // White
    onSurface = Color(0xFF000000), // Black

    error = Color(0xFFB00020), // Red
    onError = Color(0xFFFFFFFF) // White
)

@Composable
fun Dopted_mobileTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}
