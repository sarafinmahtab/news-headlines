package com.practice.newsheadlines.data.repos

import com.practice.newsheadlines.data.source.remote.NewsApiService
import com.practice.newsheadlines.helpers.ResolveApiResponse


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

object NewsRepositoryFactory {

    private lateinit var newsRepository: NewsRepository

    fun getInstance(
        newsApiService: NewsApiService,
        resolveApiResponse: ResolveApiResponse
    ): NewsRepository {
        if (!::newsRepository.isInitialized) {
            newsRepository = NewsRepositoryImpl(newsApiService, resolveApiResponse)
        }

        return newsRepository
    }
}
