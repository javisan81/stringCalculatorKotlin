package com.sonalsatpute.stringcalculator

class StringCalculator(private val bigNumber: Int?) {

    fun add(input: String): Int {
        if (input.isEmpty()) return 0

        return input.toInput().run {
            inputString.toNumbers(delimiterString)
                .handleNegatives()
                .removeNumbersGreaterThanBigNumber()
                .sum()
        }
    }

    private fun List<Int>.removeNumbersGreaterThanBigNumber() =
        if (bigNumber != null) this.filter { it <= bigNumber } else this


    private fun List<Int>.handleNegatives() : List<Int> {
        val negativeNumbers = this.filter { it < 0 }
        if (negativeNumbers.isEmpty()) {
            return this
        }
        throw IllegalArgumentException("Negative numbers not allowed " + negativeNumbers.joinToString(separator = ","))
    }

    private fun String.toNumbers(delimiterString: String?) : List<Int> {
        val delimiters = listOfNotNull(",", "\n", delimiterString)
        return this.split(*delimiters.toTypedArray()).map(String::toInt)
    }

    private fun String.toInput() : Input {
        val inputStringPattern = "^//(.*)\n(.*)"
        val delimiterMather = Regex(inputStringPattern)

        delimiterMather.find(this)?.run {
            val (delimiterString, inputString) = destructured

            return Input(delimiterString, inputString)
        }

        return Input(null, this)
    }
}