package com.example.vietnam01.samplemvp.model

import com.example.vietnam01.samplemvp.model.http.HttpHelper
import com.example.vietnam01.samplemvp.model.http.model.News
import com.example.vietnam01.samplemvp.model.http.model.Photo
import com.example.vietnam01.samplemvp.model.http.model.User
import com.example.vietnam01.samplemvp.model.http.response.BaseRespond
import com.example.vietnam01.samplemvp.model.prefs.PreferencesHelper
import io.reactivex.Observable
import retrofit2.Response

class DataManager(private var httpHelper: HttpHelper, private var preferencesHelper: PreferencesHelper) : HttpHelper, PreferencesHelper {

  override fun fetchUser(): Observable<Response<User>> {
    return httpHelper.fetchUser()
  }

  override fun fetchNews(): Observable<Response<News>> {
    return httpHelper.fetchNews()
  }

  override fun downloadPhoto(): Observable<Response<Photo>> {
    return httpHelper.downloadPhoto()
  }

  override fun uploadPhoto(photo: Photo): Observable<Response<Photo>> {
    return httpHelper.uploadPhoto(photo)
  }

  //========================================= SHARED PREFERENCES ===================================
  override fun saveUser(user: User) {
    preferencesHelper.saveUser(user)
  }

  override fun getUser(): User? {
    return preferencesHelper.getUser()
  }
}