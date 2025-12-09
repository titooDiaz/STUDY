package com.titoodev.myfirstapp.IMCAPP

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.titoodev.myfirstapp.R

class IMCActivity : AppCompatActivity() {

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var slider: RangeSlider
    private lateinit var altura: TextView
    private var isMaleSelected:Boolean = true

    private lateinit var edadText:TextView

    // botones de edad
    private var currentEdad:Int = 60
    private lateinit var upEdad: FloatingActionButton
    private lateinit var downEdad:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)

        // llamar funciones
        initComponents()
        initListeners()
    }

    private fun initComponents(){
        altura = findViewById(R.id.number)
        slider = findViewById(R.id.slider)
        viewMale = findViewById(R.id.man)
        viewFemale = findViewById(R.id.woman)

        // botoenes de aumentar y disminuir
        upEdad = findViewById(R.id.upEdad)
        downEdad = findViewById(R.id.downEdad)

        // textos que cambian
        edadText = findViewById(R.id.edad_numerica)
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

        slider.addOnChangeListener{_,value,_ ->
            altura.text = value.toString()
        }

        // botones de aumetar y disminuir
        upEdad.setOnClickListener{
            currentEdad+=1
            setEdad()
        }
        downEdad.setOnClickListener{
            currentEdad-=1
            setEdad()
        }
    }

    private fun setEdad(){
        edadText.text= "${currentEdad.toString()}"
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