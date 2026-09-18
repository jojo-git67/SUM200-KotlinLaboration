package com.example.mykotlinlabapplication.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mykotlinlabapplication.data.WeatherPost
import com.example.mykotlinlabapplication.ui.theme.MyKotlinLabApplicationTheme
import com.example.mykotlinlabapplication.util.translateWind
import com.example.mykotlinlabapplication.util.translateWeather

@Composable
fun PostCard(weatherPost : WeatherPost) {
    Card(Modifier.padding(8.dp)) {
        Column(Modifier.padding(all = 8.dp)) {
            Text(
                text = "Today's date: " + weatherPost.date,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "Today's weather forecast: " + translateWeather(weatherPost.weather),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text= "Today's minimum temperature: " + weatherPost.minTemp.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text= "Today's maximum temperature: " + weatherPost.maxTemp.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text="Today's wind speed: " + translateWind(weatherPost.wind),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    val weatherPost = WeatherPost(
        date = "20260707",
        weather = "cloudy",
        minTemp = 20,
        maxTemp = 25,
        wind = 2
    )

    MyKotlinLabApplicationTheme {
        PostCard(weatherPost)
    }
}