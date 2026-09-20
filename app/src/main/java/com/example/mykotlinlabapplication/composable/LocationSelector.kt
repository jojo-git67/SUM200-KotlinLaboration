package com.example.mykotlinlabapplication.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mykotlinlabapplication.data.Location

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
            modifier = Modifier.menuAnchor()
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