package com.tw.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTests {
    fun add(input: String): Int {
        if (input.startsWith("//")) {
            val delimiter = input[2];
            val numbers = input.replace("//"+delimiter+"\n", "")
            return sum(numbers, delimiter)
        }
        return sum(input, ',')
    }

    private fun sum(input: String, delimiter: Char) =
        if (input.isEmpty()) 0 else input.split(delimiter, '\n').sumBy { it.toInt() }

    @Test
    fun `should return 0 with an empty string`() {
        assertEquals(0, add(""))
    }

    @Test
    fun `should return 1 for 1`() {
        assertEquals(1, add("1"))
    }

    @Test
    fun `should return 2 for 2`() {
        assertEquals(2, add("2"))
    }

    @Test
    fun `should return 3 for 1,2`() {
        assertEquals(3, add("1,2"))
    }

    @Test
    fun `should return 4 for 1,3`() {
        assertEquals(4, add("1,3"))
    }

    @Test
    fun `should return 11 for 10,1`() {
        assertEquals(11, add("10,1"))
    }

    @Test
    fun `should return 6 for 1newLine2,3`() {
        assertEquals(6, add("1\n2,3"))
    }

    @Test
    fun `should return 3 when semicolon is the delimeter`() {
        assertEquals(3, add("//;\n1;2"))
    }

    @Test
    fun `should return 4 when semicolon is the delimiter and having two 2s`() {
        assertEquals(4, add("//;\n2;2"))
    }

    @Test
    fun `should return 0 when semicolon is the delimiter and we dont have anything else`() {
        assertEquals(0, add("//;\n"))
    }


    @Test
    fun `it should return 4 when inputing 2 | 2`() {
        assertEquals(4, add("//|\n2|2"))
    }
}