package com.example.fisherman.ui.screens.mymaps

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.model.Prices
import com.example.domain.model.Rating
import com.example.domain.model.Scheme
import com.example.fisherman.ui.screens.mymaps.components.MyMapsContent
import com.example.fisherman.ui.screens.mymaps.components.MyUnloadMapsContent
import com.example.fisherman.ui.theme.textColors


@Composable
fun MyMapScreen(
    //viewModel: MyMapViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Мои карты",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }

        item {
            Text(
                text = "Установленные",
                color = MaterialTheme.textColors.secondaryText,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }
/*
        itemsIndexed(maps) { map ->
            MyMapsContent(map)
        }
*/

        item {
            MyMapsContent(Scheme(
                "1", "Volga", "pr", Rating(), null, null, null, 1, true, true, true, null, 1, "", Prices(), "rus"
            ))}
        item {
            Text(
                text = "Не установленные",
                color = MaterialTheme.textColors.secondaryText,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }
/*
        itemsIndexed(maps) { map ->
            MyUnloadMapsContent(map)
        }*/

        item {
        MyUnloadMapsContent(Scheme(
            "1", "Volga", "pr", Rating(), null, null, null, 1, true, true, true, null, 1, "", Prices(), "rus"
        ))}
        item {
            Button(
                onClick = { /* TODO: Скачать карты глубин */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Скачать еще карты глубин",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}