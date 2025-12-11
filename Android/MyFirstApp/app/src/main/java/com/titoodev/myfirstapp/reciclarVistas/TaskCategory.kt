package com.titoodev.myfirstapp.reciclarVistas
// vamos a crear objetos
sealed class TaskCategory {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()
}