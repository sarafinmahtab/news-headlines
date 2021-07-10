package com.practice.newsheadlines.model

import com.google.gson.annotations.SerializedName

/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

data class NewsResponse(
    @field:SerializedName("status")
    val status: String? = null,
    @field:SerializedName("totalResults")
    val totalResults: Int = 0,
    @field:SerializedName("articles")
    val articles: List<NewsArticle>? = null
)
