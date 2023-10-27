package com.example.pmp4

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("top-headlines?category=technology&apikey=4f492880d787190800d53586ed702e7c&lang=ru")
    fun getNews() :Call<News>
}