package com.example.fisherman.ui.screens.additionaloptions.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.domain.model.News
import com.example.fisherman.R
import com.example.fisherman.ui.screens.allnews.components.NewsElement
import com.example.fisherman.ui.theme.colorStyle

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
                text = stringResource(R.string.news_block_title),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.weight(1f)
            )
            TextButton(
                onClick = { onClickAllNews() }
            ) {
                Text(
                    text = stringResource(R.string.news_block_button_all_news),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorStyle.primary
                )
            }
        }
        NewsElement(
            onClickNews = { onClickNews(it) },
            news)
    }
}