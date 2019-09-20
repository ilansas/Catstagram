package com.sas.data.retrofit

import com.google.gson.GsonBuilder
import com.sas.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CatApiBuilder {

    companion object {
        private const val CONNECT_TIMEOUT_MILLIS = 30 * 1000
        private const val READ_TIMEOUT_MILLIS = 20 * 1000
    }

    fun buildApi(): CatApiCalls {
        val httpClient = createBaseHttpBuilder().apply { addInterceptor(CatApiInterceptor()) }

        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CatApiCalls::class.java)
    }


    private fun createBaseHttpBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()

        addTimeout(builder)
        addLoggingInterceptor(builder)

        return builder
    }


    private fun addTimeout(builder: OkHttpClient.Builder) {
        builder.connectTimeout(CONNECT_TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)
        builder.readTimeout(READ_TIMEOUT_MILLIS.toLong(), TimeUnit.MILLISECONDS)
    }

    private fun addLoggingInterceptor(builder: OkHttpClient.Builder) {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        builder.interceptors().add(interceptor)
    }
}