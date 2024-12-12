package com.example.dopted_mobile.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

/**
 * A composable function that displays the "Favorite" screen in the app.
 * This screen informs the user that their favorite pets will appear here in the future.
 */
@Composable
fun FavoriteScreen() {
    // Define a vertical column layout to organize the content of the screen.
    Column(
        modifier = Modifier
            .fillMaxSize() // Make the column take up the entire screen size.
            .padding(16.dp), // Add padding around the edges of the column.
        verticalArrangement = Arrangement.Center, // Center the content vertically within the screen.
        horizontalAlignment = Alignment.CenterHorizontally // Center the content horizontally within the screen.
    ) {
        // Display the title of the screen.
        Text(
            text = "Special Friends", // Title text.
            style = MaterialTheme.typography.headlineMedium // Use a medium headline style for the title.
        )

        // Add space between the title and the subtitle.
        Spacer(modifier = Modifier.height(16.dp))

        // Display the subtitle text.
        Text(
            text = "Your favorite pets will appear here.", // Informational text.
            style = MaterialTheme.typography.bodyLarge // Use a large body text style for the subtitle.
        )
    }
}
