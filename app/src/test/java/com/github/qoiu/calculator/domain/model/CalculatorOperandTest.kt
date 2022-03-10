package com.github.qoiu.calculator.domain.model

import org.junit.Assert.*
import org.junit.Test

class CalculatorOperandTest {

    @Test
    fun operand_append() {
        var actual: Calculator.Operand<*> = OperandEmpty()
        actual = actual.append("5")
        assertEquals(OperandLong("5"), actual.result())
        actual = actual.append("6")
        assertEquals(OperandLong("56"), actual.result())
        actual = actual.append(".")
        assertEquals(OperandDouble("56."), actual.result())
        actual = actual.append("0")
        assertEquals(OperandDouble("56.0"), actual.result())
    }

    @Test(expected = IllegalStateException::class)
    fun operand_long_upperBound() {
        val actual: Calculator.Operand<*> = OperandLong("123456789")
        actual.append("2")
    }

    @Test
    fun operand_delete() {
        var actual: Calculator.Operand<*> = OperandLong("235.82")
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
    fun operand_compare() {
        assertEquals(OperandDouble("23"), OperandLong("23").compareTypeWith(OperandDouble("233.5")))
        assertEquals(
            OperandDouble("233.5"),
            OperandDouble("233.5").compareTypeWith(OperandDouble("2.5"))
        )
        assertEquals(
            OperandDouble("233.5"),
            OperandDouble("233.5").compareTypeWith(OperandLong("2.5"))
        )
        assertEquals(
            OperandDouble("0.0"),
            OperandDouble("0.0").compareTypeWith(OperandLong("2.5"))
        )
        assertEquals(
            OperandDecimal("233.5"),
            OperandDouble("233.5").compareTypeWith(OperandDecimal("123456789.123456789"))
        )
        assertEquals(
            OperandDecimal("123456789.123456789"),
            OperandDecimal("123456789.123456789").compareTypeWith(OperandDouble("233.5"))
        )
    }
}