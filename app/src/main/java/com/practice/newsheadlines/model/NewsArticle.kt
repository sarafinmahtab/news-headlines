package com.practice.newsheadlines.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

@Parcelize
data class NewsArticle(
    @field:SerializedName("source")
    val source: NewsSource? = null,
    @field:SerializedName("author")
    val author: String? = null,
    @field:SerializedName("title")
    val title: String? = null,
    @field:SerializedName("description")
    val description: String? = null,
    @field:SerializedName("url")
    val url: String? = null,
    @field:SerializedName("urlToImage")
    val urlToImage: String? = null,
    @field:SerializedName("publishedAt")
    val publishedAt: Date? = Date(),
) : Parcelable
