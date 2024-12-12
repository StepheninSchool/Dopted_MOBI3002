package com.example.dopted_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dopted_mobile.ui.theme.Dopted_mobileTheme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import kotlinx.coroutines.delay




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
    var selectedScreen by remember { mutableStateOf("Favorite") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (!shouldShowSplash) {
                TopNavBar(
                    title = selectedScreen,
                    onNavigateToOnboarding = { shouldShowSplash = true } // Navigate back to splash
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
                    "Favorite" -> HomeScreen()
                    "Pet of the Day" -> PetOfTheDayScreen()
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onSplashComplete: () -> Unit) {
    var isVisible by remember { mutableStateOf(true) }

    // Automatically hide the splash screen after a delay
    LaunchedEffect(Unit) {
        delay(3000L) // Delay for 3 seconds
        isVisible = false
        delay(500L) // Allow the fade-out animation to finish
        onSplashComplete()
    }

    // AnimatedVisibility for fade-out effect
    AnimatedVisibility(
        visible = isVisible,
        exit = fadeOut()
    ) {
        // Splash screen content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img), // Replace with your splash image
                    contentDescription = "Splash Logo",
                    modifier = Modifier.size(200.dp) // Adjust size as needed
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Welcome to Dopted",
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(
    title: String,
    onNavigateToOnboarding: () -> Unit
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = onNavigateToOnboarding) {
                Icon(Icons.Default.Home, contentDescription = "Back to Onboarding")
            }
        }
    )
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Favorite Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun PetOfTheDayScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pet of the Day Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun BottomNavBar(
    selectedScreen: String,
    onScreenSelected: (String) -> Unit
) {
    val items = listOf("Favorite", "Pet of the Day")

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    when (item) {
                        "Pet of the Day" -> Icon(
                            painter = painterResource(id = R.drawable.baseline_circle_notifications_24),
                            contentDescription = "Pet of the Day"
                        )
                        "Favorite" -> Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                    }
                },
                label = { Text(item) },
                selected = selectedScreen == item,
                onClick = { onScreenSelected(item) }
            )
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img), // Replace with your image resource
            contentDescription = "Onboarding Image",
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text("Welcome to Dopted.")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MainAppPreview() {
    Dopted_mobileTheme {
        MainApp()
    }
}
