package com.titoodev.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.titoodev.myfirstapp.IMCAPP.IMCActivity
import com.titoodev.myfirstapp.primeraApp.PrimeraActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        // primer menu
        val btnNav = findViewById<Button>(R.id.botonnav)
        btnNav.setOnClickListener{navergarSaludo()}

        // segundo menu
        val btnNav2 = findViewById<Button>(R.id.botonnav2)
        btnNav2.setOnClickListener{navergarSaludo2()}
    }

    fun navergarSaludo(){
        val intent = Intent(this, PrimeraActivity::class.java)
        startActivity(intent)
    }
    fun navergarSaludo2(){
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }
}