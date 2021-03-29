package com.example.palpalkhabar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.palpalkhabar.News
import com.example.palpalkhabar.R
import com.squareup.picasso.Picasso


class neewsAdapter(val news_items: List<News>):RecyclerView.Adapter<neewsAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        var urlToImage = view.findViewById(R.id.new_image) as ImageView
        var head = view.findViewById(R.id.Head) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = news_items[position]
        holder.head.text = current.title
        Picasso.get().load(news_items[position].urlToImage).into(holder.urlToImage)
    }

    override fun getItemCount(): Int {
       return news_items.size
    }
}