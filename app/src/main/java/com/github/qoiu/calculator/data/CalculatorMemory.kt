package com.github.qoiu.calculator.data

import android.util.Log
import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.Operand
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import java.util.*

interface CalculatorMemory {
    fun append(value: String)
    fun output(): List<Calculator>

    class Base : CalculatorMemory {
        private var lastValue: Calculator = OperandEmpty()
        private val operations: Stack<Calculator> = Stack()
        override fun append(value: String) {
            Log.w("Memory", value)
            if (lastValue is Operand<*> && lastValue !is OperandEmpty) {
                (lastValue as OperandLong).append(value)
            } else {
                lastValue = OperandLong(value)
                operations.add(lastValue)
            }
            output()
        }

        override fun output(): List<Calculator> {
            Log.w("Memory out", operations.toString())
            return operations
        }
    }
}