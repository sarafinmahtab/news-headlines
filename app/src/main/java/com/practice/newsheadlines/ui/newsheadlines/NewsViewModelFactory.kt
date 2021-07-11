package com.practice.newsheadlines.ui.newsheadlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.newsheadlines.data.repos.NewsRepository


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

class NewsViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            NewsViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
