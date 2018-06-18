package com.example.vietnam01.samplemvp.model

import com.example.vietnam01.samplemvp.model.http.HttpHelper
import com.example.vietnam01.samplemvp.model.http.model.User
import com.example.vietnam01.samplemvp.model.http.response.BaseRespond
import com.example.vietnam01.samplemvp.model.prefs.PreferencesHelper
import io.reactivex.Observable

class DataManager(var httpHelper: HttpHelper, var preferencesHelper: PreferencesHelper) : HttpHelper, PreferencesHelper {

  //========================================= NETWORK APIS ===================================
  override fun registerUser(name: String, password: String, fullName: String): Observable<BaseRespond<User>> {
    return httpHelper.registerUser(name, password, fullName)
  }

  //========================================= SHARED PREFERENCES ===================================
  override fun saveUser(user: User) {
    preferencesHelper.saveUser(user)
  }

  override fun getUser(): User? {
    return preferencesHelper.getUser()
  }
}