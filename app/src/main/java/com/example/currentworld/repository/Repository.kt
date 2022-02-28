package com.example.currentworld.repository

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.currentworld.MySingleton
import com.example.currentworld.NewsAdapter
import com.example.currentworld.models.News

class Repository{




    private lateinit var mAdapter: NewsAdapter
    fun fetchData()
    {
        val url="https://gnews.io/api/v4/search?q=example&token=71e8bdb3991d232b18429ae953385b4f&lang=en"

        val jsonObjectRequest: JsonObjectRequest =
            JsonObjectRequest(Request.Method.GET,url,null, { response->


            //Toast.makeText(this,"Success", Toast.LENGTH_LONG).show()


            val newsJsonArray = response.getJSONArray("articles")
            val newsArray=ArrayList<News>()


            for(i in 0 until newsJsonArray.length())
            {
                val newsJsonObject=newsJsonArray.getJSONObject(i)

                val news= News(




                    newsJsonObject.getString("image"),

                    newsJsonObject.getString("title"),
                    newsJsonObject.getString("description"),
                    //  newsJsonObject.getString("author"),
                    newsJsonObject.getString("url"),
                    //newsJsonObject.getString("urlToImage")


                )


                newsArray.add(news)


            }
                mAdapter.updateNews(newsArray)




        }, {

           // Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()

        }

        )

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }
}