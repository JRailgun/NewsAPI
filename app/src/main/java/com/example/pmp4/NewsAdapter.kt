package com.example.pmp4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val articles: List<Articles>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_news, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(articles[position])
    }
}

class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    private val tvBody: TextView = itemView.findViewById(R.id.tvBody)

    fun bindView(article: Articles) {
        tvTitle.text = article.title
        tvBody.text = article.description
    }
}