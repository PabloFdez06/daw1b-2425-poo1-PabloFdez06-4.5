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

    val hora = pedirValor("Introduzca la hora: ", false)
    val minutos = pedirValor("Introduzca los minutos: ")
    val segundos = pedirValor("Introduzca los segundos: ")

    val tiempo1 = Tiempo(hora, minutos, segundos)
}