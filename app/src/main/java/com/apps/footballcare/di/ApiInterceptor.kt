package com.apps.footballcare.di

import com.apps.footballcare.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 *
 * ApiInterceptor.kt
 *
 * Created by thangtx on 11/04/21
 *
 */
class ApiInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()
        val requestBuilder = original.newBuilder().url(originalHttpUrl.newBuilder().addQueryParameter("APIkey",BuildConfig.ACCESS_KEY) .build())
        requestBuilder.addHeader("Cache-Control", "public, max-stale=36000")
//        requestBuilder.apply {
//            addHeader("x-rapidapi-key", BuildConfig.ACCESS_KEY)
//            addHeader("x-rapidapi-host", BuildConfig.API_HOST)
//        }

        return chain.proceed(requestBuilder.build())
    }
}