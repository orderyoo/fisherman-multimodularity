package com.example.fisherman.ui.screens.allnews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fisherman.ui.common.components.ErrorMessage
import com.example.fisherman.ui.screens.allnews.components.NewsElement
import com.example.fisherman.ui.screens.allnews.components.NewsTopBar

@Composable
fun AllNewsScreen(
    viewModel: AllNewsScreenViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onClickNews: (String) -> Unit
){
    val state by viewModel.state.collectAsState()
    Scaffold(
        topBar = { NewsTopBar(onClickBack = {onBackClick() }) }
    ) { innerPadding ->
        when (val currentState = state) {
            is AllNewsScreenViewModel.State.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is AllNewsScreenViewModel.State.Success -> {
                LazyColumn(
                    modifier = Modifier.padding(innerPadding),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    itemsIndexed(currentState.news){ index, item ->
                        NewsElement(
                            onClickNews = { onClickNews(it) },
                            item
                        )
                        if (index < currentState.news.size - 1) {
                            HorizontalDivider(thickness = 2.dp)
                        }
                    }
                }
            }
            is AllNewsScreenViewModel.State.Error -> {
                ErrorMessage(
                    onRepit = { },
                    message = currentState.message,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}