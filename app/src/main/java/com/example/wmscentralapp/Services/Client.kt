package com.example.wmscentralapp.Services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

object Client {
    private lateinit var okHttpClient: OkHttpClient

    fun xmlInstance(): ApiServices {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                //  .callTimeout(15, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build()
        val apiServices= Retrofit.Builder()
            .baseUrl("http://192.168.60.9:7741/zwms/")
            .client(client)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
        return  apiServices
    }
}