package com.example.vietnam01.samplemvp.model.http.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "first_name") val firstName: String,
    @Json(name = "last_name") val lastName: String,
    @Json(name = "age") val age: Int
)