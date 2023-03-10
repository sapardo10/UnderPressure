package com.anarkio.hema.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Folly,
    primaryVariant = Folly,
    secondary = OxfordBlue,
    background = Color.Black,
    onBackground = Color.White,
    surface = TaupeGray
)

private val LightColorPalette = lightColors(
    primary = Folly,
    primaryVariant = Folly,
    secondary = OxfordBlue,
    background = Color.White,
    onBackground = Color.Black,
    surface = TaupeGray

    /* Other default colors to override
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun HemaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}