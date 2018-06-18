package com.example.vietnam01.samplemvp.di.module

import android.support.v4.app.Fragment
import com.example.vietnam01.samplemvp.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class FragmentModule (var fragment: Fragment) {

  @FragmentScope
  @Provides
  fun provideFragment() = fragment
}