package `in`.relsellglobal.firebasedatabasedemo.di

import `in`.relsellglobal.firebasedatabasedemo.repository.network.WeatherHerokuApiService
import `in`.relsellglobal.firebasedatabasedemo.utils.AppConstants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.Http.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesWeatherApiService(retrofit: Retrofit) : WeatherHerokuApiService {
        return retrofit.create(WeatherHerokuApiService::class.java)
    }

}