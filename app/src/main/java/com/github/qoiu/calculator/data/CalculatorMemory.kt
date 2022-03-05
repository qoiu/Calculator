package com.github.qoiu.calculator.data

import android.util.Log
import com.github.qoiu.calculator.domain.Calculator
import java.util.*

interface CalculatorMemory {
    fun append(value: Int)
    fun output(): List<Calculator>
    class Base():CalculatorMemory{
        private var lastValue: Calculator = Calculator.Add()
        private val operations: Stack<Calculator> = Stack()
        override fun append(value: Int) {
            Log.w("Memory",value.toString())
            if(lastValue is Calculator.Operand){
                    (lastValue as Calculator.Operand).action(value)
            }else{
                lastValue = Calculator.Operand(value)
                operations.add(lastValue)
            }
            output()
        }

        override fun output(): List<Calculator> {
            Log.w("Memory out",operations.toString())
            return operations
        }
    }
}