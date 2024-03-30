package com.example.weather.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weather.models.ApiResponse
import com.example.weather.models.WeatherApiRequest
import com.example.weather.models.WeatherResponse
import com.example.weather.ui.theme.WeatherTheme
import com.example.weather.utils.checkPermission
import com.example.weather.utils.getCurrentLocation
import com.example.weather.view_model.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


enum class ApiResponseState {
    SUCCESS,
    FAILURE,
    INTERNET_ERROR,
    LOADING
}

@AndroidEntryPoint
class WeatherHomePage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WeatherTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    var hasPermission by remember {
                        mutableStateOf(checkPermission(this))
                    }
                    Log.d("LOCATION", "onCreate: $hasPermission")

                    if (hasPermission) {
                        // show MapView
                        MainView(this)
                    } else {
                        LocationPermission {
                            hasPermission = true
                        }

                    }

                }

            }


        }
    }


    @Composable
    private fun MainView(activity: WeatherHomePage) {

        val viewModel: WeatherViewModel = viewModel()

        val reCallApi = remember {
            mutableStateOf(1)
        }

        LaunchedEffect(reCallApi.value) {
            getCurrentLocation(activity) {

                viewModel.callWeatherReport(
                    WeatherApiRequest(
                        lat = "${it.latitude}",
                        lon = "${it.longitude}",
                        cityName = ""
                    )
                )
            }
        }


        var showMap by remember { mutableStateOf(ApiResponseState.LOADING) }

        val weatherReportResponse: State<ApiResponse> =
            viewModel.weatherReport.collectAsState()

        val data = remember {
            mutableStateOf<WeatherResponse?>(null)
        }



        LaunchedEffect(weatherReportResponse.value) {
            if (weatherReportResponse.value.data != null) {
                val dataResponse =
                    weatherReportResponse.value.data as WeatherResponse
                data.value = dataResponse
                showMap = ApiResponseState.SUCCESS
            }

            if (weatherReportResponse.value.errorResponse != null) {
                Toast.makeText(
                    activity,
                    weatherReportResponse.value.errorResponse!!.message,
                    Toast.LENGTH_SHORT
                ).show()
                showMap = ApiResponseState.FAILURE
            }

            if (weatherReportResponse.value.error != null) {
                Log.d("LOCATION_DATA", "MainView: ${weatherReportResponse.value.error?.message}")
                Toast.makeText(
                    activity,
                    "Internet Issue",
                    Toast.LENGTH_SHORT
                ).show()
                showMap = ApiResponseState.INTERNET_ERROR
            }

        }


        when (showMap) {
            ApiResponseState.SUCCESS -> {
                MapView(data){
                    if (it.length > 3) {

                        viewModel.callWeatherReport(
                            WeatherApiRequest(
                                lat = "",
                                lon = "",
                                cityName = it
                            )
                        )

                    }
                }
            }

            ApiResponseState.FAILURE -> {
                MapView(data){
                    if (it.length > 3) {

                        viewModel.callWeatherReport(
                            WeatherApiRequest(
                                lat = "",
                                lon = "",
                                cityName = it
                            )
                        )

                    }
                }
            }

            ApiResponseState.INTERNET_ERROR -> {
                NoInternetConnection(reCallApi)
            }

            ApiResponseState.LOADING -> {

                DataLoading()


            }


        }

    }


}
