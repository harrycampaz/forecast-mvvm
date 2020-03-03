package com.dezzapps.mrforecast.data.network.response

import com.dezzapps.mrforecast.data.db.entity.Current
import com.dezzapps.mrforecast.data.db.entity.Location_
import com.dezzapps.mrforecast.data.db.entity.Request_


data class CurrentWeatherResponse_(
    val current: Current,
    val location: Location_,
    val request: Request_
)