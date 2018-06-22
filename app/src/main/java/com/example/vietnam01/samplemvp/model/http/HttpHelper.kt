package com.example.vietnam01.samplemvp.model.http

import com.example.vietnam01.samplemvp.model.http.model.News
import com.example.vietnam01.samplemvp.model.http.model.Photo
import com.example.vietnam01.samplemvp.model.http.model.User
import io.reactivex.Observable
import retrofit2.Response

interface HttpHelper {
  fun fetchUser(): Observable<Response<User>>
  fun fetchNews(): Observable<Response<News>>
  fun downloadPhoto(): Observable<Response<Photo>>
  fun uploadPhoto(photo: Photo): Observable<Response<Photo>>
}