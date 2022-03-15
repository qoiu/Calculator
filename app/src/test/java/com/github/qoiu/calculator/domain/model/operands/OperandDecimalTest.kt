package com.github.qoiu.calculator.domain.model.operands

import org.junit.Assert.*
import org.junit.Test

class OperandDecimalTest {

    @Test
    fun mod() {
        val operand = OperandDecimal("298989889.98888888")
        operand.mod()
        assertEquals(OperandDecimal("-298989889.98888888"), operand)
    }
}