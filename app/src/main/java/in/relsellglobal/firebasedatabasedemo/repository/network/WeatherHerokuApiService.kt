/*
 * Copyright (c) 2020. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo.repository.network

import `in`.relsellglobal.firebasedatabasedemo.models.CityContentDetailNetwork
import `in`.relsellglobal.firebasedatabasedemo.models.CityContentNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherHerokuApiService {
    @GET("getWeatherDataList")
    suspend fun getWeatherDataCityList() : List<CityContentNetwork>

    @GET("fetchTempretureForCity")
    suspend fun fetchTempretureForCity(@Query("cityName")  cityName:String) : CityContentDetailNetwork
}



