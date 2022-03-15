package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import org.junit.Assert.assertEquals

import org.junit.Test

class ConstantETest {

    @Test
    fun append() {
        assertEquals(
            OperatorAdd(ConstantE(), OperandLong("2")),
            ConstantE().append(OperandLong("2"))
        )
        assertEquals(ConstantE(), ConstantE().append("2"))
    }

    @Test
    fun mod() {
        val actual = ConstantE()
        actual.mod()
        assertEquals(ConstantE(), actual)
    }

    @Test
    fun testToString() {
        assertEquals("e", ConstantE().toString())
    }

    @Test
    fun value() {
        assertEquals(Math.E, ConstantE().value(), DELTA)
    }
}