package com.example.palpalkhabar.Reterofi

import com.example.palpalkhabar.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReterofitService {

    @GET("v2/top-headlines")
    fun getNews(@Query("country") countryCode: String = "in",
                @Query("apiKey") apiKey: String = "21fc137255d647f2aa6515a0b284d6fd") : Call<Response>
}