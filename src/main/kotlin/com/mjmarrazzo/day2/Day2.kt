package com.mjmarrazzo.day2

import java.io.File

private val winningCombos = mapOf(
    Choices.ROCK to Choices.SCISSORS,
    Choices.SCISSORS to Choices.PAPER,
    Choices.PAPER to Choices.ROCK
)

private val translationMap = mapOf(
    "A" to Choices.ROCK,
    "B" to Choices.PAPER,
    "C" to Choices.SCISSORS,
    "X" to Choices.ROCK,
    "Y" to Choices.PAPER,
    "Z" to Choices.SCISSORS
)

private fun getMyScore(theirPick: String, myPick: String): Int {
    val theirChoice = translationMap[theirPick]!!
    val myChoice = translationMap[myPick]!!

    val myChoiceInPoints = myChoice.ordinal + 1
    if(theirChoice == myChoice) return 3 + myChoiceInPoints

    val whatBeatsTheirs = winningCombos[theirChoice]!!
    return if(whatBeatsTheirs != myChoice) 6 + myChoiceInPoints else myChoiceInPoints
}

//private fun getMyScore2(theirPick: String, myPick: String) {
//    val theirChoice = translationMap[theirPick]!!
//
////    return when(myPick) {
////
////    }
//}

fun main() {
    val inputLines = File("src/main/resources/day2/input.txt").readLines()
    val roundScores = inputLines
        .map { it.split(" ") }
        .map { (first, second) -> getMyScore(first, second) }
    println(roundScores.sum())
}