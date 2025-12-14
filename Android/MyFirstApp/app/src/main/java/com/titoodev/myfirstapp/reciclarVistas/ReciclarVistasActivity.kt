package com.titoodev.myfirstapp.reciclarVistas

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

    // boton agregar tareas
    private lateinit var btnAddTask: FloatingActionButton

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
        initListeners()
    }

    private fun initUI(){
        // para que una vista reciclada funcione necesitamos crearle dos cosas:
        // 1. un adapatador: clase que va a conectar toda la informacion
        // 2. pintar la vista!!
        categoriesAdapter = CategoriesAdapter(categories) { position -> updateCategories(position) }
        recyclerBoxvar.layoutManager =LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerBoxvar.adapter = categoriesAdapter

        // segundo recycler
        taskAdapater = TaskAdapter(tasks, {onItemSelected(it)})
        recyclerBoxvar2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerBoxvar2.adapter = taskAdapater

        // iniizializar boton
        btnAddTask = findViewById(R.id.addTask)

    }
    private fun initComponents(){
        recyclerBoxvar = findViewById(R.id.recyclerBox)
        recyclerBoxvar2 = findViewById(R.id.recyclerBox2)
    }

    private fun initListeners(){
        btnAddTask.setOnClickListener{
            showDialog()
        }
    }

    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun showDialog(){

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        // elementos relaciondos
        val inputTask: EditText = dialog.findViewById(R.id.inputTask)
        val buttonGroup: RadioGroup = dialog.findViewById(R.id.radioGroup)
        val btnAddNewTask: Button = dialog.findViewById(R.id.btnAddTask)

        btnAddNewTask.setOnClickListener{
            val selectedId = buttonGroup.checkedRadioButtonId
            val button:RadioButton = buttonGroup.findViewById(selectedId)

            val currentCategory:TaskCategory = when(button.text){
                    "negocios"-> TaskCategory.Business
                    "personal"-> TaskCategory.Personal
                    else -> TaskCategory.Other
            }

            tasks.add(Task(inputTask.text.toString(),currentCategory))
            updateTasks()
            dialog.hide()
        }

        dialog.show()
    }

    // funcion lambda ( mirar el TaskAdapter )
    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTasks(){
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapater.tasks = newTasks
        taskAdapater.notifyDataSetChanged()
    }
}