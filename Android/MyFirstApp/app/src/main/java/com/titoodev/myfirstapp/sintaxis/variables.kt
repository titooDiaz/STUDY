package com.titoodev.myfirstapp.sintaxis
// este es el primer archivo que creamos.
// lo creamos de tipo "file", porque es de los archivos mas "simples" para trabajar

// emepezaremos hablando sobre los tipos de variables en kotlin
// es muy similar a python, el por si mismo es capaz de entender que tipo de variable estaremos usando, pero de todas formas podriamos definirlas!


fun main(){
    /**
     * VARIABLES NUMERICAS
     */

    // Valor entero ( numeros enteros relativamente no grandes )
        val entero:Int = 10

    // Valor Long ( numero enteros "grandes" )
        val grande:Long = 30

    // Flotante ( numeros con pocos decimales )
        val flotante:Float = 20.4f

    // Double ( numero con muchosss decimales )
        val decimales:Double = 20.42332

    /**
     * VARIABLES ALFANUMERICAS
     */

    // Char, solo soporta un caracter
    val caracter:Char = 'A'

    // String, valores de texto
    var cadenaTexto:String = "My name is Miguel!!"

    /**\
     * Variables Logicas
     */
    var verdadero:Boolean = true
    var falso:Boolean = false

    print(cadenaTexto)

    /**
     * Tipos de variables
     */
    // como hemos visto hemos definidos las variables de dos posibles formas, con 'var' y con 'val'
    // val es un valor constante, pero var se puede modificar en ejecucion.

    val noModificable:String = "Esto no se puede modificar"
    var modificable:String = "Esto se peude modificar"


    /**
     * Funciones aritmeticas
     */
    // sumar
    val age1=18
    val age2=20
    var total = age1 + age2

    // restar
    total = age1-age2

    // multiplicar
    total = age1*age2

    // dividir
    total = age1/age2

    // Modulo
    total = (age1%age2)

    // Transformar el tipo de una variable
    var numero:String = "2"
    var numeroEntero = numero.toInt()

    // Para concatenar elementos
    var textoConcatenado = "Hola como estas $cadenaTexto"

    // vamos a saludar con una funcion que nosotros mismo creamos
    mifuncion("miguel")

    // llamar a una funcion que retorna algo
    var valorSuma= suma(1,2)

    /**
     * Condicionales
     */
    if ("hola" != "adios"){
        println("hola es diferente de adios!")
        // podemos usar metodos para convertir variables a minuscula o a mayuscula
        var saludo:String = "hola"
        var saludoMayuscula:String = saludo.uppercase()
        var saludoMinuscula:String = saludo.lowercase()
    }else{
        println("hola es igual a adios")
        // en caso de que queramos hacer otra comparacion, podemos usar else if
        // ' else if (condicion){bloque de codigo} '
    }

    // condiciones concatenadas
    var condicion1:Boolean = true
    var condicion2:Boolean = false
    if (condicion2 && condicion1){
        println("Alguna de las condiciones, o ambas, son falsas")
    }
    if (condicion1 || condicion2){
        println("Alguna de las dos condiciones, o ambas son verdaderas")
    }

    // switch en kotlin se llama when y se usa asi:
    var numeroPrueba:Int = 2
    when(numeroPrueba){
        1 -> {
            println("caso1")
        }
        2 -> {
            println("caso2")
        }
        3,4,5 -> {
            println("caso 3, 4 o 5")
        }
        in 6..10 -> {
            println("caso del 6 al 10")
        }
        else -> {
            println("Ninguno de esos casos")
        }
    }

    // el when tambien nos sirve para verificar el tipo de los datos
    // mira la funcion 'verificarTipo'
    verificarTipo("hola")


    /**
     * Nulabilidad
     */
    // al igual que python podemos acceder a un valor especifico de un String
    var name:String? = null
    var name2:String = "hola"

    // ? ( si esto no es nulo dame este valor )
    println(name?.get(3))
    // perooo en caso de ser nulo...
    println(name?.get(3) ?: "accion!!!")

    // !! ( estoy seguro de que esto no es nulo )
    println(name2!![2])

}

/**
* Definicion de funciones
*/

// funcion que hace una tarea especifica, ( con valor por defecto )
fun mifuncion(nombre:String="Zharito"){
    println("holaaa $nombre, acabas de llamar a esta funcion")
}

// funcion que devuelve un valor
fun suma(numero1:Int, numero2:Int):Int{
    return numero1+numero2
}

// verificar tipo con when
fun verificarTipo(value:Any){
    when(value){
        is Int -> println("Es entero")
        is String -> println("Es String")
    }
}