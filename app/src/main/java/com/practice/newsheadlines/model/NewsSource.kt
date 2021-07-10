package com.practice.newsheadlines.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

@Parcelize
data class NewsSource(
    @field:SerializedName("id")
    val id: String? = null,
    @field:SerializedName("name")
    val name: String? = null
) : Parcelable
