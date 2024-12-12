package com.example.dopted_mobile.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.ui.Modifier
import com.example.dopted_mobile.R
import com.example.dopted_mobile.screens.FavoriteScreen
import com.example.dopted_mobile.ui.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.dopted_mobile.navigation.BottomNavBar

/**
 * A composable function that defines the bottom navigation bar for the app.
 * This navigation bar allows users to navigate between different sections of the app,
 * such as "Favorite" and "Pet of the Day."
 *
 * @param selectedScreen A string representing the currently selected screen.
 * @param onScreenSelected A callback function that updates the selected screen.
 * @param onPetOfTheDayClicked A callback function triggered when the "Pet of the Day" is selected.
 */
@Composable
fun BottomNavBar(
    selectedScreen: String,
    onScreenSelected: (String) -> Unit,
    onPetOfTheDayClicked: () -> Unit
) {
    // Define the items to display in the bottom navigation bar.
    val items = listOf("Favorite", "Pet of the Day")

    // Create the navigation bar with a black background and yellow content color.
    NavigationBar(
        containerColor = Color.Black, // Set the navigation bar background to black.
        contentColor = Color(0xFFFFD700) // Set icons and text color to yellow.
    ) {
        // Iterate through each item in the navigation list to create navigation bar items.
        items.forEach { item ->
            NavigationBarItem(
                // Define the icon for each item based on its name.
                icon = {
                    when (item) {
                        "Favorite" -> Icon(
                            Icons.Default.FavoriteBorder, // Icon for the "Favorite" item.
                            contentDescription = "Favorite" // Accessibility description for the icon.
                        )
                        "Pet of the Day" -> Icon(
                            painter = painterResource(id = R.drawable.baseline_circle_notifications_24), // Icon for "Pet of the Day."
                            contentDescription = "Pet of the Day" // Accessibility description for the icon.
                        )
                    }
                },
                // Define the label (text) for each item.
                label = {
                    Text(
                        item, // Display the name of the item.
                        color = Color(0xFFFFD700) // Set text color to yellow.
                    )
                },
                // Highlight the selected item by checking if the item matches the selected screen.
                selected = selectedScreen == item,
                // Define the behavior when an item is clicked.
                onClick = {
                    if (item == "Pet of the Day") {
                        onPetOfTheDayClicked() // Trigger the callback for "Pet of the Day."
                    } else {
                        onScreenSelected(item) // Update the selected screen for other items.
                    }
                },
                // Customize the colors for the navigation bar items.
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFFD700), // Set selected icon color to yellow.
                    unselectedIconColor = Color(0xFFFFD700), // Set unselected icon color to yellow.
                    selectedTextColor = Color(0xFFFFD700), // Set selected text color to yellow.
                    unselectedTextColor = Color(0xFFFFD700), // Set unselected text color to yellow.
                    indicatorColor = Color.Black // Set the indicator color to match the black background.
                )
            )
        }
    }
}