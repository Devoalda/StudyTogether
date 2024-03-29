package com.practice.studytogether.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


// Define your custom color scheme for light theme
val NeoBruntalismColorScheme = lightColorScheme(
    primary = Color.Black,
    secondary = Color.White,
    tertiary = Color(0xFF1E1E1E),
    background = Color.White,
    surface = Color.White,
    error = Color.Red,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
)

// Define your custom color scheme for dark theme
val NeoBruntalismDarkColorScheme = darkColorScheme(
    primary = Color.White,
    secondary = Color.Black,
    tertiary = Color(0xFF1E1E1E),
    background = Color.Black,
    surface = Color.Black,
    error = Color.Red,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White
)

