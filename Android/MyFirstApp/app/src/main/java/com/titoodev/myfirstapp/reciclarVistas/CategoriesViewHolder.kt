package com.titoodev.myfirstapp.reciclarVistas

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.titoodev.myfirstapp.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val tvCategoryBox:TextView = view.findViewById(R.id.categoryName)
    private val divider:View = view.findViewById(R.id.divider)
    private val ViewContainer: CardView = view.findViewById(R.id.cards)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){

        itemView.setOnClickListener{
            onItemSelected(layoutPosition)
        }

        val color = if(taskCategory.isSelected){
            R.color.orange
        }else{
            R.color.orange_dark
        }

        ViewContainer.setCardBackgroundColor(ContextCompat.getColor(ViewContainer.context, color))

        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryBox.text = "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.orange_dark)
                )
            }
            TaskCategory.Other -> {
                tvCategoryBox.text = "Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.purple_200)
                )
            }
            TaskCategory.Personal -> {
                tvCategoryBox.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.teal_200)
                )
            }
        }
    }
}