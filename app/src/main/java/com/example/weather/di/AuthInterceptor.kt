package com.example.weather.di



import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class AuthInterceptor @Inject constructor() : Interceptor {

//    @Inject
//    lateinit var  preferenceManager : PreferenceManager

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // If token has been saved, add it to the request
//        preferenceManager.getAccessToken().let {
//            requestBuilder.addHeader("Authorization", "Bearer $it")
//        }

        return chain.proceed(requestBuilder.build())
    }
}