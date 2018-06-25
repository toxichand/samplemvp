package com.example.vietnam01.samplemvp.model.db

import com.example.vietnam01.samplemvp.model.db.entity.User
import javax.inject.Inject

class RoomHelper @Inject constructor(private val appDatabase: AppDatabase) : DBHelper {

  override fun getUser(): User {
    return appDatabase.userDao().getUser()
  }

  override fun updateUser(user: User) {
    appDatabase.userDao().updateUser(user)
  }

  override fun insertUser(user: User): Long {
    return appDatabase.userDao().insertUser(user)
  }
}