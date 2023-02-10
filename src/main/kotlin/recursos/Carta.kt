package recursos

class Carta(private val palo: Palo, val numero: Int) {
    override fun toString(): String {
        return "($palo, $numero)"
    }
}