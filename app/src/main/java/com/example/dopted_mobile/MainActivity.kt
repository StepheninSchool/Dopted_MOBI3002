package com.example.dopted_mobile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.dopted_mobile.navigation.BottomNavBar
import com.example.dopted_mobile.screens.FavoriteScreen
import com.example.dopted_mobile.ui.HomeScreen
import com.example.dopted_mobile.ui.PetOfTheDayPopup
import com.example.dopted_mobile.ui.PetOfTheDayScreen
import com.example.dopted_mobile.ui.SplashScreen
import com.example.dopted_mobile.ui.TopNavBar


@Composable
fun MainApp() {
    var shouldShowSplash by remember { mutableStateOf(true) }
    var selectedScreen by remember { mutableStateOf("Favorite") }
    var showPetOfTheDayPopup by remember { mutableStateOf(false) } // State for the pop-up

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (!shouldShowSplash) {
                TopNavBar(
                    onNavigateToHome = { selectedScreen = "Home" }
                )
            }
        },
        bottomBar = {
            if (!shouldShowSplash) {
                BottomNavBar(
                    selectedScreen = selectedScreen,
                    onScreenSelected = { selectedScreen = it },
                    onPetOfTheDayClicked = { showPetOfTheDayPopup = true } // Show the pop-up
                )
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            if (shouldShowSplash) {
                SplashScreen(onSplashComplete = { shouldShowSplash = false })
            } else {
                when (selectedScreen) {
                    "Favorite" -> FavoriteScreen()
                    "Pet of the Day" -> PetOfTheDayScreen()
                    "Home" -> HomeScreen()
                }
            }
        }

        // Show the pop-up
        if (showPetOfTheDayPopup) {
            PetOfTheDayPopup(
                onDismiss = { showPetOfTheDayPopup = false } // Dismiss the pop-up
            )
        }
    }
}
