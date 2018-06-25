package com.example.vietnam01.samplemvp.presenter.profile

import android.util.Log
import com.example.vietnam01.samplemvp.base.RxPresenter
import com.example.vietnam01.samplemvp.base.contact.profile.ProfileContact
import com.example.vietnam01.samplemvp.model.DataManager
import com.example.vietnam01.samplemvp.model.db.entity.User
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import io.reactivex.schedulers.Schedulers

class ProfilePresenter @Inject constructor(private val dataManager: DataManager): RxPresenter<ProfileContact.View>(), ProfileContact.Presenter {


  override fun getProfile() {
    dataManager.fetchUser().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe ({
          if (it.isSuccessful) {
            it.body()?.let {
              view?.displayProfile(it)
              dataManager.saveUser(it)
              dataManager.insertUser(User(it.firstName, it.lastName, it.age))
            }
          }
        }, {
          Log.d(it.message, it.message)
        })
  }
}
