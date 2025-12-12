package com.titoodev.myfirstapp.reciclarVistas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.titoodev.myfirstapp.R

class TaskAdapter(private val tasks: MutableList<Task>) : RecyclerView.Adapter<TaskViewHolder>() {
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        // crear una vista visual y montar esa vistat
        holder.render(tasks[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        // pasarle la informaicon que va a pintar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        // debemos pasarle un numero entero ( una cantidad )
        return tasks.size
    }

}