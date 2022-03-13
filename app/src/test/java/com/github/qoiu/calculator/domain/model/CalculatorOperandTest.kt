package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.*
import org.junit.Assert.*
import org.junit.Test

class CalculatorOperandTest {

    @Test
    fun operand_append() {
        var actual: Operand<*> = OperandEmpty()
        actual = actual.append("5")
        assertEquals(OperandLong("5"), actual.result())
        actual = actual.append("6")
        assertEquals(OperandLong("56"), actual.result())
    }

    @Test
    fun operand_delete() {
        var actual: Operand<*> = OperandLong("235.82")
        actual = actual.delete()
        assertEquals(OperandDouble("235.8"), actual)
        actual = actual.delete()
        assertEquals(OperandDouble("235."), actual)
        actual = actual.delete()
        assertEquals(OperandLong("235"), actual)
        actual = actual.delete()
        assertEquals(OperandLong("23"), actual)
        actual = actual.delete()
        assertEquals(OperandLong("2"), actual)
        actual = actual.delete()
        assertEquals(OperandEmpty(), actual)
        actual = actual.delete()
        assertEquals(OperandEmpty(), actual)
    }


    @Test
    fun equals_hash() {
        val o1 = OperandDecimal("23")
        val o2 = OperandDecimal("23")
        val o3 = OperandLong("23")
        val o4 = OperandDecimal("25")
        assertTrue(o1 == o1)
        assertTrue(o1 == o2)
        assertTrue(o2 == o1)
        assertTrue(!o1.equals(o3))
        assertTrue(o1 != o4)
        assertEquals(o1.hashCode(), o2.hashCode())
    }
}