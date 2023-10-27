package com.example.pmp4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.mResView)

        val serviceGenerator = ServerGenerator.buildService(ApiService::class.java)
        val call = serviceGenerator.getNews()

        call.enqueue(object : Callback<News> {
            override fun onResponse(
                call: Call<News>,
                response: Response<News>
            ) {
                if(response.isSuccessful){
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = NewsAdapter(response.body()?.articles ?: emptyList())
                    }
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }
        })
    }
}
