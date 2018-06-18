package com.example.vietnam01.samplemvp.di.module

import com.example.vietnam01.samplemvp.app.App
import com.example.vietnam01.samplemvp.model.DataManager
import com.example.vietnam01.samplemvp.model.http.HttpHelper
import com.example.vietnam01.samplemvp.model.http.RetrofitHelper
import com.example.vietnam01.samplemvp.model.prefs.PreferencesHelper
import com.example.vietnam01.samplemvp.model.prefs.PreferencesHelperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

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
  fun provideDataManager(httpHelper: HttpHelper, preferencesHelper: PreferencesHelper) = DataManager(httpHelper, preferencesHelper)
}