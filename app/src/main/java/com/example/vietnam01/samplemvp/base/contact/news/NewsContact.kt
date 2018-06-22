package com.example.vietnam01.samplemvp.base.contact.news

import com.example.vietnam01.samplemvp.base.BaseView
import com.example.vietnam01.samplemvp.model.http.model.News
import com.example.vietnam01.samplemvp.model.http.model.User

interface NewsContact {
  interface View : BaseView{
    fun displayNews(news: News)
  }

  interface Presenter {
    fun getNews()
  }
}