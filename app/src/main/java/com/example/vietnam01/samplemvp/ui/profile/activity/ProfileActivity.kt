package com.example.vietnam01.samplemvp.ui.profile.activity

import android.widget.TextView
import butterknife.BindView
import com.example.vietnam01.samplemvp.R
import com.example.vietnam01.samplemvp.base.BaseActivity
import com.example.vietnam01.samplemvp.base.contact.profile.ProfileContact
import com.example.vietnam01.samplemvp.model.http.model.User
import com.example.vietnam01.samplemvp.presenter.profile.ProfilePresenter

class ProfileActivity: BaseActivity<ProfileContact.View, ProfilePresenter>(), ProfileContact.View {

  @BindView(R.id.tvFirstName)
  lateinit var tvFirsName: TextView
  @BindView(R.id.tvLastName)
  lateinit var tvLastName: TextView
  @BindView(R.id.tvAge)
  lateinit var tvAge: TextView

  override fun initInject() {
    activityComponent.inject(this)
  }

  override fun initEventAndData() {
    presenter.getProfile()
  }

  override fun getLayout(): Int {
    return R.layout.activity_user_profile
  }

  override fun displayProfile(user: User) {
    tvFirsName.text = user.firstName
    tvLastName.text = user.lastName
    tvAge.text = user.age.toString()
  }
}