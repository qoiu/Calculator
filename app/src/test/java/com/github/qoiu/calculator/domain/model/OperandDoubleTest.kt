package com.github.qoiu.calculator.domain.model

import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import org.junit.Test

class OperandDoubleTest{

    @Test
    fun strange_text(){
        // TODO: 11.03.2022 Should I check it somehow? Or just delete?
        OperandDouble("some text").fixValue()
    }
}