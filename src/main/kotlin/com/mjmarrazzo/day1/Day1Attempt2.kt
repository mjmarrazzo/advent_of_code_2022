package com.mjmarrazzo.day1

import java.io.File

fun main() {
    val inputLines = File("src/main/resources/day1/input.txt").readLines()

    val sortedElfGroups = inputLines.joinToString("|")
        .split("||")
        .map { it.split("|") }
        .map { group -> group.sumOf { it.toInt() } }
        .sortedDescending()

    println("top collector: ${sortedElfGroups.first()}")

    val sum = sortedElfGroups.subList(0, 3).sum()
    println("sum of top 3: $sum")
}