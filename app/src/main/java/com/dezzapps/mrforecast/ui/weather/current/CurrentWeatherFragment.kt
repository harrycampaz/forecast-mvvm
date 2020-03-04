package com.dezzapps.mrforecast.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.dezzapps.mrforecast.R
import com.dezzapps.mrforecast.data.ApiWeatherstackService
import com.dezzapps.mrforecast.data.network.ConnectivityInterceptorImpl
import com.dezzapps.mrforecast.data.network.WeatherNetworkDataSource
import com.dezzapps.mrforecast.data.network.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val apiWeatherstackService = ApiWeatherstackService(ConnectivityInterceptorImpl(this.context!!))

        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiWeatherstackService)

        weatherNetworkDataSource.downloadedCurrentWeather.observe(this, Observer {

            textView.text = it.toString()
        })

        GlobalScope.launch(Dispatchers.Main) {

            weatherNetworkDataSource.fetchCurrentWeather("London", "ES")

        }

    }

}
