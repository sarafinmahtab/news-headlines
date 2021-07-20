package com.practice.newsheadlines.ui.newsheadlines.adapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.practice.newsheadlines.R
import com.practice.newsheadlines.databinding.ItemNewsBinding
import com.practice.newsheadlines.model.NewsArticle


/*
 * Created by Arafin Mahtab on 7/11/2021.
 */

class NewsAdapter(
    private val glideRequestManager: RequestManager
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mDiffer = AsyncListDiffer(this, NewsDiffUtil())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemNewsBinding =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemNewsBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mDiffer.currentList[position]
        (holder as NewsViewHolder).bind(item)
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    fun submitList(list: List<NewsArticle>) {
        mDiffer.submitList(list)
    }

    inner class NewsViewHolder(
        private val itemNewsBinding: ItemNewsBinding
    ) : RecyclerView.ViewHolder(itemNewsBinding.root) {

        fun bind(newsArticle: NewsArticle) {
            glideRequestManager
                .load(newsArticle.urlToImage)
                .apply {
                    placeholder(ColorDrawable(Color.GRAY))
                    diskCacheStrategy(DiskCacheStrategy.ALL)
                }
                .into(itemNewsBinding.newsPosterImage)

            itemNewsBinding.newsTitle.text = newsArticle.title
            itemNewsBinding.newsSourceText.text =
                newsArticle.source?.name ?: itemView.context.getString(R.string.none)
        }
    }
}
