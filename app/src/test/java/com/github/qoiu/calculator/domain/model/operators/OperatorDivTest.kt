package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.TestCase
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert.assertEquals
import org.junit.Test

class OperatorDivTest {

    private val testCases = listOf(
        TestCase("1", "6", OperandDouble("0.1666666667")),
        TestCase("22222222.33333333", "11111111.22222222", OperandDouble("1.99999999")),
        TestCase("0.0", "0.3", OperandLong("0")),
        TestCase("1234567.0", "10.0", OperandDouble("123456.7")),
        TestCase("4567890.5", "10.5", OperandDecimal("435037.1904761905")),
        TestCase("888888888888.0", "-888888888888.0", OperandLong("-1")),
        TestCase("25", "25", OperandLong("1")),
        TestCase("25", "-25", OperandLong("-1"))
    )

    @Test
    fun test_division() {
        testCases.forEach {
            val o1 = OperatorDiv(OperandDecimal(it.o1), OperandDecimal(it.o2)).result()
            println(it)
            println(o1)
            assertEquals(it.expected, o1)
        }
    }

    @Test
    fun to_string() {
        with(testCases[0]) {
            assertEquals(
                "${this.o1}/${this.o2}",
                OperatorDiv(OperandDecimal(this.o1)).append(this.o2).toString()
            )
        }
    }

    @Test(expected = ArithmeticException::class)
    fun byZero() {
        OperatorDiv(OperandDecimal("25")).append("0").result()
    }
}