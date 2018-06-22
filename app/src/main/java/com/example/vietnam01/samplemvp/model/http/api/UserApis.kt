package com.example.vietnam01.samplemvp.model.http.api

import com.example.vietnam01.samplemvp.model.http.model.User
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface UserApis {
  companion object {
    const val NAME = "UserApis"
  }
  @GET("5b28c1a42f00006300f55e32")
  fun fetchUser(): Observable<Response<User>>
}