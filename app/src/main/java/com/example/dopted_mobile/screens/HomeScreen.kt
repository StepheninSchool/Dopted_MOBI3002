import androidx.compose.foundation.layout.* // Import layout modifiers such as padding, fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn // Import LazyColumn for efficient rendering of long lists
import androidx.compose.foundation.lazy.items // Import items to iterate over data in LazyColumn
import androidx.compose.material3.Text // Import Text composable for displaying text content
import androidx.compose.runtime.Composable // Import Composable annotation for defining UI components
import androidx.compose.ui.Modifier // Import Modifier for applying layout-related configurations
import androidx.compose.ui.unit.dp // Import dp (density-independent pixels) for consistent dimensions across devices

/**
 * HomeScreen composable function
 *
 * This function represents the Home Screen of the application. It displays a vertically scrollable
 * list of items using a LazyColumn. Each item in the list is a simple text component styled
 * with Material Design 3 typography.
 */
@Composable
fun HomeScreen() {
    // Generate a sample list of data for display in the LazyColumn.
    // The List function creates a list of 100 items, each labeled as "Pet #<index>".
    val sampleData = List(100) { "Pet #$it" } // Example data for scrolling content

    // LazyColumn is used for efficient rendering of lists, especially for large datasets.
    // It only renders items that are visible on the screen, reducing memory usage.
    LazyColumn(
        modifier = Modifier
            .fillMaxSize() // Modifier to make the LazyColumn fill the entire available space
            .padding(16.dp), // Apply 16dp padding to all sides of the LazyColumn
        verticalArrangement = Arrangement.spacedBy(8.dp) // Add 8dp vertical spacing between items
    ) {
        // Use the items function to iterate over the sampleData list.
        // For each item in the list, it creates a composable (in this case, Text).
        items(sampleData) { item ->
            // Display each item as a Text component.
            Text(
                text = item, // Set the content of the Text component to the current item
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge, // Apply the Material Design 3 bodyLarge typography style
                modifier = Modifier
                    .fillMaxWidth() // Make the Text component fill the entire width of the parent
                    .padding(8.dp) // Apply 8dp padding inside the Text component
            )
        }
    }
}
