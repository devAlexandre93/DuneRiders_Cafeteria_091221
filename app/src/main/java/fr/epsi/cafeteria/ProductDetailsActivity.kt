package fr.epsi.cafeteria

import android.os.Bundle

class ProductDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        showBack()
    }
}