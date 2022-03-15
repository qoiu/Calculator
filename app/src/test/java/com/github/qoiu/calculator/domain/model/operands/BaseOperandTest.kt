package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import org.junit.Assert.*
import org.junit.Test

class BaseOperandTest {

    @Test
    fun append_operand() {
        val o1 = OperandLong("3")
        val o2 = OperandLong("5")
        assertEquals(OperatorAdd(o1, o2), o1.append(o2))
    }

    @Test
    fun last_operand() {
        val o1 = OperandLong("3")
        assertEquals(o1, o1.lastOperand())
    }
}