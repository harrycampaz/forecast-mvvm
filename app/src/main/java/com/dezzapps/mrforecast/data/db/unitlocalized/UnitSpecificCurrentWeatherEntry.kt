package com.dezzapps.mrforecast.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Double
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Double
    val windDirection: Double
    val precipitationVolume: Double
    val feelslikeTemperature: Double
    val visibilityDistance: Double
}