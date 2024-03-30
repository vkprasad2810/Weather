package com.example.weather.di


import com.example.buyok_jetpack.retrofit.ApiService
import com.example.weather.di.AuthInterceptor
import com.example.weather.retrofit.APIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(APIClient.Base_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun provideWeatherApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun providesOkHttpClient(interceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

}