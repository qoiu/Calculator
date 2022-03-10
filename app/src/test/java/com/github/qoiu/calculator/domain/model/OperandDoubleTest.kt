package com.github.qoiu.calculator.domain.model

import org.junit.Assert.*
import org.junit.Test

class OperandDoubleTest{

    private val testCasesDoubleSum= listOf(
        TestCase("0.0","0.3",OperandDouble("0.3")),
        TestCase("1234567.0","10.0",OperandLong("1234577")),
        TestCase("4567890.0","10.0",OperandLong("4567900")),
        TestCase("1234567890.23","10.25",OperandDecimal("1234567900.48"))
    )

    @Test
    fun operand_double_plus(){
        testCasesDoubleSum.forEach {
            println(it)
            assertEquals(it.expected,OperandDouble(it.o1).plus(OperandDouble(it.o2)))
        }
    }
}