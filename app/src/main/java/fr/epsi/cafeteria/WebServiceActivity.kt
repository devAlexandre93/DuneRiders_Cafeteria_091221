package fr.epsi.cafeteria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WebServiceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
        setHeaderTitle("Rayons")
    }
}