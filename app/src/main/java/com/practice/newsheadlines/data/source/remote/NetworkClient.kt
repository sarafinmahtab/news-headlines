package com.practice.newsheadlines.data.source.remote

import com.google.gson.GsonBuilder
import com.practice.newsheadlines.data.AppConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

object NetworkClient {

    private var client: OkHttpClient? = null
    private var gsonConverterFactory: GsonConverterFactory? = null
    private var apiService: NewsApiService? = null

    private val okHttpClient: OkHttpClient
        get() {
            if (client == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = if (AppConstant.isDebug) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }

                client = OkHttpClient.Builder().addInterceptor(interceptor)
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(3, TimeUnit.MINUTES)
                    .writeTimeout(10, TimeUnit.MINUTES).build()
            }

            return client!!
        }

    private fun getGsonConverterFactory(): GsonConverterFactory {
        if (gsonConverterFactory == null) {
            val gson = GsonBuilder()
//                .setLenient()
//                .disableHtmlEscaping()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create()
            gsonConverterFactory = GsonConverterFactory.create(gson)
        }

        return gsonConverterFactory!!
    }

    private fun getClient(baseUrl: String): Retrofit {
        val factory = getGsonConverterFactory()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(factory)
            .client(okHttpClient)
            .build()
    }

    fun getNewsApiService(baseUrl: String): NewsApiService {
        if (apiService == null) {
            val retrofit = getClient(baseUrl)
            apiService = retrofit.create(NewsApiService::class.java)
        }

        return apiService!!
    }
}
