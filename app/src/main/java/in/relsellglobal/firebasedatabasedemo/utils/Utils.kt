package `in`.relsellglobal.firebasedatabasedemo.utils

import `in`.relsellglobal.firebasedatabasedemo.models.CityContent
import `in`.relsellglobal.firebasedatabasedemo.models.CityContentNetwork

class Utils {
    companion object {
        fun mappingCityContentNetworkToCityContent (list : List<CityContentNetwork>) : List<CityContent> {

            var retList = ArrayList<CityContent>()

            for(obj in list){
                var cityContent = CityContent()
                cityContent.cityName = obj.cityName
                cityContent.apiUrl = ""
                retList.add(cityContent)
            }

            return retList

        }
    }
}