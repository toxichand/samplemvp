package com.example.vietnam01.samplemvp.app

import android.app.Application
import com.example.vietnam01.samplemvp.di.component.AppComponent
import com.example.vietnam01.samplemvp.di.component.DaggerAppComponent
import com.example.vietnam01.samplemvp.di.module.AppModule
import com.example.vietnam01.samplemvp.di.module.HttpModule

class App: Application() {
  override fun onCreate() {
    super.onCreate()
    instance = this
  }

  companion object {
    lateinit var instance: App
    val appComponent: AppComponent by lazy {
      DaggerAppComponent.builder().appModule(AppModule(instance))
          .httpModule(HttpModule())
          .build()
    }
  }
}