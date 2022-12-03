package com.mjmarrazzo.day2

import com.mjmarrazzo.day2.Choice.Companion.toChoice
import java.io.File

//rock     beats scissors
//scissors beats paper
//paper    beats rock

// A/1 rock
// B/2 paper
// C/3 scissors

private val translationMap = mapOf(
    "A" to Choices.ROCK,
    "B" to Choices.PAPER,
    "C" to Choices.SCISSORS,
    "X" to Choices.ROCK,
    "Y" to Choices.PAPER,
    "Z" to Choices.SCISSORS
)

//part 1
private fun getMyScore(theirPick: String, myPick: String): Int {
    val theirChoice = translationMap[theirPick]!!.toChoice()
    val myChoice = translationMap[myPick]!!.toChoice()
    return myChoice.pointsAgainst(theirChoice) + myChoice.points
}

//part 2
fun getMyScore2(theirPick: String, myPick: String): Int {
    val theirChoice = translationMap[theirPick]!!.toChoice()
    return when(myPick) {
        "X" -> theirChoice.beats.ordinal + 1 //lost
        "Y" -> 3 + theirChoice.points  //draw
        "Z" -> 6 + theirChoice.beatenBy.ordinal + 1  //win
        else -> -1 //_should_ never happen
    }
}

fun main() {
    val inputLines = File("/Users/matthewmarrazzo/extraCurricular/adventOfCode/day1/lib/src/main/kotlin/day2/input.txt").readLines()
    val roundScores = inputLines
        .map { it.split(" ") }
        .map { (first, second) -> getMyScore2(first, second) }
    println(roundScores.sum())
}