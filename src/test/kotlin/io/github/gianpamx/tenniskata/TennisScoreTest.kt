package io.github.gianpamx.tenniskata

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Before
import org.junit.Test

class TennisScoreTest {
    lateinit var tennisScore: TennisScore

    @Before
    fun setUp() {
        tennisScore = ImperativeTennisScore()
        tennisScore = FunctionalTennisScore()
    }

    @Test
    fun `0 - 0`() {
        assertThat(tennisScore.score()).isEqualTo("Love - Love")
    }

    @Test
    fun `0 - 15`() {
        tennisScore.playerTwoScore()

        assertThat(tennisScore.score()).isEqualTo("Love - Fifteen")
    }

    @Test
    fun `30 - 0`() {
        tennisScore.playerOneScore()
        tennisScore.playerOneScore()

        assertThat(tennisScore.score()).isEqualTo("Thirty - Love")
    }

    @Test
    fun `0 - 40`() {
        tennisScore.playerTwoScore()
        tennisScore.playerTwoScore()
        tennisScore.playerTwoScore()

        assertThat(tennisScore.score()).isEqualTo("Love - Forty")
    }

    @Test
    fun `Player 1 Wins`() {
        tennisScore.playerOneScore()
        tennisScore.playerOneScore()
        tennisScore.playerOneScore()
        tennisScore.playerOneScore()

        assertThat(tennisScore.score()).isEqualTo("Win for Player 1")
    }

    @Test
    fun `Deuce Game`() {
        tennisScore.playerOneScore()
        tennisScore.playerTwoScore()

        tennisScore.playerOneScore()
        tennisScore.playerTwoScore()

        tennisScore.playerOneScore()
        tennisScore.playerTwoScore()

        assertThat(tennisScore.score()).isEqualTo("Deuce")
    }

    @Test
    fun `Advantage Player 2`() {
        tennisScore.playerOneScore()
        tennisScore.playerTwoScore()

        tennisScore.playerOneScore()
        tennisScore.playerTwoScore()

        tennisScore.playerOneScore()
        tennisScore.playerTwoScore()

        tennisScore.playerOneScore()
        tennisScore.playerTwoScore()

        tennisScore.playerTwoScore()

        assertThat(tennisScore.score()).isEqualTo("Advantage Player 2")
    }
}
