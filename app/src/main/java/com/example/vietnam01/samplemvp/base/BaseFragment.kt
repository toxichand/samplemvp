package com.example.vietnam01.samplemvp.base

import android.os.Bundle
import android.view.View
import com.example.vietnam01.samplemvp.app.App
import com.example.vietnam01.samplemvp.di.component.DaggerFragmentComponent
import com.example.vietnam01.samplemvp.di.component.FragmentComponent
import com.example.vietnam01.samplemvp.di.module.FragmentModule
import javax.inject.Inject

abstract class BaseFragment<in V: BaseView, P: BasePresenter<V>>: SimpleFragment(), BaseView {
  @Inject
  lateinit var presenter : P

  protected val fragmentComponent: FragmentComponent
    get() = DaggerFragmentComponent.builder()
        .appComponent(App.appComponent)
        .fragmentModule(fragmentModule)
        .build()

  private val fragmentModule: FragmentModule
    get() = FragmentModule(this)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    initInject()
    presenter.attachView(this as V)
    super.onViewCreated(view, savedInstanceState)
  }
  override fun onDestroyView() {
    presenter.detachView()
    super.onDestroyView()
  }

  protected abstract fun initInject()
}