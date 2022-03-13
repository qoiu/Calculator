package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.TestCase
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert
import org.junit.Test

class OperatorPowTest {
    private val testCases = listOf(
        TestCase("2", "2", OperandLong("4")),
        TestCase("25", "3", OperandLong("15625"))
    )

    @Test
    fun test_decimal() {
        testCases.forEach {
            val o1 = OperatorPow(OperandDecimal(it.o1)).append(it.o2)
            println(it)
            Assert.assertEquals(it.expected, o1.result())
        }
    }

    @Test
    fun to_string() {
        with(testCases[0]) {
            Assert.assertEquals(
                "${this.o1}^(${this.o2})",
                OperatorPow(OperandDecimal(this.o1)).append(this.o2).toString()
            )
        }
    }
}