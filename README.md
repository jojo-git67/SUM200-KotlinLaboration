# SUM200 Kotlin Laboration

Laboration application that retrieves weather forecasts from the [7Timer!](https://7timer.info)-API
with the use of the [Volley](https://google.github.io/volley/) library.

## Features

- Get weather forecasts from the 7Timer! API
- Select between predefined locations
- Automatically update the weather when location changes
- Translates weather data into user-friendly descriptions
- User interface using Jetpack Compose

## The project uses

- *Kotlin*
- *Android*
- *Jetpack Compose*
- *Material 3* components
- *Volley* for http requests
- *7Timer!* API for weather data

The volley library has been added as a dependency in [build.gradle.kts](https://github.com/jojo-git67/SUM200-KotlinLaboration/blob/main/app/build.gradle.kts)

Internet permission has been added to the [AndroidManifest.xml](https://github.com/jojo-git67/SUM200-KotlinLaboration/blob/main/app/src/main/AndroidManifest.xml)

## Predefined locations
| Location    | Latitude | Longitude |
|-------------|----------|-----------|
| Trollhättan | 58.2837  | 12.2886   |
| Gothenburg  | 57.7089  | 11.9746   |
| Stockholm   | 59.3293  | 18.0686   |
| Malmö       | 55.6050  | 13.0038   |
| New York    | 40.7306  | -73.9352  |

Table is inspired by documentation @ https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/organizing-information-with-tables

Additional locations can be added by adding a new `Location` data object to the `listOf<Location>` in [MainActivity.kt](https://github.com/jojo-git67/SUM200-KotlinLaboration/blob/main/app/src/main/java/com/example/mykotlinlabapplication/MainActivity.kt)
## API

The application uses the `Machine-readable` API version
where the product is `civillight` and the output is `json`.

The `civillight` product contains data relevant to the user.
- Date of request
- Weather condition
- Minimum temperature
- Maximum temperature
- Maximum wind speed

The data is translated for the user [util/WeatherTranslation.kt](https://github.com/jojo-git67/SUM200-KotlinLaboration/blob/main/app/src/main/java/com/example/mykotlinlabapplication/util/WeatherTranslation.kt) and [util/TranslateDate.kt](https://github.com/jojo-git67/SUM200-KotlinLaboration/blob/main/app/src/main/java/com/example/mykotlinlabapplication/util/TranslateDate.kt)
before it is displayed.

The data retrieved from the API is not user-friendly and that is why it must be translated before displaying.

E.g. weather = **ts** means nothing to the user. **Thunderstorm** is more descriptive for the user.

### Example API request

```` bash
https://www.7timer.info/bin/api.pl?lon=12.2886&lat=58.2837&product=civillight&output=json
````

Gets weather data for Trollhättan

Documentation on the *7Timer!* API can be found [here](https://www.7timer.info/doc.php?lang=en)

## How to run the project

Clone the repository and open the project in Android Studio, then allow Gradle to synchronize.

```` bash
git clone https://github.com/jojo-git67/SUM200-KotlinLaboration.git
````

The application can then be run on an emulator or a connected physical Android device.

## AUTHOR

Joakim Johansson

Student at University West in Trollhättan, Sweden

Course: SUM200