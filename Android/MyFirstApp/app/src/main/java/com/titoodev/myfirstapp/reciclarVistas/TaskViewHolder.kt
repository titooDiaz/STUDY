package com.titoodev.myfirstapp.reciclarVistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.titoodev.myfirstapp.R

class TaskViewHolder (view: View) : RecyclerView.ViewHolder(view){
    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val cbTask:TextView = view.findViewById(R.id.checkboxTask)

    fun render(task: Task){
        tvTask.text = task.name
    }
}