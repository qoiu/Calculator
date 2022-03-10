package com.github.qoiu.calculator.domain.model

import org.junit.Assert.*
import org.junit.Test

class OperandDecimalTest{

    private val testCaseDecimalSum = listOf(
        TestCase("11111111.22222222","22222222.33333333",OperandDecimal("33333333.55555555"))
    )

    @Test
    fun operand_decimal_plus(){
        testCaseDecimalSum.forEach {
            println(it)
            assertEquals(it.expected,OperandDecimal(it.o1).plus(OperandDecimal(it.o2)))
        }
    }
}