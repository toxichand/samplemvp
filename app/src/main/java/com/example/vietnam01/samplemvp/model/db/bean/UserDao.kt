package com.example.vietnam01.samplemvp.model.db.bean

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.vietnam01.samplemvp.model.db.entity.User

@Dao
interface UserDao {

  @Query("SELECT * FROM user LIMIT 1")
  fun getUser(): User

  @Update
  fun updateUser(user: User)

  @Insert
  fun insertUser(user: User): Long
}