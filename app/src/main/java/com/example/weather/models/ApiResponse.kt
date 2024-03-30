package com.example.weather.models

import java.util.UUID

data class ApiResponse(
    var data: Any? = null,
    var errorResponse: ErrorResponse? = null,
    var error: Throwable?=null,
    private val id: UUID = UUID.randomUUID()
)