package io.github.gianpamx.tenniskata

import java.util.LinkedList

class FunctionalTennisScore : TennisScore {
    private enum class Player { One, Two }

    private val points = LinkedList<Player>()

    override fun playerOneScore() {
        points.add(Player.One)
    }

    override fun playerTwoScore() {
        points.add(Player.Two)
    }

    override fun score(): String {
        return score(playerOne = 0, playerTwo = 0, points = points.iterator())
    }

    private fun score(playerOne: Int, playerTwo: Int, points: Iterator<Player>): String {
        val scoring = arrayOf("Love", "Fifteen", "Thirty", "Forty")

        if (!points.hasNext()) {
            return if (playerOne < 4 && playerTwo < 4 && playerOne + playerTwo != 6) {
                "${scoring[playerOne]} - ${scoring[playerTwo]}"
            } else {
                if (playerOne == playerTwo)
                    return "Deuce"
                val player = if (playerOne > playerTwo) "Player 1" else "Player 2"
                if ((playerOne - playerTwo) * (playerOne - playerTwo) == 1) "Advantage $player" else "Win for $player"
            }
        }

        return when (points.next()) {
            Player.One -> score(playerOne + 1, playerTwo, points)
            Player.Two -> score(playerOne, playerTwo + 1, points)
        }
    }
}
