package com.example.vietnam01.samplemvp.base

interface BasePresenter<in T: BaseView> {

  fun attachView(view: T)

  fun detachView()
}