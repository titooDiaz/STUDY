package com.titoodev.myfirstapp.reciclarVistas
// vamos a crear objetos
sealed class TaskCategory(var isSelected:Boolean=false) {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()
}