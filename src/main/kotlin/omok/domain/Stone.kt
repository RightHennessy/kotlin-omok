package omok.domain

class Stone(val position: Position) {
    fun findPosition(value: Position) = (position == value)
}
