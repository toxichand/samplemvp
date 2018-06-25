package com.example.vietnam01.samplemvp.presenter.news

import android.util.Log
import com.example.vietnam01.samplemvp.base.RxPresenter
import com.example.vietnam01.samplemvp.base.contact.news.NewsContact
import com.example.vietnam01.samplemvp.model.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import io.reactivex.schedulers.Schedulers

class NewsPresenter @Inject constructor(private val dataManager: DataManager): RxPresenter<NewsContact.View>(), NewsContact.Presenter {

  override fun getNews() {
    dataManager.fetchNews().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe ({
          if (it.isSuccessful) {
            it.body()?.let {
              view?.displayNews(it)
            }
          }
        }, {
          Log.d(it.message, it.message)
        })
  }
}
