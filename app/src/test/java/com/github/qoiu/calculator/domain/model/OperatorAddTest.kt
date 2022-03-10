package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import org.junit.Assert
import org.junit.Test

class OperatorAddTest {
    private val testCaseDecimalSum = listOf(
        TestCase("11111111.22222222", "22222222.33333333", OperandDecimal("33333333.55555555"))
    )

    private val testCasesDoubleSum = listOf(
        TestCase("0.0", "0.3", OperandDouble("0.3")),
        TestCase("1234567.0", "10.0", OperandLong("1234577")),
        TestCase("4567890.5", "10.5", OperandLong("4567901")),
        TestCase("888888888888.0", "888888888888.0", OperandDecimal("1777777777776.0")),
        TestCase("1234567890.23", "10.25", OperandDecimal("1234567900.48"))
    )

    private val testCasesLongSum = listOf(
        TestCase("25", "25", OperandLong("50")),
        TestCase("25", "-25", OperandLong("0"))
    )

    @Test
    fun test_long() {
        testCasesLongSum.forEach {
            val o1 = OperatorAdd(OperandLong(it.o1)).append(it.o2)
            Assert.assertEquals(it.expected, o1.result())
            println(it)
        }
    }

    @Test
    fun test_double() {
        testCasesDoubleSum.forEach {
            val o1 = OperatorAdd(OperandDouble(it.o1)).append(it.o2)
            println(it)
            Assert.assertEquals(it.expected, o1.result())
        }
    }

    @Test
    fun test_decimal() {
        testCaseDecimalSum.forEach {
            val o1 = OperatorAdd(OperandDecimal(it.o1)).append(it.o2)
            Assert.assertEquals(it.expected, o1.result())
            println(it)
        }
    }
}