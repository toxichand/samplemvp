package com.example.vietnam01.samplemvp.model.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.vietnam01.samplemvp.app.App
import com.example.vietnam01.samplemvp.model.http.model.User
import com.google.gson.Gson
import javax.inject.Inject
import android.text.TextUtils

class PreferencesHelperImpl @Inject constructor(private var gson: Gson) : PreferencesHelper {

  private val sPrefs: SharedPreferences

  init {
    sPrefs = App.instance.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
  }

  override fun saveUser(user: User) {
    val userString = gson.toJson(user)
    sPrefs.edit().putString(SP_USER, userString).apply()
  }

  override fun restoreUser(): User? {
    val userData = sPrefs.getString(SP_USER, DEFAULT_STRING)
    return if (TextUtils.isEmpty(userData)) {
      null
    } else gson.fromJson(userData, User::class.java)
  }

  companion object {
    private const val SHARED_PREFERENCES_NAME = "mvp_sp"
    private const val SP_USER = "sp_user"
    private const val DEFAULT_STRING = ""

  }
}