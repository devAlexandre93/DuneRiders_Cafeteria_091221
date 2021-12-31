package fr.epsi.cafeteria

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        setHeaderTitle("Rayons")
        showBack()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchJson()
    }

    fun fetchJson() {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = "https://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                val gson = GsonBuilder().create()
                val categoryList = gson.fromJson(data, CategoryList::class.java)
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
                val categoryAdapter = CategoryAdapter(categoryList)
                runOnUiThread {
                    recyclerView.adapter = categoryAdapter
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

}

class CategoryList (val items: List<Category>)

class Category(val category_id: String, val title: String, val products_url: String)