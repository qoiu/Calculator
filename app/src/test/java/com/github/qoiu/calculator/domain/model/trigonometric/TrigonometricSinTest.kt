package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandDecimal
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert.*
import org.junit.Test

class TrigonometricSinTest{

    @Test
    fun global(){
        val sin = TrigonometricSin("30")
        assertEquals("sin(30)",sin.toString())
        assertEquals(OperandDecimal("0.49999999999999994"),sin.result())
        var actual: CalculatorObject = TrigonometricSin()
        actual = actual.append("90")
        assertEquals("sin(90)",actual.toString())
        assertEquals(OperandLong("1"),actual.result())
    }

    @Test
    fun in_memory(){
        val calc=  CalculatorMemory.Base()
        calc.append("24")
        calc.sin()
        assertEquals("sin(24)",calc.output())
        calc.sin()
        calc.append("23")
        println(calc.output())
    }
}