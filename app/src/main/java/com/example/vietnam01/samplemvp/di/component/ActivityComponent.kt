package com.example.vietnam01.samplemvp.di.component

import android.app.Activity
import com.example.vietnam01.samplemvp.di.module.ActivityModule
import com.example.vietnam01.samplemvp.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

  fun getActivity(): Activity
  fun inject(activity: Activity)
}