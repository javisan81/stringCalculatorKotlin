package com.sonalsatpute.stringcalculator

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTests {

    private val calculator = StringCalculator(1000)

    @Test fun `empty string should return zero`() {
        assertEquals(0, calculator.add(""))
    }

    @Test fun `single number should return number` () {
        assertEquals(1, calculator.add("1"))
    }

    @Test fun `input two numbers delimited by comma should return sum` () {
        assertEquals(3, calculator.add("1,2"))
    }

    @Test fun `input two numbers delimited by new-line should return sum` () {
        assertEquals(3, calculator.add("1\n2"))
    }

    @Test fun `input multiple numbers delimited by comma should return sum` () {
        assertEquals(3, calculator.add("1,2"))
        assertEquals(6, calculator.add("1,2,3"))
        assertEquals(5, calculator.add("1,4"))
        assertEquals(5, calculator.add("1,1,1,1,1"))
    }

    @Test fun `input three numbers delimited comma and by new-line should return sum` () {
        assertEquals(6, calculator.add("1,2\n3"))
    }

    @Test fun `support different delimiters, should return sum where the default delimiter is provided as first line of string`() {
        assertEquals(3, calculator.add("//;\n1;2"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `negative number will throw an exception 'negatives not allowed' and the negative that was passed` () {
        calculator.add("//;\n-1;2")
    }

    @Test fun `numbers bigger than 1000 should be ignored` () {
        assertEquals(2, calculator.add("1002,2"))
        assertEquals(0, calculator.add("1002,10010"))
        assertEquals(1001, calculator.add("1000,10010,1"))
    }
}