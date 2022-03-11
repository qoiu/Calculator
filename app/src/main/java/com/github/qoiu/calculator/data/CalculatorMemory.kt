package com.github.qoiu.calculator.data

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.operands.Operand
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import com.github.qoiu.calculator.domain.model.operators.OperatorAdd
import com.github.qoiu.calculator.domain.model.operators.OperatorDiv
import com.github.qoiu.calculator.domain.model.operators.OperatorMultiply
import com.github.qoiu.calculator.domain.model.operators.OperatorSub
import java.util.*

interface CalculatorMemory {
    fun append(value: String)
    fun delete()
    fun add()
    fun sub()
    fun multiply()
    fun div()
    fun result(): String
    fun output(): String

    class Base : CalculatorMemory {
        private var lastValue: Calculator = OperandEmpty()
        private val operations: Stack<Calculator> = Stack()
        override fun append(value: String) {
            if (lastValue is OperandEmpty) {
                lastValue = OperandLong(value)
                operations.add(lastValue)
            } else {
                lastValue = lastValue.append(value)
            }
            output()
        }

        override fun delete() {
            lastValue = lastValue.delete()
            output()
        }

        override fun add() {
            if (lastValue is Operand<*>)
                lastValue = OperatorAdd(lastValue.result().toOperandDecimal())
            else
                lastValue = OperatorAdd(lastValue)
            output()
        }

        override fun sub() {
            if (lastValue is Operand<*>)
                lastValue = OperatorSub(lastValue.result().toOperandDecimal())
            else
                lastValue = OperatorSub(lastValue)
            output()
        }

        override fun multiply() {
            if (lastValue is Operand<*>)
                lastValue = OperatorMultiply(lastValue.result().toOperandDecimal())
            else
                lastValue = OperatorMultiply(lastValue)
            output()
        }

        override fun div() {
            if (lastValue is Operand<*>)
                lastValue = OperatorDiv(lastValue.result().toOperandDecimal())
            else
                lastValue = OperatorDiv(lastValue)
            output()
        }

        override fun result(): String = lastValue.result().toString()

        override fun output(): String = lastValue.toString()
    }
}