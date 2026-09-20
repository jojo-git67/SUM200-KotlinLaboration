package com.example.mykotlinlabapplication.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mykotlinlabapplication.data.Location
import com.example.mykotlinlabapplication.ui.theme.MyKotlinLabApplicationTheme

//Inspired by example in kotlin documentation @ https://kotlinlang.org/api/compose-multiplatform/material3/androidx.compose.material3/-exposed-dropdown-menu-box.html
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationSelector(
    locations: List<Location>,
    selectedLocation: Location,
    onLocationSelected: (Location) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier
            .padding(16.dp)
    ) {
        TextField(
            value = selectedLocation.name,
            onValueChange = {},
            readOnly = true,
            label = {
                Text("Location")
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .menuAnchor(
                type = ExposedDropdownMenuAnchorType.PrimaryNotEditable
            )
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            locations.forEach { location ->

                DropdownMenuItem(
                    text = {
                        Text(location.name)
                    },
                    onClick = {
                        onLocationSelected(location)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationSelectorPreview() {
    val locations = listOf(
        Location("Trollhättan", 58.2837, 12.2886),
        Location("Gothenburg", 57.7089, 11.9746),
        Location("Stockholm", 59.3293, 18.0686),
        Location("Malmö", 55.6050, 13.0038)
    )

    MyKotlinLabApplicationTheme {
        LocationSelector(
            locations = locations,
            selectedLocation = locations[2],
            onLocationSelected = {}
        )
    }
}