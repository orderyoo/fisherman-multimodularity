package com.example.fisherman.ui.screens.mymaps

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.Prices
import com.example.domain.model.Rating
import com.example.domain.model.Scheme
import com.example.fisherman.R
import com.example.fisherman.ui.screens.mymaps.components.MyMapsContent
import com.example.fisherman.ui.screens.mymaps.components.MyUnloadMapsContent
import com.example.fisherman.ui.theme.colorStyle


@Composable
fun MyMapScreen(
    viewModel: MyMapViewModel = hiltViewModel(),
    onClickToAllRegion: () -> Unit
) {

    //val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Text(
                text = stringResource(R.string.mymap_title),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }

        item {
            Text(
                text = stringResource(R.string.mymap_installed),
                color = MaterialTheme.colorStyle.secondaryText,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }

        /*
        itemsIndexed() { map ->
            MyMapsContent(map)
        }*/

        item {
            MyMapsContent(
                Scheme(
                    "1", stringResource(R.string.mymap_ex1_1), "pr", Rating(), null, null, null, 1, true,
                    purchased = true,
                    billingPurchased = true,
                    productId = null,
                    fileSize = 1,
                    fileVersion = "",
                    prices = Prices(),
                    waterName = stringResource(R.string.mymap_ex1_2)
                )
            )
        }
        item {
            Text(
                text = stringResource(R.string.mymap_not_installed),
                color = MaterialTheme.colorStyle.secondaryText,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }
        /*
                itemsIndexed(maps) { map ->
                    MyUnloadMapsContent(map)
                }*/

        item {
            MyUnloadMapsContent(
                Scheme(
                    "1", stringResource(R.string.mymap_ex2_1), "pr", Rating(), null, null, null, 1, true,
                    purchased = true,
                    billingPurchased = true,
                    productId = null,
                    fileSize = 1,
                    fileVersion = "",
                    prices = Prices(),
                    waterName = stringResource(R.string.mymap_ex2_2)
                )
            )
        }
        item {
            Button(
                onClick = onClickToAllRegion,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.mymap_button),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}