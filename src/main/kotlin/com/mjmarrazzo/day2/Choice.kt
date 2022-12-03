package com.mjmarrazzo.day2

import java.lang.RuntimeException

data class Choice(
    val choice: Choices,
    val beats: Choices,
    val beatenBy: Choices
) {
    val points: Int
        get() = choice.ordinal + 1

    fun pointsAgainst(other: Choice): Int {
        return when(this.choice) {
            other.beatenBy -> 6
            other.choice -> 3
            other.beats -> 0
            else -> throw RuntimeException("Shouldn't happen")
        }
    }

    companion object {
        private val rock = Choice(Choices.ROCK, Choices.SCISSORS, Choices.PAPER)
        private val paper = Choice(Choices.PAPER, Choices.ROCK, Choices.SCISSORS)
        private val scissors = Choice(Choices.SCISSORS, Choices.PAPER, Choices.ROCK)

        fun Choices.toChoice() = when(this) {
            Choices.ROCK -> rock
            Choices.PAPER -> paper
            Choices.SCISSORS -> scissors
        }
    }
}
