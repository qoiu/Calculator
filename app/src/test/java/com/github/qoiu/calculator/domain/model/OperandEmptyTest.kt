package com.github.qoiu.calculator.domain.model

import org.junit.Test

class OperandEmptyTest{
    @Test(expected = IllegalStateException::class)
    fun result(){
        OperandEmpty().result()
    }

    @Test(expected = IllegalStateException::class)
    fun plus(){
        OperandEmpty().plus(OperandEmpty())
    }

    @Test(expected = ClassCastException::class)
    fun compare_with_type(){
        OperandEmpty().compareTypeWith(OperandEmpty())
    }
}