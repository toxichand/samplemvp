package com.example.vietnam01.samplemvp.ui.news.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import com.example.vietnam01.samplemvp.R
import com.example.vietnam01.samplemvp.base.BaseActivity
import com.example.vietnam01.samplemvp.base.contact.news.NewsContact
import com.example.vietnam01.samplemvp.model.http.model.News
import com.example.vietnam01.samplemvp.presenter.news.NewsPresenter
import com.example.vietnam01.samplemvp.ui.news.adapter.NewsAdapter

class NewsActivity: BaseActivity<NewsContact.View, NewsPresenter>(), NewsContact.View {

  @BindView(R.id.rvNews)
  lateinit var rvNews: RecyclerView

  private lateinit var adapter: NewsAdapter

  override fun getLayout(): Int {
    return R.layout.activity_news
  }

  override fun initInject() {
    activityComponent.inject(this)
  }

  override fun initEventAndData() {
    rvNews.layoutManager = LinearLayoutManager(this)
    adapter = NewsAdapter(this)
    rvNews.adapter = adapter
    presenter.getNews()
  }

  override fun displayNews(news: News) {
    adapter.dataSource = news.news
    adapter.notifyDataSetChanged()
  }
}