package com.example.fisherman.ui.screens.newsdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.fisherman.R
import com.example.fisherman.ui.common.components.ErrorMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(
    newsId: String,
    viewModel: NewsDetailsScreenViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        when (val currentState = state) {
            is NewsDetailsScreenViewModel.State.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is NewsDetailsScreenViewModel.State.Success -> {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                ) {
                    if(currentState.news.urlImage != null){

                        Spacer(Modifier.padding(8.dp))

                        AsyncImage(
                            model = currentState.news.urlImage,
                            contentDescription = "Описание для доступности",
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(R.drawable.ic_app),
                            error = painterResource(R.drawable.ic_appbar_map)
                        )
                    }

                    Spacer(Modifier.padding(8.dp))

                    Text(
                        text = currentState.news.title ?: "нет названия" ,
                        style = MaterialTheme.typography.headlineLarge,
                    )

                    Spacer(Modifier.padding(8.dp))

                    Text(
                        text = currentState.news.publicationDate ?: "нет даты",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Gray,
                    )

                    Spacer(Modifier.padding(8.dp))

                    Text(
                        text = buildAnnotatedString {
                            append(
                                HtmlCompat.fromHtml(
                                    currentState.news.text,
                                    HtmlCompat.FROM_HTML_MODE_LEGACY
                                ).toString()
                            )
                        },
                        style = MaterialTheme.typography.headlineSmall

                    )
                }
            }
            is NewsDetailsScreenViewModel.State.Error -> {
                ErrorMessage(
                    onRepeat = { viewModel.loadNewDetails(newsId) },
                    message = currentState.message,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}