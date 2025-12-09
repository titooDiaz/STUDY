package com.titoodev.myfirstapp.primeraApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.titoodev.myfirstapp.R
import android.util.Log
import android.widget.EditText

class PrimeraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primera)

        // al arrancar la pantalla

        val firstInput = findViewById<EditText>(R.id.input)
        val firstButton = findViewById<Button>(R.id.FirstButton) // ya tenemos enganchado el boton!!
        firstButton.setOnClickListener{
            val texto:String = firstInput.text.toString()
            if (texto.isNotEmpty()){
                Log.i("titoDev", "Hola!! $texto")
                val intent = Intent(this, SegundaActivity::class.java)
                intent.putExtra("EXTRA_NAME", texto)
                startActivity(intent)
            }
        }
    }
}