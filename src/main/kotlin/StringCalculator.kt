package com.sonalsatpute.stringcalculator

import java.lang.IllegalArgumentException

class StringCalculator {

    private val delimiters = mutableListOf<String>()

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0

        delimiters.clear()
        delimiters.add(",")
        delimiters.add("\n")

        return numbers
            .extractDelimiter()
            .toNumbers()
            .handleNegatives()
            .sum()
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
        return if (this.startsWith("//")) {
            delimiters.add(this.substring(2, 3))
            this.substring(4)
        } else
            this
    }
}