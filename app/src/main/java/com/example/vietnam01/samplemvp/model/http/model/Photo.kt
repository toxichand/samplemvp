package com.example.vietnam01.samplemvp.model.http.model

import com.squareup.moshi.Json

data class Photo(
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String
)