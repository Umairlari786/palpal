package com.example.palpalkhabar.Reterofi

object Common {

    private val BASE_URL ="https://newsapi.org/"

    val reterofitService:ReterofitService
        get() = ReterofitClient.getClient(BASE_URL).create(ReterofitService::class.java)
}