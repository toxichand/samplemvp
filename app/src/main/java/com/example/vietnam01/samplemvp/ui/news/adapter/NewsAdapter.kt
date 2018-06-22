package com.example.vietnam01.samplemvp.ui.news.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.vietnam01.samplemvp.R
import com.example.vietnam01.samplemvp.model.http.model.NewsContent

class NewsAdapter(val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
  var dataSource: List<NewsContent>? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_new, parent, false))

  override fun getItemCount(): Int = dataSource?.size ?: 0

  override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
    dataSource?.let {
      holder.tvTitle.text = it[position].title
      holder.tvContent.text = it[position].content
    }
  }

  inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.tvTitle)
    lateinit var tvTitle: TextView
    @BindView(R.id.tvContent)
    lateinit var tvContent: TextView

    init {
      ButterKnife.bind(this, itemView)
    }

  }
}