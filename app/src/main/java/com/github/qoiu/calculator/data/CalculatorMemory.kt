package com.github.qoiu.calculator.data

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.*
import com.github.qoiu.calculator.domain.model.operators.*
import com.github.qoiu.calculator.domain.model.trigonometric.TrigonometricSin
import java.util.*

interface CalculatorMemory {
    fun append(value: String)
    fun delete()
    fun rewrite()
    fun clear()
    fun add()
    fun sub()
    fun multiply()
    fun div()
    fun result(): String
    fun output(): String
    fun pow()
    fun join()
    fun sin()

    class Base : CalculatorMemory {
        private var currentValue: CalculatorObject = OperandEmpty()
        private var value: CalculatorObject = OperandEmpty()
        private val operations: Stack<CalculatorObject> = Stack()

        override fun append(value: String) {
            if (currentValue is OperandEmpty) {
                currentValue = OperandLong(value)
                operations.add(currentValue)
            } else {
                currentValue = currentValue.append(value)
            }
        }

        override fun delete() {
            currentValue = currentValue.delete()
        }

        override fun clear() {
            currentValue = OperandEmpty()
        }

        override fun rewrite() {
            currentValue = currentValue.result()
        }

        override fun add() {
            currentValue = currentValue.append(OperatorAdd())
        }

        override fun sub() {
            currentValue = currentValue.append(OperatorSub())
        }

        override fun multiply() {
            currentValue = currentValue.append(OperatorMultiply())
        }

        override fun div() {
            currentValue = currentValue.append(OperatorDiv())
        }

        override fun pow() {
            currentValue = currentValue.append(OperatorPow())
        }

        override fun join() {
            currentValue = currentValue.append(OperatorJoin())
        }

        override fun sin() {
            currentValue = currentValue.append(TrigonometricSin())
        }

        /**
         * @return result of all operation and save it in memory
         */
        override fun result(): String = currentValue.result().toString()

        /**
         * @return expression
         */
        override fun output(): String = currentValue.toString()
    }
}