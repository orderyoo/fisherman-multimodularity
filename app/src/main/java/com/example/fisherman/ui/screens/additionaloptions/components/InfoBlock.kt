package com.example.fisherman.ui.screens.additionaloptions.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fisherman.R
import com.example.fisherman.ui.theme.textColors

@Composable
fun InfoBlock(
    onClickReference: () -> Unit,
    onClickAbout: () -> Unit
) {
    Column {

        Text(
            text = "Информация",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.textColors.primaryText
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier.clickable { onClickReference() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Справка",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.textColors.primaryText,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .weight(1f)
            )
            Icon(
                painterResource(R.drawable.ic_button_external_link),
                contentDescription = "Иконка внешней ссылки"
            )
        }

        HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = "О приложении",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.textColors.primaryText,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClickAbout() }
                .padding(vertical = 8.dp)
        )
    }
}