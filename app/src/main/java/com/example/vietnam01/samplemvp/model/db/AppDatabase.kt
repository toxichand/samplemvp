package com.example.vietnam01.samplemvp.model.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.vietnam01.samplemvp.model.db.bean.UserDao
import com.example.vietnam01.samplemvp.model.db.entity.User

@Database(entities = [
    User::class
], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun userDao(): UserDao

  companion object {
    private const val DB_NAME = "mydb.db"

    fun getInstance(context: Context): AppDatabase {
        synchronized(AppDatabase::class) {
          return Room.databaseBuilder(context.applicationContext,
              AppDatabase::class.java, DB_NAME)
              .allowMainThreadQueries()
              .build()
        }
    }
  }
}