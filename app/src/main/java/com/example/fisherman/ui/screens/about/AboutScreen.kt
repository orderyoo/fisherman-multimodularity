package com.example.fisherman.ui.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fisherman.R
import com.example.fisherman.ui.theme.colorStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    onBackClick: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.info_block_param_about),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorStyle.primaryText
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
           horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.padding(24.dp))

            Image(
                painter = painterResource(R.drawable.ic_app_logo),
                contentDescription = "ic app",
                modifier = Modifier.size(100.dp)
            )

            Spacer(Modifier.padding(24.dp))

            Image(
                painter = painterResource(R.drawable.ic_app_logo_text),
                contentDescription = "ic app",
                modifier = Modifier.size(width = 258.dp, height = 72.dp)
            )

            Spacer(Modifier.padding(16.dp))

            Text(
                text = stringResource(R.string.app_description),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorStyle.primaryText
            )

            Spacer(Modifier.padding(16.dp))

            Text(
                text = stringResource(R.string.app_version),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorStyle.secondaryText,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.padding(16.dp))

            val links = listOf(
                Link(stringResource(R.string.about_rate),null),
                Link(stringResource(R.string.about_our_site),null),
                Link(stringResource(R.string.about_vkgroup),null),
                Link(stringResource(R.string.about_telegram),null),
                Link(stringResource(R.string.about_policy),null),
                Link(stringResource(R.string.about_agreement),null),
            )

            links.forEachIndexed { index, link ->
                Row(
                    modifier = Modifier.padding(vertical = 20.dp)
                ){
                    Text(
                        text = link.text,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorStyle.primaryText,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        painterResource(R.drawable.ic_button_external_link),
                        contentDescription = "Иконка внешней ссылки"
                    )
                }
                if (index != links.size-1)
                    HorizontalDivider(thickness = 2.dp)
            }
        }
    }
}

data class Link(
    val text: String,
    val link: String?
)
