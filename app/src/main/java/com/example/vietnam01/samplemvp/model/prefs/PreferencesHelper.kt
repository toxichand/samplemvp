package com.example.vietnam01.samplemvp.model.prefs

import com.example.vietnam01.samplemvp.model.http.model.User

interface PreferencesHelper {

  fun saveUser(user: User)
  fun getUser(): User?
}