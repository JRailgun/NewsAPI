package com.example.pmp4

data class News(
        val totalArticles: Int,
        val articles: List<Articles>
)

data class Articles (
        val title: String?,
        val description: String?,
        val content: String,
        val url: String?,
        val image: String?,
        val publishedAt: String?,
        val source: Source
)

data class Source(
        val name: String?,
        val url: String?
)