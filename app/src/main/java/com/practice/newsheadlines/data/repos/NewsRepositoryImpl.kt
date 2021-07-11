package com.practice.newsheadlines.data.repos

import com.practice.newsheadlines.data.source.remote.NewsApiService
import com.practice.newsheadlines.helpers.ResolveApiResponse
import com.practice.newsheadlines.helpers.Results
import com.practice.newsheadlines.model.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

class NewsRepositoryImpl(
    private val newsApiService: NewsApiService,
    private val resolveApiResponse: ResolveApiResponse
) : NewsRepository {

    override suspend fun loadTopHeadlines(
        apiKey: String,
        country: String?,
        category: String?,
        sources: String?,
        query: String?,
        pageSize: Int,
        page: Int
    ): Results<NewsResponse> = withContext(Dispatchers.IO) {

        return@withContext resolveApiResponse.resolve(this.javaClass.name) {
            newsApiService.loadTopHeadlines(
                apiKey,
                country,
                category,
                sources,
                query,
                pageSize,
                page
            )
        }
    }
}
