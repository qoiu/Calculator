package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.TestCase
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert.assertEquals
import org.junit.Test

class OperatorAddTest {
    private val testCases = listOf(
        TestCase("11111111.22222222", "22222222.33333333", OperandDecimal("33333333.55555555")),
        TestCase("0.0", "0.3", OperandDouble("0.3")),
        TestCase("1234567.0", "10.0", OperandLong("1234577")),
        TestCase("4567890.5", "10.5", OperandLong("4567901")),
        TestCase("888888888888.0", "888888888888.0", OperandDecimal("1777777777776")),
        TestCase("1234567890.23", "10.25", OperandDecimal("1234567900.48")),
        TestCase("25", "25", OperandLong("50")),
        TestCase("25", "-25", OperandLong("0"))
    )

    @Test
    fun test_decimal() {
        testCases.forEach {
            val o1 = OperatorAdd(OperandDecimal(it.o1)).append(it.o2)
            val result = o1.result()
            val result2 = it.expected.result()
            assertEquals(result2.fixValue(), result.result())
            println(it)
        }
    }

    @Test
    fun to_string() {
        with(testCases[0]) {
            assertEquals(
                "${this.o1}+${this.o2}",
                OperatorAdd(OperandDecimal(this.o1)).append(this.o2).toString()
            )
        }
    }
}