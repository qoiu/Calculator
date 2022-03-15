package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import org.junit.Assert.assertEquals
import org.junit.Test

class TrigonometricCosTest {

    @Test
    fun global() {
        val cos = TrigonometricCos("30")
        assertEquals("cos(30)", cos.toString())
        assertEquals(OperandDecimal("0.8660254037844387"), cos.result())
        var actual: CalculatorObject = TrigonometricCos()
        actual = actual.append("90")
        assertEquals("cos(90)", actual.toString())
    }

    @Test
    fun in_memory() {
        val calc = CalculatorMemory.Base()
        calc.append("24")
        calc.cos()
        assertEquals("cos(24)", calc.output())
        calc.cos()
        calc.append("23")
        println(calc.output())
    }
}