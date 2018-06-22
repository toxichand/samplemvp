package com.example.vietnam01.samplemvp.base

interface BaseView {
  fun showLoading()
  fun dismissLoading()
  fun showError(message: String)
}