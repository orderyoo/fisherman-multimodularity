package com.example.fisherman.ui.screens.allmaps.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.model.Scheme
import com.example.fisherman.R
import com.example.fisherman.ui.common.components.ButtonType
import com.example.fisherman.ui.common.components.PrimaryButton


@Composable
fun MapList(scheme: Scheme) {
    var purchased by remember { mutableStateOf(scheme.free) }
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    stringResource(R.string.map_version_and_size, scheme.fileVersion, scheme.fileSize),
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
                    stringResource(R.string.map_buy, scheme.prices.google)
                } else {
                    stringResource(R.string.map_download)
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