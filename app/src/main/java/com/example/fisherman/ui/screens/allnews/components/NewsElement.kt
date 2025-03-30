package com.example.fisherman.ui.screens.allnews.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.model.News
import com.example.fisherman.R

@Composable
fun NewsElement(
    onClickNews: (String) -> Unit,
    item: News
){
    Row(
        modifier = Modifier.clickable { onClickNews(item.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 0.dp)
                .weight(1f),
        ){
            Text(
                text = item.title,
                style = MaterialTheme.typography.headlineSmall,

            )
            Text(
                text = item.publicationDate,
                style = MaterialTheme.typography.titleSmall,
                color = Color.Gray
            )
        }
        if(item.urlImage != null){
            Box(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 0.dp),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    model = item.urlImage,
                    contentDescription = "Описание для доступности",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.ic_app_logo),
                    error = painterResource(R.drawable.ic_appbar_map)
                )
            }
        }
    }
}