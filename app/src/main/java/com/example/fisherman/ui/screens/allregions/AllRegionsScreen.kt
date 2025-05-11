package com.example.fisherman.ui.screens.allregions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fisherman.ui.common.ErrorMessage
import com.example.fisherman.ui.theme.colorStyle
import com.example.fisherman.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllRegionsScreen(
    viewModel: AllRegionsScreenViewModel = hiltViewModel(),
    onClickBack: () -> Unit,
    onClickRegion: (String) -> Unit
) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                title = {
                    Text(
                        text = stringResource(R.string.region_choose),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorStyle.primaryText
                    )
                }
            )
        }
    ) { innerPadding ->
        when (val currentState = state) {
            is AllRegionsScreenViewModel.State.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is AllRegionsScreenViewModel.State.Success -> {
                LazyColumn (
                    modifier = Modifier.padding(innerPadding)
                ){
                    itemsIndexed(currentState.regions){ _, region ->
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onClickRegion(region.id) }
                            .padding(10.dp)
                        ) {
                            Text(
                                text = region.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = stringResource(R.string.region_schemes, region.schemes),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
            }

            is AllRegionsScreenViewModel.State.Error -> {
                ErrorMessage(
                    onRepeat = { },
                    message = currentState.message,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}