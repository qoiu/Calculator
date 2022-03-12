package com.github.qoiu.calculator.data

import org.junit.Assert.*
import org.junit.Test

class CalculatorMemoryTest {

    @Test
    fun global() {
        //8+6*2/3-5=7
        val calculator = CalculatorMemory.Base()
        calculator.append("8")
        calculator.add()
        calculator.append("6")
        assertEquals("14", calculator.result())
        calculator.multiply()
        calculator.append("2")
        assertEquals("20", calculator.result())
        calculator.div()
        calculator.append("3")
        assertEquals("12", calculator.result())
        calculator.sub()
        calculator.append("5")
        assertEquals("7", calculator.result())
    }

    @Test
    fun global_delete() {
        val calculator = CalculatorMemory.Base()
        calculator.append("8")
        calculator.add()
        calculator.append("6")
        calculator.multiply()
        calculator.append("2")
        calculator.div()
        calculator.append("3")
        calculator.sub()
        calculator.append("5")
        //8+6*2/3-5
        calculator.delete()
        assertEquals("12", calculator.result())
        calculator.delete()
        calculator.delete()
        assertEquals("20", calculator.result())
        calculator.delete()
        calculator.delete()
        assertEquals("14", calculator.result())
    }
}