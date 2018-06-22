package com.example.vietnam01.samplemvp.model.http

import com.example.vietnam01.samplemvp.model.http.api.PhotoApis
import com.example.vietnam01.samplemvp.model.http.api.NewApis
import com.example.vietnam01.samplemvp.model.http.api.UserApis
import com.example.vietnam01.samplemvp.model.http.model.News
import com.example.vietnam01.samplemvp.model.http.model.Photo
import com.example.vietnam01.samplemvp.model.http.model.User
import io.reactivex.Observable
import javax.inject.Inject
import retrofit2.Response
import javax.inject.Named

class RetrofitHelper @Inject constructor (@Named(NewApis.NAME) var newApiService: NewApis,
                                          @Named(UserApis.NAME) var userApiService: UserApis,
                                          @Named(PhotoApis.NAME) var photoApiService: PhotoApis) : HttpHelper {

  override fun fetchUser(): Observable<Response<User>> {
    return userApiService.fetchUser()
  }

  override fun fetchNews(): Observable<Response<News>> {
    return newApiService.fetchNews()
  }

  override fun downloadPhoto(): Observable<Response<Photo>> {
    return photoApiService.downloadPhoto()
  }

  override fun uploadPhoto(photo: Photo): Observable<Response<Photo>> {
    return photoApiService.uploadPhoto(photo)
  }
}