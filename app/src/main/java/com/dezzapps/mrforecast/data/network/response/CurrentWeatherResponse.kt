package com.dezzapps.mrforecast.data.network.response

import com.dezzapps.mrforecast.data.db.entity.Current
import com.dezzapps.mrforecast.data.db.entity.Location
import com.dezzapps.mrforecast.data.db.entity.Request


data class CurrentWeatherResponse(
    val current: Current,
    val location: Location,
    val request: Request
)