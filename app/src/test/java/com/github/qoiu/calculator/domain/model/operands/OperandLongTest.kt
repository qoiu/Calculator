package com.github.qoiu.calculator.domain.model.operands

import org.junit.Assert.*
import org.junit.Test

class OperandLongTest {

    @Test
    fun value() {
        assertTrue(OperandLong("23").value() == 23L)
    }

    @Test
    fun mod() {
        val operand = OperandLong("9")
        operand.mod()
        assertEquals(OperandLong("-9"), operand)
    }
}