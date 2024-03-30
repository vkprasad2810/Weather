package com.example.weather.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.weather.R
import com.example.weather.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MainView()
        }

    }

    @Preview
    @Composable
    fun MainView() {
        WeatherTheme {

            Surface(modifier = Modifier.fillMaxSize()) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Image(
                        modifier = Modifier.weight(1f),
                        painter = painterResource(id = R.drawable.place),
                        contentDescription = ""
                    )

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.get_accurate_weather_data),
                            style = TextStyle(fontSize = 32.sp, textAlign = TextAlign.Center)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = stringResource(R.string.whatever_your_plans_and_wherever_you_aro_stay_one_step_ahead_with_the_weather_app),
                            style = TextStyle(fontSize = 16.sp, textAlign = TextAlign.Center)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(shape = RoundedCornerShape(6.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(),
                            onClick = {

                                startActivity(Intent(this@MainActivity,WeatherHomePage::class.java))
                                finish()

                            }) {
                            Text(
                                text = stringResource(R.string.get_started),
                                modifier = Modifier.padding(6.dp),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color(0xffffffff),
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                    }

                }

            }

        }
    }

}
