  package com.github.qoiu.calculator.domain.model

import org.junit.Test

class OperatorAddTest{
    @Test(expected = ClassCastException::class)
    fun wrongClass(){
        OperatorAdd(OperandLong("23")).operation(OperandLong("23"),OperandDecimal("23.5"))
    }
}