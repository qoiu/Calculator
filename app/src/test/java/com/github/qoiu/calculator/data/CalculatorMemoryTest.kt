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
        assertEquals("8", calculator.result())
        calculator.add()
        assertEquals("8", calculator.result())
        calculator.append("6")
        assertEquals("14", calculator.result())
        calculator.multiply()
        assertEquals("14", calculator.result())
        calculator.append("2")
        assertEquals("20", calculator.result())
        calculator.div()
        calculator.append("3")
        assertEquals("12", calculator.result())
        calculator.sub()
        calculator.append("5")
        assertEquals("7", calculator.result())
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


    @Test
    fun global_reverse() {
        val calculator = CalculatorMemory.Base()
        calculator.append("8")
        calculator.sub()
        calculator.append("6")
        assertEquals("2", calculator.result())
        calculator.div()
        calculator.append("2")
        assertEquals("5", calculator.result())
        calculator.multiply()
        calculator.append("3")
        assertEquals("(-1)", calculator.result())
        calculator.add()
        calculator.append("5")
        assertEquals("4", calculator.result())
    }

    @Test
    fun minus_plus() {
        val calc = CalculatorMemory.Base()
        calc.append("56")
        calc.sub()
        calc.append("6")
        calc.add()
        calc.append("25")
        assertEquals("75", calc.result())
    }

    @Test
    fun plus_minus() {
        val calc = CalculatorMemory.Base()
        calc.append("56")
        calc.add()
        calc.append("6")
        calc.sub()
        calc.append("25")
        assertEquals("37", calc.result())
    }

    @Test
    fun global_pow_test() {
        val calculator = CalculatorMemory.Base()
        calculator.append("6")
        calculator.add()
        calculator.append("2")
        calculator.pow()
        calculator.append("6")
        assertEquals("70", calculator.result())

    }
}