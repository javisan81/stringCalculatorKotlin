package com.tw.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTests {
    fun add(numbers: String): Int {
        if (numbers.isEmpty()) {
            return 0
        }

            return numbers.split(',').sumBy { it.toInt() }

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
    fun `should return 3 for 1,2` () {
        assertEquals(3, add("1,2"))
    }

    @Test
    fun `should return 4 for 1,3` () {
        assertEquals(4, add("1,3"))
    }
}