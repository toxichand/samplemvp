package com.example.vietnam01.samplemvp.di.component

import com.example.vietnam01.samplemvp.di.module.AppModule
import com.example.vietnam01.samplemvp.di.module.HttpModule
import com.example.vietnam01.samplemvp.model.DataManager
import com.google.gson.Gson
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, HttpModule::class])
interface AppComponent {
  fun getDataManager(): DataManager
  fun getGson(): Gson
}