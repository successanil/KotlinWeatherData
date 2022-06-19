package `in`.relsellglobal.firebasedatabasedemo.viewmodels

import `in`.relsellglobal.firebasedatabasedemo.BuildConfig
import `in`.relsellglobal.firebasedatabasedemo.models.CityContent
import `in`.relsellglobal.firebasedatabasedemo.models.CityContentDetailNetwork
import `in`.relsellglobal.firebasedatabasedemo.models.CityContentNetwork
import `in`.relsellglobal.firebasedatabasedemo.repository.WeatherDataRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CitiesViewModel(private val weatherDataRepository: WeatherDataRepository) : ViewModel() {



    private lateinit var citiesContent: MutableLiveData<List<CityContentNetwork>>

    private lateinit var cityContentNetworkDetail: MutableLiveData<CityContentDetailNetwork>


    suspend fun getCitiesList(): LiveData<List<CityContentNetwork>> {
       // if (!::citiesContent.isInitialized) {
            citiesContent = MutableLiveData()
            loadCities()
       // }
        return citiesContent
    }

    suspend fun getCityDetail(cityName:String): LiveData<CityContentDetailNetwork> {
        if (!::cityContentNetworkDetail.isInitialized) {
            citiesContent = MutableLiveData()
            fetchTempretureForCity(cityName)
        }
        return cityContentNetworkDetail
    }


    private suspend fun loadCities() {
        citiesContent = weatherDataRepository.getWeatherDataCityList()
    }

    private suspend fun fetchTempretureForCity(cityName: String) {
        cityContentNetworkDetail = weatherDataRepository.fetchTempretureForCity(cityName)
    }


//    private fun loadCities() {
//        val listOfCities = mutableListOf<CityContent>()
//        var city = CityContent()
//        city.cityName = "dehradun"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//        city = CityContent()
//        city.cityName = "new delhi"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//
//        city = CityContent()
//        city.cityName = "hyderabad"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//
//        city = CityContent()
//        city.cityName = "chennai"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//
//        city = CityContent()
//        city.cityName = "mumbai"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//        city = CityContent()
//        city.cityName = "mangalore"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//        city = CityContent()
//        city.cityName = "dispur"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//
//        city = CityContent()
//        city.cityName = "indore"
//        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
//        listOfCities.add(city)
//
//        citiesContent.value = listOfCities
//
//    }
}