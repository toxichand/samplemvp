package com.example.vietnam01.samplemvp.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class SimpleActivity: AppCompatActivity() {

  protected var mContext: Activity? = null
//  private var loadingDialog: LoadingDialog? = null
  private var mUnBinder: Unbinder? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayout())
//    loadingDialog = LoadingDialog(this)
    mUnBinder = ButterKnife.bind(this)
    mContext = this
    onViewCreated()
    initEventAndData()
  }

  protected fun setToolBar(toolbar: Toolbar, title: String) {
    toolbar.title = title
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
    toolbar.setNavigationOnClickListener { onBackPressed() }
  }

  protected open fun onViewCreated() {

  }

  fun replaceFragment(containerId: Int, fragment: Fragment, tag: String) {
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(containerId, fragment, tag)
    transaction.addToBackStack(tag)
    transaction.commit()
  }

  fun addFragment(containerId: Int, fragment: Fragment, tag: String, isAddToBackStack: Boolean) {
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.add(containerId, fragment, tag)
    if (isAddToBackStack) {
      transaction.addToBackStack(tag)
    }
    transaction.commit()
  }

  override fun onDestroy() {
    super.onDestroy()
    mUnBinder?.unbind()
  }

  protected abstract fun initEventAndData()
  protected abstract fun getLayout(): Int

}