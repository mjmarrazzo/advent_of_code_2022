package com.mjmarrazzo.day6

import java.io.File

private fun getFirstMarkerIndex(input: String, windowSize: Int): Int {
    (0 until input.length - (windowSize - 1)).forEach {  index ->
        val charSet = input.substring(index, index + windowSize).toSet()
        if(charSet.size == windowSize) {
            return index + windowSize
        }
    }
    return -1
}

fun main() {
    val inputLines = File("src/main/resources/day6/input.txt").readText()
    println("part 1: ${getFirstMarkerIndex(inputLines, 4)}")
    println("part 2: ${getFirstMarkerIndex(inputLines, 14)}")

}