package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
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