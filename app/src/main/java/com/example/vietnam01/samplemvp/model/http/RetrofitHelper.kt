package com.example.vietnam01.samplemvp.model.http

import com.example.vietnam01.samplemvp.di.qualifier.AwsUrl
import com.example.vietnam01.samplemvp.di.qualifier.RenosyUrl
import com.example.vietnam01.samplemvp.model.http.api.AwsApis
import com.example.vietnam01.samplemvp.model.http.api.RenosyApis
import com.example.vietnam01.samplemvp.model.http.model.User
import com.example.vietnam01.samplemvp.model.http.response.BaseRespond
import io.reactivex.Observable
import javax.inject.Inject
import com.google.gson.JsonObject
import javax.inject.Named

class RetrofitHelper @Inject constructor ( @Named(RenosyApis.TAG) var renosyApiService: RenosyApis, @Named(AwsApis.TAG) var awsApiService: AwsApis) : HttpHelper {

  override fun registerUser(name: String, password: String, fullName: String): Observable<BaseRespond<User>> {
    val params = JsonObject()
    params.addProperty("name", name)
    params.addProperty("password", password)
    params.addProperty("fullName", fullName)
    return renosyApiService.registerUser(params)
  }
}