# SUM200 Kotlin Laboration

A weather application developed as part of the **SUM200** course at Högskolan Väst. The application is built with **Kotlin** and **Jetpack Compose** and retrieves weather forecasts from the [7timer!](https://www.7timer.info/) weather API.

## About the project

The purpose of this project is to practice Android development using Kotlin and Jetpack Compose.

The application retrieves weather information for a selected location and presents the forecast in a simple, user-friendly interface. Locations can be selected from a dropdown menu, after which the application requests updated weather data for the selected coordinates.

## Features

- Retrieve weather forecasts from the 7timer! API
- Select between predefined locations
- Automatically update the weather when the selected location changes
- Display minimum and maximum temperatures
- Display maximum wind speed
- Translate weather codes into more understandable descriptions
- Display the forecast date
- Material 3 / Jetpack Compose user interface
- Compose previews for UI components

## The project uses

- **Kotlin**
- **Android**
- **Jetpack Compose**
- **Material 3**
- **Volley** for HTTP requests
- **7timer! API** for weather data
- **Gradle** with Kotlin DSL

## Available locations to try out

The application currently contains the following predefined locations:

| Location | Latitude | Longitude |
|---|---:|---:|
| Trollhättan | 58.2837 | 12.2886 |
| Gothenburg | 57.7089 | 11.9746 |
| Stockholm | 59.3293 | 18.0686 |
| Malmö | 55.6050 | 13.0038 |
| New York | 40.7306 | -73.9352 |

Additional locations can be added to the location list by creating another `Location` object.

## API

Weather data is provided by **7timer!** using the `civillight` product and JSON output.

Example request:

```text
https://www.7timer.info/bin/api.pl?lon=12.2886&lat=58.2837&product=civillight&output=json
```

The application extracts information such as:

- Forecast date
- Weather condition
- Minimum temperature
- Maximum temperature
- Maximum wind speed

For more information about the API, visit the [7timer! documentation](https://www.7timer.info/doc.php?lang=en).

## Running the project

Clone the repository and open the project in Android Studio, then allow Gradle to synchronize.

The application can then be run using an Android emulator or a connected Android device.

## Learning objectives

This project is primarily a learning exercise. It has been used to practice:

- Kotlin syntax
- Jetpack Compose
- Composable functions
- Compose state
- State-driven UI
- Material 3 components
- HTTP requests using Volley
- Separating UI components from data models

## Author

**Joakim Johansson**

Högskolan Väst  
SUM200
