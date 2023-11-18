package com.slvmk.restaurants_demo.data.api

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by SlavaMk on 2/27/23.
 */
class ApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("Accept", "application/json")
            .header("Authorization", "bearer $apiKey")
            .build()
        return chain.proceed(request)
    }
}