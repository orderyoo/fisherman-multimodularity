package com.example.fisherman.ui.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fisherman.R
import com.example.fisherman.navigation.Routes

@Composable
fun AppNavigationBar(
    currentRoute: String,
    onTabSelected: (String) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = contentColorFor(backgroundColor = MaterialTheme.colorScheme.surface)
    ) {
        val navigationItems = listOf(
            AppNavigationBarElement(stringResource(R.string.bar_map), painterResource(R.drawable.ic_appbar_map), Routes.MapScreen.route),
            AppNavigationBarElement(stringResource(R.string.mymap_title), painterResource(R.drawable.ic_appbar_my_map), Routes.MyMapScreen.route),
            AppNavigationBarElement(stringResource(R.string.bar_points), painterResource(R.drawable.ic_appbar_point), Routes.PointScreen.route),
            AppNavigationBarElement(stringResource(R.string.bar_tracks), painterResource(R.drawable.ic_appbar_tracks), Routes.TrackScreen.route),
            AppNavigationBarElement(stringResource(R.string.bar_more), painterResource(R.drawable.ic_appbar_additional_options), Routes.AdditionalOptionsScreen.route),
        )
        navigationItems.forEach { item ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title,
                        tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleSmall,
                        color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray
                    ) },
                selected = isSelected,
                onClick = { onTabSelected(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}

private data class AppNavigationBarElement(
    val title: String,
    val icon: Painter,
    val route: String
)