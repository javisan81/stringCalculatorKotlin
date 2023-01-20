package com.tw.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTests {
    fun add(numbers: String): Int {
        return if (numbers.isEmpty()) return 0 else numbers.split(',', '\n').sumBy { it.toInt() }
    }

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

}