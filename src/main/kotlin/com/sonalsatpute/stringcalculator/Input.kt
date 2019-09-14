package com.sonalsatpute.stringcalculator

data class Input(val delimiterString: String? = null, val inputString: String) {

    fun toNumbers() : List<Int> {
        println(inputString)
        val delimiters = listOfNotNull(",", "\n", delimiterString)
        return inputString.split(*delimiters.toTypedArray()).map(String::toInt)
    }
}