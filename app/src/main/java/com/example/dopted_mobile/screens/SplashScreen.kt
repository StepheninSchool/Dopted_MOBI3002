package com.example.dopted_mobile.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.material3.Text
import com.example.dopted_mobile.R

/**
 * A composable function that represents the splash screen of the app.
 * Displays a logo and welcome message with an animation, and transitions to the next screen after a delay.
 *
 * @param onSplashComplete A callback function that is triggered when the splash screen completes.
 */
@Composable
fun SplashScreen(onSplashComplete: () -> Unit) {
    // State to control the visibility of the splash screen content.
    var isVisible by remember { mutableStateOf(true) }

    // LaunchedEffect to manage the delay and transition logic.
    LaunchedEffect(Unit) {
        delay(3000L) // Wait for 3 seconds before hiding the content.
        isVisible = false // Set visibility to false to start the fade-out animation.
        delay(500L) // Additional delay to allow the animation to complete.
        onSplashComplete() // Trigger the callback to indicate the splash screen has finished.
    }

    // AnimatedVisibility to manage the visibility and fade-out animation of the splash content.
    AnimatedVisibility(
        visible = isVisible, // Control visibility with the isVisible state.
        exit = fadeOut() // Apply a fade-out animation when the content disappears.
    ) {
        // Box layout to center the content on the screen.
        Box(
            modifier = Modifier
                .fillMaxSize() // Make the Box take up the entire screen.
                .padding(16.dp), // Add padding around the content.
            contentAlignment = Alignment.Center // Center the content both vertically and horizontally.
        ) {
            // Column layout to stack the logo and text vertically.
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Display the app logo.
                Image(
                    painter = painterResource(id = R.drawable.img), // Load the image resource.
                    contentDescription = "Splash Logo", // Accessibility description for the logo.
                    modifier = Modifier.size(200.dp) // Set the size of the logo.
                )

                // Add spacing between the logo and the text.
                Spacer(modifier = Modifier.height(16.dp))

                // Display the welcome message.
                Text("Welcome to Dopted") // Text content for the splash screen.
            }
        }
    }
}
