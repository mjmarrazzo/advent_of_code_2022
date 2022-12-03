package com.mjmarrazzo.day3

import java.io.File

private val letters = CharRange('a', 'z').toList() + CharRange('A', 'Z').toList()

private fun getSumOfPrioritiesPart1(lines: List<String>) {
    val giftsInBothCompartments = lines
        .map { it.chunked(it.length / 2) }
        .map { (first, second) -> first.toSet().intersect(second.toSet()).first() }
        .sumOf { letters.indexOf(it) + 1 }
    println("part 1: $giftsInBothCompartments")
}

private fun getSumOfPrioritiesPart2(lines: List<String>) {
    val giftsInThreeRows = lines.chunked(3)
        .map { (first, second, third) -> first.toSet().intersect(second.toSet()).intersect(third.toSet()).first() }
        .sumOf { letters.indexOf(it) + 1 }
    println("part 2: $giftsInThreeRows")
}

fun main() {
    val inputLines = File("src/main/resources/day3_input.txt").readLines()
    getSumOfPrioritiesPart1(inputLines)
    getSumOfPrioritiesPart2(inputLines)
}