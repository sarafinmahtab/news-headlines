package com.practice.newsheadlines.ui.newsheadlines

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.newsheadlines.BuildConfig
import com.practice.newsheadlines.data.repos.NewsRepository
import com.practice.newsheadlines.helpers.Results
import com.practice.newsheadlines.model.NewsArticle
import kotlinx.coroutines.launch


/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private var pageNo = 1

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _newsArticles = MutableLiveData<List<NewsArticle>>()
    val newsArticles: LiveData<List<NewsArticle>> = _newsArticles

    private val _errorResult = MutableLiveData<String>()
    val errorResult: LiveData<String> = _errorResult

    fun loadNewsHeadlines(
        country: String? = null,
        category: String? = null,
        sources: String? = null,
        query: String? = null
    ) {
        viewModelScope.launch {
            _loading.postValue(true)

            val result = repository.loadTopHeadlines(
                apiKey = BuildConfig.API_TOKEN,
                country = country,
                category = category,
                sources = sources,
                query = query,
                page = pageNo
            )

            when (result) {
                is Results.Failure -> {
                    _loading.postValue(false)
                    _errorResult.postValue(result.throwable.toString())
                    Log.w(TAG, result.throwable)
                }
                is Results.Success -> {
                    _loading.postValue(false)
                    _newsArticles.postValue(result.value.articles)
                }
            }
        }
    }

    companion object {
        private const val TAG = "NewsViewModel"
    }
}
