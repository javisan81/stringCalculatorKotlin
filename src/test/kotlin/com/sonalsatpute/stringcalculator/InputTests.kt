package com.sonalsatpute.stringcalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InputTests {

    @Test
    fun `single number input should convert to list of number`() {
        assertEquals(listOf(1), Input(inputString = "1").toNumbers())
    }

    @Test
    fun `multiple numbers input delimited by comma should convert to list of numbers`() {
        assertEquals(listOf(1, 2, 3, 4), Input(inputString = "1,2,3,4").toNumbers())
    }

    @Test
    fun `multiple numbers input delimited by custom delimiters should convert to list of numbers`() {
        val numbers = Input(delimiterString = "|", inputString = "1,2|3|4").toNumbers()
        assertEquals(listOf(1, 2, 3, 4), numbers)
    }
}