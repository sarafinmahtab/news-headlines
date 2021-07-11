package com.practice.newsheadlines.data.source.remote

import com.practice.newsheadlines.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

interface NewsApiService {

    @GET("everything")
    suspend fun allArticles(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("top-headlines")
    suspend fun loadTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("sources") sources: String?,
        @Query("q") query: String?,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int
    ): NewsResponse
}
