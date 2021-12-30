package fr.epsi.cafeteria

import android.os.Bundle
import android.widget.ImageView
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
    }
}