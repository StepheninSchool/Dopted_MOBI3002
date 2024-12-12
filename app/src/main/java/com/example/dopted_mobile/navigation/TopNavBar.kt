package com.example.dopted_mobile.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

/**
 * A composable function that represents the top navigation bar of the app.
 * The navigation bar includes a home button that navigates back to the home screen.
 *
 * @param onNavigateToHome A callback function that is triggered when the home icon is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(
    onNavigateToHome: () -> Unit
) {
    TopAppBar(
        title = { /* Empty composable to remove label */ }, // No title displayed in the top navigation bar.
        navigationIcon = {
            IconButton(onClick = onNavigateToHome) { // Handle click on the home button.
                Icon(
                    Icons.Default.Home, // Display the home icon.
                    contentDescription = "Go to Home" // Accessibility description for the icon.
                )
            }
        }
    )
}
