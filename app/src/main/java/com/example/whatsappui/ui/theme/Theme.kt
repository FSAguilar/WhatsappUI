package com.example.whatsappui.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Tema claro fijo: no se reemplaza por los colores del fondo de pantalla.
private val WaLightColorScheme = lightColorScheme(
    primary = WaGreen,
    onPrimary = Color.White,
    primaryContainer = WaBubbleOut,
    onPrimaryContainer = WaTextPrimary,
    secondary = WaGreenLight,
    onSecondary = WaTextPrimary,
    tertiary = WaTickBlue,
    background = Color.White,
    onBackground = WaTextPrimary,
    surface = Color.White,
    onSurface = WaTextPrimary,
    onSurfaceVariant = WaTextSecondary,
    outline = WaTextSecondary,
    error = WaRed,
    onError = Color.White
)

@Composable
fun WhatsappUITheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = WaLightColorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
