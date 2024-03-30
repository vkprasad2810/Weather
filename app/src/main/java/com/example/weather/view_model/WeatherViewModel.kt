package com.example.weather.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.models.ApiResponse
import com.example.weather.models.WeatherApiRequest
import com.example.weather.repository.WeatherApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherApiRepo: WeatherApiRepo,
) :
    ViewModel() {

    // weather report api
    val weatherReport: StateFlow<ApiResponse>
        get() = weatherApiRepo.getData


    fun callWeatherReport(requestBody: WeatherApiRequest) {
        viewModelScope.launch {
            weatherApiRepo.callApi(requestBody)
        }
    }


}