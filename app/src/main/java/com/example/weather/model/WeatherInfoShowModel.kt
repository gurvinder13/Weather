package com.example.weather.model

import WeatherInfoResponse
import com.example.weather.common.RequestCompleteListener

interface WeatherInfoShowModel {
    fun getSearchCity(cityId: String, callback: RequestCompleteListener<WeatherInfoResponse>)
}