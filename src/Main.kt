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

fun main(){

    val hora1 = try { // preguntar en clase por el ajuste de valores y el try en cuanto a pasarse de la hora
        pedirValor("Ingrese la hora (0-23) para el primer tiempo: ")
    }catch (e: IllegalArgumentException) {
        println("ERROR: ${e.message}")
        0
    }

    val minuto1 = pedirValor("Ingrese los minutos (0-59) para el primer tiempo: ")

    val segundo1 = pedirValor("Ingrese los segundos (0-59) para el primer tiempo: ")


    val tiempo1 = Tiempo(hora1, minuto1, segundo1)
    println("Primer tiempo creado: $tiempo1")

    // Pedimos los datos para crear el segundo objeto Tiempo
    val hora2 = try {
        pedirValor("Ingrese la hora (0-23) para el segundo tiempo: ")
    }catch (e: IllegalArgumentException) {
        println("ERROR: ${e.message}")
        0 // Si no le damos este 0, en caso de error no devolvera nada, y las funciones que esperan el parametro se creen que devolvera any, ya que no saben que tiene que ser Int, poniendo este 0 lo arreglamos
    }

    val minuto2 = try {
        pedirValor("Ingrese los minutos (0-59) para el segundo tiempo: ")
    }catch (e: IllegalArgumentException) {
        println("ERROR: ${e.message}")
        0 // Si no le damos este 0, en caso de error no devolvera nada, y las funciones que esperan el parametro se creen que devolvera any, ya que no saben que tiene que ser Int, poniendo este 0 lo arreglamos
    }

    val segundo2 = try {
        pedirValor("Ingrese los segundos (0-59) para el segundo tiempo: ")
    }catch (e: IllegalArgumentException) {
        println("ERROR: ${e.message}")
        0 // Si no le damos este 0, en caso de error no devolvera nada, y las funciones que esperan el parametro se creen que devolvera any, ya que no saben que tiene que ser Int, poniendo este 0 lo arreglamos
    }

    // Creamos el segundo objeto Tiempo
    val tiempo2 = Tiempo(hora2, minuto2, segundo2)
    println("Segundo tiempo creado: $tiempo2")

    // Ejemplo de incrementar
    println("\nIntentando incrementar el tiempo del primer objeto con el segundo...")
    val incrementoExitoso = tiempo1.incrementar(tiempo2)
    if (incrementoExitoso) {
        println("Tiempo después de incrementar: $tiempo1")
    } else {
        println("Error: No se pudo incrementar, se excede el límite 23:59:59.")
    }

    // Ejemplo de decrementar
    println("\nIntentando decrementar el tiempo del primer objeto con el segundo...")
    val decrementoExitoso = tiempo1.decrementar(tiempo2)
    if (decrementoExitoso) {
        println("Tiempo después de decrementar: $tiempo1")
    } else {
        println("Error: No se pudo decrementar, el resultado sería menor a 00:00:00.")
    }

    // Ejemplo de comparar
    val comparacion = tiempo1.comparar(tiempo2)
    when (comparacion) {
        -1 -> println("\nEl primer tiempo es menor que el segundo.")
        0 -> println("\nEl primer tiempo es igual al segundo.")
        1 -> println("\nEl primer tiempo es mayor que el segundo.")
    }

    // Ejemplo de copiar el tiempo
    val tiempoCopiado = tiempo1.copiar()
    println("\nTiempo copiado: $tiempoCopiado")

    // Copiar tiempo de otro objeto
    val tiempoNuevo = tiempo1.copiar(tiempo2)
    println("\nTiempo copiado desde el segundo objeto: $tiempoNuevo")

    // Ejemplo de sumar
    println("\nIntentando sumar los dos tiempos...")
    val suma = tiempo1.sumar(tiempo2)
    if (suma != null) {
        println("Resultado de la suma: $suma")
    } else {
        println("Error: La suma excede el límite 23:59:59.")
    }

    // Ejemplo de restar
    println("\nIntentando restar los dos tiempos...")
    val resta = tiempo1.restar(tiempo2)
    if (resta != null) {
        println("Resultado de la resta: $resta")
    } else {
        println("Error: La resta da como resultado un tiempo negativo.")
    }

    // Ejemplo de comprobar si es mayor que
    val esMayor = tiempo1.esMayorQue(tiempo2)
    println("\nEl primer tiempo es mayor que el segundo: $esMayor")

    val esMenor = tiempo1.esMenorQue(tiempo2)
    println("\nEl primer tiempo es menor que el segundo: $esMenor")
}