package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import org.junit.Assert.*
import org.junit.Test

class TrigonometricSqrtTest {

    @Test
    fun global() {
        val sqrt = TrigonometricSqrt("36")
        assertEquals("√(36)", sqrt.toString())
        assertEquals(OperandLong("6"), sqrt.result())
        var actual: CalculatorObject = TrigonometricSqrt()
        actual = actual.append("25")
        assertEquals("√(25)", actual.toString())
        assertEquals(OperandLong("5"), actual.result())
    }

    @Test
    fun in_memory() {
        val calc = CalculatorMemory.Base()
        calc.append("9")
        calc.sqrt()
        assertEquals("√(9)", calc.output())
        calc.sqrt()
        calc.append("3")
        println(calc.output())
    }
}