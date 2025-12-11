package com.titoodev.myfirstapp.reciclarVistas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.titoodev.myfirstapp.R

class ReciclarVistasActivity : AppCompatActivity() {

    private var categories = listOf(
        TaskCategory.Other,
        TaskCategory.Business,
        TaskCategory.Personal
    )

    // inicialziar tareas
    private var tasks = mutableListOf<Task>(
        Task("Prueba", TaskCategory.Business),
        Task("Personal", TaskCategory.Personal),
        Task("otros", TaskCategory.Other),
    )

    // primeras cartas reutilziables
    private lateinit var recyclerBoxvar: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    // cartas teutilizables con checkbox
    private lateinit var recyclerBoxvar2: RecyclerView
    private lateinit var taskAdapater:TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reciclar_vistas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // la vista reciclada va a recibir un conjunto de datos
        initComponents()
        initUI()
    }

    private fun initUI(){
        // para que una vista reciclada funcione necesitamos crearle dos cosas:
        // 1. un adapatador: clase que va a conectar toda la informacion
        // 2. pintar la vista!!
        categoriesAdapter = CategoriesAdapter(categories)
        recyclerBoxvar.layoutManager =LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerBoxvar.adapter = categoriesAdapter

        // segundo recycler
        taskAdapater = TaskAdapter(tasks)
        recyclerBoxvar2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerBoxvar2.adapter = taskAdapater
    }
    private fun initComponents(){
        recyclerBoxvar = findViewById(R.id.recyclerBox)
        recyclerBoxvar2 = findViewById(R.id.recyclerBox2)
    }
}