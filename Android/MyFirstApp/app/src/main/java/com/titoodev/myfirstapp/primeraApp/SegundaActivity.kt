package com.titoodev.myfirstapp.primeraApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.titoodev.myfirstapp.R
import org.w3c.dom.Text

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        val textoTitulo = findViewById<TextView>(R.id.titulo)
        val name:String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        textoTitulo.text = "Bienvenido $name"
    }
}