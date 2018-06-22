package com.example.vietnam01.samplemvp.base.contact.profile

import com.example.vietnam01.samplemvp.base.BaseView
import com.example.vietnam01.samplemvp.model.http.model.User

interface ProfileContact {
  interface View : BaseView{
    fun displayProfile(user: User)
  }

  interface Presenter {
    fun getProfile()
  }
}