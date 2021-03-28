package com.example.palpalkhabar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.palpalkhabar.`Retero-fit`.Common
import com.example.palpalkhabar.`Retero-fit`.ReterofitService
import com.example.palpalkhabar.adapter.neewsAdapter
import com.example.palpalkhabar.model.Article
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: ReterofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var areeb: neewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mService=Common.reterofitService

        recyclerview.setHasFixedSize(true)
        layoutManager= LinearLayoutManager(this)
        recyclerview.layoutManager=layoutManager


        getNews()

    }

    private fun getNews() {
        
        mService.getNewsList().enqueue(object : Callback<MutableList<Article>> {
            override fun onResponse(call: Call<MutableList<Article>>, response: Response<MutableList<Article>>) {
                areeb= neewsAdapter(response.body() as MutableList<Article>)
                areeb.notifyDataSetChanged()
                recyclerview.adapter=areeb
            }

            override fun onFailure(call: Call<MutableList<Article>>, t: Throwable) {

            }


        })
    }


}
