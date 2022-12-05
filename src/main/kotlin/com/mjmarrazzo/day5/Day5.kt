package com.mjmarrazzo.day5

import java.io.File

//part 1
private fun moveStacks(listOfStacks: List<ArrayDeque<Char>>, moveLines: List<String>) {
    moveLines.forEach {  moveString ->
        val (amount, fromStackIndex, toStackIndex) =
            Regex("move (\\d+) from (\\d+) to (\\d+)").find(moveString)!!.destructured
        val fromStack = listOfStacks[fromStackIndex.toInt() - 1]
        val toStack = listOfStacks[toStackIndex.toInt() - 1]
        (0 until amount.toInt()).forEach { _ ->
            toStack.add(fromStack.removeLast())
        }
    }
    val lastLetters = listOfStacks.map { it.last() }.joinToString("")
    println("part 1: $lastLetters")
}

//part 2
private fun moveStacks2(listOfStacks: List<ArrayDeque<Char>>, moveLines: List<String>) {
    moveLines.forEach {  moveString ->
        val (amount, fromStackIndex, toStackIndex) =
            Regex("move (\\d+) from (\\d+) to (\\d+)").find(moveString)!!.destructured
        val fromStack = listOfStacks[fromStackIndex.toInt() - 1]
        val toStack = listOfStacks[toStackIndex.toInt() - 1]
        val moveStack = (0 until amount.toInt())
            .map { fromStack.removeLast() }
            .reversed()
        toStack.addAll(moveStack)
    }
    val lastLetters = listOfStacks.map { it.last() }.joinToString("")
    println("part 2: $lastLetters")
}


fun main() {
    val inputLines = File("src/main/resources/day5/input.txt").readLines()

    val emptyLineIndex = inputLines.indexOf("")
    val stackLines = inputLines.subList(0, emptyLineIndex - 1)
    val moveLines = inputLines.subList(emptyLineIndex + 1, inputLines.size)

    val maxStacks = inputLines[emptyLineIndex - 1]
        .split(" ")
        .filter(String::isNotBlank)
        .max().toInt()

    val listOfStacks = (0 until maxStacks)
        .map { ArrayDeque<Char>(stackLines.size) }

    stackLines.reversed().forEach { line ->
        for(i in 1 until line.length step 4) {
            val letter = line[i]
            if(!letter.isWhitespace()) {
                listOfStacks[i/4].add(letter)
            }
        }
    }

    //moveStacks(listOfStacks, moveLines)
    moveStacks2(listOfStacks, moveLines)
}
