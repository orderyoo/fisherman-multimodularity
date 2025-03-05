package com.example.fisherman.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TestView(
    viewModel: TestVM = hiltViewModel()
){

    val newsList by viewModel.newsState.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            onClick = { viewModel.loadNews1() },
            content = { Text(text = "get news")}
        )
        LazyColumn() {
            items(newsList) { news ->
                Column {
                    Text(text = news.title ?: "Нет названия")
                    Text(text = news.id ?: "Нет ID")
                    Text(text = news.publicationDate ?: "Дата не указана")
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}