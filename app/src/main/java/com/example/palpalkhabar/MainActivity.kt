package com.example.palpalkhabar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.palpalkhabar.Reterofi.Common
import com.example.palpalkhabar.Reterofi.ReterofitService

import com.example.palpalkhabar.adapter.neewsAdapter
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var mService: ReterofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var mAdapter: neewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //recyclerView=findViewById(R.id.recyclerview)
        mService= Common.reterofitService
        news_recyclerview.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        news_recyclerview.layoutManager=layoutManager


        getNews()

    }

    private fun getNews() {
        mService.getNews().enqueue(object :Callback<com.example.palpalkhabar.Response>{
            override fun onResponse(call: Call<com.example.palpalkhabar.Response>, response: Response<com.example.palpalkhabar.Response>) {
                val newsList=response.body()!!.articles
                mAdapter=neewsAdapter(newsList)
                news_recyclerview.adapter=mAdapter

            }

            override fun onFailure(call: Call<com.example.palpalkhabar.Response>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}
