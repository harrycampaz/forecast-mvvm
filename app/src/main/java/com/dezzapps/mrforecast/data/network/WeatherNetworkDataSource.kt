package com.dezzapps.mrforecast.data.network

import androidx.lifecycle.LiveData

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherRespose>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}
