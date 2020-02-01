package `in`.relsellglobal.firebasedatabasedemo.viewmodels

import `in`.relsellglobal.firebasedatabasedemo.BuildConfig
import `in`.relsellglobal.firebasedatabasedemo.pojo.CityContent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CitiesViewModel : ViewModel() {
    val APPID =
        BuildConfig.OPENWEATHERDATA_API_KEY

    private lateinit var citiesContent: MutableLiveData<List<CityContent>>



    fun getCitiesList(): LiveData<List<CityContent>> {
        if (!::citiesContent.isInitialized) {
            citiesContent = MutableLiveData()
            loadCities()
        }
        return citiesContent
    }



    private fun loadCities() {
        val listOfCities = mutableListOf<CityContent>()
        var city = CityContent()
        city.cityName = "dehradun"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)

        city = CityContent()
        city.cityName = "new delhi"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)


        city = CityContent()
        city.cityName = "hyderabad"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)


        city = CityContent()
        city.cityName = "chennai"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)


        city = CityContent()
        city.cityName = "mumbai"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)

        city = CityContent()
        city.cityName = "mangalore"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)

        city = CityContent()
        city.cityName = "dispur"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)


        city = CityContent()
        city.cityName = "indore"
        city.apiUrl =  "http://api.openweathermap.org/data/2.5/weather?q="+city.cityName+"&appid="+APPID
        listOfCities.add(city)

        citiesContent.value = listOfCities

    }
}