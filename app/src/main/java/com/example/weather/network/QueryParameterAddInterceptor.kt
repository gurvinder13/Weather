package com.example.weather.network
import okhttp3.Interceptor
import okhttp3.Response

class QueryParameterAddInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val url = chain.request().url.newBuilder()
                .addQueryParameter("appid", "6d107df22cf02ce34d7a72e7f7aea3b8")
                .build()

        val request = chain.request().newBuilder()
                // .addHeader("Authorization", "Bearer token")
                .url(url)
                .build()

        return chain.proceed(request)
    }
}