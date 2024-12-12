package com.example.dopted_mobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.Color

/**
 * A composable function that represents the "Pet of the Day" screen.
 * This screen displays a static message for the Pet of the Day section.
 */
@Composable
fun PetOfTheDayScreen() {
    // Create a surface to cover the entire screen and apply the app's background color.
    Surface(
        modifier = Modifier.fillMaxSize(), // Ensure the surface takes up the entire screen.
        color = MaterialTheme.colorScheme.background // Use the app's theme background color.
    ) {
        // Display the title of the screen.
        Text(
            text = "Pet of the Day Screen", // Static title text for the screen.
            style = MaterialTheme.typography.headlineMedium, // Apply medium headline typography style.
            modifier = Modifier.padding(16.dp) // Add padding around the text.
        )
    }
}

/**
 * A composable function that displays a pop-up dialog with details about the Pet of the Day.
 *
 * @param onDismiss A callback function to handle dismissing the dialog.
 */
@Composable
fun PetOfTheDayPopup(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss, // Handle dialog dismissal when the user taps outside or uses the back button.
        title = {
            Text(
                text = "Meet Mikey!", // Title text for the dialog.
                style = MaterialTheme.typography.headlineMedium // Apply medium headline typography style.
            )
        },
        text = {
            Text(
                text = "Mikey is a lovely cat who is outgoing and loves exploring.", // Description text for Mikey.
                style = MaterialTheme.typography.bodyMedium // Apply medium body typography style.
            )
        },
        confirmButton = {
            Button(
                onClick = onDismiss, // Trigger the onDismiss callback when the button is clicked.
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF007F), // Set the button background color to hot pink.
                    contentColor = Color.White // Set the button text color to white.
                )
            ) {
                Text("VIEW PET") // Label for the confirm button.
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { // Trigger the onDismiss callback when the dismiss button is clicked.
                Text("CLOSE") // Label for the dismiss button.
            }
        }
    )
}
