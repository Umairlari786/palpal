package com.example.palpalkhabar.`Retero-fit`

object Common {
    //private val  Base_url = "https://www.simplifiedcoding.net/demos/"
           private val  Base_url = "https://newsapi.org/"
            //private val Base_api="21fc137255d647f2aa6515a0b284d6fd"
    val  reterofitService:ReterofitService
    get() = ReterofitClient.getClient(Base_url).create(ReterofitService::class.java)

}