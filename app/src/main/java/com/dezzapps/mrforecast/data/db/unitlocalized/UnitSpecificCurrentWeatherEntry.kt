package com.dezzapps.mrforecast.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Int
    val weatherDescriptions: List<String>
    val weatherIcons: List<String>
    val windSpeed: Int
    val windDir: String
    val precip: Int
    val feelslike: Int
    val visibility: Int
}