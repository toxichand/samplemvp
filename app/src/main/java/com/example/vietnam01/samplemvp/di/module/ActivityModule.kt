package com.example.vietnam01.samplemvp.di.module

import android.app.Activity
import com.example.vietnam01.samplemvp.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: Activity) {

  @ActivityScope
  @Provides
  fun provideActivity() = activity
}