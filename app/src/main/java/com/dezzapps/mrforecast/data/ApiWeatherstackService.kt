package com.dezzapps.mrforecast.data


import com.dezzapps.mrforecast.data.network.ConnectivityInterceptor
import com.dezzapps.mrforecast.data.network.response.CurrentWeatherResponse
import com.dezzapps.mrforecast.utils.GlobalConstans
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

val API_KEY = GlobalConstans.KEY
// http://api.weatherstack.com/current?access_key=795ce159eb4bc4da5df9ba1c97eb81ef&query=New York
interface ApiWeatherstackService {

   @GET("current")
   fun getCurrentWeather(
       @Query("query") location: String

   ): Deferred<CurrentWeatherResponse>

    companion object {
        operator  fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): ApiWeatherstackService{

            val requestInterceptor = Interceptor{
                chain ->
//                  New Version
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()

//                val url = chain.request()
//                    .url()
//                    .newBuilder()
//                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return  Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiWeatherstackService::class.java)

        }
    }
}