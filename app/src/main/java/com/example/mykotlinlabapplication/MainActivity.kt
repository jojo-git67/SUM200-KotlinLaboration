package com.example.mykotlinlabapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.Volley
import com.example.mykotlinlabapplication.composable.PostCard
import com.example.mykotlinlabapplication.data.WeatherPost
import com.example.mykotlinlabapplication.ui.theme.MyKotlinLabApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(application)

        enableEdgeToEdge()
        setContent {
            var post by remember { mutableStateOf<WeatherPost?>(null) }

            val url =
                "https://www.7timer.info/bin/api.pl?lon=58.28225&lat=12.29285&product=civillight&output=json"

            val request = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                Response.Listener { response ->

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

                },
                { error ->
                    Log.e("VolleyError", error.toString())
                }
            )

            queue.add(request)

            MyKotlinLabApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        when (val postState = post) {
                            null -> Text("Nothing to show!")
                            else -> PostCard(postState)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyKotlinLabApplicationTheme {
        Greeting("Android")
    }
}