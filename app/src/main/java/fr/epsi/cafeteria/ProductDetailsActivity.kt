package fr.epsi.cafeteria

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }
        showBack()

        val imgView = findViewById<ImageView>(R.id.imgViewProductDetails)
        val urlImage = intent.getStringExtra("productUrl")
        Picasso.get().load(urlImage).error(R.drawable.no_image).into(imgView)

        val txtView = findViewById<TextView>(R.id.txtViewProductDetails)
        val description = intent.getStringExtra("description")
        txtView.text = description

    }
}