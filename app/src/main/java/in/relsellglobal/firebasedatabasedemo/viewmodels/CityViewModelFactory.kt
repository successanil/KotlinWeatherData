package `in`.relsellglobal.firebasedatabasedemo.viewmodels

import `in`.relsellglobal.firebasedatabasedemo.repository.WeatherDataRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class CityViewModelFactory @Inject constructor(private val weatherDataRepository: WeatherDataRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CitiesViewModel(weatherDataRepository) as T
    }
}