package com.example.vietnam01.samplemvp.base

import com.example.vietnam01.samplemvp.app.App
import com.example.vietnam01.samplemvp.di.component.ActivityComponent
import com.example.vietnam01.samplemvp.di.component.DaggerActivityComponent
import com.example.vietnam01.samplemvp.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<in V : BaseView, P : BasePresenter<V>> : SimpleActivity(), BaseView {

  @Inject
  protected lateinit var presenter: P

  protected val activityComponent: ActivityComponent
    get() = DaggerActivityComponent.builder()
        .appComponent(App.appComponent)
        .activityModule(activityModule)
        .build()

  private val activityModule: ActivityModule
    get() = ActivityModule(this)

  override fun showLoading() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun dismissLoading() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showError(message: String) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }


  override fun onViewCreated() {
    super.onViewCreated()
    initInject()
    presenter.attachView(this as V)
  }

  override fun onDestroy()
  {
    presenter.detachView()
    super.onDestroy()
  }


  protected abstract fun initInject()
}