package com.example.weather.models

data class ErrorResponse(
	val message: String? = null,
	val error: String? = null,
	val cod: Int? = null
)

