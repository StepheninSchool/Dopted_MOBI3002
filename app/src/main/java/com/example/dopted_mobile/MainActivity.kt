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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    var selectedScreen by remember { mutableStateOf("Favorite") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (!shouldShowOnboarding) {
                TopNavBar(
                    title = selectedScreen,
                    onNavigateToOnboarding = { shouldShowOnboarding = true } // Navigate to onboarding
                )
            }
        },
        bottomBar = {
            if (!shouldShowOnboarding) {
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
            if (shouldShowOnboarding) {
                OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
            } else {
                when (selectedScreen) {
                    "Favorite" -> HomeScreen()
                    "Pet of the Day" -> PetOfTheDayScreen()
                }
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
