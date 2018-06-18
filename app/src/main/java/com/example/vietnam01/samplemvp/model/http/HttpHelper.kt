package com.example.vietnam01.samplemvp.model.http

import com.example.vietnam01.samplemvp.model.http.model.User
import com.example.vietnam01.samplemvp.model.http.response.BaseRespond
import io.reactivex.Observable

interface HttpHelper {
  fun registerUser(name: String, password: String, fullName: String): Observable<BaseRespond<User>>

}