package com.example.palpalkhabar.Reterofi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReterofitClient {
    private var retrofit: Retrofit? = null

    fun getClient (baseurl:String):Retrofit{
        val client = OkHttpClient.Builder().build()

        if(retrofit == null){
            retrofit=Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
        }
        return retrofit!!

    }
}