/*
 * Copyright (c) 2020. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo.repository.network

import `in`.relsellglobal.firebasedatabasedemo.models.CityContentNetwork
import retrofit2.http.GET

interface WeatherHerokuApiService {
    @GET("getWeatherDataList")
    suspend fun getWeatherDataCityList() : List<CityContentNetwork>
}



