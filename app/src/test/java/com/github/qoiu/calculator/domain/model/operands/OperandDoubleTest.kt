package com.github.qoiu.calculator.domain.model.operands

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OperandDoubleTest {

    @Test
    fun value() {
        assertTrue(OperandDouble("23.5").value() == 23.5)
    }

    @Test
    fun mod() {
        val operand = OperandDouble("2.9")
        operand.mod()
        assertEquals(OperandDouble("-2.9"), operand)
    }
}