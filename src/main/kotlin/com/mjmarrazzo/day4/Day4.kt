package com.mjmarrazzo.day4

import java.io.File

private fun String.toIntRange(): IntRange {
    val (start, end) = this.split("-")
    return IntRange(start.toInt(), end.toInt())
}

private fun List<String>.toRanges(): List<List<IntRange>>
    = this.map { it.split(",") }
        .map {
            it.map(String::toIntRange)
        }

private fun IntRange.overlaps(other: IntRange): Boolean
    = (this.contains(other.first) && this.contains(other.last))
        || (other.contains(this.first) && other.contains(this.last))

private fun getFullyOverlappingRowCount(lines: List<String>) {
    val count = lines.toRanges()
        .count { (firstRange, secondRange) -> firstRange.overlaps(secondRange) }
    println("part 1: $count")
}

private fun getOverlappingRowCount(lines: List<String>) {
    val count = lines.toRanges()
        .map { (firstSet, secondSet) -> firstSet.intersect(secondSet) }
        .count { it.isNotEmpty() }
    println("part 2: $count")
}

fun main() {
    val inputLines = File("src/main/resources/day4/input.txt").readLines()

    getFullyOverlappingRowCount(inputLines)
    getOverlappingRowCount(inputLines)
}