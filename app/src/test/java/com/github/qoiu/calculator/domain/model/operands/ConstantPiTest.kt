package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import org.junit.Assert.*
import org.junit.Test

const val DELTA = 1e-15
class ConstantPiTest{
    @Test
    fun append() {
        assertEquals(OperatorAdd(ConstantPi(),OperandLong("2")),ConstantPi().append(OperandLong("2")))
        assertEquals(ConstantPi(),ConstantPi().append("2"))
    }

    @Test
    fun mod() {
        val actual = ConstantPi()
        actual.mod()
        assertEquals(ConstantPi(),actual)
    }

    @Test
    fun testToString() {
        assertEquals("π",ConstantPi().toString())
    }

    @Test
    fun value() {
        assertEquals(Math.PI,ConstantPi().value(), DELTA)
    }
}