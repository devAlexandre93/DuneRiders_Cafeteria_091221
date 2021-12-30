package fr.epsi.cafeteria

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button

class GroupActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)
        setHeaderTitle("Infos")
        showBack()
        val buttonStudent1 = findViewById<Button>(R.id.button_group_student1)
        val buttonStudent2 = findViewById<Button>(R.id.button_group_student2)
        val buttonStudent3 = findViewById<Button>(R.id.button_group_student3)

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,StudentDetailsActivity::class.java)
            newIntent.putExtra("title","Clément")
            newIntent.putExtra("urlImage","https://avatars.dicebear.com/v2/male/e3795a61ccf739c63f042fa1d8f01fa6.png")
            newIntent.putExtra("infos","28 ans, Bordeaux")
            newIntent.putExtra("name","Clément Escande")
            newIntent.putExtra("email","clement.escande@epsi.fr")
            startActivity(newIntent)
        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,StudentDetailsActivity::class.java)
            newIntent.putExtra("title","Yahya")
            newIntent.putExtra("urlImage","https://avatars.dicebear.com/v2/male/28665fe6eaa02541e25282e0a56c61aa.png")
            newIntent.putExtra("infos","22 ans, Bordeaux")
            newIntent.putExtra("name","Yahya Qaddouri")
            newIntent.putExtra("email","yahya.qaddouri@epsi.fr")
            startActivity(newIntent)
        })

        buttonStudent3.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,StudentDetailsActivity::class.java)
            newIntent.putExtra("title","Alexandre")
            newIntent.putExtra("urlImage","https://avatars.dicebear.com/v2/male/ad5ee5c403181cc1604f8ed9ff090e8f.png")
            newIntent.putExtra("infos","28 ans, Bordeaux")
            newIntent.putExtra("name","Alexandre Anania")
            newIntent.putExtra("email","alexandre.anania@epsi.fr")
            startActivity(newIntent)
        })
    }
}