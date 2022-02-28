package com.example.currentworld

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.currentworld.models.News
import com.example.currentworld.repository.Repository
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(),NewItemsClicked{

    private lateinit var mAdapter:NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {




        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.recylerViewId)
        recyclerView.layoutManager=LinearLayoutManager(this)

       // val store=DataSource()
        lateinit var repo:Repository

        repo.fetchData()


        // mAdapter.updateNews(newsArray


       mAdapter=NewsAdapter(this)



        recyclerView.adapter = mAdapter


    }




    override fun onItemClicked(item: News) {

        val builder = CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.url));
    }
}