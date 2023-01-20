package com.tw.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTests {
    fun add(numbers: String): Int {
        return 0
    }

    @Test
    fun `should return 0 with an empty string`() {
        assertEquals(0, add(""))
    }
}