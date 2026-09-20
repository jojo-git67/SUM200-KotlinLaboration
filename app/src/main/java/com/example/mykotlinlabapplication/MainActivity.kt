package com.example.mykotlinlabapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.mykotlinlabapplication.composable.LocationSelector
import com.example.mykotlinlabapplication.composable.PostCard
import com.example.mykotlinlabapplication.composable.PostCardPreview
import com.example.mykotlinlabapplication.data.Location
import com.example.mykotlinlabapplication.data.WeatherPost
import com.example.mykotlinlabapplication.ui.theme.MyKotlinLabApplicationTheme

class MainActivity : ComponentActivity() {
    val locations = listOf(
        Location("Trollhättan", 58.2837, 12.2886),
        Location("Gothenburg", 57.7089, 11.9746),
        Location("Stockholm", 59.3293, 18.0686),
        Location("Malmö", 55.6050, 13.0038),
        Location("New York", 40.7306, -73.9352)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(application)

        enableEdgeToEdge()
        setContent {
            var post by remember { mutableStateOf<WeatherPost?>(null) }

            var selectedLocation by remember { mutableStateOf(locations[0]) }


            LaunchedEffect(selectedLocation){
                val url =
                    "https://www.7timer.info/bin/api.pl" +
                            "?lon=${selectedLocation.longitude}" +
                            "&lat=${selectedLocation.latitude}" +
                            "&product=civillight" +
                            "&output=json"

                val request = JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    { response ->

                        val dataseries = response.getJSONArray("dataseries")

                        val today = dataseries.getJSONObject(0)

                        val date = today.getInt("date").toString()
                        val weather = today.getString("weather")

                        val temperatures = today.getJSONObject("temp2m")

                        val minTemp = temperatures.getInt("min")
                        val maxTemp = temperatures.getInt("max")

                        val wind = today.getInt("wind10m_max")

                        post = WeatherPost(
                            date,
                            weather,
                            minTemp,
                            maxTemp,
                            wind)

                        Log.e("API-String", url)
                        Log.d("Weather", response.toString())

                    },
                    { error ->
                        Log.e("VolleyError", error.toString())
                    }
                )

                queue.add(request)
            }

            MyKotlinLabApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LocationSelector(
                            locations = locations,
                            selectedLocation = selectedLocation,
                            onLocationSelected = { location ->
                                selectedLocation = location
                            }
                        )

                        when (val postState = post) {
                            null -> PostCardPreview()
                            else -> PostCard(postState)
                        }
                    }
                }
            }
        }
    }
}