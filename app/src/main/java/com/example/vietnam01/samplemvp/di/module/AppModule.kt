package com.example.vietnam01.samplemvp.di.module

import com.example.vietnam01.samplemvp.app.App
import com.example.vietnam01.samplemvp.model.DataManager
import com.example.vietnam01.samplemvp.model.db.AppDatabase
import com.example.vietnam01.samplemvp.model.http.HttpHelper
import com.example.vietnam01.samplemvp.model.http.RetrofitHelper
import com.example.vietnam01.samplemvp.model.prefs.PreferencesHelper
import com.example.vietnam01.samplemvp.model.prefs.PreferencesHelperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.example.vietnam01.samplemvp.model.db.DBHelper
import com.example.vietnam01.samplemvp.model.db.RoomHelper

@Module
class AppModule(private val application: App) {

  @Provides
  @Singleton
  fun provideApplicationContext(): App = application

  @Provides
  @Singleton
  fun provideHttpHelper(retrofitHelper: RetrofitHelper) : HttpHelper {
    return  retrofitHelper
  }

  @Provides
  @Singleton
  fun providePreferencesHelper(preferencesHelperImpl: PreferencesHelperImpl) : PreferencesHelper  = preferencesHelperImpl

  @Provides
  @Singleton
  fun provideDBHelper(roomHelperImpl: RoomHelper): DBHelper {
    return roomHelperImpl
  }

  @Provides
  @Singleton
  fun provideAppDatabase(app: App): AppDatabase {
    return AppDatabase.getInstance(app.applicationContext)
  }

  @Provides
  @Singleton
  fun provideDataManager(httpHelper: HttpHelper, dbHelper: DBHelper, preferencesHelper: PreferencesHelper) = DataManager(httpHelper, dbHelper, preferencesHelper)
}