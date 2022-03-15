package com.github.qoiu.calculator.data

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.RadDegSwitcher
import com.github.qoiu.calculator.domain.model.operands.ConstantE
import com.github.qoiu.calculator.domain.model.operands.ConstantPi
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import com.github.qoiu.calculator.domain.model.operators.*
import com.github.qoiu.calculator.domain.model.trigonometric.TrigonometricCos
import com.github.qoiu.calculator.domain.model.trigonometric.TrigonometricSin
import com.github.qoiu.calculator.domain.model.trigonometric.TrigonometricSqrt

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
    fun switchRad()
    fun switchDeg()
    fun set(value: String)
    fun const(value: String)
    fun mod()
    fun cos()
    fun sqrt()

    class Base(
        private var currentValue: CalculatorObject = OperandEmpty(),
        private val switcher: RadDegSwitcher = RadDegSwitcher.Base()
    ) : CalculatorMemory {

        override fun append(value: String) {
            currentValue = if (currentValue is OperandEmpty) {
                OperandLong(value)
            } else {
                currentValue.append(value)
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

        override fun sqrt() {
            currentValue = currentValue.append(TrigonometricSqrt())
        }

        override fun join() {
            currentValue = currentValue.append(OperatorJoin())
        }

        override fun sin() {
            currentValue = currentValue.append(TrigonometricSin(switcher = switcher))
        }

        override fun cos() {
            currentValue = currentValue.append(TrigonometricCos(switcher = switcher))
        }

        override fun switchRad() {
            switcher.toRad()
        }

        override fun switchDeg() {
            switcher.toDeg()
        }

        override fun mod() {
            currentValue.lastOperand().mod()
        }

        override fun set(value: String) {
            clear()
            currentValue = currentValue.append(value)
        }

        override fun const(value: String) {
            when (value) {
                "π" -> currentValue = currentValue.append(ConstantPi())
                "e" -> currentValue = currentValue.append(ConstantE())
            }
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