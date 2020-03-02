package com.dezzapps.mrforecast.data.db.unitlocalized

import androidx.room.ColumnInfo

class ImperialCurrentWeatherEntry(

    @ColumnInfo(name = "temperature")
    override val temperature: Int,
    override val weatherDescriptions: List<String>,
    override val weatherIcons: List<String>,

    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Int,
    @ColumnInfo(name = "windDir")
    override val windDir: String,
    @ColumnInfo(name = "precip")
    override val precip: Int,
    @ColumnInfo(name = "feelslike")
    override val feelslike: Int,
    @ColumnInfo(name = "visibility")
    override val visibility: Int
): UnitSpecificCurrentWeatherEntry {
}