package fr.epsi.cafeteria

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class WebServiceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
        setHeaderTitle("Rayons")
        showBack()

        val products = arrayListOf<Product>()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val productAdapter = ProductAdapter(products)
        recyclerView.adapter=productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val requestUrl="http://djemam.com/epsi/categories.json"
        val request = Request.Builder()
            .url(requestUrl)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null){
                    val jsProducts = JSONObject(data)
                    val jsArrayProducts= jsProducts.getJSONArray("items")
                    for(i in 0 until jsArrayProducts.length()){
                        val jsProduct = jsArrayProducts.getJSONObject(i)
                        val product = Product(jsProduct.optString("title",""),
                            jsProduct.optString("category_id",""),
                            jsProduct.optString("products_url",""))
                        products.add(product)
                        Log.d("product",product.name)
                    }
                    Log.d("Product","${products.size}")
                    runOnUiThread(Runnable {
                        productAdapter.notifyDataSetChanged()
                    })
                }
            }

        })
    }
}