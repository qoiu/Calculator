package com.github.qoiu.calculator.domain.model.operands

import org.junit.Assert.assertTrue
import org.junit.Test

class OperandDoubleTest {

    @Test
    fun strange_text() {
        // TODO: 11.03.2022 Should I check it somehow? Or just delete?
        OperandDouble("some text").fixValue()
    }

    @Test
    fun value() {
        assertTrue(OperandDouble("23.5").value() == 23.5)
    }
}