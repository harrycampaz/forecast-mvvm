package com.dezzapps.mrforecast.data.db.unitlocalized

import androidx.room.ColumnInfo

data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "temperature")
    override var temperature: Double,
    @ColumnInfo(name = "wind_dir")
    override var windDir: String,

    @ColumnInfo(name = "wind_speed")
    override var windSpeed: Int,

    @ColumnInfo(name = "precip")
    override var precip: Int,
    @ColumnInfo(name = "feelslike")
    override var feelslike: Int


): UnitSpecificCurrentWeatherEntry