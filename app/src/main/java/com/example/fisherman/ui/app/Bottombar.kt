package com.example.fisherman.ui.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.AddLocationAlt
import androidx.compose.material.icons.filled.DensityMedium
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomAppBar() {

    val list = listOf(
        BottomAppBarElement("Карта", Icons.Default.Map),
        BottomAppBarElement("Мои карты", Icons.Default.Map),
        BottomAppBarElement("Точки", Icons.Default.AddLocation),
        BottomAppBarElement("Треки", Icons.Default.AddLocationAlt),
        BottomAppBarElement("Ещё", Icons.Default.DensityMedium),
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(66.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                list.forEach { item ->
                    Column(
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(top = 5.dp)
                            .clickable { },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                        )
                        Text(
                            text = item.title,
                            fontSize = 12.sp,
                        )
                    }
                }
            }
        }
    )
}

data class BottomAppBarElement(
    val title: String,
    val icon: ImageVector
)