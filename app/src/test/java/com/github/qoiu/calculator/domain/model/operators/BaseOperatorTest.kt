package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import com.github.qoiu.calculator.domain.model.trigonometric.TrigonometricSin
import org.junit.Assert.*

import org.junit.Test

class BaseOperatorTest {

    @Test
    fun append() {
        val actual = OperatorAdd(OperandDecimal("2"))
        actual.append("2")
        assertEquals(OperandLong("4"), actual.result())
        assertEquals("2+2", actual.toString())
    }

    @Test
    fun last_operand() {
        val expected = OperandDouble("2.3")
        val actual = OperatorMultiply(OperandLong("23"), expected)
        assertEquals(expected, actual.lastOperand())
    }

    @Test
    fun append_operand() {
        val operand = OperandDouble("2.3")
        val expected = OperatorMultiply(OperandLong("23"), operand)
        val actual = OperatorMultiply(OperandLong("23"), OperandEmpty())
        assertEquals(expected, actual.append(operand))
    }

    @Test
    fun append_operand_not_empty() {
        val operand = OperandDouble("2.3")
        val expected = OperatorMultiply(OperandLong("23"), OperatorAdd(operand, operand))
        val actual = OperatorMultiply(OperandLong("23"), operand)
        assertEquals(expected, actual.append(operand))
    }

    @Test
    fun delete() {
        var actual: CalculatorObject = OperatorAdd(OperandDecimal("2").fixValue())
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
        assertEquals(OperandLong("2"), actual.result())
    }

    @Test
    fun extra_test() {
        var actual: CalculatorObject = OperatorAdd(OperandDecimal("0.25"))
        actual = actual.append("0.75").result()
        assertEquals(OperandLong("1"), actual)
    }

    @Test
    fun add_with_operand() {
        var actual: CalculatorObject = OperatorAdd().init(OperandLong("2"))
        actual = actual.append(OperatorAdd())
        actual = actual.append("32")
        actual = actual.append(OperatorSub())
        actual = actual.append(OperatorMultiply())
        actual = actual.append("2")
        assertEquals(OperandLong("66"), actual.result())
    }

    @Test
    fun add_with_operand_reverse() {
        var actual: CalculatorObject = OperatorAdd().init(OperandLong("2"))
        actual = actual.append(OperatorAdd())
        actual = actual.append("32")
        actual = actual.append(OperatorMultiply())
        actual = actual.append(OperatorSub())
        actual = actual.append("2")
        assertEquals(OperandLong("32"), actual.result())
    }

    @Test
    fun global_test() {
        //8+6*2/3-5=7
        var actual: CalculatorObject = OperatorAdd(OperandDecimal("8"), OperandLong("6"))
        actual = (actual as BaseOperator).append(OperatorMultiply())
        actual = actual.append("2")
        actual = (actual as BaseOperator).append(OperatorDiv())
        actual = actual.append("3")
        actual = (actual as BaseOperator).append(OperatorSub())
        actual = actual.append("5")
        actual = actual.result()
        assertEquals(OperandLong("7"), actual)
        assertEquals("7", actual.toString())
    }


    @Test
    fun equals_hash() {
        val o1 = OperatorAdd(OperandLong("23"))
        val o2 = OperatorAdd(OperandLong("23"))
        val o3 = OperatorSub(OperandLong("23"))
        val o4 = OperatorAdd(OperandLong("25"))
        assertTrue(o1 == o1)
        assertTrue(o1 == o2)
        assertTrue(o2 == o1)
        assertTrue(!o1.equals(o3))
        assertTrue(o1 != o4)
        assertEquals(o1.hashCode(), o2.hashCode())
        assertNotEquals(o1.hashCode(), o4.hashCode())
    }

    @Test
    fun trigonom_append() {
        val actual = OperatorAdd(OperandLong("25")).append("12")
        assertEquals(
            OperatorAdd(OperandLong("25"), TrigonometricSin("12")),
            actual.append(TrigonometricSin("12"))
        )
    }

    @Test
    fun trigonom_append_empty() {
        val actual = OperatorAdd(OperandLong("25"))
        assertEquals(
            OperatorAdd(OperandLong("25"), TrigonometricSin()),
            actual.append(TrigonometricSin())
        )
    }
}