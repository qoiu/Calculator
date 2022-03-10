package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.OperandLong
import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import org.junit.Assert.*
import org.junit.Test

class CalculatorOperatorTest {

    @Test
    fun append() {
        val actual = OperatorAdd(OperandLong("2"))
        actual.append("2")
        assertEquals(OperandLong("4"), actual.result())
        assertEquals("2+2", actual.toString())
    }

    @Test
    fun delete() {
        var actual: Calculator = OperatorAdd(OperandLong("2"))
        actual = actual.append("2")
        actual = actual.append("3")
        actual = actual.append("4")
        assertEquals("2+234", actual.toString())
        actual = actual.delete()
        assertEquals("2+23", actual.toString())
        actual = actual.delete()
        assertEquals("2+2", actual.toString())
        actual = actual.delete()
        assertEquals("2+", actual.toString())
        assertEquals(OperatorAdd::class.java, actual.javaClass)
        actual = actual.delete()
        assertEquals(OperandLong("2"), actual)
    }

    @Test
    fun extra_test(){
        var actual: Calculator = OperatorAdd(OperandLong("0.25"))
        actual = actual.append("0.75").result()
        assertEquals(OperandLong("1"),actual)
    }
}