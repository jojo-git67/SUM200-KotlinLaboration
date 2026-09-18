package com.example.mykotlinlabapplication.util

fun translateWeather(weather: String): String {
    return when (weather) {
        "clear" -> "Clear sky"
        "pcloudy" -> "Partly cloudy"
        "mcloudy" -> "Mostly cloudy"
        "cloudy" -> "Cloudy"
        "lightrain" -> "Light rain"
        "oshower" -> "Occasional showers"
        "ishower" -> "Intermittent showers"
        "lightsnow" -> "Light snow"
        "snow" -> "Snow"
        "rainsnow" -> "Rain and snow"
        "ts" -> "Thunderstorm"
        "tsrain" -> "Thunderstorm with rain"
        "humid" -> "High humidity"
        else -> "Unknown weather"
    }
}

fun getWeatherEmoji(weather: String): String {
    return when (weather) {
        "clear" -> "☀️"
        "pcloudy" -> "🌤️"
        "mcloudy" -> "⛅"
        "cloudy" -> "☁️"
        "lightrain" -> "🌦️"
        "rain" -> "🌧️"
        "oshower" -> "🌦️"
        "ishower" -> "🌦️"
        "lightsnow" -> "🌨️"
        "snow" -> "❄️"
        "rainsnow" -> "🌨️"
        "ts" -> "⛈️"
        else -> "🌤️"
    }
}

fun translateWind(wind: Int): String {
    return when (wind) {
        0 -> "Calm"
        1 -> "Light air"
        2 -> "Light breeze"
        3 -> "Gentle breeze"
        4 -> "Moderate breeze"
        5 -> "Fresh breeze"
        6 -> "Strong breeze"
        7 -> "Near gale"
        8 -> "Gale"
        9 -> "Strong gale"
        10 -> "Storm"
        11 -> "Violent storm"
        12 -> "Hurricane-force"
        else -> "Unknown"
    }
}