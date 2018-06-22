package com.example.vietnam01.samplemvp.di.component

import android.app.Activity
import com.example.vietnam01.samplemvp.di.module.ActivityModule
import com.example.vietnam01.samplemvp.di.scope.ActivityScope
import com.example.vietnam01.samplemvp.ui.news.activity.NewsActivity
import com.example.vietnam01.samplemvp.ui.profile.ProfileActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

  fun getActivity(): Activity
  fun inject(profileActivity: ProfileActivity)
  fun inject(newsActivity: NewsActivity)
}