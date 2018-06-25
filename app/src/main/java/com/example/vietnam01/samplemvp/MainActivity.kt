package com.example.vietnam01.samplemvp

import android.content.Intent
import android.view.View
import butterknife.OnClick
import com.example.vietnam01.samplemvp.base.SimpleActivity
import com.example.vietnam01.samplemvp.ui.news.activity.NewsActivity
import com.example.vietnam01.samplemvp.ui.profile.activity.ProfileActivity

class MainActivity : SimpleActivity() {


  override fun getLayout(): Int {
    return R.layout.activity_main
  }

  override fun initEventAndData() {
  }

  @OnClick(R.id.btnDetail)
  fun openDetail(view: View) {
    val intent = Intent(MainActivity@ this, ProfileActivity::class.java)
    startActivity(intent)
  }

  @OnClick(R.id.btnList)
  fun openNews(view: View) {
    val intent = Intent(MainActivity@ this, NewsActivity::class.java)
    startActivity(intent)
  }

}
