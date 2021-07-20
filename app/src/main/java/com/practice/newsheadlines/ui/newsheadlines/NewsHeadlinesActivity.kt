package com.practice.newsheadlines.ui.newsheadlines

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.practice.newsheadlines.BuildConfig
import com.practice.newsheadlines.data.repos.NewsRepositoryFactory
import com.practice.newsheadlines.data.source.remote.NetworkClient
import com.practice.newsheadlines.databinding.ActivityNewsHeadlinesBinding
import com.practice.newsheadlines.helpers.ResolveApiResponse
import com.practice.newsheadlines.helpers.extensions.viewModelProvider
import com.practice.newsheadlines.ui.newsheadlines.adapter.NewsAdapter

/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

class NewsHeadlinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsHeadlinesBinding

    private lateinit var viewModel: NewsViewModel

    private lateinit var newsAdapter: NewsAdapter

    private var mCategory: String? = "technology"

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

        newsAdapter = NewsAdapter(Glide.with(this))
        binding.newsList.layoutManager = LinearLayoutManager(this)
        binding.newsList.adapter = newsAdapter

        viewModel.loading.observe(this, {
            if (it) {
                binding.progressBar.show()
            } else {
                binding.progressBar.hide()
            }
        })

        viewModel.errorResult.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

        viewModel.newsArticles.observe(this, {
            newsAdapter.submitList(it)
        })

        viewModel.loadNewsHeadlines(category = mCategory)
    }
}
