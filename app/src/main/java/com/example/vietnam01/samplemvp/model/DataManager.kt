package com.example.vietnam01.samplemvp.model

import com.example.vietnam01.samplemvp.model.db.DBHelper
import com.example.vietnam01.samplemvp.model.http.HttpHelper
import com.example.vietnam01.samplemvp.model.http.model.News
import com.example.vietnam01.samplemvp.model.http.model.Photo
import com.example.vietnam01.samplemvp.model.http.model.User
import com.example.vietnam01.samplemvp.model.db.entity.User as UserEntity
import com.example.vietnam01.samplemvp.model.prefs.PreferencesHelper
import io.reactivex.Observable
import retrofit2.Response

class DataManager(private var httpHelper: HttpHelper, private var dbHelper: DBHelper, private var preferencesHelper: PreferencesHelper) : HttpHelper, DBHelper, PreferencesHelper {

  //========================================= NETWORK ==============================================
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

  //========================================= DATABASE =============================================

  override fun updateUser(user: UserEntity) {
    dbHelper.updateUser(user)
  }

  override fun insertUser(user: UserEntity): Long {
    return dbHelper.insertUser(user)
  }

  override fun getUser(): UserEntity {
    return dbHelper.getUser()
  }

  //========================================= SHARED PREFERENCES ===================================
  override fun saveUser(user: User) {
    preferencesHelper.saveUser(user)
  }

  override fun restoreUser(): User? {
    return preferencesHelper.restoreUser()
  }
}