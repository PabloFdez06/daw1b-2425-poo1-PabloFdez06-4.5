import kotlin.math.min

class Tiempo(var hora: Int, var minutos: Int, var segundos: Int) {

    constructor(hora: Int, minutos: Int) : this(hora, minutos, 0)
    constructor(hora: Int) : this(hora, 0, 0)

    init {
        if (segundos > 59) {
            minutos += segundos / 60
            segundos %= 60
        }

        if (minutos > 59){
            hora += minutos / 60
            minutos %= 60
        }

        require(hora in 0..24) {"La hora debe ser un valor entre 0 y 24"}
        if(hora == 24) {
            require(minutos == 0 && segundos == 0) {"La hora máxima es 24:00:00"}
        }
    }

    override fun toString(): String {
        return "${"%02d".format(hora)}h ${"%02d".format(minutos)}m ${"%02d".format(segundos)}s "
    }
}