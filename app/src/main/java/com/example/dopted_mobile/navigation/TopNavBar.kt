package com.example.dopted_mobile.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(
    onNavigateToHome: () -> Unit
) {
    TopAppBar(
        title = { /* Empty composable to remove label */ },
        navigationIcon = {
            IconButton(onClick = onNavigateToHome) {
                Icon(Icons.Default.Home, contentDescription = "Go to Home")
            }
        }
    )
}
