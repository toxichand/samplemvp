package com.example.vietnam01.samplemvp.model.http.api

import com.example.vietnam01.samplemvp.model.http.model.Photo
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PhotoApis {
  companion object {
    const val NAME = "PhotoApis"
  }

  @GET("download/photo")
  fun downloadPhoto(): Observable<Response<Photo>>

  @POST("upload/photo")
  fun uploadPhoto(@Body photo: Photo): Observable<Response<Photo>>
}