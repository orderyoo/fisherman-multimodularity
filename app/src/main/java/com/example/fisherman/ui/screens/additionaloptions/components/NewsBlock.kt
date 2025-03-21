package com.example.fisherman.ui.screens.additionaloptions.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.domain.model.News
import com.example.fisherman.ui.screens.allnews.components.NewsElement

@Composable
fun NewsBlock(
    news: News,
    onClickNews: (String) -> Unit,
    onClickAllNews: () -> Unit
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Новости",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.weight(1f)
            )
            TextButton(
                onClick = { onClickAllNews() }
            ) {
                Text(
                    text = "Все новости",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Blue
                )
            }
        }
        NewsElement(
            onClickNews = { onClickNews(it) },
            news)
    }
}