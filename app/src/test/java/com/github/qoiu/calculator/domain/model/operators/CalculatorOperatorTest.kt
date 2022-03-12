package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert.*
import org.junit.Test

class CalculatorOperatorTest {

    @Test
    fun append() {
        val actual = OperatorAdd(OperandDecimal("2"))
        actual.append("2")
        assertEquals(OperandLong("4"), actual.result())
        assertEquals("2+2", actual.toString())
    }

    @Test
    fun delete() {
        var actual: Calculator = OperatorAdd(OperandDecimal("2").fixValue())
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
    fun extra_test() {
        var actual: Calculator = OperatorAdd(OperandDecimal("0.25"))
        actual = actual.append("0.75").result()
        assertEquals(OperandLong("1"), actual)
    }

    @Test
    fun global_test() {
        //8+6*2/3-5=7
        var actual: Calculator = OperatorAdd(OperandDecimal("8")).append("6")
        actual = (actual as Operator).append(OperatorMultiply())
        actual = actual.append("2")
        actual = (actual as Operator).append(OperatorDiv())
        actual = actual.append("3")
        actual = (actual as Operator).append(OperatorSub())
        actual = actual.append("5")
        actual = actual.result()

        assertEquals(7L, actual.value())
    }
}