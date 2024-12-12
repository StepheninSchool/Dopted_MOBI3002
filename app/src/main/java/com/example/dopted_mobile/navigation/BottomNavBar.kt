package com.example.dopted_mobile.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import com.example.dopted_mobile.R

@Composable
fun BottomNavBar(
    selectedScreen: String,
    onScreenSelected: (String) -> Unit
) {
    val items = listOf("Favorite", "Pet of the Day")

    NavigationBar(
        containerColor = Color.Black, // Black background for the nav bar
        contentColor = Color(0xFFFFD700) // Default Yellow color
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    when (item) {
                        "Favorite" -> Icon(
                            Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite"
                        )
                        "Pet of the Day" -> Icon(
                            painter = painterResource(id = R.drawable.baseline_circle_notifications_24),
                            contentDescription = "Pet of the Day"
                        )
                    }
                },
                label = { Text(item, color = Color(0xFFFFD700)) }, // Text color set to yellow
                selected = selectedScreen == item,
                onClick = { onScreenSelected(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFFD700), // Yellow for selected icons
                    unselectedIconColor = Color(0xFFFFD700), // Yellow for unselected icons
                    selectedTextColor = Color(0xFFFFD700), // Yellow for selected text
                    unselectedTextColor = Color(0xFFFFD700), // Yellow for unselected text
                    indicatorColor = Color.Black // Match background
                )
            )
        }
    }
}
