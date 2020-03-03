package com.dezzapps.mrforecast.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dezzapps.mrforecast.R
import com.dezzapps.mrforecast.data.ApiWeatherstackService
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

        val apiWeatherstackService = ApiWeatherstackService()

        GlobalScope.launch(Dispatchers.Main) {
            val currentWeatherResponse = apiWeatherstackService.getCurrentWeather("London").await()

            Log.d("Este es el dato: ", currentWeatherResponse.toString())
          //  print("Esta es el DATO: "+currentWeatherResponse)
             textView.text = currentWeatherResponse.currentWeatherEntry.toString()
        }
    }

}
