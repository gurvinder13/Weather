package com.example.weather.network
import WeatherInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    fun callApiForWeatherInfo(@Query("id") cityId: Int): Call<WeatherInfoResponse>
    //https://api.openweathermap.org/data/2.5/weather?q=delhi&appid=3d026a998949874335fe4b45b73d5112
    @GET("weather")
    fun callCityWeather(@Query("q") city: String): Call<WeatherInfoResponse>
}