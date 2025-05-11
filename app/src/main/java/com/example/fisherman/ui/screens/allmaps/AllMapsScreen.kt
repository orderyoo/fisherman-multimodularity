package com.example.fisherman.ui.screens.allmaps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fisherman.ui.common.ErrorMessage
import com.example.fisherman.ui.screens.allmaps.components.MapList

@Composable
fun AllMapsScreen(
    water_id: String,
    viewModel: AllMapsScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    when (val currentState = state) {
        is AllMapsScreenViewModel.State.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is AllMapsScreenViewModel.State.Success -> {
            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {
                itemsIndexed(currentState.maps) { _, item ->
                    MapList(item)
                }
            }
        }

        is AllMapsScreenViewModel.State.Error -> {
            ErrorMessage(
                onRepeat = { viewModel.loadAllMaps(water_id) },
                message = currentState.message
            )
        }
    }

}