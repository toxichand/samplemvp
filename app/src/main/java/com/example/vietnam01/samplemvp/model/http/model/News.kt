package com.example.vietnam01.samplemvp.model.http.model

import com.squareup.moshi.Json

data class News(
  @Json(name = "news") val news: List<NewsContent>
)

data class NewsContent(
  @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String
)