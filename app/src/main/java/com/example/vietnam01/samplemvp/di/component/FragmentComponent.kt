package com.example.vietnam01.samplemvp.di.component

import android.support.v4.app.Fragment
import com.example.vietnam01.samplemvp.di.module.FragmentModule
import com.example.vietnam01.samplemvp.di.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(dependencies = [AppComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

  fun getFragment(): Fragment
//  fun inject(activity: Activity)
}