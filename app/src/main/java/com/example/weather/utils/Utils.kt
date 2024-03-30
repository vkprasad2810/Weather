package com.example.weather.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.weather.BuildConfig
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng

fun checkPermission(context: Context): Boolean {
    return !(ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) != PackageManager.PERMISSION_GRANTED
            )
}


@Suppress("MissingPermission")
fun getCurrentLocation(context: Context, onLocationFetch: (LatLng) -> Unit) {
    
    var locationLatLng: LatLng
    val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    fusedLocationClient.lastLocation
        .addOnSuccessListener { location: Location? ->
            if (location != null) {
                locationLatLng =
                    LatLng(location.latitude, location.longitude)
                onLocationFetch(locationLatLng)

            }

        }
        .addOnFailureListener { exception: Exception ->
            // Handle failure to get location
            Log.d("LOCATION-EXCEPTION", exception.message.toString())
        }

}