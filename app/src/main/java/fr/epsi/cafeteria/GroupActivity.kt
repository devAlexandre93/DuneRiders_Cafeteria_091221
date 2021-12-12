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
            val newIntent = Intent(application,DetailsActivity::class.java)
            newIntent.putExtra("title","Clément")
            newIntent.putExtra("urlImage","https://avatars.dicebear.com/v2/male/b28fbff8404004995e0db18a41465e54.png")
            newIntent.putExtra("infos","28 ans")
            newIntent.putExtra("name","Clément Escande")
            newIntent.putExtra("email","clement.escande@epsi.fr")
            startActivity(newIntent)
        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailsActivity::class.java)
            newIntent.putExtra("title","Yahya Qaddouri")
            newIntent.putExtra("urlImage","https://avatars.dicebear.com/v2/male/7f0f8030f7a23375644a4e9ea46916b0.png")
            newIntent.putExtra("infos","22 ans")
            newIntent.putExtra("name","Yahya Qaddouri")
            newIntent.putExtra("email","yahya.qaddouri@epsi.fr")
            startActivity(newIntent)
        })

        buttonStudent3.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,DetailsActivity::class.java)
            newIntent.putExtra("title","Alexandre")
            newIntent.putExtra("urlImage","https://avatars.dicebear.com/v2/male/94ef6d97cde99e62e2b8fc53130a0198.png")
            newIntent.putExtra("infos","28 ans")
            newIntent.putExtra("name","Alexandre Anania")
            newIntent.putExtra("email","alexandre.anania@epsi.fr")
            startActivity(newIntent)
        })
    }
}