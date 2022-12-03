/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.mjmarrazzo.day1

import java.io.File

fun main() {
    val inputLines = File("src/main/resources/day1_input.txt").readLines()

    val blankLinesIndexes = listOf(0) + inputLines
        .mapIndexed { index, s -> if(s == "") index else -1 }
        .filter{ it != -1}

    val elfPresents = blankLinesIndexes.zipWithNext{ first, second ->
        inputLines.subList(first, second)
            .filter { it != ""}
            .map(String::toInt)
            .sum()
    }

    val sortedElfPresents = elfPresents.sortedDescending()
    println("top collector: ${sortedElfPresents.first()}")

    val sum = sortedElfPresents.subList(0, 3).also {println(it)}.sum()
    println("sum of top 3: $sum")
}


