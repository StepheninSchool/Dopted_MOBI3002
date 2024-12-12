package com.example.dopted_mobile

import HomeScreen // Import the HomeScreen composable function
import android.os.Bundle // Import the Bundle class for saving activity state
import androidx.activity.ComponentActivity // Import base activity for Jetpack Compose
import androidx.activity.compose.setContent // Import setContent for defining the Compose UI
import androidx.compose.foundation.layout.fillMaxSize // Import Modifier to make UI fill the screen
import androidx.compose.foundation.layout.padding // Import Modifier for adding padding
import androidx.compose.material3.MaterialTheme // Import MaterialTheme for consistent styling
import androidx.compose.material3.Scaffold // Import Scaffold for consistent layout structure
import androidx.compose.material3.Surface // Import Surface for applying background and elevation
import androidx.compose.runtime.Composable // Import Composable annotation for UI components
import androidx.compose.runtime.getValue // Import getValue for state delegation
import androidx.compose.runtime.mutableStateOf // Import mutableStateOf for managing state
import androidx.compose.runtime.remember // Import remember for retaining state across recompositions
import androidx.compose.runtime.setValue // Import setValue for state delegation
import androidx.compose.ui.Modifier // Import Modifier for UI customization
import com.example.dopted_mobile.navigation.BottomNavBar // Import BottomNavBar composable for navigation
import com.example.dopted_mobile.screens.FavoriteScreen // Import FavoriteScreen composable
import com.example.dopted_mobile.ui.PetOfTheDayPopup // Import PetOfTheDayPopup composable for pop-ups
import com.example.dopted_mobile.ui.PetOfTheDayScreen // Import PetOfTheDayScreen composable
import com.example.dopted_mobile.ui.SplashScreen // Import SplashScreen composable
import com.example.dopted_mobile.ui.TopNavBar // Import TopNavBar composable for top navigation
import com.example.dopted_mobile.ui.theme.Dopted_mobileTheme // Import app theme for styling

/**
 * MainActivity class
 *
 * This class serves as the entry point of the application. It is responsible for setting up
 * the user interface using Jetpack Compose and managing the app's navigation and state.
 */
class MainActivity : ComponentActivity() {
    /**
     * onCreate method
     *
     * This method is called when the activity is first created. It sets the content view
     * for the activity and applies the app's theme using Jetpack Compose's setContent function.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Apply the custom theme for the application
            Dopted_mobileTheme {
                // Call the MainApp composable function to display the main UI
                MainApp()
            }
        }
    }
}

/**
 * MainApp composable function
 *
 * This function defines the primary user interface of the application. It uses Scaffold
 * to provide a consistent layout structure with a top navigation bar, bottom navigation bar,
 * and a central content area. It also manages application states like showing the splash screen
 * and displaying the "Pet of the Day" pop-up.
 */
@Composable
fun MainApp() {
    // State to determine whether the splash screen should be shown
    var shouldShowSplash by remember { mutableStateOf(true) }

    // State to keep track of the currently selected screen in the bottom navigation bar
    var selectedScreen by remember { mutableStateOf("Favorite") }

    // State to manage the visibility of the "Pet of the Day" pop-up
    var showPetOfTheDayPopup by remember { mutableStateOf(false) }

    // Scaffold provides a consistent layout structure with top and bottom bars
    Scaffold(
        modifier = Modifier.fillMaxSize(), // Make the Scaffold fill the entire available space

        // Top navigation bar, only displayed when the splash screen is not visible
        topBar = {
            if (!shouldShowSplash) {
                TopNavBar(
                    onNavigateToHome = { selectedScreen = "Home" } // Action to navigate to the Home screen
                )
            }
        },

        // Bottom navigation bar, only displayed when the splash screen is not visible
        bottomBar = {
            if (!shouldShowSplash) {
                BottomNavBar(
                    selectedScreen = selectedScreen, // Pass the currently selected screen to the nav bar
                    onScreenSelected = { selectedScreen = it }, // Update selected screen when a new one is clicked
                    onPetOfTheDayClicked = { showPetOfTheDayPopup = true } // Show the "Pet of the Day" pop-up when clicked
                )
            }
        }
    ) { innerPadding ->
        // Surface provides a background and content container with padding applied
        Surface(
            modifier = Modifier.padding(innerPadding), // Add padding to avoid overlap with top and bottom bars
            color = MaterialTheme.colorScheme.background // Set the background color using the app's theme
        ) {
            // Display the splash screen if it should be shown
            if (shouldShowSplash) {
                SplashScreen(onSplashComplete = { shouldShowSplash = false }) // Dismiss splash screen after completion
            } else {
                // Navigate to the selected screen based on the current state
                when (selectedScreen) {
                    "Favorite" -> FavoriteScreen() // Show the Favorite screen
                    "Pet of the Day" -> PetOfTheDayScreen() // Show the Pet of the Day screen
                    "Home" -> HomeScreen() // Show the Home screen
                }
            }
        }

        // Show the "Pet of the Day" pop-up if its state is true
        if (showPetOfTheDayPopup) {
            PetOfTheDayPopup(
                onDismiss = { showPetOfTheDayPopup = false } // Dismiss the pop-up when the user interacts with it
            )
        }
    }
}
