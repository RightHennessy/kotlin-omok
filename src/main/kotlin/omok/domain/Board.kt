package omok.domain

import omok.domain.judgement.FourJudgement
import omok.domain.judgement.LineJudgement
import omok.domain.judgement.ThreeJudgement

class Board(val blackPlayer: Player, val whitePlayer: Player) {
    private val positions = Position.POSITIONS.toList()

    fun isBlackPlaceable(position: Position): Boolean {
        return when {
            LineJudgement(blackPlayer, position).check() -> true
            ThreeJudgement(blackPlayer, whitePlayer, position).check() || FourJudgement(blackPlayer, whitePlayer, position).check() -> false
            else -> positions.find { it == position }?.isEmpty() == true
        }
    }

    fun isWhitePlaceable(position: Position): Boolean {
        return positions.find { it == position }?.isEmpty() == false
    }

    fun putStone(position: Position) {
        positions.find { it == position }?.occupy()
    }
}
