package `in`.relsellglobal.firebasedatabasedemo.models

import com.google.gson.annotations.SerializedName

data class CityContentDetailNetwork(
    var name : String = "",
    var weather : ArrayList<Weather>? = null,
    var main : MainData? = null
) {
}

data class Weather (
    var id : Int = 0,
    var main : String = "",
    var description : String = "",
    var icon : String = ""
        )

data class MainData(
    var temp : Float = 0.0f,
    @SerializedName("feels_like")
    var feelsLike : Float = 0.0f,

    @SerializedName("temp_min")
    var tempMin : Float = 0.0f,

    @SerializedName("temp_max")
    var tempMax : Float = 0.0f,

    @SerializedName("pressure")
    var pressure : Int = 0,

    @SerializedName("humidity")
    var humidity : Int = 0,

    @SerializedName("sea_level")
    var seaLevel : Int = 0,

    @SerializedName("grnd_level")
    var groundLevel : Int = 0

)