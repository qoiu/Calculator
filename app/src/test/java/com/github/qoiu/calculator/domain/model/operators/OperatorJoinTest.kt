package com.github.qoiu.calculator.domain.model.operators

import com.github.qoiu.calculator.data.CalculatorMemory
import org.junit.Test
import kotlin.math.sin

class OperatorJoinTest{

    @Test
    fun global(){
        val calc = CalculatorMemory.Base()
        calc.append("25")
        println(calc.output())
        calc.add()
        println(calc.output())
        calc.join()
        println(calc.output())
    }
    @Test
    fun global_not_emopty(){
        val calc = CalculatorMemory.Base()
        calc.append("25")
        println(calc.output())
        calc.add()
        calc.append("2")
        println(calc.output())
        calc.join()
        println(calc.output())
    }

    @Test
    fun trigonom(){
        val a= Math.toRadians(45.0)
        println(sin(a))
    }

}