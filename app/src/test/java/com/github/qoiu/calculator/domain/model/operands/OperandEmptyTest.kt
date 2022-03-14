package com.github.qoiu.calculator.domain.model.operands

import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import com.github.qoiu.calculator.domain.model.operators.OperatorJoin
import com.github.qoiu.calculator.domain.model.trigonometric.TrigonometricSin
import org.junit.Assert.assertEquals
import org.junit.Test

class OperandEmptyTest {

    @Test
    fun trigonometric_append(){
        val expected = TrigonometricSin()
        assertEquals(expected,OperandEmpty().append(expected))
    }

    @Test
    fun operator_add_append(){
        val expected = OperatorAdd()
        assertEquals(OperandEmpty(),OperandEmpty().append(expected))
    }

    @Test
    fun operator_join_append(){
        val expected = OperatorJoin()
        assertEquals(expected,OperandEmpty().append(expected))
    }

    @Test
    fun result() {
        assertEquals(OperandEmpty(), OperandEmpty().result())
    }

    @Test
    fun value() {
        assertEquals(0, OperandEmpty().value())
    }

    @Test
    fun to_string() {
        assertEquals("", OperandEmpty().toString())
    }
}