package com.titoodev.myfirstapp.sintaxis

// hasta ahora usamos estructura de datos simples, pero en kotlin tmabien existen los arrays.
// supondremos que ya sabemos que es un array, asi que solo mostraremos las sintaxis

fun main(){
    val diasSemana = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    // los indices se usan igual que en cualquier lenguaje de programacion (Java, Python, C++)
    println(diasSemana[0]) // lunes

    // metodos comunes
    println(diasSemana.size)

    // modificar
    // los arrays se peuden modificar igual que en cualquier otro lenguaje:
    diasSemana[0] = "Lunes Raro"

    /**
     * Bucles
     */
    // para empezar mostraremos la sintaxis del ciclo repetitivo for
    for(dia in diasSemana){
        println(dia)
    }

    for ((posicion, valor) in diasSemana.withIndex()){
        println("$posicion $valor")
    }

    for (posicion in diasSemana.indices){
        println(posicion)
    }
}