package recursos

import java.util.*

class Baraja {
    //baraja española de 40 cartas. No hay 8 y 9.
    private val NUM_CARTAS = 40
    private val cartas = arrayOfNulls<Carta>(NUM_CARTAS)
    var primeraMazo //el indice de la primera carta sin dar. A las cartas sin dar le llamo mazo.
            = 0

    init {
//crea una baraja ordenada por palos y números
        var ultimaCarta = 0
        for (p in Palo.values()) {
            for (j in 0..11) {
                if (j == 7 || j == 8) {
                    continue
                }
                cartas[ultimaCarta] = Carta(p, j + 1)
                ultimaCarta++
            }
        }
    }

    fun barajar() {
//baraja el mazo, es decir, la cartas sin dar
        val r = Random()
        for (i in primeraMazo until cartas.size) {
            val posicionAzar = r.nextInt(cartas.size - primeraMazo) + primeraMazo
            val temp = cartas[i]
            cartas[i] = cartas[posicionAzar]
            cartas[posicionAzar] = temp
        }
    }

    fun darCartas(numCartasDar: Int): Array<Carta?> {
        val cartasParaDar: Array<Carta?>
        val cartasEnMazo = cartas.size - primeraMazo
        if (cartasEnMazo < numCartasDar) {
            cartasParaDar = arrayOf()
        } else {
            cartasParaDar = cartas.copyOfRange(primeraMazo, primeraMazo + numCartasDar)
            primeraMazo = primeraMazo + numCartasDar
        }
        return cartasParaDar
    }

}
