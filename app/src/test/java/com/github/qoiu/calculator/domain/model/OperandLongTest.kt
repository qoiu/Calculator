package com.github.qoiu.calculator.domain.model

import org.junit.Assert.*
import org.junit.Test

class OperandLongTest{

    private val testCasesLongSum = listOf(
        TestCase("25", "25", OperandLong("50")),
        TestCase("25", "-25", OperandLong("0"))
    )

    @Test
    fun operand_long_plus(){
        testCasesLongSum.forEach {
            assertEquals(it.expected,OperandLong(it.o1).plus(OperandLong(it.o2)))
            println(it)
        }
    }

}