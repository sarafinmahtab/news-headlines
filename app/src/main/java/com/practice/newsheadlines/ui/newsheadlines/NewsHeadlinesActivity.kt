package com.practice.newsheadlines.ui.newsheadlines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practice.newsheadlines.databinding.ActivityNewsHeadlinesBinding

/*
 * Created by Arafin Mahtab on 7/10/2021.
 */

class NewsHeadlinesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsHeadlinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsHeadlinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: Implement News Headlines Functionality
    }
}
