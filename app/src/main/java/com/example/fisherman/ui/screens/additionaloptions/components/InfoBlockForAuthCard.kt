package com.example.fisherman.ui.screens.additionaloptions.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fisherman.R

@Preview
@Composable
fun InfoBlockForAuthCard(){
    val advantages = listOf(
        "все приобретённые карты глубины сохраняются в вашем аккаунте навсегда",
        "купленные карты можно скачивать на разных устройствах с одним аккаунтом",
        "мы сообщим когда появится обновление для ваших карт")
    Column{
        advantages.forEachIndexed() {
            index, text ->
            Row {
                Box(
                    modifier = Modifier.size(24.dp),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(R.drawable.ic_check_mark),
                        contentDescription = "")
                }

                Spacer(Modifier.padding(8.dp))

                Text(
                    text = text,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            if(index != 2){
                Spacer(Modifier.padding(8.dp))
            }
        }
    }
}