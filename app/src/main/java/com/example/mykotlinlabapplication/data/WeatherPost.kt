package com.example.mykotlinlabapplication.data

/**
 * Holds data from a post from the 7timer! weather API
 */

data class WeatherPost(
    val date : String,
    val weather : String,
    val minTemp : Int,
    val maxTemp: Int,
    val wind: Int
)