package com.example.weather.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.models.WeatherResponse
import com.example.weather.ui.theme.WeatherTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


@Composable
fun MapView(data: MutableState<WeatherResponse?>, onSearch: (String) -> Unit) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    WeatherTheme {

        if (data != null) {


            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(
                    LatLng(
                        data.value?.coord?.lat!!,
                        data.value?.coord?.lon!!
                    ), 15f
                )
            }


            LaunchedEffect(data.value) {
                cameraPositionState.position = CameraPosition.fromLatLngZoom(
                    LatLng(
                        data.value?.coord?.lat!!,
                        data.value?.coord?.lon!!
                    ), 15f
                )
            }

            val state = rememberLazyListState()

            val searchPlace = remember {
                mutableStateOf("")
            }


            val keyboardController = LocalSoftwareKeyboardController.current
            val focusManager = LocalFocusManager.current




            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xff899ba1),
                                Color(0xff48585e)
                            )
                        )
                    )
            ) {


                LazyColumn(
                    state = state,
                    modifier = Modifier

                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {


                    item {
                        GoogleMap(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(
                                    (screenHeight / 2) + 10.dp
                                ),
                            cameraPositionState = cameraPositionState
                        ) {

                            Marker(
                                state = MarkerState(
                                    position = LatLng(
                                        data.value?.coord?.lat!!,
                                        data.value?.coord?.lon!!
                                    )
                                ),
                                title = "Location",
                                snippet = "Marker in current location",

                                )

                        }
                    }

                    item {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {

                            Text(
                                color = Color.White,
                                style = TextStyle(fontSize = 32.sp),
                                modifier = Modifier.drawBehind {
                                    val strokeWidthPx = 1.dp.toPx()
                                    val verticalOffset = size.height - 2.sp.toPx()
                                    drawLine(
                                        color = Color.White,
                                        strokeWidth = strokeWidthPx,
                                        start = Offset(0f, verticalOffset),
                                        end = Offset(size.width, verticalOffset)
                                    )
                                },
                                text = data.value?.name!!,
                            )

                            Text(
                                color = Color.White,
                                text = data.value?.weather?.get(0)?.main!!
                            )
                        }


                    }

                    item {


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {

//                            AsyncImage(
//                                model = "https://openweathermap.org/img/w/50n.png",
//                                contentDescription = "weather icon"
//                            )

                                Image(
                                    modifier = Modifier.size(60.dp),
                                    painter = painterResource(id = R.drawable.app_logo),
                                    contentDescription = ""
                                )
                                Spacer(modifier = Modifier.width(32.dp))

                                Text(
                                    color = Color.White,
                                    text = "${data.value?.main?.temp}°",
                                    style = TextStyle(
                                        fontSize = 40.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(32.dp))
                            Row {
                                CardView(
                                    modifier = Modifier.weight(1f),
                                    title = "Wind Speed",
                                    icon = R.drawable.wind,
                                    value = "${data.value?.wind?.speed!!} m/s"
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                CardView(
                                    modifier = Modifier.weight(1f),
                                    title = "Humidity",
                                    icon = R.drawable.humidity,
                                    value = "${data.value?.main?.humidity!!}%"
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Row {
                                CardView(
                                    modifier = Modifier.weight(1f),
                                    title = "Visibility",
                                    icon = R.drawable.visibility,
                                    value = "${data.value?.visibility!! / 1000} km"

                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                CardView(
                                    modifier = Modifier.weight(1f),
                                    title = "Pressure",
                                    icon = R.drawable.pressure,
                                    value = "${data.value?.main?.pressure!!} hPa"
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                        }

                    }

                }

                TextField(
                    leadingIcon = {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.location),
                            contentDescription = ""
                        )
                    },
                    trailingIcon = {
                        if (searchPlace.value.trim().isNotEmpty()) {
                            Image(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        searchPlace.value = ""
                                        keyboardController?.hide()
                                        focusManager.clearFocus()
                                    },
                                painter = painterResource(id = R.drawable.cross),
                                contentDescription = ""
                            )
                        }
                    },
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onSearch(searchPlace.value)
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        disabledContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),

                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(color = Color.White, shape = RoundedCornerShape(12.dp))
//                    .border(1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
                    ,
                    value = searchPlace.value,
                    onValueChange = {
                        searchPlace.value = it
                    },
                    placeholder = {
                        Text(text = "Enter a city name")
                    })


            }

        }

    }
}


@Composable
fun CardView(modifier: Modifier, title: String, icon: Int, value: String) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color(0x20ffffff))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                color = Color.White,
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = icon),
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    color = Color.White,
                    text = value,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

        }

    }
}
