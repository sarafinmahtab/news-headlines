package com.practice.newsheadlines.ui.newsheadlines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practice.newsheadlines.BuildConfig
import com.practice.newsheadlines.data.repos.NewsRepositoryFactory
import com.practice.newsheadlines.data.source.remote.NetworkClient
import com.practice.newsheadlines.databinding.ActivityNewsHeadlinesBinding
import com.practice.newsheadlines.helpers.ResolveApiResponse
import com.practice.newsheadlines.helpers.extensions.viewModelProvider

/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

class NewsHeadlinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsHeadlinesBinding

    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsHeadlinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dependency Injection
        // Retrofit API Service
        val newsApiService = NetworkClient.getNewsApiService(BuildConfig.BASE_URL)
        // Repository
        val repository = NewsRepositoryFactory.getInstance(newsApiService, ResolveApiResponse)
        // ViewModel
        val viewModelFactory = NewsViewModelFactory(repository)
        viewModel = viewModelProvider(viewModelFactory)

        //TODO: Implement News Headlines Functionality
    }
}
