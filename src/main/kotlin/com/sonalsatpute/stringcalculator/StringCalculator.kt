package com.sonalsatpute.stringcalculator


class StringCalculator(private val bigNumber: Int?) {

    fun add(input: String): Result<Throwable, Int> {
        if (input.isBlank()) return Success(0)

        return when (val result = input.toInput().toNumbers().validate()) {
            is Success -> Success(result.value.removeNumbersGreaterThanBigNumber().sum())
            is Failure -> result
        }
    }

    private fun String.toInput(): Input {
        val inputStringPattern = "^//(.*)\n(.*)"
        val delimiterMather = Regex(inputStringPattern)

        delimiterMather.find(this)?.run {
            val (delimiterString, inputString) = destructured

            return Input(delimiterString, inputString)
        }

        return Input(inputString = this)
    }

    private fun List<Int>.validate(): Result<Throwable, List<Int>> {
        val negativeNumbers = this.filter { it < 0 }

        if (negativeNumbers.isEmpty()) {
            return Success(this)
        }
        return Failure(IllegalArgumentException("Negative numbers not allowed " + negativeNumbers.joinToString(separator = ",")))
    }

    private fun List<Int>.removeNumbersGreaterThanBigNumber() =
        if (bigNumber != null) this.filter { it <= bigNumber } else this
}