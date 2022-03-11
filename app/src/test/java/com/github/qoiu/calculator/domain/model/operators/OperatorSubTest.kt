package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.TestCase
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert
import org.junit.Test

class OperatorSubTest {

    private val testCases = listOf(
        TestCase("22222222.33333333", "11111111.22222222", OperandDecimal("11111111.11111111")),
        TestCase("0.0", "0.3", OperandDouble("-0.3")),
        TestCase("1234567.0", "10.0", OperandLong("1234557")),
        TestCase("4567890.5", "10.5", OperandLong("4567880")),
        TestCase("888888888888.0", "-888888888888.0", OperandLong("1777777777776")),
        TestCase("1234567890.23", "10.25", OperandDouble("1234567879.98")),
        TestCase("25", "25", OperandLong("0")),
        TestCase("25", "-25", OperandLong("50"))
    )

    @Test
    fun test_decimal() {
        testCases.forEach {
            val o1 = OperatorSub(OperandDecimal(it.o1)).append(it.o2)
            println(it)
            Assert.assertEquals(it.expected, o1.result())
        }
    }

    @Test
    fun to_string() {
        with(testCases[0]) {
            Assert.assertEquals(
                "${this.o1}-${this.o2}",
                OperatorSub(OperandDecimal(this.o1)).append(this.o2).toString()
            )
        }
    }
}