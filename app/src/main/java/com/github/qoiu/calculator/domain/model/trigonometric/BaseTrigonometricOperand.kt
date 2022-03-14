package com.github.qoiu.calculator.domain.model.trigonometric

import com.github.qoiu.calculator.domain.model.CalculatorObject
import com.github.qoiu.calculator.domain.model.operands.OperandDouble
import com.github.qoiu.calculator.domain.model.operands.OperandEmpty
import com.github.qoiu.calculator.domain.model.operands.OperandLong
import com.github.qoiu.calculator.domain.model.operators.OperatorAdd

abstract class BaseTrigonometricOperand(protected var value: String) :
    CalculatorObject.Trigonometric {

    override fun delete(): CalculatorObject {
        if (value.isNotEmpty()) {
            this.value = value.substring(0, value.length - 1)
            return this
        }
        return OperandEmpty()
    }

    override fun result(): CalculatorObject.Operand =
        if (value != "")
            OperandDouble(operation(Math.toRadians(value())).toString()).fixValue()
        else
            OperandLong("0")

    override fun append(symbol: String): CalculatorObject {
        this.value = "$value$symbol"
        return this
    }

    override fun append(operator: CalculatorObject.Operator): CalculatorObject =
        operator.init(this)

    override fun append(operator: CalculatorObject.Trigonometric): CalculatorObject =
        OperatorAdd(this, operator)

    fun value(): Double = value.toDouble()

    abstract fun operation(double: Double): Double

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseTrigonometricOperand

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }


}