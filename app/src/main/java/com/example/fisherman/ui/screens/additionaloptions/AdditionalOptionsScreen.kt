package com.example.fisherman.ui.screens.additionaloptions

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fisherman.R
import com.example.fisherman.navigation.Routes
import com.example.fisherman.ui.screens.additionaloptions.components.AuthBlock
import com.example.fisherman.ui.screens.additionaloptions.components.InfoBlock
import com.example.fisherman.ui.screens.additionaloptions.components.NewsBlock
import com.example.fisherman.ui.screens.additionaloptions.components.SettingsBlock

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun AdditionalOptionsScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: AdditionalOptionsScreenViewModel = hiltViewModel()
) {
    var isLoggedIn by remember { mutableStateOf(false) }
    val scrollState = rememberLazyListState()
    val state = viewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        state = scrollState
    ) {

        item { Spacer(modifier = Modifier.padding(32.dp)) }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_app_logo),
                    contentDescription = "Логотип",
                    modifier = Modifier.size(48.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Добро пожаловать в профиль Dap Drift!",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 28.dp)
                )
            }
        }

        item { Spacer(modifier = Modifier.padding(16.dp)) }

        stickyHeader {
            AuthBlock(
                isLoggedIn = isLoggedIn,
                onLoginClick = { isLoggedIn = !isLoggedIn },
                onLogOutClick = {isLoggedIn = !isLoggedIn },
                onDeleteAccountClick = { }
            )
        }

        item { Spacer(modifier = Modifier.padding(16.dp)) }

        item {
            when (val currentState = state.value) {
                is AdditionalOptionsScreenViewModel.State.Loading -> {

                }
                is AdditionalOptionsScreenViewModel.State.Success -> {
                    NewsBlock(
                        news = currentState.news[0],
                        onClickNews = { navController.navigate(Routes.NewsDetails.route + "/${it}") },
                        onClickAllNews = { navController.navigate(Routes.AllNews.route)}
                    )
                }
                is AdditionalOptionsScreenViewModel.State.Error -> {
                    Box {
                        Text("НИЧЕГО НЕ ЗАГРУЗИЛОСЬ")
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.padding(16.dp)) }

        item { SettingsBlock() }

        item { Spacer(modifier = Modifier.padding(16.dp)) }

        item {
            InfoBlock(
                onClickReference = { },
                onClickAbout = { navController.navigate(Routes.About.route) }
            )
        }

        item { Spacer(modifier = Modifier.padding(32.dp)) }
    }
}