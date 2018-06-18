package com.example.vietnam01.samplemvp.model.http.response

import com.google.gson.annotations.SerializedName

class BaseRespond<T>(@SerializedName("status") val status: Boolean,
                     @SerializedName("message") val message: String,
                     @SerializedName("data") val t: T)