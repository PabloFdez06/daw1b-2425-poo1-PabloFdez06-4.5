fun pedirValor(msj: String, aceptaVacio: Boolean = true) : Int {
    var valor: Int? = null

    do {
        print(msj)
        val entrada = readln().trim()
        if (aceptaVacio && entrada.isEmpty()){
            valor = 0
        } else {
            try {
                valor = entrada.toInt()
            } catch (e: NumberFormatException){
                println("Formato númerico incorrecto!")
            }
        }
    } while (valor == null)

    return valor

}

fun preguntasTiempo(): Tiempo{

    while (true) {
        try {
            val hora = pedirValor("Ingrese la hora (0-23) para el primer tiempo: ")
            val minuto = pedirValor("Ingrese los minutos (0-59) para el primer tiempo: ")
            val segundo = pedirValor("Ingrese los segundos (0-59) para el primer tiempo: ")
            return Tiempo(hora, minuto, segundo)
        } catch (e: IllegalArgumentException) {
            println("ERROR: ${e.message}")        }
    }

}

fun main(){

    val tiempo1 = preguntasTiempo()
    println("Primer tiempo creado: $tiempo1")

    // Pedimos los datos para crear el segundo objeto Tiempo

    val tiempo2 = preguntasTiempo()

    println("Segundo tiempo creado: $tiempo2")

    print("---------------------")

    // Ejemplo de incrementar
    println("\nIntentando incrementar el tiempo del primer objeto con el segundo...")
    val incrementoExitoso = tiempo1.incrementar(tiempo2)
    if (incrementoExitoso) {
        println("Tiempo después de incrementar: $tiempo1")
    } else {
        println("Error: No se pudo incrementar, se excede el límite 23:59:59.")
    }

    print("---------------------")

    // Ejemplo de decrementar
    println("\nIntentando decrementar el tiempo del primer objeto con el segundo...")
    val decrementoExitoso = tiempo1.decrementar(tiempo2)
    if (decrementoExitoso) {
        println("Tiempo después de decrementar: $tiempo1")
    } else {
        println("Error: No se pudo decrementar, el resultado sería menor a 00:00:00.")
    }

    print("---------------------")

    // Ejemplo de comparar
    val comparacion = tiempo1.comparar(tiempo2)
    when (comparacion) {
        -1 -> println("\nEl primer tiempo es menor que el segundo.")
        0 -> println("\nEl primer tiempo es igual al segundo.")
        1 -> println("\nEl primer tiempo es mayor que el segundo.")
    }

    print("---------------------")

    // Ejemplo de comprobar si es mayor que
    val esMayor = tiempo1.esMayorQue(tiempo2)
    println("\nEl primer tiempo es mayor que el segundo: $esMayor")

    val esMenor = tiempo1.esMenorQue(tiempo2)
    println("\nEl primer tiempo es menor que el segundo: $esMenor")

    print("---------------------")

    // Ejemplo de copiar el tiempo
    val tiempoCopiado = tiempo1.copiar()
    println("\nTiempo copiado: $tiempoCopiado")

    print("---------------------")

    // Copiar tiempo de otro objeto
    val tiempoNuevo = tiempo1.copiar(tiempo2)
    println("\nTiempo copiado desde el segundo objeto: $tiempoNuevo")

    print("---------------------")

    // Ejemplo de sumar
    println("\nIntentando sumar los dos tiempos...")
    val suma = tiempo1.sumar(tiempo2)
    if (suma != null) {
        println("Resultado de la suma: $suma")
    } else {
        println("Error: La suma excede el límite 23:59:59.")
    }

    print("---------------------")

    // Ejemplo de restar
    println("\nIntentando restar los dos tiempos...")
    val resta = tiempo1.restar(tiempo2)
    if (resta != null) {
        println("Resultado de la resta: $resta")
    } else {
        println("Error: La resta da como resultado un tiempo negativo.")
    }


}