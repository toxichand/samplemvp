package com.example.vietnam01.samplemvp.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class SimpleFragment: Fragment() {
  protected var rootView: View? = null
  protected var mActivity: Activity? = null
  protected var mContext: Context? = null
  private var mUnBinder: Unbinder? = null

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    mActivity = context as Activity?
    mContext = context
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    super.onCreateView(inflater, container, savedInstanceState)
    rootView = inflater.inflate(getLayoutId(), null)
    return rootView
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mUnBinder = ButterKnife.bind(this, view)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    dismissLoading()
    mUnBinder?.unbind()
  }

  fun showLoading() {
  }

  fun dismissLoading() {

  }

  protected abstract fun initEventAndData()
  protected abstract fun getLayoutId(): Int
}