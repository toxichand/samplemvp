package com.example.vietnam01.samplemvp.app

object Constant {
  object Host {
    const val RENOSY = "Renosy"
    const val AWS = "Aws"
  }
  enum class BaseURL(val URL: String) {RENOSY("http://www.mocky.io/v2/"), AWS("http://www.aws.io/v2/") }
}