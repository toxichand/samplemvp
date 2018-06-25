package com.example.vietnam01.samplemvp.model.http.api

import com.example.vietnam01.samplemvp.model.http.model.News
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface NewApis {
  companion object {
    const val NAME = "NewApis"
  }

  @GET("5b2b038a3000004c009cd528")
  fun fetchNews(): Observable<Response<News>>
}