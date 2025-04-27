package com.example.fisherman.ui.screens.allmaps

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.Scheme
import com.example.fisherman.R
import com.example.fisherman.ui.common.ErrorMessage
import com.example.fisherman.ui.common.components.ButtonType
import com.example.fisherman.ui.common.components.PrimaryButton

@Composable
fun AllMapsScreen(
    water_id: String,
    viewModel: AllMapsScreenViewModel = hiltViewModel(),
    onBackClick: () -> Unit
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


@Composable
fun MapList(scheme: Scheme) {
    var purchased by remember { mutableStateOf(scheme.free) }
    //var showTwoButtons by remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    "Версия ${scheme.fileVersion} - Размер ${scheme.fileSize}",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(scheme.name, style = MaterialTheme.typography.headlineSmall)
            }

            Image(
                painter = painterResource(id = R.drawable.ic_app_logo),
                contentDescription = "Карта",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
        PrimaryButton(
            text =
                if (!purchased) {
                    "Купить за ${scheme.prices.google}"
                } else {
                    "Загрузить"
                },
            buttonType = if (!purchased) {
                ButtonType.Primary
            } else {
                ButtonType.Secondary
            },
            onClick = {
                if (!purchased) {
                    purchased = true
                }
            }
        )
    }
}