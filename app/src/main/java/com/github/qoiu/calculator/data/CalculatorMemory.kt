package com.github.qoiu.calculator.data

import com.github.qoiu.calculator.domain.model.Calculator
import com.github.qoiu.calculator.domain.model.Calculator.*
import com.github.qoiu.calculator.domain.model.operands.*
import com.github.qoiu.calculator.domain.model.operators.*
import java.util.*

interface CalculatorMemory {
    fun append(value: String)
    fun delete()
    fun clear()
    fun add()
    fun sub()
    fun multiply()
    fun div()
    fun result(): String
    fun output(): String
    fun pow()
    fun join()

    class Base : CalculatorMemory {
        private var currentValue: Calculator = OperandEmpty()
        private var value: Calculator = OperandEmpty()
        private val operations: Stack<Calculator> = Stack()

        override fun append(value: String) {
            if (currentValue is OperandEmpty) {
                currentValue = OperandLong(value)
                operations.add(currentValue)
            } else {
                currentValue = currentValue.append(value)
            }
            output()
        }

        override fun delete() {
            currentValue = currentValue.delete()
            output()
        }

        override fun clear() {
            currentValue = OperandEmpty()
            output()
        }

        override fun add() {
            append(OperatorAdd())
        }

        override fun sub() {
            append(OperatorSub())
        }

        override fun multiply() {
            append(OperatorMultiply())
        }

        override fun div() {
            append(OperatorDiv())
        }

        override fun pow() {
            append(OperatorPow())
        }

        override fun join() {
            append(OperatorJoin())
        }

        fun sin(){
            append(OperandSin())
        }

        private fun append(operandTrigonometric: BaseTrigonometricOperand){
            when(currentValue) {
                is OperandEmpty -> currentValue = operandTrigonometric
                is Operand -> currentValue = operandTrigonometric.init(currentValue as BaseOperand<*>)
            }
        }

        private fun append(operator: BaseOperator) {
            if (currentValue is OperandEmpty) return
            currentValue = currentValue.append(operator)
            output()
        }

        override fun result(): String = currentValue.result().toString()

        override fun output(): String = currentValue.toString()
    }
}