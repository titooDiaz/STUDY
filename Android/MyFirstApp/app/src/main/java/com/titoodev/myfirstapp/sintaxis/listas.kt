package com.titoodev.myfirstapp.sintaxis

fun main(){
    listaInmutable()
    ListaMutable()
}
fun ListaMutable(){
    var diasSemana:MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    // como en cualquier lista queremos agregar valores nuevos:
    diasSemana.add("Domingo Nuevo")
    // tambien recibe indices
    diasSemana.add(0,"Lunes nuevo")

    for (dia in diasSemana){
        println(dia)
    }

    // recorramolo con un for each
    diasSemana.forEach { dia -> print("$dia,") }

    // hay metodo importantes
    println(diasSemana.isEmpty())
    println(diasSemana.isNotEmpty())
}

fun listaInmutable(){
    // creemos la lista!
    val leerLista:List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    // para las listas tambien funcionan los metodos ".size"

    // para ver los valores podemos usar el metodo toString
    println(leerLista.toString())

    // para obtener el ultimos podemos usar el metodo .last
    println(leerLista.last())

    // para traer el primero podemos usar el metodo .first
    println(leerLista.first())

    // tambien podemos filtrar valores
    val filtrado = leerLista.filter { it.contains("M") }
    println(filtrado) // Martes Miercoles
}