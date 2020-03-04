package com.dezzapps.mrforecast.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    var temperature: Double
    var windDir: String
    var windSpeed: Int
   var precip: Int
    var feelslike: Int
}