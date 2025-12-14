package com.titoodev.myfirstapp.reciclarVistas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.titoodev.myfirstapp.R

class CategoriesAdapter(private val categories:List<TaskCategory>, private val onItemSelected:(Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        // crear una vista visual y montar esa vista
        holder.render(categories[position], onItemSelected)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        // pasarle la informaicon que va a pintar
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        // debemos pasarle un numero entero ( una cantidad )
        return categories.size
    }

}