package com.example.fisherman.ui.common.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PrimaryButton(
    text: String = "Base Button",
    textStyle: TextStyle = MaterialTheme.typography.titleLarge,
    buttonType: ButtonType = ButtonType.Error,
    buttonModifier: Modifier = Modifier,
    icon: Painter? = null,
    onClick: () -> Unit = {},
) {
    val buttonColor = when (buttonType) {
        ButtonType.Primary -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
        ButtonType.PrimaryContainer -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
        ButtonType.Secondary -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
        ButtonType.Surface -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
        ButtonType.Error -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        )
    }

    val textColor = when (buttonType) {
        ButtonType.Primary -> MaterialTheme.colorScheme.onPrimary
        ButtonType.PrimaryContainer -> MaterialTheme.colorScheme.onPrimaryContainer
        ButtonType.Secondary -> MaterialTheme.colorScheme.onSecondary
        ButtonType.Surface -> MaterialTheme.colorScheme.onSurface
        ButtonType.Error -> MaterialTheme.colorScheme.onError
    }

    val buttonContent: @Composable RowScope.() -> Unit = {
        if (icon != null)
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
            )
        Text(
            text = text,
            color = textColor,
            style = textStyle
        )
    }

    Button(
        modifier = buttonModifier
            .height(48.dp),
        shape = RoundedCornerShape(10.dp),
        colors = buttonColor,
        onClick = onClick,
        content = buttonContent
    )
}

enum class ButtonType {
    Primary,
    PrimaryContainer,
    Secondary,
    Surface,
    Error
}