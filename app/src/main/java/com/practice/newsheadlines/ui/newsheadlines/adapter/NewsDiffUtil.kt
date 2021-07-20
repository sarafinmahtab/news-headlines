package com.practice.newsheadlines.ui.newsheadlines.adapter

import androidx.recyclerview.widget.DiffUtil
import com.practice.newsheadlines.model.NewsArticle


/*
 * Created by Arafin Mahtab on 7/11/2021.
 */

class NewsDiffUtil : DiffUtil.ItemCallback<NewsArticle>() {

    override fun areItemsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewsArticle, newItem: NewsArticle): Boolean {
        return oldItem == newItem
    }
}
