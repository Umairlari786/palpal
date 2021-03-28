package com.example.palpalkhabar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.palpalkhabar.model.Article
import com.example.palpalkhabar.R
import com.squareup.picasso.Picasso

class neewsAdapter( private val news_items:MutableList<Article>):RecyclerView.Adapter<neewsAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var headline:TextView
        var newsImage:ImageView
        init {
            headline=itemView.findViewById(R.id.Head)
            newsImage=itemView.findViewById(R.id.new_image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var news_view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(news_view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.headline.text=news_items[position].title
        Picasso.get().load(news_items[position].urlToImage).into(holder.newsImage)

    }

    override fun getItemCount(): Int {
       return news_items.size
    }
}