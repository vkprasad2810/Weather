package com.example.buyok_jetpack.retrofit


import com.example.weather.models.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {


    @Headers("Accept: application/json")
    @GET("weather/")
    suspend fun weatherApiWithLatLong(
        @Query("lat") lat: String = "19.2172713",
        @Query("lon") lon: String = "72.8241238",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "81f655c60eb0a2e3e170a2c6ce091ed8"
    ): Response<WeatherResponse>

    @Headers("Accept: application/json")
    @GET("weather/")
    suspend fun weatherApiWithCityName(
        @Query("q") q: String = "Mumbai",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "81f655c60eb0a2e3e170a2c6ce091ed8"
    ): Response<WeatherResponse>


}
