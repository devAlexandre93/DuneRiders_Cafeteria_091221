package fr.epsi.cafeteria

import android.content.Intent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun showBack() {
        val imageViewBack = findViewById<ImageView>(R.id.imageViewBack)
        imageViewBack.visibility = View.VISIBLE
        imageViewBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    fun setHeaderTitle(text: String) {
        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        textViewTitle.text = text
    }

    fun setInfosStudent(text: String) {
        val textViewInfos= findViewById<TextView>(R.id.textViewInfos)
        textViewInfos.text = text
    }

    fun setNameStudent(text: String) {
        val textViewName= findViewById<TextView>(R.id.textViewName)
        textViewName.text = text
    }

    fun setEmailStudent(text: String) {
        val textViewEmail= findViewById<TextView>(R.id.textViewEmail)
        textViewEmail.text = text
    }

    fun goToProductsList(id: String, title: String, productsUrl: String) {
        val newIntent = Intent(application, ProductsListActivity::class.java)
        newIntent.putExtra("id", id)
        newIntent.putExtra("title", title)
        newIntent.putExtra("productsUrl", productsUrl)
        startActivity(newIntent)
    }

    fun goToProductDetails(title: String, description: String, productUrl: String) {
        val newIntent = Intent(application, ProductDetailsActivity::class.java)
        newIntent.putExtra("title", title)
        newIntent.putExtra("description", description)
        newIntent.putExtra("productUrl", productUrl)
        startActivity(newIntent)
    }

}