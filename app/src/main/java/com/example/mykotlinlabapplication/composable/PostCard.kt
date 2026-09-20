package com.example.mykotlinlabapplication.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mykotlinlabapplication.data.WeatherPost
import com.example.mykotlinlabapplication.ui.theme.MyKotlinLabApplicationTheme
import com.example.mykotlinlabapplication.util.getTodaysDate
import com.example.mykotlinlabapplication.util.getWeatherEmoji
import com.example.mykotlinlabapplication.util.translateDate
import com.example.mykotlinlabapplication.util.translateWind
import com.example.mykotlinlabapplication.util.translateWeather

@Composable
fun PostCard(weatherPost: WeatherPost) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        )

    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            //Header text
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Today's Weather",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary

            )

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = translateDate(weatherPost.date),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(32.dp))

            //Current weather
            //Emoji
            Text(
                text = getWeatherEmoji(weatherPost.weather),
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            //Emoji description
            Text(
                text = translateWeather(weatherPost.weather),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(32.dp))

            //Row with min- and max-temperatures
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherValue(
                    label = "Minimum",
                    value = "${weatherPost.minTemp}°C"
                )

                WeatherValue(
                    label = "Maximum",
                    value = "${weatherPost.maxTemp}°C"
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(24.dp))

            //Row with wind information
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "💨 Wind",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = translateWind(weatherPost.wind),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun WeatherValue(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    val weatherPost = WeatherPost(
        date = getTodaysDate(),
        weather = "unknown",
        minTemp = 0,
        maxTemp = 0,
        wind = 0
    )

    MyKotlinLabApplicationTheme {
        PostCard(weatherPost)
    }
}