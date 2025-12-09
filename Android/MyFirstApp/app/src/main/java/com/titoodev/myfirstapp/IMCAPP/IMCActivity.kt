package com.titoodev.myfirstapp.IMCAPP

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.titoodev.myfirstapp.R

class IMCActivity : AppCompatActivity() {

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private var isMaleSelected:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)

        // llamar funciones
        initComponents()
        initListeners()
    }

    private fun initComponents(){
        viewMale = findViewById<CardView>(R.id.man)
        viewFemale = findViewById<CardView>(R.id.woman)
    }

    private fun initListeners(){
        viewMale.setOnClickListener(){
            isMaleSelected = true
            setGenderColor(true)
        }
        viewFemale.setOnClickListener(){
            isMaleSelected = false
            setGenderColor(false)
        }
    }

    private fun setGenderColor(isMaleSelected:Boolean){
        if (isMaleSelected){
            viewMale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.orange_dark))
            viewFemale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.orange))
        }else{
            viewFemale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.orange_dark))
            viewMale.setCardBackgroundColor(ContextCompat.getColor(this, R.color.orange))
        }
    }
}