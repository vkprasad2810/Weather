package com.example.weather.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.ui.theme.WeatherTheme

@Composable
fun NoInternetConnection(reCallApi: MutableState<Int>) {
    WeatherTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.internet_issue),
                    contentDescription = "internet error"
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Oops!",
                    style = TextStyle(
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "There is no Internet connection \nplease check your Internet connection",
                    style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,

                        )
                )


                Spacer(modifier = Modifier.weight(1f))
                Button(colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
                    shape = RoundedCornerShape(6.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(),
                    onClick = {
                        reCallApi.value += 1
                    }) {
                    Text(
                        color = MaterialTheme.colorScheme.primary,
                        text = "Try again",
                        modifier = Modifier.padding(6.dp),
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xffffffff),
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }


        }
    }

}