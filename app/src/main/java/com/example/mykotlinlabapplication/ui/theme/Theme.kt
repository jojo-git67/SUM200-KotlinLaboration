package com.example.mykotlinlabapplication.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val WeatherColorScheme = lightColorScheme(
    primary = SkyBlue,
    onPrimary = CloudWhite,

    secondary = DarkBlue,
    onSecondary = CloudWhite,

    tertiary = SunnyYellow,
    onTertiary = DarkBlue,

    background = CloudWhite,
    onBackground = DarkBlue,

    surface = CloudWhite,
    onSurface = DarkBlue
)

@Composable
fun MyKotlinLabApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = WeatherColorScheme,
        typography = Typography,
        content = content
    )
}