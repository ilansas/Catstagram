package com.sas.data.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class CatApiInterceptor : Interceptor {

    companion object {
        private const val API_KEY = "2dfd1909-0732-4e01-add9-3fa4317f2cee"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder().url(chain.request().url()).also {
            it.addHeader("x-api-key", API_KEY)
        }
        return chain.proceed(requestBuilder.build())
    }
}
