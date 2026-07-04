package com.slideindex.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun SlideIndexTheme(
    seedColor: Color = Purple40,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) {
        expressiveDarkColorScheme(seedColor)
    } else {
        expressiveLightColorScheme(seedColor)
    }

    MaterialExpressiveTheme(
        colorScheme = colorScheme,
        shapes = ExpressiveShapes,
        typography = SlideIndexTypography,
        motionScheme = MotionScheme.expressive(),
        content = content,
    )
}
