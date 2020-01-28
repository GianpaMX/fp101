package io.github.gianpamx.tenniskata

class ImperativeTennisScore : TennisScore {
    private enum class Scoring {
        Love, Fifteen, Thirty, Forty, Advantage
    }

    private var isDeuce: Boolean = false
    private var playerOne: Scoring = Scoring.Love
    private var playerTwo: Scoring = Scoring.Love
    private var score: String = "Love - Love"

    override fun playerOneScore() {
        if (isDeuce) {
            isDeuce = false
            playerOne = Scoring.Advantage
            score = "Advantage Player 1"
            return
        }
        when (playerOne) {
            Scoring.Love -> playerOne = Scoring.Fifteen
            Scoring.Fifteen -> playerOne = Scoring.Thirty
            Scoring.Thirty -> {
                playerOne = Scoring.Forty

                if (playerTwo == Scoring.Forty) {
                    isDeuce = true
                    score = "Deuce"
                    return
                }
            }
            Scoring.Forty -> {
                if (playerTwo == Scoring.Advantage) {
                    isDeuce = true
                    playerTwo = Scoring.Forty
                    score = "Deuce"
                } else {
                    score = "Win for Player 1"
                }
                return
            }
            Scoring.Advantage -> {
                score = "Win for Player 1"
                return
            }
        }

        score = "$playerOne - $playerTwo"
    }

    override fun playerTwoScore() {
        if (isDeuce) {
            isDeuce = false
            score = "Advantage Player 2"
            return
        }
        when (playerTwo) {
            Scoring.Love -> playerTwo = Scoring.Fifteen
            Scoring.Fifteen -> playerTwo = Scoring.Thirty
            Scoring.Thirty -> {
                playerTwo = Scoring.Forty

                if (playerOne == Scoring.Forty) {
                    isDeuce = true
                    score = "Deuce"
                    return
                }
            }
            Scoring.Forty -> {
                if (playerOne == Scoring.Advantage) {
                    isDeuce = true
                    playerOne = Scoring.Forty
                    score = "Deuce"
                } else {
                    score = "Win for Player 1"
                }
                return
            }
            Scoring.Advantage -> {
                score = "Win for Player 1"
                return
            }
        }

        score = "$playerOne - $playerTwo"
    }

    override fun score() = score
}
