package com.example.fisherman.ui.screens.additionaloptions.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fisherman.R
import com.example.fisherman.ui.theme.textColors

@Preview(showBackground = true)
@Composable
fun AuthBlock(
    isLoggedIn: Boolean = false,
    onLoginClick:() -> Unit = {},
    onLogOutClick: () -> Unit = {},
    onDeleteAccountClick: () -> Unit = {}
) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (!isLoggedIn) stringResource(R.string.auth_block_title_no_auth )
                        else stringResource(R.string.auth_block_title_with_auth),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.textColors.primaryText,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = if (!isLoggedIn) stringResource(R.string.auth_block_subtext_no_auth)
                        else "markovmaks895@gmail.com",
                    style = if(!isLoggedIn) MaterialTheme.typography.bodyMedium
                        else MaterialTheme.typography.titleMedium,
                    color = if(!isLoggedIn) MaterialTheme.textColors.secondaryText
                        else MaterialTheme.textColors.primaryText
                )
                if(!isLoggedIn){
                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = stringResource(R.string.auth_block_button_log_in),
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.textColors.primaryText,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                } else {
                    Row(
                        modifier = Modifier

                            .padding(top = 16.dp)
                    ) {
                        TextButton(
                            onClick = onLogOutClick,
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = stringResource(R.string.auth_block_button_log_out),
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.textColors.primaryText
                            )
                        }
                        TextButton(
                            onClick = onDeleteAccountClick,
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = stringResource(R.string.auth_block_button_delete_profile),
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }

        val advantages = listOf(
            stringResource(R.string.auth_block_advantage_1),
            stringResource(R.string.auth_block_advantage_2),
            stringResource(R.string.auth_block_advantage_3)
        )

        if(!isLoggedIn) {
            Spacer(modifier = Modifier.padding(16.dp))
            advantages.forEachIndexed { index, text ->
                Row {
                    Box(
                        modifier = Modifier.size(24.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            painterResource(R.drawable.ic_check_mark),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(Modifier.padding(8.dp))

                    Text(
                        text = text,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.textColors.primaryText
                    )
                }
                if(index != 2) Spacer(Modifier.padding(8.dp))
            }
        }
    }
}