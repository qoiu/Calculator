package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.operands.OperandLong
import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class BaseTrigonometricOperandTest {

    @Test
    fun empty_result() {
        assertEquals(OperandLong("0"), TrigonometricCos().result())
    }

    @Test
    fun last_operand() {
        assertEquals(OperandLong("0"), TrigonometricCos().lastOperand())
    }

    @Test
    fun append() {
        val operand = OperandLong("321")
        val operator = OperatorAdd()
        val trigonometricCos = TrigonometricCos("12")
        assertEquals(OperatorAdd(trigonometricCos, operand), trigonometricCos.append(operand))
        assertEquals(OperatorAdd(trigonometricCos), trigonometricCos.append(operator))
    }


    @Test
    fun equals_hash() {
        val o1 = TrigonometricSin("23")
        val o2 = TrigonometricSin("23")
        val o4 = TrigonometricSin("25")
        Assert.assertTrue(o1 == o1)
        Assert.assertTrue(o1 == o2)
        Assert.assertTrue(o2 == o1)
        Assert.assertTrue(o1 != o4)
        assertEquals(o1.hashCode(), o2.hashCode())
        Assert.assertNotEquals(o1.hashCode(), o4.hashCode())
    }

}