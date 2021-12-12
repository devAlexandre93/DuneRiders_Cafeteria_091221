package fr.epsi.cafeteria

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setHeaderTitle("Epsi")
        val buttonGroup = findViewById<Button>(R.id.button_home_group)
        val buttonWebService = findViewById<Button>(R.id.button_home_ws)

        buttonGroup.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,GroupActivity::class.java)
            startActivity(newIntent)
        })

        buttonWebService.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application,WebServiceActivity::class.java)
            startActivity(newIntent)
        })

    }
}