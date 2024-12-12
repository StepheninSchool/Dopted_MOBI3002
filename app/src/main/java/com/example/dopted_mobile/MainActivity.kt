package com.example.dopted_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import com.example.dopted_mobile.screens.FavoriteScreen
import com.example.dopted_mobile.ui.*
import com.example.dopted_mobile.ui.theme.Dopted_mobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dopted_mobileTheme {
                MainApp()
            }
        }
    }
}


@Composable
fun MainApp() {
    var shouldShowSplash by remember { mutableStateOf(true) }
    var selectedScreen by remember { mutableStateOf("Favorite") } // Default to Favorite

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (!shouldShowSplash) {
                TopNavBar(
                    onNavigateToHome = { selectedScreen = "Home" } // Navigate to HomeScreen
                )
            }
        },
        bottomBar = {
            if (!shouldShowSplash) {
                BottomNavBar(
                    selectedScreen = selectedScreen,
                    onScreenSelected = { selectedScreen = it }
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
    }
}

