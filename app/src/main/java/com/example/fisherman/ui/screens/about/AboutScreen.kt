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
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fisherman.R
import com.example.fisherman.ui.theme.textColors

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
                        text = "О приложении",
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.textColors.primaryText
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
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
                text = "Карты глубин рек и водохранилищ \n для рыбалки в твоём смартфоне",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.textColors.primaryText
            )

            Spacer(Modifier.padding(16.dp))

            Text(
                text = "Версия 1.12.2347",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.textColors.secondaryText,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.padding(16.dp))

            val links = listOf(
                Link("Оценить приложение в <StorName>",null),
                Link("Наш сайт",null),
                Link("Группа ВКонтакте",null),
                Link("Канал в Telegram",null),
                Link("Политика конфиденциальности",null),
                Link("Пользовательское соглашение",null),
            )

            links.forEachIndexed { index, link ->
                Row(
                    modifier = Modifier.padding(vertical = 20.dp)
                ){
                    Text(
                        text = link.text,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.textColors.primaryText,
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
