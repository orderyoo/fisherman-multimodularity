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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

data class DapDriftColorScheme(
    val primaryText: Color,
    val secondaryText: Color,
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val primaryContainerGradient: Brush,
    val primaryPressed: Color,
    val primaryContainerPressed: Color,
    val primaryGradient: Brush,
    val primaryGradient2: Brush,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryVariant: Color,
    val onSecondaryVariant: Color,
    val secondaryPressed: Color,
    val background: Color,
    val background90: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val surfacePressed: Color,
    val tertiary : Color,
    val error: Color,
    val onError: Color,
    val errorPressed: Color,
    val light: Brush,
    val skeleton: Brush
)

val lightColorScheme = DapDriftColorScheme(
    primaryText = Color(0xFF212529),
    secondaryText = Color(0xFF5C5C5C),
    primary = Color(0xFF0A9AEB),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFCEE4F0),
    onPrimaryContainer = Color(0xFF0A9AEB),
    primaryContainerGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFFCEE4F0).copy(alpha = 0.8f), Color.Transparent),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    ),
    primaryPressed = Color(0xFF097EC0),
    primaryContainerPressed = Color(0xFF097EC0),
    primaryGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF0A9AEB), Color.Transparent),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    ),
    primaryGradient2 = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF0A9AEB).copy(alpha = 0.2f),
            Color.Transparent
        ),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    ),
    secondary = Color(0xFFBAEBCF),
    onSecondary = Color(0xFF27AE60),
    secondaryVariant = Color(0xFFFFFFFF),
    onSecondaryVariant = Color(0xFFFFFFFF),
    secondaryPressed = Color(0xFF93E9B7),
    background = Color(0xFFFFFFFF),
    background90 = Color(0xCCFFFFFF),
    surface = Color(0xFFF3F3F3),
    onSurface = Color(0xFF767676),
    surfaceVariant = Color(0xFFD9D9D9),
    surfacePressed = Color(0xFFD9D9D9),
    tertiary = Color(0xFFEB8A09),
    error = Color(0xFFF7DCD8),
    onError = Color(0xFFF63821),
    errorPressed = Color(0xFFEDB1A8),
    light = Brush.verticalGradient(
        colors = listOf(Color.White, Color.Transparent),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    ),
    skeleton = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFE9E9E9),
            Color(0xFF99A2AD),
            Color(0xFFE9E9E9)
        ),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    )
)

val darkColorScheme = DapDriftColorScheme(
    primaryText = Color(0xFFE0E0E0),
    secondaryText = Color(0xFFA5A5A5),
    primary = Color(0xFF1B7EB7),
    onPrimary = Color(0xFFEFEFEF),
    primaryContainer = Color(0xFF153344),
    onPrimaryContainer = Color(0xFF19A5F5),
    primaryContainerGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF153344).copy(alpha = 0.8f), Color.Transparent),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    ),
    primaryPressed = Color(0xFF104B6D),
    primaryContainerPressed = Color(0xFF0B1C25),
    primaryGradient = Brush.horizontalGradient(
        colors = listOf(Color(0xFF1B7EB7), Color.Transparent),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    ),
    primaryGradient2 = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1B7EB7).copy(alpha = 0.2f),
            Color.Transparent
        ),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    ),
    secondary = Color(0xFF41BB75),
    onSecondary = Color(0xFF092816),
    secondaryVariant = Color(0xFF41BB75),
    onSecondaryVariant = Color(0xFF121212),
    secondaryPressed = Color(0xFF318856),
    background = Color(0xFF121212),
    background90 = Color(0xCC121212),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFF929292),
    surfaceVariant = Color(0xFF4B4B4B),
    surfacePressed = Color(0xFF282828),
    tertiary = Color(0xFFEB8A09),
    error = Color(0xFFDB6658),
    onError = Color(0xFF121212),
    errorPressed = Color(0xFFA8574E),
    light = Brush.verticalGradient(
        colors = listOf(Color(0xFF121212), Color.Transparent),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    ),
    skeleton = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFF4B4B4B),
            Color(0xFF2E3339),
            Color(0xFF4B4B4B)
        ),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    )
)

val LocalDapDriftColorScheme = staticCompositionLocalOf { lightColorScheme }
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
        darkTheme -> darkColorScheme()
        else -> lightColorScheme()
    }

    val dapDriftColorScheme = if(darkTheme) darkColorScheme else lightColorScheme

    CompositionLocalProvider(
        LocalDapDriftColorScheme provides dapDriftColorScheme
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            shapes = DapDriftShapes,
            typography = Typography,
            content = content
        )
    }
}

val MaterialTheme.colorStyle: DapDriftColorScheme
    @Composable
    get() = LocalDapDriftColorScheme.current