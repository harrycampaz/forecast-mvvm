package com.dezzapps.mrforecast.data.network.response

import com.dezzapps.mrforecast.data.db.entity.CurrentWeatherEntry
import com.dezzapps.mrforecast.data.db.entity.Location
import com.google.gson.annotations.SerializedName


data class CurrentWeatherRespose(
    @SerializedName(value = "current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)