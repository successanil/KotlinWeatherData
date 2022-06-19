/*
 * Copyright (c) 2020. Relsell Global
 */

package `in`.relsellglobal.firebasedatabasedemo.repository

import `in`.relsellglobal.firebasedatabasedemo.models.CityContentNetwork
import `in`.relsellglobal.firebasedatabasedemo.repository.network.WeatherHerokuApiService
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class WeatherDataRepository @Inject constructor(private val weatherHerokuApiService: WeatherHerokuApiService) {

    suspend fun getWeatherDataCityList(): MutableLiveData<List<CityContentNetwork>> {

        val data = MutableLiveData<List<CityContentNetwork>>()
        data.value = weatherHerokuApiService.getWeatherDataCityList()

        return data
    }


}