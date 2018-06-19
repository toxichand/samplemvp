package com.example.vietnam01.samplemvp.model.http.api

import com.example.vietnam01.samplemvp.model.http.model.User
import com.example.vietnam01.samplemvp.model.http.response.BaseRespond
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/* Renosy APIs related */
interface RenosyApis {
  companion object {
    const val TAG = "RenosyApis"
    const val BASE_URL = "http://aaaa"
  }

  @POST("api/register")
  fun registerUser(@Body params: JsonObject): Observable<BaseRespond<User>>
}