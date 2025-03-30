package com.example.fisherman.ui.screens.allnews.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.fisherman.ui.theme.textColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsTopBar(
    onClickBack: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onClickBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
            }
        },
        title = {
            Text(
                text = "Новости",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.textColors.primaryText
            )
        }
    )
}