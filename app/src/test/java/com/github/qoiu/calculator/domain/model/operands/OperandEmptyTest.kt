package com.github.qoiu.calculator.domain.model.operands

import org.junit.Test

class OperandEmptyTest{
    @Test(expected = IllegalStateException::class)
    fun result(){
        OperandEmpty().result()
    }


    @Test(expected = java.lang.IllegalStateException::class)
    fun value(){
        OperandEmpty().value()
    }
}