package fr.epsi.cafeteria

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class StudentDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        showBack()
        intent.getStringExtra("title")?.let { setHeaderTitle(it) }

        val imgView = findViewById<ImageView>(R.id.imageViewDetails)
        val urlImage = intent.getStringExtra("urlImage")
        Picasso.get().load(urlImage).into(imgView)

        intent.getStringExtra("infos")?.let { setInfosStudent(it) }
        intent.getStringExtra("name")?.let { setNameStudent(it) }
        intent.getStringExtra("email")?.let { setEmailStudent(it) }

        val emailTextView = findViewById<TextView>(R.id.textViewEmail)
        emailTextView.setOnClickListener(View.OnClickListener {
            showToast("Aucune application ne prend en charge l'envoi d'email depuis votre appareil")
        })
    }
}