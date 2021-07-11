package com.practice.newsheadlines.data.repos

import com.practice.newsheadlines.data.ServerConstant
import com.practice.newsheadlines.helpers.Results
import com.practice.newsheadlines.model.NewsResponse


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

interface NewsRepository {

    suspend fun loadTopHeadlines(
        apiKey: String,
        country: String?,
        category: String?,
        sources: String?,
        query: String?,
        pageSize: Int = ServerConstant.DEFAULT_PAGE_SIZE,
        page: Int
    ): Results<NewsResponse>
}
