package com.example.palpalkhabar.`Retero-fit`

import com.example.palpalkhabar.model.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY ="21fc137255d647f2aa6515a0b284d6fd"
interface ReterofitService {

    @GET("v2/top-headlines$API_KEY")
    fun getNewsList(@Query("country") countryCode: String = "in") : Call<MutableList<Article>>
}