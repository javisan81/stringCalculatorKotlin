package com.sonalsatpute.stringcalculator

import java.lang.IllegalArgumentException


class StringCalculator {

    private val BIG_NUMBER = 1000
    private val DELIMITER_MARKER = "//"
    private val delimiters = mutableListOf<String>()

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0

        delimiters.clear()
        delimiters.add("\n")
        delimiters.add(",")

        return numbers
            .extractDelimiter()
            .toNumbers()
            .handleNegatives()
            .removeNumbersGreaterThan(BIG_NUMBER)
            .sum()
    }

    private fun List<Int>.removeNumbersGreaterThan(number: Int): List<Int> {
        return this.filter { it <= number }
    }

    private fun List<Int>.handleNegatives() : List<Int> {
        val negativeNumbers = this.filter { it < 0 }
        if (negativeNumbers.isEmpty()) {
            return this
        }
        throw IllegalArgumentException("Negative numbers not allowed " + negativeNumbers.joinToString(separator = ","))
    }

    private fun String.toNumbers() : List<Int> {
        return this.split(*delimiters.toTypedArray())
            .map(String::toInt)
    }

    private fun String.extractDelimiter() : String {
        return if (hasDelimiter()) {
            delimiters.add(getDelimiter())
            removeDelimiterLine()
        } else
            this
    }

    private fun String.getDelimiter() = this.substring(DELIMITER_MARKER.length, DELIMITER_MARKER.length + 1)

    private fun String.removeDelimiterLine() = this.substring(4)

    private fun String.hasDelimiter() = this.startsWith(DELIMITER_MARKER)
}


