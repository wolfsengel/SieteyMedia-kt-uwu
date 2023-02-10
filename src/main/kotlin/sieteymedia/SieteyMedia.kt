package sieteymedia

import recursos.Baraja
import recursos.Carta


class SieteyMedia {
    var baraja: Baraja
    var cartasJugador: List<Carta?>
    var cartasBanca: List<Carta?>

    init {
        baraja = Baraja()
        baraja.barajar()
        cartasJugador = List(15) { null }
        cartasBanca = List(15) { null }
    }

    fun valorCartas(cartas: List<Carta?>): Double {
        var total = 0.0
        var `val`: Int
        var i = 0
        while (cartas[i] != null) {
            `val` = cartas[i]!!.numero
                if (`val` > 7){
                    total += 0.5
                } else {
                    total += `val`
                }
            i++
        }
        return total
    }

    fun insertarCartaEnArray(cartas: MutableList<Carta?>, c: Carta?) {
        var i = 0
        while (i < cartas.size && cartas[i] != null) {
            i++
        }
        if (i < cartas.size) {
            cartas[i] = c
        } else {
            cartas.add(c)
        }
    }


    fun turnoJugador() {
        val c = baraja.darCartas(1)[0]!!
        insertarCartaEnArray(cartasJugador as MutableList<Carta?>, c)
    }

    fun turnoBanca() {
        while (valorCartas(cartasBanca) < valorCartas(cartasJugador)) {
            val c = baraja.darCartas(1)[0]!!
            insertarCartaEnArray(cartasBanca as MutableList<Carta?>, c)
        }
    }
}
