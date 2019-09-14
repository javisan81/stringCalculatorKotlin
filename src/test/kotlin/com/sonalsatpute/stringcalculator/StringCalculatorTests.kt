package com.sonalsatpute.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTests {

    private val calculator = StringCalculator(1000)

    @Test fun `empty string should return zero`() {
        assertEquals(0, calculator.add(" ").expectSuccess())
    }

    @Test fun `single number should return number` () {
        assertEquals(1, calculator.add("1").expectSuccess())
    }

    @Test fun `input two numbers delimited by comma should return sum` () {
        assertEquals(3, calculator.add("1,2").expectSuccess())
    }

    @Test fun `input two numbers delimited by new-line should return sum` () {
        assertEquals(3, calculator.add("1\n2").expectSuccess())
    }

    @Test fun `input multiple numbers delimited by comma should return sum` () {
        assertEquals(3, calculator.add("1,2").expectSuccess())
        assertEquals(6, calculator.add("1,2,3").expectSuccess())
        assertEquals(5, calculator.add("1,4").expectSuccess())
        assertEquals(5, calculator.add("1,1,1,1,1").expectSuccess())
    }

    @Test fun `input three numbers delimited comma and by new-line should return sum` () {
        assertEquals(6, calculator.add("1,2\n3").expectSuccess())
    }

    @Test fun `support different delimiters, should return sum where the default delimiter is provided as first line of string`() {
        assertEquals(3, calculator.add("//;\n1;2").expectSuccess())
    }

    @Test
    fun `negative number will throw an exception 'negatives not allowed' and the negative that was passed` () {
        assertEquals("Negative numbers not allowed -1", calculator.add("//;\n-1;2").expectFailure().message)
    }

    @Test fun `numbers bigger than 1000 should be ignored` () {
        assertEquals(2, calculator.add("1002,2").expectSuccess())
        assertEquals(0, calculator.add("1002,10010").expectSuccess())
        assertEquals(1001, calculator.add("1000,10010,1").expectSuccess())
    }
}