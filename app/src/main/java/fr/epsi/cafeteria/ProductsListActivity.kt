package fr.epsi.cafeteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProductsListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        showBack()
    }
}