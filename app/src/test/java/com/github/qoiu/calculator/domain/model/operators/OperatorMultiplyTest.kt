package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.domain.model.TestCase
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert.assertEquals
import org.junit.Test

class OperatorMultiplyTest {
    private val testCases = listOf(
        TestCase(
            "11111111.22222222",
            "22222222.33333333",
            OperandDouble("2.4691358395061722E14")
        ),
        TestCase("0.02", "0.3", OperandDouble("0.006")),
        TestCase("0.0", "0.3", OperandLong("0")),
        TestCase("1234567.0", "10.0", OperandLong("12345670")),
        TestCase("4567890.5", "10.5", OperandDouble("4.796285025E7")),
        TestCase("888888888888.0", "888888888888.0", OperandDouble("7.901234567885432E23")),
        TestCase("1234567890.23", "10.25", OperandDouble("1.26543208748575E10")),
        TestCase("-25", "25", OperandLong("-625")),
        TestCase("25", "0", OperandLong("0")),
        TestCase("3900", "3900", OperandLong("15210000")),
        TestCase("15210000", "15210000", OperandLong("231344100000000")),
        TestCase("231344100000000", "15210000", OperandDouble("3.518743761E21"))
    )

    @Test
    fun test_decimal() {
        testCases.forEach {
            val o1 = OperatorMultiply(OperandDecimal(it.o1)).append(it.o2)
            assertEquals(it.expected, o1.result())
            println(it)
        }
    }

    @Test
    fun to_string() {
        with(testCases[0]) {
            assertEquals(
                "${this.o1}*${this.o2}",
                OperatorMultiply(OperandDecimal(this.o1)).append(this.o2).toString()
            )
        }
    }
}