package fr.epsi.cafeteria

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class ProductsListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        showBack()
        val url = intent.getStringExtra("productsUrl")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProductsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productsList = ProductsList(listOf())
        val productsListAdapter = ProductsListAdapter(productsList)
        recyclerView.adapter = productsListAdapter

        if (url != null) {
            fetchJson(url)
        }
    }

    fun fetchJson(url: String) {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url(url)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                val gson = GsonBuilder().create()
                val productsList = gson.fromJson(data, ProductsList::class.java)
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProductsList)
                val productsListAdapter = ProductsListAdapter(productsList)
                runOnUiThread {
                    recyclerView.adapter = productsListAdapter
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

}

class ProductsList(val items: List<Product>)

class Product(val name: String, val description: String, val picture_url: String)