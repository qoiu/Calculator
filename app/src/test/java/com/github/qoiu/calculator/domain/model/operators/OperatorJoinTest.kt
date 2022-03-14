package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.data.CalculatorMemory
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import com.github.qoiu.calculator.domain.model.trigonometric.TrigonometricSin
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.sin

class OperatorJoinTest{

    @Test
    fun global(){
        val calc = CalculatorMemory.Base()
        calc.join()
        assertEquals("(",calc.output())
        calc.append("25")
        println(calc.output())
        calc.add()
        calc.append("12")
        calc.join()
        calc.multiply()
        calc.append("2")
        assertEquals("74",calc.result())
        println(calc.output())
        println(calc.output())
    }
    @Test
    fun global_not_empty(){
        val calc = CalculatorMemory.Base()
        calc.append("25")
        println(calc.output())
        calc.add()
        calc.append("2")
        println(calc.output())
        calc.join()
        println(calc.output())
        assertEquals("25+(2",calc.output())
    }

    @Test
    fun global_join_is_empty(){
        val calc = CalculatorMemory.Base()
        calc.join()
        println(calc.output())
        calc.add()
        calc.append("2")
        println(calc.output())
        calc.join()
        println(calc.output())
        assertEquals("(2)",calc.output())
    }

    @Test
    fun append_operator_add(){
        val expected = OperatorJoin()
        assertEquals(expected,expected.append(OperatorAdd()))
    }

    @Test
    fun append_trig_sin_to_empty(){
        val expected = OperatorJoin(TrigonometricSin())
        assertEquals(expected,OperatorJoin().append(TrigonometricSin()))
    }

    @Test
    fun append_trig_sin_to_long(){
        val expected = OperatorJoin(TrigonometricSin("4"))
        val actual = OperatorJoin().append(TrigonometricSin()).append("4")
        assertEquals(expected,actual)
    }

    @Test
    fun delete(){
        var actual = OperatorJoin().append(TrigonometricSin()).append("4")
        actual = actual.delete()
        assertEquals(OperatorJoin(TrigonometricSin()),actual)
        actual = actual.delete()
        assertEquals(OperatorJoin(),actual)
        actual = actual.delete()
        assertEquals(OperandEmpty(),actual)
    }

    @Test
    fun trigonom(){
        val a= Math.toRadians(45.0)
        println(sin(a))
    }
}