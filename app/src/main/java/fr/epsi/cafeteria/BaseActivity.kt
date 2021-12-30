package fr.epsi.cafeteria

import android.view.View import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
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
}