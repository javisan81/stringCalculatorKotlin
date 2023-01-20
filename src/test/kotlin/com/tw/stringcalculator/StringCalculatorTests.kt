package com.tw.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCalculatorTests {
    fun add(numbers: String): Int {
        if(numbers.isEmpty()){
            return 0
        }
        return numbers.toInt()
    }

    @Test
    fun `should return 0 with an empty string`() {
        assertEquals(0, add(""))
    }
    @Test
    fun `should return 1 for 1`() {
        assertEquals(1, add("1"))
    }
}