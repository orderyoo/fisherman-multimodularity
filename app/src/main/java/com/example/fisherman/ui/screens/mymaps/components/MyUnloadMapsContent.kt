package com.example.fisherman.ui.screens.mymaps.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.domain.model.Scheme
import com.example.fisherman.R
import com.example.fisherman.ui.theme.colorStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MyUnloadMapsContent(
    map: Scheme,
    modifier: Modifier = Modifier
) {
    var showTwoButtons by remember { mutableStateOf(false) }
    var isExpanded by remember { mutableStateOf(false) }
    var progress by remember { mutableFloatStateOf(0.0f) }
    val scope = rememberCoroutineScope()
    scope.launch {
        while (progress < 1f) {
            progress += 0.1f
            delay(2500L)
        }
    }
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
                    color = MaterialTheme.colorStyle.secondaryText,
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
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.85f),
                            contentAlignment = Alignment.Center
                        ) {
                            LinearProgressIndicator(
                                progress = { progress },
                                color = MaterialTheme.colorStyle.secondary,
                                trackColor = MaterialTheme.colorStyle.onSecondary,
                                modifier = Modifier
                                    .height(35.dp)
                                    .fillMaxWidth(),
                                strokeCap = StrokeCap.Square,
                                gapSize = 0.dp
                            )
                            Text(text = stringResource(R.string.button_uploading), style = MaterialTheme.typography.titleLarge)
                        }

                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .background(
                                    color = MaterialTheme.colorStyle.error,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .clickable { showTwoButtons = false },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.Close,
                                tint = MaterialTheme.colorScheme.onError,
                                contentDescription = "",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                } else {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        ),
                        onClick = {
                            showTwoButtons = true
                            progress = 0.0f
                        }
                    ) {
                        Text(stringResource(R.string.map_download), style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}