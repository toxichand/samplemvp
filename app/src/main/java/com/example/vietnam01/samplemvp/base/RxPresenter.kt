package com.example.vietnam01.samplemvp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class RxPresenter<T: BaseView>: BasePresenter<T> {
  protected var view: T? = null
  protected var compositeDisposable: CompositeDisposable? = null

  override fun attachView(view: T) {
    this.view = view
  }

  override fun detachView() {
    this.view = null
    unSubscribe()
  }

   protected fun unSubscribe() {
     compositeDisposable?.clear()
    }

    protected fun addSubscribe(subscription: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(subscription)
    }

}
