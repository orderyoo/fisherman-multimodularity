package com.example.fisherman.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

data class AppTextColors(
    val primaryText: Color,
    val secondaryText: Color
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1B7EB7),
    onPrimary = Color(0xFFEFEFEF),
    primaryContainer = Color(0xFF153344),
    onPrimaryContainer = Color(0xFF19A5F5),
    secondary = Color(0xFF41BB75),
    onSecondary = Color(0xFF092816),
    secondaryContainer = Color(0xFF318856),
    onSecondaryContainer = Color(0xFF41BB75),
    tertiary = Color(0xFFEB8A09),
    onTertiary = Color(0xFFEFEFEF),
    error = Color(0xFFDB6658),
    onError = Color(0xFF121212),
    errorContainer = Color(0xFFA8574E),
    onErrorContainer = Color(0xFF121212),
    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFF929292),
    surfaceVariant = Color(0xFF4B4B4B),
    outline = Color(0xFF2A2A2A),
)

private val DarkTextColors = AppTextColors(
    primaryText = Color(0xFFE0E0E0),
    secondaryText = Color(0xFF929292)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0A9AEB),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFCEE4F0),
    onPrimaryContainer = Color(0xFF0A9AEB),
    secondary = Color(0xFFBAEBCF),
    onSecondary = Color(0xFF27AE60),
    secondaryContainer = Color(0xFF93E9B7),
    onSecondaryContainer = Color(0xFF27AE60),
    tertiary = Color(0xFFEB8A09),
    onTertiary = Color(0xFFFFFFFF),
    error = Color(0xFFF7DCD8),
    onError = Color(0xFFF63821),
    errorContainer = Color(0xFFEDB1A8),
    onErrorContainer = Color(0xFFF63821),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF212529),
    surface = Color(0xFFF3F3F3),
    onSurface = Color(0xFF767676),
    surfaceVariant = Color(0xFFD9D9D9),
    outline = Color(0xFF5C5C5C),
)

private val LightTextColors = AppTextColors(
    primaryText = Color(0xFF212529),
    secondaryText = Color(0xFF767676)
)

val LocalAppTextColors = staticCompositionLocalOf { LightTextColors }

@Composable
fun DapDriftTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val textColors = if (darkTheme) DarkTextColors else LightTextColors

    CompositionLocalProvider(
        LocalAppTextColors provides textColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            shapes = DapDriftShapes,
            typography = Typography,
            content = content
        )
    }
}

val MaterialTheme.textColors: AppTextColors
    @Composable
    get() = LocalAppTextColors.current