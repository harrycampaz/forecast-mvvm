package com.dezzapps.mrforecast.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dezzapps.mrforecast.data.ApiWeatherstackService
import com.dezzapps.mrforecast.data.network.response.CurrentWeatherResponse
import com.dezzapps.mrforecast.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl(
    private val apiWeatherstackService: ApiWeatherstackService
) : WeatherNetworkDataSource {

    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()

    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {


        try {
            val fetchCurrentWeather = apiWeatherstackService
                .getCurrentWeather(location)
                .await()

            _downloadedCurrentWeather.postValue(fetchCurrentWeather)

        }catch (e: NoConnectivityException){
            Log.e("Connectivity", "No internet connection.", e)
        }

    }
}