package com.titoodev.myfirstapp.IMCAPP

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import com.titoodev.myfirstapp.primeraApp.PrimeraActivity

class IMCActivity : AppCompatActivity() {

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var slider: RangeSlider
    private lateinit var altura: TextView
    private var isMaleSelected:Boolean = true

    private lateinit var edadText:TextView
    private lateinit var pesoText:TextView

    // boton calcular
    private lateinit var botonCalcularIMC: Button

    // botones de edad
    private var currentEdad:Int = 60
    private var currentPeso:Int = 60
    private var currentAltura:Float = 120f
    private lateinit var upEdad: FloatingActionButton
    private lateinit var downEdad:FloatingActionButton
    private lateinit var upPeso: FloatingActionButton
    private lateinit var downPeso:FloatingActionButton


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
        upPeso = findViewById(R.id.upPeso)
        downPeso = findViewById(R.id.downPeso)

        // textos que cambian
        edadText = findViewById(R.id.edad_numerica)
        pesoText = findViewById(R.id.peso_numero)

        // inicializar boton de calcular
        botonCalcularIMC = findViewById(R.id.button)
    }

    private fun initListeners(){
        botonCalcularIMC.setOnClickListener(){
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("IMC_RESULT",calcularIMC())
            startActivity(intent)
        }

        viewMale.setOnClickListener(){
            isMaleSelected = true
            setGenderColor(true)
        }
        viewFemale.setOnClickListener(){
            isMaleSelected = false
            setGenderColor(false)
        }

        slider.addOnChangeListener{_,value,_ ->
            currentAltura = value.toString().toFloat()
            altura.text = currentAltura.toString()
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

        upPeso.setOnClickListener{
            currentPeso+=1
            setPeso()
        }
        downPeso.setOnClickListener{
            currentPeso-=1
            setPeso()
        }
    }

    private fun setEdad(){
        edadText.text= "${currentEdad.toString()}"
    }

    private fun setPeso(){
        pesoText.text= "${currentPeso.toString()}"
    }

    // calcular IMC
    private fun calcularIMC():Float{
        val imc:Float = currentPeso/((currentAltura*currentAltura)/10000)
        Log.d("titoDev", "$imc")
        return imc
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