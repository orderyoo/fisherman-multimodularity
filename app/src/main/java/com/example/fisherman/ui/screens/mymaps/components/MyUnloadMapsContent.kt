package com.example.fisherman.ui.screens.mymaps.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Scheme
import com.example.fisherman.R
import com.example.fisherman.ui.theme.textColors

@Composable
fun MyUnloadMapsContent(
    map: Scheme,
    modifier: Modifier = Modifier
) {
    var showTwoButtons by remember { mutableStateOf(false) }
    var isExpanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Transparent)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_app_logo),
                contentDescription = "Карта",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = map.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(0.dp, 5.dp)
                )
                Text(
                    text = map.waterName,
                    color = MaterialTheme.textColors.secondaryText,
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = {
                isExpanded = !isExpanded
            }) {
                Icon(
                    imageVector =
                        if (!isExpanded) {
                            Icons.Default.KeyboardArrowDown
                        } else {
                            Icons.Default.KeyboardArrowUp
                        },
                    contentDescription = "Раскрыть",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        AnimatedVisibility(visible = isExpanded) {
            Column {
                if (showTwoButtons) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            modifier = Modifier.fillMaxWidth(0.8f),
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                            ),
                            elevation = ButtonDefaults.buttonElevation(

                            ),
                            onClick = {/*todo*/ }
                        ) {
                            Text("Загрузить", style = MaterialTheme.typography.titleLarge)
                        }
                        IconButton(
                            colors = IconButtonColors(
                                containerColor = MaterialTheme.colorScheme.error,
                                contentColor = MaterialTheme.textColors.secondaryText,
                                disabledContainerColor = MaterialTheme.colorScheme.error,
                                disabledContentColor = MaterialTheme.textColors.secondaryText
                            ),
                            onClick = { showTwoButtons = false }) {
                                Icon(Icons.Default.Close, tint = MaterialTheme.colorScheme.onError, contentDescription = "", modifier = Modifier)
                        }
                    }
                } else {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        ),
                        onClick = { showTwoButtons = true }
                    ) {
                        Text("Загрузить", style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}