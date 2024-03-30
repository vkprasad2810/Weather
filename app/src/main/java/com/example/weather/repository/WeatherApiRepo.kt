package com.example.weather.repository

import com.example.weather.models.ApiResponse
import com.example.weather.models.ErrorResponse
import com.example.buyok_jetpack.retrofit.ApiService
import com.example.weather.models.WeatherApiRequest
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherApiRepo @Inject constructor(
    private val api: ApiService,

    ) {


    private val data = MutableStateFlow(ApiResponse())

    val getData: StateFlow<ApiResponse>
        get() = data

    suspend fun callApi(requestBody: WeatherApiRequest) {
        try {
            val response = if (requestBody.cityName == "") {
                api.weatherApiWithLatLong(
                    lat = requestBody.lat,
                    lon = requestBody.lon,
                    units = "metric",
                    appid = "81f655c60eb0a2e3e170a2c6ce091ed8"
                )

            } else {
                api.weatherApiWithCityName(
                    q = requestBody.cityName,
                    units = "metric",
                    appid = "81f655c60eb0a2e3e170a2c6ce091ed8"
                )
            }

            if (response.isSuccessful && response.body() != null) {
                data.emit(ApiResponse(data = response.body()!!, errorResponse = null, error = null))
            } else {
                try {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    val gson =
                        Gson().fromJson(jObjError.toString(), ErrorResponse::class.java)
                    data.emit(ApiResponse(data = null, errorResponse = gson, error = null))

                } catch (e: Exception) {
                    data.emit(ApiResponse(data = null, errorResponse = null, error = e.cause))
                }

            }
        } catch (e: HttpException) {
            data.emit(ApiResponse(data = null, errorResponse = null, error = e.cause))
            //An unexpected error occured
        } catch (e: IOException) {
            data.emit(ApiResponse(data = null, errorResponse = null, error = e.cause))
            //Couldn't reach server. Check your internet connection.
        }

    }


}