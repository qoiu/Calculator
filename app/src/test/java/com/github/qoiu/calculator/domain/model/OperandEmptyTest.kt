package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import org.junit.Test

class OperandEmptyTest{
    @Test(expected = IllegalStateException::class)
    fun result(){
        OperandEmpty().result()
    }


    @Test(expected = ClassCastException::class)
    fun compare_with_type(){
        OperandEmpty().compareTypeWith(OperandEmpty())
    }

    @Test(expected = java.lang.IllegalStateException::class)
    fun value(){
        OperandEmpty().value()
    }
}