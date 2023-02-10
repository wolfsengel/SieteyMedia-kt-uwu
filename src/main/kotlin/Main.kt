package sieteymedia

import recursos.Carta
import java.util.*

fun main() {
    presentarJuego()
    GameControler()
    println("Adios")
}

    fun presentarJuego() {
        println("- El usuario es el jugador y el ordenador la banca.")
        println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.")
        println("- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.")
        println("- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.")
        println("- El jugador va pidiendo cartas a la banca de una en una.")
        println("- El jugador puede plantarse en cualquier momento.")
        print("- Si la suma de los valores de las cartas sacadas es superior ")
        println("a 7 y medio, el jugador 'se pasa de siete y medio' y pierde.")
        println("- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta está obligada a sacar cartas hasta empatar o superar al jugador.")
        println("- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.")
        println("- La banca no se puede plantar y tiene que empatar o superar la puntuación del jugador sin pasarse.")
        println("- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.")
        println("\nEmpecemos!!!\n")
    }

    fun mostrarCartas(cartas: List<Carta?>) {
        var i = 0
        while (cartas[i] != null) {
            print("\t" + cartas[i])
            i++
        }
    }

    fun GameControler() {
        val xogo = SieteyMedia()
        //-------------------------------------------------------------
        var opc = 'C'
        println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte")
        while (xogo.valorCartas(xogo.cartasJugador) < 7.5 && opc == 'C') {
            println("Éstas son tus cartas jugador:")
            xogo.turnoJugador()
            mostrarCartas(xogo.cartasJugador)
            System.out.println(
                """
	Valor de cartas: ${xogo.valorCartas(xogo.cartasJugador)}"""
            )
            if (xogo.valorCartas(xogo.cartasJugador) < 7.5) {
                println("\n¿Pides [C]arta o te [P]lantas?")
                opc = readLine()!!.trim().uppercase(Locale.getDefault())[0]
            }
        }
        //-----------------------------------------------------------------
        if (xogo.valorCartas(xogo.cartasJugador) > 7.5) {
            println("Jugador, te has pasado en tu jugada anterior, gana la banca")
        } else {
            println("\n\nTurno de banca ...")
            println("Éstas son mis cartas:")
            xogo.turnoBanca()
            mostrarCartas(xogo.cartasBanca)
            System.out.println("""Valor de mis cartas(banca): ${xogo.valorCartas(xogo.cartasBanca)}""".trimIndent())
            if (xogo.valorCartas(xogo.cartasBanca) > 7.5) {
                println("Me pasé, ganas tú,jugador")
            } else {
                println("Gana la banca")
            }
        }
        //------------------------------------------------------------------
    }

