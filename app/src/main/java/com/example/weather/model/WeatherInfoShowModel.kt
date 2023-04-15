package com.example.weather.model

import com.example.weather.model.data.City
import WeatherInfoResponse
import com.example.weather.common.RequestCompleteListener
interface WeatherInfoShowModel {
    fun getCityList(callback: RequestCompleteListener<MutableList<City>>)
    fun getWeatherInfo(cityId: Int, callback: RequestCompleteListener<WeatherInfoResponse>)
    fun getSearchCity(cityId:String,callback: RequestCompleteListener<WeatherInfoResponse>)
}