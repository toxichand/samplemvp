package com.example.vietnam01.samplemvp.di.component

import com.example.vietnam01.samplemvp.app.App
import com.example.vietnam01.samplemvp.di.module.AppModule
import com.example.vietnam01.samplemvp.di.module.HttpModule
import com.example.vietnam01.samplemvp.model.DataManager
import dagger.Component
import javax.inject.Singleton
import com.example.vietnam01.samplemvp.model.http.RetrofitHelper



@Singleton
@Component(modules = [AppModule::class, HttpModule::class])
interface AppComponent {
  fun getDataManager(): DataManager
}